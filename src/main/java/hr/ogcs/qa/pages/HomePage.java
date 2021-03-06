package hr.ogcs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hr.ogcs.qa.base.TestBase;
import hr.ogcs.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(id="search_main_box")
	WebElement search_box;
	
	@FindBy(xpath = "//a[@name='products1__c']//span[contains(text(),'Products')]")
	WebElement products;
	
	@FindBy(linkText="Test/Control/Reference Items")
	WebElement testControlReferance;
	
	@FindBy(linkText="Library")
	WebElement library;
	//D1
	@FindBy(linkText="Archive & Regulatory")
	WebElement archive_regulatory;
	

	//D2
	@FindBy(linkText="Archive & Regulatory")
	WebElement arch_reg_tab;
	
	@FindBy(linkText="Submissions")
	WebElement submissions;
	

	@FindBy(linkText="Applications")
	WebElement applications;

	
	@FindBy(linkText="Study & QAU")
	WebElement study_qau;
	
	@FindBy(linkText="Inspections")
	WebElement inspections;
	
	//D4
	@FindBy(xpath="//div[2]/div/div/div/button/span")
	WebElement create_btn;
	
	@FindBy(xpath="//li[4]/a/span[2]")
	WebElement upload_btn;
	
	@FindBy(linkText ="Binder")
    WebElement selectBinder;
	
	@FindBy(xpath="//button[@class='vv_button vv_button_nav vv_inbox_new_button inboxNewButton']")
	WebElement createButton;
	
	@FindBy(xpath="//div[@class='header_std vv_navbar']//li[3]//a[1]")
	WebElement binderButton;
	
	@FindBy(xpath="//a[@name='study_qau__c']")
	WebElement studyQAU;
	
	@FindBy(xpath = "//a[contains(text(),'Studies')]")
	WebElement studiesButton;
	
	@FindBy(linkText="Phases")
	WebElement phases;
	
	@FindBy(linkText="Trials")
	WebElement trials;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void  SearchDocument() throws InterruptedException{
		TestUtil.type(search_box, "Search Box", "2018/2001297" + Keys.ENTER);
		//search_box.sendKeys(Keys.ENTER);
	}
	
	public void GoToApplications() {
		TestUtil.click(archive_regulatory, "Archive & Regulatory");
		TestUtil.click(applications, "Applications");
	}
	
	//C15
	public void GoToTestControlReferance() {
		TestUtil.click(products, "Product");
		TestUtil.click(testControlReferance, "Test/Control/Reference Items");
	}
	
	//A1	
	public void GoToLibrary(){
		TestUtil.click(library, "Library");
		//search_box.sendKeys(Keys.ENTER);
	}
	

	//D2
	public void GoToArchive() {
		TestUtil.click(arch_reg_tab, "Archive & Regulatory");
		TestUtil.click(submissions, "Submissions");
	}
	

	//D4
	public void GoToUpload() {
		TestUtil.click(create_btn, "Create Button");
		TestUtil.click(upload_btn, "Upload Button");
	}
	
	public void GoToBinder() {
		TestUtil.click(create_btn, "Create button");
		TestUtil.click(selectBinder, "Binder button");

    }

	
	public void GoToStudyQUA() {
		TestUtil.click(studyQAU, "Study QUA");
		TestUtil.click(studiesButton, "Studies");
		
//		studyQAU.click();
//		studiesButton.click();
		
	}
	
	public void GoToInspections() {
		TestUtil.click(study_qau, "Study & QAU");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.click(inspections, "Inspections");
    }
	
	public void goToPhases() {
		TestUtil.click(studyQAU, "Study QAU");
		TestUtil.click(phases, "Phases");
	}
	
	public void goToTrials() {
		TestUtil.click(study_qau, "Study QAU");
		TestUtil.click(trials, "Trials Button");
	}
	
}
