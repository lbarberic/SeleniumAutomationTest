package hr.ogcs.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hr.ogcs.qa.base.TestBase;
import hr.ogcs.qa.pages.DocumentPage;
import hr.ogcs.qa.pages.HomePage;
import hr.ogcs.qa.pages.LibraryPage;
import hr.ogcs.qa.pages.LoginPage;
import hr.ogcs.qa.pages.UploadPage;
import hr.ogcs.qa.util.TestUtil;

public class EAG_TSF_D004 extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	LibraryPage libraryPage;
	DocumentPage documentPage;
	UploadPage uploadPage;

	public EAG_TSF_D004 () {
		super ();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
    	parentTest = extent.createTest("EAG_TSF_D004");
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		documentPage = new DocumentPage();
		libraryPage = new LibraryPage();
		uploadPage = new UploadPage();
		homePage = loginPage.login(prop.getProperty("us_dossieradmin"), prop.getProperty("psw_dossieradmin"));
	}
	
	@Test
	public void EAG_TSF_D004() throws InterruptedException, IOException{
		
		//d004.02 Uploading Document(s)
	  	childTest = parentTest.createNode("Uploading Document(s)");
		homePage.GoToUpload();
		uploadPage.UploadFile();
		uploadPage.ClickUpload();
		
		//d004.03 Classification of Uploaded Document(s)
	  	childTest = parentTest.createNode("Classification of Uploaded Document(s)");
		libraryPage.OpenUploadedDocument();
		documentPage.ClassificationOfUploadedDocument();
		
		//d004.04 Filling Editable Fields
	  	childTest = parentTest.createNode("Filling Editable Fields");
		documentPage.FillEditableFields();
		
		//d004.05 Verifying Text Present
	  	childTest = parentTest.createNode("Verifying Text Present");
		documentPage.TextVerifycation();
		TestUtil.takeScreenshotAtEndOfTest();
		
		//d004.06 Checking Cancel Function
	  	childTest = parentTest.createNode("Checking Cancel Function");
		homePage.GoToUpload();
		uploadPage.UploadFile();
		uploadPage.ClickCancel();;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
