package hr.ogcs.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hr.ogcs.qa.base.TestBase;
import hr.ogcs.qa.pages.CreateTrialPage;
import hr.ogcs.qa.pages.HomePage;
import hr.ogcs.qa.pages.LoginPage;
import hr.ogcs.qa.pages.SavedTrialPage;
import hr.ogcs.qa.pages.TrialsPage;


public class EAG_TSF_G005 extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TrialsPage trialsPage;
	CreateTrialPage createTrialPage;
	SavedTrialPage savedTrialPage;
		
		
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		trialsPage = new TrialsPage();
		createTrialPage = new CreateTrialPage();
		savedTrialPage = new SavedTrialPage();
		homePage = loginPage.login(prop.getProperty("us_lgpw"), prop.getProperty("psw_lgpw"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	@Test
	public void testG5() throws IOException, InterruptedException {
		homePage.goToTrials();
		trialsPage.createTrial();
		createTrialPage.fillOutTrialForm();
		savedTrialPage.verifyTrialData();
		savedTrialPage.goToTrials();
		
		trialsPage.createTrial();
		createTrialPage.fillOutTrialFormAndCancel();
	}
	
}