package hr.ogcs.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hr.ogcs.qa.base.TestBase;
import hr.ogcs.qa.pages.DocumentPage;
import hr.ogcs.qa.pages.HomePage;
import hr.ogcs.qa.pages.LibraryPage;
import hr.ogcs.qa.pages.LoginPage;
import hr.ogcs.qa.util.TestUtil;

@Listeners(hr.ogcs.qa.util.TestListener.class)
public class EAG_TSF_A001 extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	LibraryPage libraryPage;
	DocumentPage documentPage;

	public EAG_TSF_A001 () {
		super ();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
    	parentTest = extent.createTest("EAG_TSF_A001");
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		documentPage = new DocumentPage();
		libraryPage = new LibraryPage();
		homePage = loginPage.login(prop.getProperty("us_globaladmin"), prop.getProperty("psw_globaladmin"));
	}
	
	@Test
	public void EAG_TSF_A001() throws InterruptedException, IOException{
		
		//A001.02 - Choosing Document in Status Pending Archival 
    	childTest = parentTest.createNode("Choosing Document in Status Pending Archival");
		homePage.GoToLibrary();
		libraryPage.Filter();
		libraryPage.SetTabularView();
		documentPage.SelectDocument();
		
		//A001.03 - Filling Editable Fields
    	childTest = parentTest.createNode("Filling Editable Fields");
		documentPage.ClickEditButton();
		documentPage.FillForm();
		
		//A001.04 - Changing Status of Document - Negative Testing
    	childTest = parentTest.createNode("Changing Status of Document - Negative Testing");
		documentPage.ArchiveNegative();
		
		//A001.05 - Changing Status of Document 
    	childTest = parentTest.createNode("Changing Status of Document");
		documentPage.ArchivePositive();

		//A001.06 - Verify Text Present
    	childTest = parentTest.createNode("Verifying Text Present");
		documentPage.Verifycation();
		TestUtil.takeScreenshotAtEndOfTest();
		
		//A001.07 - Filling Editable Fields After Document Status is Changed
    	childTest = parentTest.createNode("Filling Editable Fields After Document Status is Changed");
		documentPage.FillAfterDocumentStatusIsChanged();
		TestUtil.takeScreenshotAtEndOfTest();
		documentPage.SaveButton();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
