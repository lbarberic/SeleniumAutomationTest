package hr.ogcs.qa.pages;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hr.ogcs.qa.base.TestBase;
import hr.ogcs.qa.util.TestUtil;

public class CreateInspectionPage extends TestBase {
	
	SimpleDateFormat formatter= new SimpleDateFormat("mm/dd/yyyy");
	Date date = new Date(System.currentTimeMillis());
	
	@FindBy(xpath="//span[@selenium-name='computired_system__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_computerized_system;
	
	@FindBy(xpath="//span[@selenium-name='glp_inspector__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_glp_inspector;
	
	@FindBy(xpath = "//span[@selenium-name='request_item__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_request_item;
	
	//dates
	@FindBy(xpath = "//span[@selenium-name='planned_start_date__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='text']")
	WebElement form_planned_start_date;
	
	@FindBy(xpath = "//span[@selenium-name='planned_end_date__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='text']")
	WebElement form_planned_end_date;
	
	@FindBy(xpath = "//span[@selenium-name='confirmed_inspection_date__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='text']")
	WebElement form_confirmed_inspection_date;
	
	@FindBy(xpath = "//span[@selenium-name='closure_date__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='text']")
	WebElement form_closure_date;
	
	@FindBy(xpath = "//span[@selenium-name='actual_start_date__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='text']")
	WebElement form_actual_start_date;
	
	@FindBy(xpath = "//span[@selenium-name='actual_end_date__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='text']")
	WebElement form_actual_end_date;
	
	@FindBy(xpath = "//span[@selenium-name='instrument__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_instrument;
	
	@FindBy(css="li.vv-menu-item.vv-menu-item-focused")
	WebElement form_select_item;
	
	@FindBy(name= "description__c")
	WebElement form_description;
	
	@FindBy(name = "request_no__c")
	WebElement form_request_item_others;
	
	@FindBy(xpath="//span[@selenium-name='facility__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_facility;
	
	@FindBy(xpath="//span[@selenium-name='performing_unit__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_performing_unit;
	
	@FindBy(xpath="//span[@selenium-name='item_from_guidelines__c']//parent::label//parent::div//following-sibling::div[1]//textarea")
	WebElement form_items_from_guidelines;
	
	@FindBy(xpath="//span[@selenium-name='basf_study_id__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_basf_study_id;
	
	@FindBy(xpath="//span[@selenium-name='document_type__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_document_type;
	
	@FindBy(xpath="//span[@selenium-name='inspection_content__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_inspection_content;
	
	@FindBy(xpath="//span[@selenium-name='process_type__c']//parent::label//parent::div//following-sibling::div[1]//input[@type='search']")
	WebElement form_process_type;
	
	@FindBy(xpath="//input[@name='internal_facility_inspection__c' and @value='true']")
	WebElement form_internal_facility_inspection;
	
	@FindBy(xpath="//input[@name='inspection_decision__c' and @value='true']")
	WebElement form_inspection_decision;
	
	@FindBy(xpath = "//input[@name='process_based_inspection__c' and @value='true']")
	WebElement 	form_process_based_inspection;
	
	@FindBy(name="confirmed_inspection_comments__c")
	WebElement form_confirmed_inspection_comment;
	
	@FindBy(name="reason_for_cancelling__c")
	WebElement form_reason_for_cancelling__c;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement save_btn;
	
	//Verification
	@FindBy(xpath = "//span[@selenium-value-name='name__v']")
	WebElement verify_name;
	
	@FindBy(xpath = "//span[@selenium-value-name='computired_system__c']")
	WebElement  verify_computerized_system;
	
	@FindBy(xpath = "//span[@selenium-value-name='glp_inspector__c']")
	WebElement verify_glp_inspector ;
	
	@FindBy(xpath = "//span[@selenium-value-name='object_type__v']")
	WebElement verify_inspection_type;
	
	@FindBy(xpath = "//span[@selenium-value-name='state__v']")
	WebElement verify_lifecycle_state;
	
	@FindBy(xpath = "//span[@selenium-value-name='description__c']")
	WebElement verify_description;
	
	@FindBy(xpath = "//span[@selenium-value-name='request_item__c']")
	WebElement verify_request_item;
	
	@FindBy(xpath = "//span[@selenium-value-name='request_no__c']")
	WebElement verify_request_item_others;
	
	@FindBy(xpath = "//span[@selenium-value-name='planned_start_date__c']")
	WebElement verify_planned_start_date;
	
	@FindBy(xpath = "//span[@selenium-value-name='planned_end_date__c']")
	WebElement verify_planned_end_date;
	
	@FindBy(xpath = "//span[@selenium-value-name='confirmed_inspection_date__c']")
	WebElement  verify_confirmed_inspection_date;
	
	@FindBy(xpath = "//span[@selenium-value-name='closure_date__c']")
	WebElement  verify_closure_date;

	@FindBy(xpath = "//span[@selenium-value-name='actual_start_date__c']")
	WebElement   verify_start_date;
	
	@FindBy(xpath = "//span[@selenium-value-name='actual_end_date__c']")
	WebElement  verify_end_date;
	
	@FindBy(xpath = "//div[text()='Inspection Dates']")
	WebElement  inspection_date_tab;
	
	@FindBy(xpath = "//div[text()='Additional Details']")
	WebElement  additional_details_tab;
	
	@FindBy(xpath = "//span[@selenium-value-name='document_type__c']")
	WebElement  verify_document_type;
	
	@FindBy(xpath = "//span[@selenium-value-name='inspection_content__c']")
	WebElement  verify_inspection_content;
	
	@FindBy(xpath = "//span[@selenium-value-name='basf_study_id__c']")
	WebElement  verify_basf_study_id;
	
	@FindBy(xpath = "//descendant::span[contains(@class, 'userCell')][1]")
	WebElement  verify_created_by;

	@FindBy(xpath = "//span[@selenium-value-name='created_date__v']")
	WebElement  verify_created_date;

	@FindBy(xpath = "//descendant::span[contains(@class, 'userCell')][2]")
	WebElement  verify_modified_by;

	@FindBy(xpath = "//span[@selenium-value-name='modified_date__v']")
	WebElement  verify_modified_date;

	@FindBy(xpath = "//span[@selenium-value-name='id']")
	WebElement  verify_id;

	@FindBy(xpath = "//span[@selenium-value-name='status__v']")
	WebElement  verify_status;
	
	@FindBy(xpath = "//span[@selenium-value-name='lifecycle__v']")
	WebElement  verify_lifecycle;
	
	@FindBy(xpath = "//span[@selenium-value-name='source__c']")
	WebElement  verify_source;
	
	@FindBy(xpath = "//span[@selenium-value-name='buid__c']")
	WebElement  verify_buid;
	
	@FindBy(xpath = "//span[@selenium-value-name='internal_facility_inspection__c']")
	WebElement  verify_internal_facility_inspection;
	
	@FindBy(xpath = "//span[@selenium-value-name='facility__c']")
	WebElement  verify_facility;
	
	@FindBy(xpath = "//span[@selenium-value-name='performing_unit__c']")
	WebElement  verify_performing_unit;

	@FindBy(xpath = "//span[@selenium-value-name='item_from_guidelines__c']")
	WebElement  verify_item_from_guidelines;
	
	@FindBy(xpath = "//span[@selenium-value-name='instrument__c']")
	WebElement  verify_instrument;

	@FindBy(xpath = "//span[@selenium-value-name='reason_for_cancelling__c']")
	WebElement  verify_reason_for_cancelling;

	@FindBy(xpath = "//span[@selenium-value-name='inspection_decision__c']")
	WebElement  verify_inspection_decision;

	@FindBy(xpath = "//span[@selenium-value-name='confirmed_inspection_comments__c']")
	WebElement  verify_confirmed_inspection_comments;
	
	@FindBy(xpath = "//span[@selenium-value-name='process_based_inspection__c']")
	WebElement  verify_process_based_inspection;
	
	@FindBy(xpath = "//span[@selenium-value-name='process_type__c']")
	WebElement  verify_process_type;
	
	@FindBy(xpath="//header/div[2]/div[2]/button")
	WebElement cancel_btn;
	
	public  CreateInspectionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void FillComputerizedSystemInspection() throws InterruptedException {
		
		TestUtil.type(form_computerized_system, "Computerized System*", "QUARTS");
		TestUtil.ClickOnFocusedItem("QUARTS");
		TestUtil.type(form_glp_inspector, "GLP Inspector", "QAU Writer1, Lihof");
		TestUtil.ClickOnFocusedItem("QAU Writer1, Lihof");
		TestUtil.type(form_description, "Description", "Validation - Description Inspection 001");
		TestUtil.type(form_request_item, "Request Item", "Others");
		TestUtil.ClickOnFocusedItem("Others");
		
		TestUtil.type(form_request_item_others, "Request Item (Others)", "Validation Request Other");
		TestUtil.type(form_planned_start_date, "Planned Start Date", "10/29/2018");
		TestUtil.type(form_planned_end_date, "Planned End Date", "10/29/2018");
		TestUtil.type( form_actual_start_date, "Actual Start Date", "10/29/2018");
		TestUtil.type( form_actual_end_date, "Actual End Date", "10/29/2018");
		TestUtil.type( form_closure_date, "Closure Date", "10/29/2018");
		TestUtil.type( form_confirmed_inspection_date, "Confirmed Inspection Date", "10/29/2018");

		TestUtil.click( save_btn, "Save Button");
	}
	
	public void FillDocumentInspection() throws InterruptedException {
		form_glp_inspector.sendKeys("QAU Writer1, Lihof");
		TestUtil.type(form_glp_inspector, "GLP Inspector", "QAU Writer1, Lihof");
		TestUtil.ClickOnFocusedItem("QAU Writer1, Lihof");
		TestUtil.type(form_description, "Description", "Validation - Description Inspection 001");
		TestUtil.type(form_basf_study_id, "BASF Study ID*", "Schulung_1");
		TestUtil.ClickOnFocusedItem("Schulung_1");
		TestUtil.type(form_document_type, "Document Type*", "Study Protocol");
		TestUtil.ClickOnFocusedItem("Study Protocol");
		TestUtil.type(form_inspection_content, "Inspection Content", "2018/2001300");
		TestUtil.ClickOnFocusedItem("2018/2001300");
		TestUtil.type(form_planned_start_date, "Planned start date", "10/29/2018");
		TestUtil.type(form_planned_end_date, "Planned End Date", "10/29/2018");
		TestUtil.type( form_actual_start_date, "Actual Start Date", "10/29/2018");
		TestUtil.type( form_actual_end_date, "Actual End Date", "10/29/2018");
		TestUtil.type( form_closure_date, "Closure Date", "10/29/2018");
		
		TestUtil.click( save_btn, "Save Button");
	}
	
	public void FillFacilityInspection() throws InterruptedException {
		TestUtil.click(form_internal_facility_inspection, "Internal Facility Inspection - YES");
		TestUtil.type(form_facility, "Facility*", "ZAAS");
		TestUtil.ClickOnFocusedItem("ZAAS");
		TestUtil.type(form_items_from_guidelines, "Item (from guidelines)", "Others");
		TestUtil.ClickOnFocusedItem("Others");
		TestUtil.type(form_glp_inspector, "GLP Inspector", "QAU Writer1, Lihof");
		TestUtil.ClickOnFocusedItem("QAU Writer1, Lihof");
		TestUtil.type(form_performing_unit, "Performing Unit", "ZPD/L");
		TestUtil.ClickOnFocusedItem("ZPD/L");		
		TestUtil.type(form_planned_start_date, "Planned start date", "10/29/2018");
		TestUtil.type(form_planned_end_date, "Planned End Date", "10/29/2018");
		TestUtil.type( form_actual_start_date, "Actual Start Date", "10/29/2018");
		TestUtil.type( form_actual_end_date, "Actual End Date", "10/29/2018");
		TestUtil.type( form_closure_date, "Closure Date", "30/10/2018");
		TestUtil.type( form_confirmed_inspection_date, "Confirmed Inspection Date", "10/29/2018");
		TestUtil.click( save_btn, "Save Button");
	}
	
	public void FillInstrumentInspection() throws InterruptedException {
		TestUtil.type(form_instrument, "Instrument*", "MA010");
		TestUtil.ClickOnFocusedItem("MA010");
		TestUtil.type(form_glp_inspector, "GLP Inspector", "QAU Writer1, Lihof");
		TestUtil.ClickOnFocusedItem("QAU Writer1, Lihof");
		TestUtil.type(form_description, "Description", "Validation - Description Inspection 001");
		TestUtil.type(form_request_item, "Request Item", "MS measurement");
		TestUtil.ClickOnFocusedItem("MS measurement");
		TestUtil.type(form_request_item_others, "Request Item (Others)", "Mass spec standard");
		TestUtil.type(form_confirmed_inspection_comment, "Confirmed Inspection Comments", "Validation comments");
		TestUtil.type(form_reason_for_cancelling__c, "Reason for Cancelling", "Validation reason");
		TestUtil.click(form_inspection_decision, "Inspection Decision* - YES");
		TestUtil.type(form_inspection_content, "Inspection Content", "2018/2001300");
		TestUtil.ClickOnFocusedItem("2018/2001300");
		TestUtil.type(form_planned_start_date, "Planned start date", "10/29/2018");
		TestUtil.type(form_planned_end_date, "Planned End Date", "10/29/2018");
		TestUtil.type( form_actual_start_date, "Actual Start Date", "10/29/2018");
		TestUtil.type( form_actual_end_date, "Actual End Date", "10/29/2018");
		TestUtil.type( form_closure_date, "Closure Date", "10/29/2018");
		TestUtil.click( save_btn, "Save Button");
	}
	
	public void FillStudyBasedInspection() throws InterruptedException {
		
		TestUtil.type(form_basf_study_id, "BASF Study ID*", "Schulung_1");
		TestUtil.ClickOnFocusedItem("Schulung_1");
		TestUtil.type(form_glp_inspector, "GLP Inspector", "QAU Writer1, Lihof");
		TestUtil.ClickOnFocusedItem("QAU Writer1, Lihof");

		TestUtil.type(form_description, "Description", "Validation - Description Inspection 001");
		TestUtil.type(form_request_item, "Request Item", "Others");
		TestUtil.ClickOnFocusedItem("Others");
		TestUtil.type(form_request_item_others, "Request Item (Others)", "Validation - Description Inspection 001");

		TestUtil.click(form_process_based_inspection, "Process based Inspection? - YES");

		TestUtil.type(form_process_type, "Process Type", "Physical");
		TestUtil.ClickOnFocusedItem("Physical");
		
		TestUtil.type(form_planned_start_date, "Planned start date", "10/29/2018");
		TestUtil.type(form_planned_end_date, "Planned End Date", "10/29/2018");
		TestUtil.type( form_actual_start_date, "Actual Start Date", "10/29/2018");
		TestUtil.type( form_actual_end_date, "Actual End Date", "10/29/2018");
		TestUtil.type( form_closure_date, "Closure Date", "30/10/2018");
		TestUtil.type( form_confirmed_inspection_date, "Confirmed Inspection Date", "10/29/2018");
				
		TestUtil.click( save_btn, "Save Button");
	}
	
	
	
	public void FacilityInspectionVerifycation() throws IOException, InterruptedException {
		TestUtil.containText(verify_name, "INS-");
		TestUtil.verifyEquals(verify_glp_inspector, "QAU Writer1, Lihof");
		TestUtil.verifyEquals(verify_internal_facility_inspection, "YES");
		TestUtil.verifyEquals(verify_lifecycle_state, "Planned");
		TestUtil.verifyEquals(verify_facility, "ZAAS - Zhejiang Academy of Agricultural Sciences");
		TestUtil.verifyEquals(verify_performing_unit, "ZPD/L");
		TestUtil.verifyEquals(verify_item_from_guidelines, "Others");
		TestUtil.verifyEquals(verify_inspection_type, "Facility Inspection");

		TestUtil.click(inspection_date_tab, "Inspection Date Tab");

		
		TestUtil.verifyEquals(verify_planned_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_planned_end_date, "10/29/2018");
		TestUtil.verifyEquals(verify_closure_date, "10/30/2018");
		TestUtil.verifyEquals(verify_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_end_date, "10/29/2018");
		
		jse.executeScript("window.scrollBy(0,500)", "");
		
		TestUtil.click(additional_details_tab, "Additional Details Tab");
		
		wait.until(ExpectedConditions.visibilityOf(verify_created_by));
		TestUtil.verifyEquals(verify_created_by, "Lihof QAU writer2");
		TestUtil.containText(verify_created_date, formatter.format(date));
		TestUtil.verifyEquals(verify_modified_by, "Lihof QAU writer2");
		TestUtil.verifyEquals(verify_modified_date, formatter.format(date));
		TestUtil.containText(verify_id, "OP4");
		TestUtil.verifyEquals(verify_status, "Active");
		TestUtil.verifyEquals(verify_lifecycle, "Inspection Lifecycle");
		
	}
	
	public void ComputerizedSystemInspectionVerifycation() throws IOException, InterruptedException {
		TestUtil.containText(verify_name, "INS-");
		TestUtil.verifyEquals(verify_computerized_system, "QUARTS");
		TestUtil.verifyEquals(verify_glp_inspector, "QAU Writer1, Lihof");
		TestUtil.verifyEquals(verify_inspection_type, "Computerized System Inspection");
		TestUtil.verifyEquals(verify_lifecycle_state, "Planned");
		TestUtil.verifyEquals(verify_description, "Validation - Description Inspection 001");
		TestUtil.verifyEquals(verify_request_item, "Others");
		TestUtil.verifyEquals(verify_request_item_others, "Validation Request Other");
		
		TestUtil.click(inspection_date_tab, "Inspection Date Tab");
	
		TestUtil.verifyEquals(verify_planned_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_planned_end_date, "10/29/2018");
		TestUtil.verifyEquals(verify_confirmed_inspection_date, "10/29/2018");
		TestUtil.verifyEquals(verify_closure_date, "10/29/2018");
		TestUtil.verifyEquals(verify_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_end_date, "10/29/2018");
		
		jse.executeScript("window.scrollBy(0,500)", "");

		TestUtil.click(additional_details_tab, "Additional Details Tab");
		wait.until(ExpectedConditions.visibilityOf(verify_created_by));
		TestUtil.verifyEquals(verify_created_by, "Lihof QAU writer2");
		TestUtil.containText(verify_created_date, formatter.format(date));
		TestUtil.verifyEquals(verify_modified_by, "Lihof QAU writer2");
		TestUtil.verifyEquals(verify_modified_date, formatter.format(date));
		TestUtil.containText(verify_id, "OP4");
		TestUtil.verifyEquals(verify_status, "Active");
		TestUtil.verifyEquals(verify_lifecycle, "Inspection Lifecycle");
	}
	
	
	public void DocumentInspectionVerifycation() throws IOException, InterruptedException {
		TestUtil.containText(verify_name, "INS-");
		TestUtil.verifyEquals(verify_glp_inspector, "QAU Writer1, Lihof");
		TestUtil.verifyEquals(verify_document_type, "Study Protocol");
		TestUtil.verifyEquals(verify_inspection_type, "Document Inspection");
		TestUtil.verifyEquals(verify_lifecycle_state, "Planned");
		TestUtil.verifyEquals(verify_description, "Validation - Description Inspection 001");
		TestUtil.verifyEquals(verify_basf_study_id, "999999");
		//TestUtil.verifyEquals(verify_inspection_content, "2018/2001300");
		
		TestUtil.click(inspection_date_tab, "Inspection Date Tab");
		
		TestUtil.verifyEquals(verify_planned_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_planned_end_date, "10/29/2018");
		TestUtil.verifyEquals(verify_closure_date, "10/29/2018");
		TestUtil.verifyEquals(verify_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_end_date, "10/29/2018");
		
		jse.executeScript("window.scrollBy(0,500)", "");

		TestUtil.click(additional_details_tab, "Additional Details Tab");
		wait.until(ExpectedConditions.visibilityOf(verify_created_by));
		TestUtil.verifyEquals(verify_created_by, "Lihof QAU writer1");
		TestUtil.containText(verify_created_date, formatter.format(date));
		TestUtil.verifyEquals(verify_modified_by, "Lihof QAU writer1");
		TestUtil.verifyEquals(verify_modified_date, formatter.format(date));
		TestUtil.containText(verify_id, "OP4");
		TestUtil.verifyEquals(verify_status, "Active");
		TestUtil.verifyEquals(verify_lifecycle, "Inspection Lifecycle");
		
	}
	
	public void InstrumentInspectionVerifycation() throws IOException, InterruptedException {
		TestUtil.containText(verify_name, "INS-");
		TestUtil.verifyEquals(verify_instrument, "MA010");
		TestUtil.verifyEquals(verify_glp_inspector, "QAU Writer1, Lihof");
		TestUtil.verifyEquals(verify_inspection_type, "Instrument Inspection");
		TestUtil.verifyEquals(verify_lifecycle_state, "Planned");
		TestUtil.verifyEquals(verify_description, "Validation - Description Inspection 001");
		TestUtil.verifyEquals(verify_request_item, "MS measurement");
		TestUtil.verifyEquals(verify_request_item_others, "Mass spec standard");
		TestUtil.verifyEquals(verify_confirmed_inspection_comments, "Validation comments");
		TestUtil.verifyEquals(verify_reason_for_cancelling, "Validation reason");
		TestUtil.verifyEquals(verify_inspection_decision, "Yes");

		//TestUtil.verifyEquals(verify_inspection_content, "2018/2001300");
		
		TestUtil.click(inspection_date_tab, "Inspection Date Tab");
		
		TestUtil.verifyEquals(verify_planned_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_planned_end_date, "10/29/2018");
		TestUtil.verifyEquals(verify_closure_date, "10/29/2018");
		TestUtil.verifyEquals(verify_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_end_date, "10/29/2018");
		
		jse.executeScript("window.scrollBy(0,500)", "");

		TestUtil.click(additional_details_tab, "Additional Details Tab");
		wait.until(ExpectedConditions.visibilityOf(verify_created_by));
		TestUtil.verifyEquals(verify_created_by, "Lihof QAU writer1");
		TestUtil.containText(verify_created_date, formatter.format(date));
		TestUtil.verifyEquals(verify_modified_by, "Lihof QAU writer1");
		TestUtil.verifyEquals(verify_modified_date, formatter.format(date));
		TestUtil.containText(verify_id, "OP4");
		TestUtil.verifyEquals(verify_status, "Active");
		TestUtil.verifyEquals(verify_lifecycle, "Inspection Lifecycle");
		
	}
	
	
	
	public void StudyBasedVerifycation() throws IOException, InterruptedException {
		TestUtil.containText(verify_name, "INS-");
		TestUtil.verifyEquals(verify_glp_inspector, "QAU Writer1, Lihof");
		TestUtil.containText(verify_basf_study_id, "Schulung_1");
		TestUtil.verifyEquals(verify_inspection_type, "Study Based Inspection");
		TestUtil.verifyEquals(verify_lifecycle_state, "Planned");
		TestUtil.verifyEquals(verify_description, "Validation - Description Inspection 001");
		TestUtil.verifyEquals(verify_request_item, "Others");
		TestUtil.verifyEquals(verify_request_item_others, "Validation - Description Inspection 001");
		TestUtil.verifyEquals(verify_process_based_inspection, "Yes");
		TestUtil.verifyEquals(verify_process_type, "Physical");
		
		TestUtil.click(inspection_date_tab, "Inspection Date Tab");
		
		TestUtil.verifyEquals(verify_planned_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_planned_end_date, "10/29/2018");
		TestUtil.verifyEquals(verify_closure_date, "10/29/2018");
		TestUtil.verifyEquals(verify_start_date, "10/29/2018");
		TestUtil.verifyEquals(verify_end_date, "10/29/2018");
		
		jse.executeScript("window.scrollBy(0,500)", "");

		TestUtil.click(additional_details_tab, "Additional Details Tab");
		wait.until(ExpectedConditions.visibilityOf(verify_created_by));
		TestUtil.verifyEquals(verify_created_by, "Lihof QAU writer1");
		TestUtil.containText(verify_created_date, formatter.format(date));
		TestUtil.verifyEquals(verify_modified_by, "Lihof QAU writer1");
		TestUtil.verifyEquals(verify_modified_date, formatter.format(date));
		TestUtil.containText(verify_id, "OP4");
		TestUtil.verifyEquals(verify_status, "Active");
		TestUtil.verifyEquals(verify_lifecycle, "Inspection Lifecycle");
		
	}
	
	
	public void Cancel() {
		TestUtil.click(cancel_btn, "Cancel Button");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
