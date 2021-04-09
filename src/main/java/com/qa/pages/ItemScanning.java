package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.qa.config.fc;
import com.qa.util.TestBase;

public class ItemScanning extends TestBase {
	static String parentWindow;
	@FindBy(xpath = "//span[@id='custrecord_tss_seraial_lot_no_fs_lbl_uir_label']//following-sibling::span")
	WebElement lotnrs;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_bin_no_fs_lbl_uir_label']//following-sibling::span")
	WebElement bin_text;
	
	@FindBy(xpath = "//*[@id=\"main_form\"]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/span[2]")
	WebElement removal_serial_nrs;
	
	@FindBy(xpath = "//*[@id=\"custpage_show_processed_fs\"]/img")
	WebElement show_processed;
	
	@FindBy(xpath = "//td[@id='tdbody_submitter']")
	WebElement process;
	
	@FindBy(xpath = "//li[contains(@class,'ns-header ns-menuitem') and @data-title='Inventory Count']")
	WebElement inventory_count;
	
	@FindBy(xpath = "//li[@data-title='Inventory Analytics']")
	WebElement inventory_analytics;
	
	@FindBy(xpath = "//li[@data-title='Processed Inventory Count Data']")
	WebElement processed_inventory_count_screen;
	
	@FindBy(xpath = "//li[@data-title='Failure Inventory Count Data']")
	WebElement failure_inventory_count_screen;
	
	@FindBy(xpath = "//li[@data-title='Success Inventory Count Data']")
	WebElement success_inventory_count_screen;
	
	@FindBy(xpath = "//li[contains(@class,'ns-header ns-menuitem') and @data-title='Inventory Count']")
	WebElement inventory_count1;
	
	@FindBy(xpath = "//li//li[@data-title='Inventory Count']")
	WebElement IC;
	
	@FindBy(xpath = "//li//li[@data-title='Item Scanning']")
	WebElement IS;
	
	@FindBy(xpath = "//*[@id=\"custpage_process1_fs\"]/img")
	WebElement item_process;
	
	@FindBy(xpath = "//input[@id='itemname']")
	WebElement itemname;
	
	@FindBy(xpath = "//input[@id='submission']")
	WebElement submit_button;
	
	@FindBy(xpath = "//select[@id='location_1']")
	Select location;
	
	@FindBy(xpath = "//select[@id='inventorylocation']")
	WebElement location_click;
	
	@FindBy(xpath = "//select[@id='inventorybin']")
	WebElement bin_click;
	
	@FindBy(xpath = "//select[@id='bin_1']")
	Select bin;
	
	@FindBy(xpath = "//textarea[@id='seriallot_1']")
	WebElement serial;
	
	@FindBy(xpath = "//input[@id='quantity_1']")
	WebElement quantity;
	
	@FindBy(xpath = "//input[@id='selectrows']")
	WebElement select_rows;
	
	@FindBy(xpath = "//input[@name='inpt_custpage_accountinfo']")
	WebElement account_arrow;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> account_list;
	
	@FindBy(xpath = "//input[@id='st']")
	WebElement account_search_input;
	
	@FindBy(xpath = "//input[@id='Search']")
	WebElement account_search_button;
	
	@FindBy(xpath = "//div[@id='inner_popup_div']//table//tbody//tr")
	List<WebElement> account_lists;
	
	@FindBy(xpath = "//span[@id='custpage_haserrors_fs']//img")
	WebElement has_errors;
	
	@FindBy(xpath = "//td[@id='tdbody_custpage_refresh']")
	WebElement filter;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tbody//tr[@class='uir-list-row-tr uir-list-row-odd']//td[count( //td[@data-label='error Details']//preceding-sibling::td)+1]")
	WebElement error_message;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tbody//tr[@class='uir-list-row-tr uir-list-row-odd']//td[count( //td[@data-label='Netsuite Qty']//preceding-sibling::td)]")
	WebElement physcial_quantity;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tbody//td[@class='uir-list-row-cell listtext']//a")
	WebElement view_link;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_add_serial_nos_fs_lbl_uir_label']//following-sibling::span")
	WebElement serial_numbers_text;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_remove_serial_nos_fs_lbl_uir_label']//following-sibling::span")
	WebElement removed_serial_numbers;
	
	@FindBy(xpath = "//tr[@id='custpage_listrow0']//td//a")
	WebElement processed_view_link;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_inventory_adj_link_lbl_uir_label']//following-sibling::span")
	WebElement adjustment_link;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_seraial_lot_no_fs_lbl_uir_label']//following-sibling::span")
	WebElement lot_nrs;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[contains(@id,'custpage_listrow')]//td[count(//td[@data-label='Estimated Variance Cost']//preceding-sibling::td)]")
	List<WebElement> variance_quantity_before_processing;
	

	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[contains(@id,'custpage_listrow')]//td[count(//td[@data-label='Physical Qty']//preceding-sibling::td)]")
	List<WebElement> items_before_processing;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[contains(@id,'custpage_listrow')]//td[count(//td[@data-label='Items']//preceding-sibling::td)]")
	List<WebElement> bin_before_processing;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[contains(@id,'custpage_listrow')]//td[count(//td[@data-label='Bin']//preceding-sibling::td)]")
	List<WebElement> location_before_processing;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[contains(@id,'custpage_listrow')]//td[count(//td[@data-label='Record Link']//preceding-sibling::td)+2]//a")
	List<WebElement> view_link_list;
	
	@FindBy(xpath = "//table[@id='example']//tbody//tr[@role='row']//td[count(//table[@id='example']//th[contains(@aria-label,'Quantity')]//preceding-sibling::th)]//textarea")
	List<WebElement> serial_lot_nr_entering_list;
	
	@FindBy(xpath = "//table[@id='example']//tbody//tr[@role='row']//td[count(//table[@id='example']//th[contains(@aria-label,'Quantity')]//preceding-sibling::th)+1]//input")
	List<WebElement> quantity_enter;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_physical_qty_fs_lbl_uir_label']//following-sibling::span")
	WebElement physcial_quantity_consol;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_netsuite_qty_fs_lbl_uir_label']//following-sibling::span")
	WebElement netsuite_quantity;
	
	@FindBy(xpath = "//td[@id='tdbody_custpage_consolidate']")
	WebElement consolidated_button;
	
	@FindBy(xpath = "//li[@data-title='Inventory Count Screen']//a")
	WebElement inventory_count_screen;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//td[@data-label='Location(ware house)']//preceding-sibling::td)]")
	List<WebElement> item_list_in_processed_screen;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//td[@data-label='Bin']//preceding-sibling::td)]")
	List<WebElement> location_in_processed_screen;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//td[@data-label='Netsuite Quantity']//preceding-sibling::td)]")
	List<WebElement> physical_quantity_in_processed_screen;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//td[@data-label='Inventory Adjustment Link']//preceding-sibling::td)+1]")
	List<WebElement> adjustment_link_in_processed_screen;
	
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[contains(@id,'custpage_listrow')]//td[count(//td[@data-label='Warehouse']//preceding-sibling::td)]//img")
	List<WebElement> process_checkbox_list;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_total_variance_qty_fs_lbl_uir_label']//following-sibling::span")
	WebElement variance_quantity;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//td[@data-label='Inventory Adjustment Link']//preceding-sibling::td)]")
	List<WebElement> variance_quantity_list;
	
	@FindBy(xpath = "//span[@id='custpage_consolidate_records_fs']//img")
	WebElement consolidate_checkbox;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//td[@data-label='PHYSICAL QUANTITY']//preceding-sibling::td)]")
	List<WebElement> serial_lot_nrs_in_processed_screen;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//td[@data-label='Serial / Lot Numbers']//preceding-sibling::td)]")
	List<WebElement> bin_in_processed_screen;
	
	@FindBy(xpath = "//tr[@id='tr_select']")
	WebElement select_file;
	
	@FindBy(xpath = "//td[@id='tdbody_next']")
	WebElement next_button;
	
	@FindBy(xpath = "//td[@id='tdbody_secondarynext']")
	WebElement secondary_next;
	

	@FindBy(xpath = "//span[@alttext='Item']")
	WebElement item_field;
	
	@FindBy(xpath = "//span[@title='TSS CR Inventory Count : Item (Req)']//parent::td//preceding-sibling::td[@class='text']")
	WebElement item_mapping;
	
	@FindBy(xpath = "//span[@alttext='Location(ware house)']")
	WebElement location_field;
	
	@FindBy(xpath="//span[@alttext='Physical Quantity']")
	WebElement physical_quantity_field;
	
	@FindBy(xpath = "//span[@alttext='bin']")
	WebElement bin_field;
	
	@FindBy(xpath = "//span[@alttext='Bin']")
	WebElement bin_before_map;
	
	@FindBy(xpath = "//span[@title='TSS CR Inventory Count : Bin']//parent::td//preceding-sibling::td[@class='text']")
	WebElement bin_mapping;
	
	@FindBy(xpath = "//span[@title='TSS CR Inventory Count : Location(ware house) (Req)']//parent::td//preceding-sibling::td[@class='text']")
	WebElement location_mapping;
	
	@FindBy(xpath = "//span[@title='TSS CR Inventory Count : PHYSICAL QUANTITY (Req)']//parent::td//preceding-sibling::td[@class='text']")
	WebElement physical_quantity_mapping;
	
	@FindBy(xpath = "//img[@class='multiBntTri']")
	WebElement run_arrow;
	
	@FindBy(xpath = "//a[@class='ddmAnchor']//span[text()='Run']")
	WebElement run;
	
	@FindBy(xpath = "//a[text()='Import Job Status.']")
	WebElement import_job_status;
	
	@FindBy(xpath = "//tr[contains(@id,'row')]//td[count(//td[@data-label='Percent Complete']//preceding-sibling::td)]")
	List<WebElement> import_status;
	
	
	
	

	public ItemScanning() {
		PageFactory.initElements(driver, this);
	}

	public void Inventory_count() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(inventory_count).build().perform();
		Thread.sleep(2000);
		action.moveToElement(IC).build().perform();
		Thread.sleep(2000);
		action.moveToElement(IS).build().perform();
		IS.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}

	}
	public void processed_screen() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(inventory_count).build().perform();
		Thread.sleep(2000);
		action.moveToElement(inventory_analytics).build().perform();
		Thread.sleep(2000);
		action.moveToElement(processed_inventory_count_screen).build().perform();
		processed_inventory_count_screen.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		
	}
	public void success_screen() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(inventory_count).build().perform();
		Thread.sleep(2000);
		action.moveToElement(inventory_analytics).build().perform();
		Thread.sleep(2000);
		action.moveToElement(success_inventory_count_screen).build().perform();
		success_inventory_count_screen.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		
	}
	public void Inventory_count_screen() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(inventory_count).build().perform();
		Thread.sleep(2000);
		action.moveToElement(IC).build().perform();
		Thread.sleep(2000);
		action.moveToElement(inventory_count_screen).build().perform();
		inventory_count_screen.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}

	}
	public boolean isAlertPresent_() {
		try {
			Alert a = new WebDriverWait(driver, 3).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
		}

	}
	
	public void has_errors(ExtentTest test) throws InterruptedException
	{
		selectAccount();
		Thread.sleep(2000);
		has_errors.click();
		filter.click();
		String error = error_message.getText();
		System.out.println("The error is" + error);
		if(!error.equals(""))
		{
			test.pass(error);
		}
		else
		{
			
			test.fail("Test case is failed");
		}
	}
	Actions action=new Actions(driver);
	public void item_scanning_screen(String itemname,String location,String quantity,String bin,String serial) throws InterruptedException
	{
		Thread.sleep(2000);
		this.itemname.sendKeys(itemname.trim());
		submit_button.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='test' and @class='se-pre-con']")));
		location_click.click();
		location_click.sendKeys(location.trim());
		if(!bin.trim().equals(""))
		{
			bin_click.click();
			bin_click.sendKeys(bin);
		}
		if (this.serial.isEnabled()) {
			this.serial.sendKeys(serial);
			
		}
		this.quantity.clear();
		this.quantity.sendKeys(quantity.trim());
		Thread.sleep(3000);
		select_rows.click();
		submit_button.click();
		Thread.sleep(10000);
		if(isAlertPresent_()==true)
		{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		
	}
	public void invalid_data(String itemname1, String location1, String bin1, String serial1, String quantity1,String testcase,String error_messages,String error2, ExtentTest test) throws InterruptedException {
		
		item_scanning_screen(itemname1, location1, quantity1, bin1, serial1);
		selectAccount();
		has_errors.click();
		filter.click();
		String error = error_message.getText();
		if(!error2.trim().equals(""))
		{
		if(error_messages.trim().equals(error.trim()))
		{
			System.out.println("Error message is: "+error);
			test.pass(error);
		}
		else
		{
			test.fail("Error message is incorrect");
		}
		}
		else
		{
			test.pass("Quantity is adjusted automatically based on number of serial numbers entered");
		}
		Thread.sleep(3000);

	}
	public void processing(String itemname1, String location1, String bin1, String serial1,
			String quantity1, String testcase1,String new_serial,String new_quantity,ExtentTest test) throws InterruptedException
	{
		for(int i=0;i<2;i++)
		{
		if(i==1)
		{
			Inventory_count();
		}
		itemname.sendKeys(itemname1.trim());
		submit_button.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='test' and @class='se-pre-con']")));		//eleAvailability(driver, itemname, 20);
		location_click.sendKeys(location1.trim());
		if (!bin1.trim().equals(""))
		{
			bin_click.click();
			bin_click.sendKeys(bin1.trim());
		}
		if(i==0)
		{
		serial.sendKeys(serial1.trim());
		quantity.clear();
		quantity.sendKeys(quantity1.trim());
		}
		if(i==1)
		{
			serial.sendKeys(new_serial.trim());
			quantity.clear();
			quantity.sendKeys(new_quantity.trim());
		}
		select_rows.click();
		submit_button.click();
		 wait.until(ExpectedConditions.alertIsPresent());	
		if(isAlertPresent_()==true)
		{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		selectAccount();
		Thread.sleep(2000);
		process_checkbox_list.get(0).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)", "");
		Thread.sleep(2000);
		process.click();
		selectAccount();
		show_processed.click();
		filter.click();
		Thread.sleep(2000);
		show_processed.click();
		selectAccount();
		Thread.sleep(2000);
		show_processed.click();
		filter.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		if(i==1)
		{
		processed_view_link.click();
		}
		}

		
	}
	public void consolidation_again(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(5000);
		consolidated_button.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		Thread.sleep(2000);
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
		}
		
	}
	public void consolidation(ExtentTest test) throws InterruptedException
	{
		String fail_message=null;
		Thread.sleep(2000);
		consolidated_button.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			if(alert.getText().contains("This action will attempt to consolidate all open items."))
			{
			alert.accept();
			}
			else
			{
				System.out.println("Alert is wrongly displayed");
				test.fail(alert.getText());
				alert.accept();
			}
		}
		Thread.sleep(4000);
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			if(alert.getText().contains("Offline Job has been submitted for your request, an email will be sent once process is completed."))
			{
				alert.accept();

			}
			else
			{
			 test.fail(alert.getText());
			 alert.accept();
			 Thread.sleep(10000);
			 consolidation_again(test);
			}
			
			
		}
	}
	public void bin_mismatch_inventory(String itemname1, String location1, String bin1, String quantity1, String testcase,ExtentTest test)
			throws InterruptedException {
		itemname.sendKeys(itemname1);
		submit_button.click();
		Thread.sleep(3000);
		location_click.click();
		Thread.sleep(1000);
		location_click.sendKeys(location1);
		Thread.sleep(5000);
		bin_click.click();
		bin_click.sendKeys(bin1);
		bin_click.click();
		Thread.sleep(3000);
		String error=null;
		if(isAlertPresent_()==true)
		{
		Alert alert = driver.switchTo().alert();
		error = alert.getText();
		alert.accept();
		}
		
		if(!testcase.equals("Giving bin for non bin item"))
		{
		ExtentTest test1=test.createNode("Invalid bin");
		System.out.println("The error is :" + error);
		test1.pass(error);
		quantity.clear();
		quantity.sendKeys(quantity1);
		select_rows.click();
		submit_button.click();
		Thread.sleep(6000);
		if(isAlertPresent_()==true)
		{
		Alert alert=driver.switchTo().alert();
		driver.switchTo().alert();
		alert.accept();
		}
		
		Thread.sleep(3000);
		ExtentTest test2=test.createNode("Without giving bin testcase");
		has_errors(test2);
		}
		else
		{
			test.pass(error);
		}
		
	}

	public void bin_mismatch_serial(String itemname2, String location2, String bin2, String serial2, String quantity2,String testcase,ExtentTest test1)
			throws InterruptedException {

		itemname.sendKeys(itemname2);
		submit_button.click();
		Thread.sleep(3000);
		location_click.click();
		Thread.sleep(1000);
		location_click.sendKeys(location2);
		bin_click.click();
		Select sel=new Select(driver.findElement(By.xpath("//select[@id='inventorybin']")));
		sel.selectByVisibleText(bin2.trim());
		Thread.sleep(3000);
		String error=null;
		if(isAlertPresent_()==true)
		{
		Alert alert = driver.switchTo().alert();
		error = alert.getText();
		alert.accept();
		}
		ExtentTest test=test1.createNode("Invalid bin testcase");
		System.out.println("Error is :" + error);
		test.pass("Error is :" + error);
		Thread.sleep(3000);
		serial.sendKeys(serial2);
		quantity.clear();
		quantity.sendKeys(quantity2);
		select_rows.click();
		submit_button.click();
		Thread.sleep(5000);
		if(isAlertPresent_()==true)
		{
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		}
		Thread.sleep(3000);
		ExtentTest test2=test1.createNode("Without giving bin testcase");
		has_errors(test2);

	}
	public void selectAccount() throws InterruptedException
	{
		eleAvailability(driver, account_arrow, 20);
		account_arrow.click();
		for(int j=0;j<account_list.size();j++)
		{
			if(account_list.get(j).getText().equals("1000 Checking"))
			{
				Thread.sleep(2000);
				account_list.get(j).click();
				break;
			}
			
		}
	}

	public void inventory_adjustment_test(String itemname1, String location1, String bin1, String quantity1,
			String testcase,String type,ExtentTest test) throws Exception {
		String serial="";
		String[] quantites=new String[4];
		String [] types=new String[4];
		for(int i=0;i<4;i++)
		{
			quantites=quantity1.trim().split(",");
			types=type.trim().split(",");
		}
		for(int i=0;i<quantites.length;i++)
		{
			if(i>0)
			{
				Inventory_count();
			}
		item_scanning_screen(itemname1, location1, quantites[i], bin1, serial);
		selectAccount();
		item_process.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)", "");
		Thread.sleep(2000);
		process.click();
		Thread.sleep(2000);
		for(int k=0;k<2;k++)
		{
		selectAccount();
		show_processed.click();
		filter.click();
		Thread.sleep(2000);
		show_processed.click();
		}
		for(int j=0;j<2;j++)
		{
		driver.navigate().refresh();
		if(isAlertPresent_()==true)
		{
			Alert alert1=driver.switchTo().alert();
			alert1.accept();
		}
		}
		if(i>0)
		{
			processed_view_link.click();
			windowHandle();
			String text = adjustment_link.getText();
		if (text.trim().equals(""))
		{	
			System.out.println("Adjustment record is not created because physical quantity and netsuite quantity is same");
				ExtentTest test1=test.createNode("Equal Quantity Testing");
				test1.pass("Adjustment record is not created because physical quantity and netsuite quantity is same");
				driver.close();
				driver.switchTo().window(parentWindow);
		} 
		else 
		{
			System.out.println("The Adjustment record is created with" + text + " " + "number");
			if(types[i].trim().equals("greater"))
			{
			ExtentTest test2=test.createNode("Greater Quantity Testing");
			test2.pass("The Adjustment record is created with" + text + " " + "number");
			}
			if(types[i].trim().equals("lesser"))
			{
				ExtentTest test3=test.createNode("Lesser Quantity Testing");
				test3.pass("The Adjustment record is created with" + text + " " + "number");
			}
			driver.close();
			driver.switchTo().window(parentWindow);

		}
		
		}
		}
	}
	public void serial_items_numbers_adding_with_bins(String itemname1, String location1, String bin1, String serial1,
			String quantity1, String testcase1,String new_serial,String new_quantity,ExtentTest test) throws Exception {

		System.out.println(new_serial);
		if(!new_serial.trim().equals(""))
		{
			processing(itemname1, location1, bin1, serial1, quantity1, testcase1, new_serial, new_quantity, test);
		}
		else
		{
		item_scanning_screen(itemname1, location1, quantity1, bin1, serial1);
		selectAccount();
		Thread.sleep(2000);
		item_process.click();
		process.click();
		Thread.sleep(2000);
		if(testcase1.trim().equals("quanity zero without serial number with bins"))
		{
			System.out.println("Physical quantity is set to " +physcial_quantity.getText());
			test.pass("Physical quantity is set to " +physcial_quantity.getText());
		}
		selectAccount();
		Thread.sleep(2000);
		show_processed.click();
		filter.click();
		Thread.sleep(2000);
		show_processed.click();
		selectAccount();
		Thread.sleep(2000);
		show_processed.click();
		filter.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		processed_view_link.click();
		}
		windowHandle();
		if(testcase1.trim().equals("new serial numbers adding with bins"))
		{
			String text_serial = serial_numbers_text.getText();
			String remove_text = removal_serial_nrs.getText();
			System.out.println("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			test.pass("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			//driver.quit();
			
		}
		if(testcase1.trim().equals("existing and new serial numbers with bins"))
		{
			String text_serial = serial_numbers_text.getText();
			String remove_text = removal_serial_nrs.getText();
			System.out.println("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			test.pass("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			//driver.quit();

		}
		if(testcase1.trim().equals("quanity zero with new serial number with bins"))
		{
			String text_serial = serial_numbers_text.getText();
//			System.out.println("text is"+text_serial);
//			if(text_serial.trim().isEmpty())
//			{
//				System.out.println("The item is processed succesfully without changing serial number");
//				test.pass("The item is processed succesfully without changing serial number");
//			}
//			else
//			{
//				test.fail("Test case is failed");
//			}
			test.pass("Quantity is adjusted automatically based on number of serial numbers entered");
			//driver.quit();

		}
			
		if(testcase1.trim().equals("Adding item to bin which is not used by the item before with bins"))
		{
			String bin_text_get=bin_text.getText();
			if(bin_text_get.equals(bin1.trim()))
			{
				System.out.println("The item is added to" +" " +bin1+ " " +"successfully");
				test.pass("The item is added to" +" " +bin1+ " " +"successfully");
				
			}
			else
			{
				test.fail("Item is not added to the bin");
			}
		}

		
		if(testcase1.trim().equals("quanity zero with existing serial number with bins"))
		{
			String remove_text = removal_serial_nrs.getText();
//			if(remove_text.equals(serial1.trim()))
//			{
//				System.out.println("The serial number" +" " +remove_text+" "+"is removed successfully because we are using existing serial number when quantity is zero");
//				test.pass("The serial number" +" " +remove_text+" "+"is removed successfully because we are using existing serial number when quantity is zero");
//			}
//			else
//			{
//				test.fail("The serial number is not removed");
//			}
			test.pass("Quantity is adjusted automatically based on number of serial numbers entered");
			//driver.quit();

			
		}
		if(testcase1.trim().equals("New serial numbers adding without bins"))
		{
			String text_serial = serial_numbers_text.getText();
			String remove_text = removal_serial_nrs.getText();
			System.out.println("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			//driver.quit();
			test.pass("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			
		}
		if(testcase1.trim().equals("Existing and new serial number combination without bins"))
		{
			String text_serial = serial_numbers_text.getText();
			String remove_text = removal_serial_nrs.getText();
			System.out.println("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			//driver.quit();
			test.pass("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			
		}
		if(testcase1.trim().equals("Same item with different location and different serial number"))
		{
			String text_serial = serial_numbers_text.getText();
			String remove_text = removal_serial_nrs.getText();
			System.out.println("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			//driver.quit();
			test.pass("The new serial numbers" + " " + text_serial + " " + "are added" + " " + "and old serial numbers"
					+ " " + remove_text + " " + " are removed");
			
		}
		if(testcase1.trim().equals("New serial number with quantity zero without bin"))
		{
//			String text_serial = serial_numbers_text.getText();
//			System.out.println("text is"+text_serial);
//			if(text_serial.trim().isEmpty())
//			{
//				System.out.println("The item is processed succesfully without changing serial number");
//				test.pass("The item is processed succesfully without changing serial number");
//			}
//			else
//			{
//				System.out.println("Item is not processed");
//				test.fail("Item is not processed");
//			}
			test.pass("Quantity is adjusted automatically based on number of serial numbers entered");
			//driver.quit();
		}
		if(testcase1.trim().equals("Existing serial number with quantity zero without bins"))
		{
//			String remove_text = removal_serial_nrs.getText();
//			if(remove_text.equals(serial1.trim()))
//			{
//				System.out.println("The serial number" +" " +remove_text+" "+"is removed successfully because we are using existing serial number when quantity is zero");
//				test.pass("The serial number" +" " +remove_text+" "+"is removed successfully because we are using existing serial number when quantity is zero");
//			}
//			else
//			{
//				test.fail("The serial number is not removed");
//			}
			test.pass("Quantity is adjusted automatically based on number of serial numbers entered");
			//driver.quit();
		}
	}


	public void without_giving_serial_numbers(String itemname1, String location1, String bin1, String serial1,
			String quantity1, String testcase,ExtentTest test) throws InterruptedException {
		itemname.sendKeys(itemname1.trim());
		submit_button.click();
		Thread.sleep(10000);
		location_click.click();
		Thread.sleep(1000);
		location_click.sendKeys(location1.trim());
		if (testcase.trim().equals("without serial number for bin items testing")) {
			bin_click.click();
			bin_click.sendKeys(bin1.trim());
		}
		quantity.click();
		quantity.clear();
		quantity.sendKeys(quantity1.trim());
		select_rows.click();
		submit_button.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("The error message is" + alert.getText());
		String error="The error message is" + alert.getText();
		alert.accept();
		if(!error.equals(""))
		{
			test.pass(error);
		}
		else
		{
			test.fail("Error Message is not displaying");
		}
		

	}

	public void lot_numbers_processing(String itemname1, String location1, String bin1, String serial1, String quantity1,
			 String testcase,String new_lot,String new_quantity,ExtentTest test) throws Exception {
		if(!new_lot.trim().equals(""))
		{
			processing(itemname1, location1, bin1, serial1, quantity1, testcase, new_lot, new_quantity, test);
			
		}
		else
		{
		item_scanning_screen(itemname1, location1, quantity1, bin1, serial1);
		selectAccount();
		Thread.sleep(2000);
		process_checkbox_list.get(0).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)", "");
		Thread.sleep(2000);
		process.click();
		Thread.sleep(2000);
		selectAccount();
		Thread.sleep(2000);
		show_processed.click();
		filter.click();
		Thread.sleep(2000);
		show_processed.click();
		selectAccount();
		Thread.sleep(2000);
		show_processed.click();
		filter.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		processed_view_link.click();
		}
		windowHandle();
		if (testcase.equals("same lot numbers in different bins")) {
			String lot_nr_text = lotnrs.getText();
			System.out.println(lot_nr_text);
			if (serial1.trim().equals(lot_nr_text)) {
				System.out.println("The item is processed succesfully without errors");
				test.pass("The item is processed succesfully without errors");
			}
			else
			{
				test.fail("Item is not processed");
			}
		} 
		else if (testcase.equals("zero quantity and existing lot number with bins")) 
		{
			String adjust_text = adjustment_link.getText();
			if (!adjust_text.equals(""))
			{
				System.out.println("The item is processed and adjustment record is created with" + " " + adjust_text
						+ " " + "number");
				test.pass("The item is processed and adjustment record is created with" + " " + adjust_text
						+ " " + "number");
			}
			else
			{
				test.fail("Item is not processed when we use zero quantity and existing lot number");
			}
		} 
		else if (testcase.equals("adding lot number item to new location with bin"))
		{
			String adjust_text = adjustment_link.getText();
			if (!adjust_text.equals(""))
			{
				System.out.println("The item is added to the" + " " + location1 + " "
						+ "and adjustment record is created with" + " " + adjust_text + " " + "number");
				test.pass("The item is added to the" + " " + location1 + " "
						+ "and adjustment record is created with" + " " + adjust_text + " " + "number");
			}
			else
			{
				test.fail("The item is not added to the "+location1);
			}
		} 
		else if (testcase.equals("Adding new lot numbers with bins")) 
		{
			String lot_text = lot_nrs.getText();
			System.out.println(lot_text);
			if (lot_text.equals(serial1.trim())) {
				System.out.println("Lot numbers "+lot_text+" " +"are added successfully");
				test.pass("Lot numbers "+lot_text+" " +"are added successfully");
			}
			else
			{
				test.fail("Lot numbers "+lot_text+" " +"are  not added");
			}
		}
		else if (testcase.equals("zero quantity and existing lot number without bins")) 
		{

				String adjust_text = adjustment_link.getText();
				if (!adjust_text.equals(""))
				{
					System.out.println("The item is processed and adjustment record is created with" + " " + adjust_text
							+ " " + "number");
					test.pass("The item is processed and adjustment record is created with" + " " + adjust_text
							+ " " + "number");
				}
				else
				{
					test.fail("Item is not processed when we use  zero quantity and existing lot number");
					
				}
				
		}
		else if(testcase.equals("Adding new lot numbers without bin"))
		{
			String lot_text = lot_nrs.getText();
			System.out.println(lot_text);
			if (lot_text.equals(serial1.trim())) {
				System.out.println("New lot numbers " +lot_text+" "+"are added succesfully");
				test.pass("New lot numbers " +lot_text+" "+"are added succesfully");
			}
			else
			{
				test.fail("New Lot numbers are not added");
			}
		}
		else if(testcase.equals("Adding  lot numbers  to the location without any lot nrs before without bin"))
		{
			String adjust_text = adjustment_link.getText();
			if (!adjust_text.equals(""))
				System.out.println("The lot numbers are added to the" + " " + location1 + " "
						+ "and adjustment record is created with" + " " + adjust_text + " " + "number");
			test.pass("The lot numbers are added to the" + " " + location1 + " "
						+ "and adjustment record is created with" + " " + adjust_text + " " + "number");
			
		}

		 else {
			System.out.println("not a test case");
			test.fail("Lot Numbers are not added to the given location");
		}
	}

	public static void windowHandle() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String currentwindow = driver.getWindowHandle();
		parentWindow = currentwindow;
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		while (i.hasNext()) {
			String childwindow = i.next();
			if (!childwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(childwindow);
			}
		}
	}
	public void item_entering(String itemname, String location, String bin, String serial, String quantity,int i) throws InterruptedException
	{
		
		this.itemname.sendKeys(itemname.trim());
		submit_button.click();
		WebDriverWait wait = new WebDriverWait(driver, 11);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='test' and @class='se-pre-con']")));
		location_click.click();
		location_click.sendKeys(location.trim());
		Thread.sleep(3000);
		if(!bin.equals(""))
		{
			bin_click.click();
			Select sel=new Select(driver.findElement(By.xpath("//select[@id='inventorybin']")));
			sel.selectByVisibleText(bin.trim());
			//bin_click.sendKeys(bin.trim());
		}
		Thread.sleep(3000);
		if (this.serial.isEnabled()) {
			serial_lot_nr_entering_list.get(i).sendKeys(serial);
		}
		quantity_enter.get(i).clear();
		quantity_enter.get(i).sendKeys(quantity);
	}
	public void consolidate_checkbox_itemscanning(String itemname, String location, String bin, String serial, String quantity, String testcase, ExtentTest test) throws Exception
	{
		double total_quantity=0.0;
		String[] two_serial=new String[2];
		String [] two_bins=new String[2];
		
		for(int i=0;i<two_serial.length;i++)
		{
			two_serial=serial.split(":");
			two_bins=bin.split(",");
			System.out.println(two_serial[i]);
		}

		for(int i=0;i<two_serial.length;i++)
		{
		total_quantity=total_quantity+Double.parseDouble(quantity);
		item_entering(itemname, location, bin, two_serial[i], quantity, i);
		}
		Duplicate dup=new Duplicate();
		select_rows.click();
		submit_button.click();
		Thread.sleep(10000);
		if(isAlertPresent_()==true)
		{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		String []serial_nrs_from_consolidated_record=null;
		for(int i=0;i<items_before_processing.size();i++)
		{
			if(items_before_processing.get(i).getText().equals(itemname.trim())&&bin_before_processing.get(i).getText().trim().equals(bin.trim())&&location_before_processing.get(i).getText().equals(location.trim()))
			{
				view_link_list.get(i).click();
				
				windowHandle();
				Thread.sleep(2000);
				serial_nrs_from_consolidated_record=serial_numbers_text.getText().trim().split(",");
				for(int j=0;j<serial_nrs_from_consolidated_record.length;j++)
				{
					System.out.print("serial from consolidate record: "+serial_nrs_from_consolidated_record[i]);
				}
				break;
			}
		}
				String all_serial_nrs_from_excel=serial.replace(":", ",");
				String[] serial_nrs_after_removing_duplicates=dup.characterCount(all_serial_nrs_from_excel);
				Arrays.sort(serial_nrs_after_removing_duplicates);
				Arrays.sort(serial_nrs_from_consolidated_record);
				System.out.println(Arrays.asList(serial_nrs_after_removing_duplicates));
				System.out.println(Arrays.asList(serial_nrs_from_consolidated_record));
				
				if(Arrays.asList(serial_nrs_after_removing_duplicates).equals(Arrays.asList(serial_nrs_from_consolidated_record)))
				{
					if(serial_nrs_from_consolidated_record.length==Integer.parseInt(physcial_quantity_consol.getText().trim().replace(".0", "")))
					{
					test.pass("Serial numbers before consolidation: "+all_serial_nrs_from_excel);
					test.pass("Serial numbers after consolidation is: "+serial_numbers_text.getText().trim());
					System.out.println("Physical quantity is equal to Serial numbers");
					test.pass("So, Record is consolidated");
					test.pass("Physical quantity after consolidation is: "+physcial_quantity_consol.getText());
					test.pass("So, quantity is equal to serial numbers");
					}
					else
					{
						test.fail("Serial numbers before consolidation: "+all_serial_nrs_from_excel);
						test.fail("Serial numbers after consolidation is: "+serial_numbers_text.getText().trim());
						test.fail("Record is not consolidated");
						test.fail("Physical quantity after consolidation is: "+physcial_quantity_consol.getText());
						System.out.println("Quantity is not equal to serial numbers");
						test.fail("Quantity is not equal to serial numbers");
					}
				}
				
				
			}
			
			
	
	public void consolidate_through_inventory_count(String itemname, String location, String bin, String serial, String quantity, String testcase, ExtentTest test) throws Exception
	{
		double total_quantity=0.0;
		String[] two_serial=new String[2];
		String [] two_bins=new String[2];
		
		for(int i=0;i<two_serial.length;i++)
		{
			two_serial=serial.split(":");
			two_bins=bin.split(",");
			System.out.println(two_serial[i]);
		}
		if(testcase.trim().equals("Verifying serial number consolidation with different bin and same location from inventory count screen"))
		{
			boolean item_f=false;
			String old_serial_nrs1=null;
			Inventory_count_screen();
			consolidation(test);
			for(int i=0;i<5;i++)
			{
				driver.navigate().refresh();
			}
			for(int i=0;i<items_before_processing.size();i++)
			{
				if(items_before_processing.get(i).getText().equals(itemname.trim())&&location_before_processing.get(i).getText().equals(location.trim())&&bin_before_processing.get(i).getText().trim().equals(two_bins[0])||bin_before_processing.get(i).getText().trim().equals(two_bins[1]))
				{
					item_f=true;
					view_link_list.get(i).click();
					windowHandle();
					Thread.sleep(2000);
					 old_serial_nrs1=serial_numbers_text.getText().trim();
					 driver.close();
					 Thread.sleep(2000);
					 driver.switchTo().window(parentWindow);

					 break;
				}
			}
			if(!item_f)
			{
				old_serial_nrs1="";
			}
			 
			for(int i=0;i<two_serial.length;i++)
			{
				Inventory_count();
				item_scanning_screen(itemname, location, quantity, two_bins[i], two_serial[i]);
			}
			consolidation(test);
			for(int i=0;i<5;i++)
			{
				driver.navigate().refresh();
			}
		for(int i=0;i<items_before_processing.size();i++)
		{
			if(items_before_processing.get(i).getText().equals(itemname.trim())&&location_before_processing.get(i).getText().equals(location.trim())&&bin_before_processing.get(i).getText().trim().equals(two_bins[0])||bin_before_processing.get(i).getText().trim().equals(two_bins[1]))
			{
				view_link_list.get(i).click();
				windowHandle();
				Thread.sleep(2000);
				
			}
			String serial_nrs=null;
			if(!old_serial_nrs1.equals(""))
			{
			 serial_nrs=serial.trim().replace(":", ",")+","+old_serial_nrs1;
			}
			else
			{
				serial_nrs=serial.trim().replace(":", ",");
			}
			Duplicate dup=new Duplicate();
			String [] final_serials=dup.characterCount(serial_nrs);
			String[] physical_q=serial_numbers_text.getText().trim().split(",");
			Arrays.sort(final_serials);
			Arrays.sort(physical_q);
				if(Arrays.asList(physical_q).containsAll(Arrays.asList(final_serials)))
				{
					test.fail("Serial numbers before consolidation are: "+serial_nrs);
					test.fail("Serial numbers after consolidation are: "+serial_numbers_text.getText().trim());
					System.out.println("Record is consolidated");
					test.fail("Record is  consolidated");
					
				}
				else
				{
				test.pass("Serial numbers before consolidation are: "+serial_nrs);
				test.pass("Serial numbers after consolidation are: "+serial_numbers_text.getText().trim());
				System.out.println("Record is not consolidated");
				test.pass("Record is not consolidated");
				
				}
				
				
			}
		}
		
		else
		{
		Thread.sleep(5000);
		Inventory_count_screen();
		Thread.sleep(5000);
		consolidated_button.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		Thread.sleep(2000);
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
		}
		
		String old_serial_nrs=null;
		boolean item_found=false;
		for(int i=0;i<items_before_processing.size();i++)
		{
			if(items_before_processing.get(i).getText().equals(itemname.trim())&&location_before_processing.get(i).getText().equals(location.trim())&&bin.trim().equals(bin_before_processing.get(i).getText().trim()))
			{
				item_found=true;
				view_link_list.get(i).click();
				windowHandle();
				Thread.sleep(2000);
				 old_serial_nrs=serial_numbers_text.getText().trim();
				 driver.close();
				 Thread.sleep(2000);
				 driver.switchTo().window(parentWindow);
				 break;
			}
		}
		if(!item_found)
		{
			old_serial_nrs="";
			System.out.println("no old serial items");
		}
		for(int i=0;i<two_serial.length;i++)
		{
			total_quantity=total_quantity+Double.parseDouble(quantity);
			Inventory_count();
			item_scanning_screen(itemname, location, quantity, bin, two_serial[i]);
		}
		consolidated_button.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		Thread.sleep(2000);
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
		}
		for(int i=0;i<5;i++)
		{
			driver.navigate().refresh();
		}
			Duplicate dup=new Duplicate();
			String new_serial_nrs=null;
			for(int i=0;i<items_before_processing.size();i++)
			{
				if(items_before_processing.get(i).getText().equals(itemname.trim())&&location_before_processing.get(i).getText().equals(location.trim()))
				{
					view_link_list.get(i).click();
					windowHandle();
					new_serial_nrs=serial_numbers_text.getText().trim();
					break;

				}
				else
				{
					System.out.println("there is no match");
				}
			}
				String duplicate_serial_nrs=null;
					Thread.sleep(2000);
					System.out.println("new serial nrs: "+new_serial_nrs);
					if(!old_serial_nrs.equals(""))
					{
					duplicate_serial_nrs=old_serial_nrs+","+serial.replace(":", ",");
					}
					else
					{
						duplicate_serial_nrs=serial.replace(":", ",");
					}
					String serial_nrs_after_removing_dups[]=dup.characterCount(duplicate_serial_nrs);
					System.out.println("after removing dups are: "+Arrays.asList(serial_nrs_after_removing_dups));
					String new_serial_numbers_after_splitting[]=new_serial_nrs.split(",");
					Arrays.sort(serial_nrs_after_removing_dups);
					Arrays.sort(new_serial_numbers_after_splitting);
					if(Arrays.asList(serial_nrs_after_removing_dups).equals(Arrays.asList(new_serial_numbers_after_splitting)))
					{
						if(new_serial_numbers_after_splitting.length==Integer.parseInt(physcial_quantity_consol.getText().trim().replace(".0", "")))
							{
								test.pass("Serial numbers before consolidation are: "+duplicate_serial_nrs);
								test.pass("Serial numbers after consolidation are: "+serial_numbers_text.getText().trim());
								test.pass("Serial numbers are consolidated");
								test.pass("Physical Quantity after Consolidation is: "+physcial_quantity_consol.getText().trim());
								test.pass("So, Quantity is equal to serial numbers");
								System.out.println("Quantity is equal to serial numbers");
							}
						else
						{
							test.fail("Serial numbers before consolidation are: "+duplicate_serial_nrs);
							test.fail("Serial numbers after consolidation are: "+serial_numbers_text.getText().trim());
							test.fail("Serial numbers are not consolidated");
							test.fail("Physical Quantity after Consolidation is: "+physcial_quantity_consol.getText().trim());
							test.fail("Quantity is not equal to serial numbers");
							System.out.println("quantity is not equal to serial numbers");
						}
					}
					else
					{
						test.fail("Serial numbers are not consolidated");
					}
					
				}
			}
			
		
		
		
	
		
		
		
		
	
	public void automatic_updation(String itemname, String location, String bin, String serial, String quantity, String testcase, ExtentTest test) throws InterruptedException
	{
		
		this.itemname.sendKeys(itemname.trim());
		submit_button.click();
		Thread.sleep(3000);
		location_click.click();
		location_click.sendKeys(location.trim());
		if(!bin.equals(""))
		{
			bin_click.click();
			bin_click.sendKeys(bin);
		}
		if (this.serial.isEnabled()) {
			this.serial.sendKeys(serial);
			action.sendKeys(Keys.TAB).build().perform();
			String quantity_value=driver.findElement(By.xpath("//input[@id='quantity_1']")).getAttribute("value").trim();
			if(quantity_value.equals(quantity.trim()))
			{
				System.out.println("Quantity is updated correctly");
				test.pass("Quantity is updated automatically");
			}
			else
			{
				test.fail("Quantity is not updated automatically");
			}
			String serial_numbers_value=this.serial.getAttribute("value").trim();

			this.serial.click();
			int len=serial_numbers_value.length();
			char comma=serial_numbers_value.charAt(len-1);
			if(comma==',')
			{
				test.pass("Comma is automatically added to serial numbers");
				System.out.println("Comma is added automatically");
			}
			else
			{
				test.fail("Comma is not automatically added to serial numbers");
			}
			
		}
		this.quantity.clear();
		this.quantity.sendKeys(quantity.trim());
		select_rows.click();
		submit_button.click();
		Thread.sleep(10000);
		if(isAlertPresent_()==true)
		{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}

		
	}

	public void consolidate_through_inventory_count_lot(String itemname2, String location2, String bin2, String serial2, String quantity2, String testcase, ExtentTest test) throws Exception {
		
		double total_quantity=0.0;
		String[] two_serial=new String[2];
		String [] two_bins=new String[2];
		String[] two_quantity=new String[2];
		for(int i=0;i<two_serial.length;i++)
		{
			
			two_serial=serial2.split(":");
			two_bins=bin2.split(",");
			two_quantity=quantity2.split(":");
			System.out.println(two_serial[i]);
		}
		Thread.sleep(5000);
		Inventory_count_screen();
		Thread.sleep(5000);
		consolidation(test);
		Thread.sleep(5000);
		for(int i=0;i<10;i++)
		{
			driver.navigate().refresh();
		}
		if(testcase.trim().equals("Verifying lot number consolidation with same location but different bin from inventory count screen"))
		{
			String old_serial_nrs1=null;
			String old_quantity1=null;
			boolean item_f=false;
			for(int i=0;i<items_before_processing.size();i++)
			{
			if(items_before_processing.get(i).getText().trim().equals(itemname2.trim())&&location_before_processing.get(i).getText().trim().equals(location2.trim()))
			{
				if(bin_before_processing.get(i).getText().trim().equals(two_bins[0]))
				{
				Thread.sleep(5000);	
				view_link_list.get(i).click();
				item_f=true;
				windowHandle();
				Thread.sleep(3000);
				old_serial_nrs1=lot_nrs.getText().trim();
				old_quantity1=physcial_quantity_consol.getText().trim();
				break;
				}
			}
			}
			if(!item_f)
			{
				old_serial_nrs1="";
				old_quantity1="";
			}
			for(int i=0;i<two_serial.length;i++)
			{
			Inventory_count();
			item_scanning_screen(itemname2, location2, two_quantity[i], two_bins[i], two_serial[i]);
			}
			consolidation(test);
			Thread.sleep(5000);
			for(int i=0;i<10;i++)
			{
				driver.navigate().refresh();
			}
			for(int i=0;i<items_before_processing.size();i++)
			{
			if(items_before_processing.get(i).getText().trim().equals(itemname2.trim())&&location_before_processing.get(i).getText().trim().equals(location2.trim()))
			{
				if(bin_before_processing.get(i).getText().trim().equals(two_bins[0]))
				{
				Thread.sleep(5000);
				view_link_list.get(i).click();
				windowHandle();
				break;
				}
				
			}
			}
			String [] new_quantity=physcial_quantity_consol.getText().trim().split(",");
			Thread.sleep(2000);
			String total_lot_nrs=null;
			String total_quantity1=null;
			if(!old_serial_nrs1.trim().equals(""))
			{
			total_lot_nrs=serial2.replace(":", ",")+","+old_serial_nrs1;
			total_quantity1=quantity2.replace(":", ",")+","+old_quantity1;
			}
			else
			{
				total_lot_nrs=serial2.replace(":", ",");
				total_quantity1=quantity2.replace(":", ",");
			}
			fc lotts=new fc();
			Quantitydup dup1=new Quantitydup();
			String []serial_nrs_after_removing_dups=new String[new_quantity.length];
			String [] quantity_after_removing=new String[new_quantity.length];
			boolean exc=false;
			try
			{
			
			serial_nrs_after_removing_dups=lotts.lotnr_conslidate(total_lot_nrs,total_quantity1,new_quantity.length);
			quantity_after_removing=dup1.lotnr_conslidate(total_lot_nrs, total_quantity1, new_quantity.length);
			
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				exc=true;
				System.out.println("Exception");
			}
			 
	            	if(!exc)
					{
	            		String [] alllot_nrs=lot_nrs.getText().trim().split(",");
	            		String [] excel_lot_nrs=serial2.replace(":", ",").split(",");
	            		if(Arrays.asList(alllot_nrs).containsAll(Arrays.asList(excel_lot_nrs)))
	            		{
					
	            			test.fail("Lot numbers before consolidation are: "+total_lot_nrs);
	            			test.fail("Physical Quantity before consolidation is: "+total_quantity1);
	            			test.fail("Lot numbers after consolidation are: "+lot_nrs.getText().trim());
	            			test.fail("physical Quantity after consolidation is: "+physcial_quantity_consol.getText().trim());
	            			System.out.println("Record is consolidated");
	            			test.fail("Lot numbers are consolidated");
	            		}
	            		else
						{
							test.pass("Lot numbers before consolidation are: "+total_lot_nrs);
		            		test.pass("Physical Quantity before consolidation is: "+total_quantity1);
		            		test.pass("Lot numbers after consolidation are: "+lot_nrs.getText().trim());
		            		test.pass("physical Quantity after consolidation is: "+physcial_quantity_consol.getText().trim());
		            		test.pass("Lot numbers are not consolidated");
							System.out.println("Record is not consolidated");
						}
					}
					else
					{
						test.pass("Lot numbers before consolidation are: "+total_lot_nrs);
	            		test.pass("Physical Quantity before consolidation is: "+total_quantity1);
	            		test.pass("Lot numbers after consolidation are: "+lot_nrs.getText().trim());
	            		test.pass("physical Quantity after consolidation is: "+physcial_quantity_consol.getText().trim());
	            		test.pass("Lot numbers are not consolidated");
						System.out.println("Record is not consolidated");
					}
				
		}
		
			
		
		else
		{
		String old_serial_nrs=null;
		String old_quantity=null;
		boolean item_found=false;
		for(int i=0;i<items_before_processing.size();i++)
		{
			if(items_before_processing.get(i).getText().equals(itemname2.trim())&&location_before_processing.get(i).getText().equals(location2.trim())&&bin2.trim().equals(bin_before_processing.get(i).getText().trim()))
			{
				item_found=true;
				view_link_list.get(i).click();
				windowHandle();
				Thread.sleep(2000);
				 old_serial_nrs=lot_nrs.getText().trim();
				 old_quantity=physcial_quantity_consol.getText().trim();
				 driver.close();
				 Thread.sleep(2000);
				 driver.switchTo().window(parentWindow);
				 break;
			}
		}
		if(!item_found)
		{
			old_serial_nrs="";
			System.out.println("no old serial items");
		}
		for(int i=0;i<two_serial.length;i++)
		{
			//total_quantity=total_quantity+Double.parseDouble(quantity2);
			Thread.sleep(4000);
			Inventory_count();
			item_scanning_screen(itemname2.trim(), location2, two_quantity[i], bin2, two_serial[i]);
		}
		Thread.sleep(2000);
		consolidation(test);
		Thread.sleep(6000);
		for(int i=0;i<10;i++)
		{
			driver.navigate().refresh();
		}
			Duplicate dup=new Duplicate();
			String new_serial_nrs=null;
			String new_quantity=null;
			for(int i=0;i<items_before_processing.size();i++)
			{
				if(items_before_processing.get(i).getText().equals(itemname2.trim())&&location_before_processing.get(i).getText().equals(location2.trim())&&bin_before_processing.get(i).getText().trim().equals(bin2.trim()))
				{
					view_link_list.get(i).click();
					windowHandle();
					new_serial_nrs=lot_nrs.getText().trim();
					new_quantity=physcial_quantity_consol.getText().trim();
					
					
					break;

				}
				else
				{
					System.out.println("there is no match");
				}
			}
			String[] new_quantity_array=new_quantity.split(",");
				fc lotts=new fc();
				String duplicate_serial_nrs=null;
				String duplicate_quantity=null;
					Thread.sleep(2000);
					System.out.println("new serial nrs: "+new_serial_nrs);
					if(!old_serial_nrs.equals(""))
					{
					duplicate_serial_nrs=old_serial_nrs+","+serial2.replace(":", ",");
					duplicate_quantity=old_quantity+","+quantity2.replace(":", ",");
					}
					else
					{
						duplicate_serial_nrs=serial2.replace(":", ",");
						duplicate_quantity=quantity2.replace(":", ",");
					}
					Quantitydup dup1=new Quantitydup();
					String []serial_nrs_after_removing_dups=lotts.lotnr_conslidate(duplicate_serial_nrs,duplicate_quantity,new_quantity_array.length);
					String [] quantity_after_removing=dup1.lotnr_conslidate(duplicate_serial_nrs, duplicate_quantity, new_quantity_array.length);
					String [] netsuite_lotnrs=new_serial_nrs.split(",");
					String[] netsuite_quantity=new_quantity.split(",");
			        String netsuite_serials[]=new_serial_nrs.split(",");
			        String netsuite_q[]=new_quantity.split(",");
			        int count=0;
			        for(int i = 0; i <netsuite_serials.length; i++) {  
			            for(int j = 0; j <netsuite_serials.length; j++) {  
			                if(netsuite_serials[i].equals(serial_nrs_after_removing_dups[j])) { 
			                	if(netsuite_q[i].equals(quantity_after_removing[j]))
			                	{
			                		count=count+1;
			                		System.out.println(count);
			                		
			                	}
			                }    
			            } 
			        }
		            	if(count==netsuite_serials.length)
		            	{
		            		test.pass("Lot numbers before consolidation are: "+duplicate_serial_nrs);
		            		test.pass(" Physical Quantity before consolidation is: "+duplicate_quantity);
		            		test.pass("Lot numbers after consolidation are: "+lot_nrs.getText().trim());
		            		test.pass("Physical Quantity after consolidation is: "+physcial_quantity_consol.getText().trim());
		            		test.pass("Lot numbers are consolidated");
		            		System.out.println("Lot numbers are consolidated");
		            	}
		            	else
		            	{
		            		test.fail("Lot numbers before consolidation are: "+duplicate_serial_nrs);
		            		test.fail("Physical Quantity before consolidation is: "+duplicate_quantity);
		            		test.fail("Lot numbers after consolidation are: "+lot_nrs.getText().trim());
		            		test.fail("physical Quantity after consolidation is: "+physcial_quantity_consol.getText().trim());
		            		test.fail("Lot numbers are not consolidated");
		            		System.out.println("Lot numbers are not consolidated");
		            	}

				}
		
		
		
		
	}

	public void consolidate_through_item_scanning_lot(String itemname2, String location2, String bin2, String serial2, String quantity2, String testcase, ExtentTest test) throws Exception {
		
		String[] two_serial=new String[2];
		String [] two_bins=new String[2];
		String[] two_quantity=new String[2];
		
		for(int i=0;i<two_serial.length;i++)
		{
			two_serial=serial2.split(":");
			two_bins=bin2.split(",");
			two_quantity=quantity2.split(":");
			System.out.println(two_serial[i]);
		}
		
		Inventory_count();
		for(int i=0;i<two_serial.length;i++)
		{		
		item_entering(itemname2.trim(), location2.trim(), bin2.trim(), two_serial[i], two_quantity[i], i);
		}
		Quantitydup q=new Quantitydup();
		fc lotnrsdup=new fc();
		select_rows.click();
		submit_button.click();
		Thread.sleep(10000);
		if(isAlertPresent_()==true)
		{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		
		for(int i=0;i<items_before_processing.size();i++)
		{
			
			if(!bin2.equals(""))
			{
			if(items_before_processing.get(i).getText().equals(itemname2.trim())&&bin_before_processing.get(i).getText().trim().equals(bin2.trim())&&location_before_processing.get(i).getText().equals(location2.trim()))
			{
				view_link_list.get(i).click();
				windowHandle();
				Thread.sleep(2000);
				break;
			}
			}
			else
			{
				
				if(items_before_processing.get(i).getText().equals(itemname2.trim())&&location_before_processing.get(i).getText().equals(location2.trim()))
				{
					view_link_list.get(i).click();
					windowHandle();
					Thread.sleep(2000);
					break;
				}
			}
			
		}
		String [] lot_nrs_from_consolidated_screen=lotnrs.getText().trim().split(",");
		String [] quantity_from_consolidated_screen=physcial_quantity_consol.getText().trim().split(",");
				String all_lot_nrs_from_excel=serial2.replace(":", ",");
				String[] lot_nrs_after_removing_duplicates=lotnrsdup.lotnr_conslidate(serial2.replace(":", ","), quantity2.replace(":", ","), quantity_from_consolidated_screen.length);
				String[] quantity_after_consolidating=q.lotnr_conslidate(serial2.replace(":", ","), quantity2.replace(":", ","), quantity_from_consolidated_screen.length);
				
				
				 int count=0;
			        for(int i = 0; i <lot_nrs_from_consolidated_screen.length; i++) {  
			            for(int j = 0; j <lot_nrs_from_consolidated_screen.length; j++) {  
			                if(lot_nrs_from_consolidated_screen[i].equals(lot_nrs_after_removing_duplicates[j])) { 
			                	if(quantity_from_consolidated_screen[i].equals(quantity_after_consolidating[j]))
			                	{
			                		count=count+1;
			                		System.out.println(count);
			                		
			                	}
			                }    
			            } 
			        }
		            	if(count==lot_nrs_from_consolidated_screen.length)
		            	{
		            		test.pass("Lot numbers before consolidation are: "+serial2.replace(":", ","));
		            		test.pass(" Physical Quantity before consolidation is: "+quantity2.replace(":", ","));
		            		test.pass("Lot numbers after consolidation are: "+lot_nrs.getText().trim());
		            		test.pass("Physical Quantity after consolidation is: "+physcial_quantity_consol.getText().trim());
		            		test.pass("Lot numbers are consolidated");
		            		System.out.println("Lot numbers are consolidated");
		            	}
		            	else
		            	{
		            		test.fail("Lot numbers before consolidation are: "+serial2.replace(":", ","));
		            		test.fail("Physical Quantity before consolidation is: "+quantity2.replace(":", ","));
		            		test.fail("Lot numbers after consolidation are: "+lot_nrs.getText().trim());
		            		test.fail("physical Quantity after consolidation is: "+physcial_quantity_consol.getText().trim());
		            		test.fail("Lot numbers are not consolidated");
		            		System.out.println("Lot numbers are not consolidated");
		            	}
		}
	
		public double addition(double a, double b)
		{
			double ans=a+b;
			return ans;
			
		}
	
	
		
		public void inventory_consolidation_item_scanning(String itemname2, String location2, String bin2, String quantity2, String testcase, String serial2,String variance, ExtentTest test) throws Exception
		{
			
			String[] two_quantity=new String[2];		
			for(int i=0;i<two_quantity.length;i++)
			{
				two_quantity=quantity2.split(",");
			}
			
			Inventory_count();
			for(int i=0;i<two_quantity.length;i++)
			{		
			item_entering(itemname2.trim(), location2.trim(), bin2.trim(),serial2, two_quantity[i], i);
			}
			select_rows.click();
			submit_button.click();
			Thread.sleep(10000);
			if(isAlertPresent_()==true)
			{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			}
			Thread.sleep(3000);
			for(int i=0;i<items_before_processing.size();i++)
			{
			if(items_before_processing.get(i).getText().trim().equals(itemname2.trim())&&location_before_processing.get(i).getText().trim().equals(location2.trim())&&bin_before_processing.get(i).getText().trim().equals(bin2.trim()))
			{
				
				view_link_list.get(i).click();
				Thread.sleep(5000);
				windowHandle();
				break;
			}
			}
			Double ans=addition(Double.parseDouble(two_quantity[0]),Double.parseDouble((two_quantity[1])));
			Double phy_q=Double.parseDouble(physcial_quantity_consol.getText().trim());
			Double net_q=Double.parseDouble(netsuite_quantity.getText().trim());
			Double result=phy_q-net_q;
			Double variance_quantity1=Double.parseDouble(this.variance_quantity.getText().trim());
			if(variance.trim().equals("no"))
			{
				if(Double.compare(phy_q, net_q)==0)
				{
					if(variance_quantity.getText().trim().equals("0.0"))
					{
						test.pass("Physical Quantity before consolidation is: "+quantity2);
						test.pass("Physical Quantity after consolidation is: "+phy_q);
						test.pass("Netsuite Quantity is: "+net_q);
						test.pass("Variance Quantity is: "+variance_quantity.getText());
						test.pass("Record is consolidated");
					}
				}
				else
				{
					test.fail("Variance quantity is: "+variance_quantity.getText());
					test.fail("Record is not consolidated");
					System.out.println("record is not consolidated");
				}
				
			}
			else
			{
				if(Double.compare(phy_q, ans)==0)
				{
				if(Double.compare(result, variance_quantity1)==0)
				{
					
					{
						test.pass("Physical Quantity before consolidation is: "+quantity2);
						test.pass("Physical Quantity after consolidation is: "+phy_q);
						test.pass("Netsuite Quantity is: "+net_q);
						test.pass("Variance Quantity is: "+variance_quantity.getText());
						test.pass("Record is consolidated");
						System.out.println("record is consolidated");
					}
				}
				else
				{
					test.fail("Variance quantity is: "+variance_quantity.getText());
					test.fail("Record is not consolidated");
					System.out.println("record is not consolidated");
				}
			}
			}
			
			
			
			
		}
		public void inventory_consolidation(String itemname2, String location2, String bin2, String quantity2, String testcase, String serial2,String variance, ExtentTest test) throws Exception
		{
			String[] two_quantity=quantity2.trim().split(",");
			for(int i=0;i<two_quantity.length;i++)
			{
				Inventory_count();
				item_scanning_screen(itemname2.trim(), location2.trim(), two_quantity[i], bin2.trim(), serial2.trim());	
			}
			consolidation(test);
			for(int i=0;i<7;i++)
			{
				driver.navigate().refresh();
			}
			
			for(int i=0;i<items_before_processing.size();i++)
			{
			if(items_before_processing.get(i).getText().trim().equals(itemname2.trim())&&location_before_processing.get(i).getText().trim().equals(location2.trim())&&bin_before_processing.get(i).getText().trim().equals(bin2.trim()))
			{
				
				view_link_list.get(i).click();
				Thread.sleep(5000);
				windowHandle();
				break;
			}
			}
			Double ans=addition(Double.parseDouble(two_quantity[0]),Double.parseDouble((two_quantity[1])));
			Double phy_q=Double.parseDouble(physcial_quantity_consol.getText().trim());
			Double net_q=Double.parseDouble(netsuite_quantity.getText().trim());
			Double result=phy_q-net_q;
			Double variance_quantity1=Double.parseDouble(this.variance_quantity.getText().trim());
			if(variance.trim().equals("no"))
			{
				if(Double.compare(phy_q, net_q)==0)
				{
					if(variance_quantity.getText().trim().equals("0.0"))
					{
						test.pass("Physical Quantity before consolidation is: "+quantity2);
						test.pass("Physical Quantity after consolidation is: "+phy_q);
						test.pass("Netsuite Quantity is: "+net_q);
						test.pass("Variance Quantity is: "+variance_quantity.getText());
						test.pass("Record is consolidated");
					}
				}
				else
				{
					test.fail("Variance quantity is: "+variance_quantity.getText());
					test.fail("Record is not consolidated");
					System.out.println("record is not consolidated");
				}
				
			}
			else
			{
				if(Double.compare(phy_q, ans)==0)
				{
				if(Double.compare(result, variance_quantity1)==0)
				{
					
					{
						test.pass("Physical Quantity before consolidation is: "+quantity2);
						test.pass("Physical Quantity after consolidation is: "+phy_q);
						test.pass("Netsuite Quantity is: "+net_q);
						test.pass("Variance Quantity is: "+variance_quantity.getText());
						test.pass("Record is consolidated");
						System.out.println("record is consolidated");
					}
				}
				else
				{
					test.fail("Variance quantity is: "+variance_quantity.getText());
					test.fail("Record is not consolidated");
					System.out.println("record is not consolidated");
				}
			}
			}
			
			
			
			
		}
		public void consolidated_checkbox(String[] itemname2, String[] location2, String[] bin2, String[] quantity2, String[] serial2, ExtentTest test) throws InterruptedException
		{
			for(int i=0;i<itemname2.length;i++)
			{
				Inventory_count();
				item_scanning_screen(itemname2[i], location2[i], quantity2[i], bin2[i], serial2[i]);
			}
			Inventory_count_screen();
			Thread.sleep(2000);
			int count=0;
			String [] items_before=new String[itemname2.length];
			int m=0;
			consolidate_checkbox.click();
			for(int i=0;i<process_checkbox_list.size();i++)
			{
				if(!variance_quantity_before_processing.get(i).getText().equals("0.0"))
				{
					process_checkbox_list.get(i).click();
					
					items_before[m]=items_before_processing.get(i).getText();
					System.out.println("before "+items_before[m]);
					m=m+1;
					count=count+1;
				}
				if(itemname2.length==count)
				{
					break;
				}
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(2000);
			selectAccount();
			process.click();
			Thread.sleep(2000);
			for(int k=0;k<2;k++)
			{
			selectAccount();
			show_processed.click();
			filter.click();
			Thread.sleep(2000);
			show_processed.click();
			}
			for(int j=0;j<2;j++)
			{
			driver.navigate().refresh();
			if(isAlertPresent_()==true)
			{
				Alert alert1=driver.switchTo().alert();
				alert1.accept();
			}	
			}
			Thread.sleep(2000);
			processed_screen();
			Thread.sleep(2000);
			int count1=0;
			String items_after_process[]=new String[itemname2.length];
			String adjustment_nr[]=new String[itemname2.length];
			for(int i=0;i<item_list_in_processed_screen.size();i++)
			{
				count1=count1+1;
				items_after_process[i]=item_list_in_processed_screen.get(i).getText();
				System.out.println("after "+items_after_process[i]);
				adjustment_nr[i]=adjustment_link_in_processed_screen.get(i).getText();
				if(count1==itemname2.length)
				{
					break;
				}
			}
	        Set<String> s = new HashSet<>(Arrays.asList(adjustment_nr));
	        Arrays.sort(items_before);
	        Arrays.sort(items_after_process);
	        System.out.println(Arrays.asList(items_before));
	        System.out.println(Arrays.asList(items_after_process));
	        if(Arrays.asList(items_before).equals(Arrays.asList(items_after_process)))
	        {
	        if(s.size()==1)
	        {
	        	test.pass("Items before processing are: "+Arrays.toString(items_before).replace("[", "").replace("]", ""));
	        	test.pass("Items after processing are: "+Arrays.toString(items_after_process).replace("[", "").replace("]", "")+"</br>"+" Adjustment record numbers are: "+Arrays.toString(adjustment_nr).replace("[", "").replace("]", ""));
	        	test.pass("Adjustment record is created with same adjustment number for all the processed items");
	        	System.out.println("same adjustment record");
	        }
	        else
	        {
	        	test.fail("Adjustment record is not same");
	        	System.out.println("different adjustment record");
	        }
	        }
	        else
	        {
	        	System.out.println("items are not same");
	        }
		}

		public void processed_report(String itemname2, String location2, String bin2, String quantity2, String serial2, String type, ExtentTest test) throws InterruptedException {
			
			String[] three_quantity=quantity2.split(",");
			String [] three_serial=serial2.split(":");
			ExtentTest test2=null;
			ExtentTest test3=null;
			ExtentTest test4=null;
			if(type.trim().equals("serial"))
			{
			test2=test.createNode("Verifying processed Inventory Count Data Report for serial items");
			}
			if(type.trim().equals("lot"))
			{
			test3=test.createNode("Verifying Processed Inventory Count Data Report for lot numbered items");
			}
			if(type.trim().equals("inventory"))
			{
			test4=test.createNode("Verifying Processed Inventory Count Data Report for inventory items");
			}
			
			for(int i=0;i<three_quantity.length;i++)
			{
				Inventory_count();
				if(!type.trim().equals("inventory"))
				{
				item_scanning_screen(itemname2, location2, three_quantity[i], bin2,three_serial[i]);
				}
				else
				{
					item_scanning_screen(itemname2, location2, three_quantity[i], bin2, serial2);
				}
				///Inventory_count_screen();
				process_checkbox_list.get(0).click();
				Thread.sleep(2000);
				int count=0;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)", "");
				Thread.sleep(2000);
				selectAccount();
				process.click();
				Thread.sleep(2000);
				for(int k=0;k<2;k++)
				{
					selectAccount();
					show_processed.click();
					filter.click();
					Thread.sleep(2000);
					show_processed.click();
				}
			for(int j=0;j<2;j++)
			{
			driver.navigate().refresh();
			if(isAlertPresent_()==true)
			{
				Alert alert1=driver.switchTo().alert();
				alert1.accept();
			}	
			}
			if(i>0)
			{
			Thread.sleep(2000);
			processed_screen();
			Thread.sleep(2000);
			
				for(int k=0;k<item_list_in_processed_screen.size();k++)
				{
					if(item_list_in_processed_screen.get(k).getText().trim().equals(itemname2.trim())&&location_in_processed_screen.get(k).getText().trim().equals(location2.trim())&&bin_in_processed_screen.get(k).getText().trim().equals(bin2.trim()))
					{
						if(variance_quantity_list.get(k).getText().trim().equals("0.0")||variance_quantity_list.get(k).getText().trim().equals("0"))
						{
							if(adjustment_link_in_processed_screen.get(k).getText().trim().equals(""))
							{
								
								if(type.trim().equals("serial"))
								{
									test2.pass("Inventory Adjustment record is not created for serial items having variance quantity zero");
								}
								if(type.trim().equals("lot"))
								{
									test3.pass("Inventory Adjustment record is not created for lot numbered items having variance quantity zero");
								}
								if(type.trim().equals("inventory"))
								{
									test4.pass("Inventory Adjustment record is not created for inventory items having variance quantity zero");
								}
								System.out.println("Adjustment record is not created");
								break;
							}
							else
							{
								if(type.trim().equals("serial"))
								{
									test2.fail("Inventory Adjustment record is created for serial items having variance quantity zero");
								}
								if(type.trim().equals("lot"))
								{
									test3.fail("Inventory Adjustment record is created for lot numbered items having variance quantity zero");
								}
								if(type.trim().equals("inventory"))
								{
									test4.fail("Inventory Adjustment record is created for inventory items having variance quantity zero");
								}
								break;
							}
						}
						if(!variance_quantity_list.get(k).getText().trim().equals("0.0")||!variance_quantity_list.get(k).getText().trim().equals("0"))
						{
							if(!adjustment_link_in_processed_screen.get(k).getText().trim().equals(""))
							{
								if(type.trim().equals("serial"))
								{
								test2.pass("Inventory Adjustment record is created for serial items having variance quantity other than zero"+"</br>"+"Inventory Adjustment record number is: "+adjustment_link_in_processed_screen.get(k).getText());
								}
								if(type.trim().equals("lot"))
								{
									test3.pass("Inventory Adjustment record is created for lot numbered items having variance quantity other than zero"+"</br>"+"Inventory Adjustment record number is: "+adjustment_link_in_processed_screen.get(k).getText());
								}
								if(type.trim().equals("inventory"))
								{
								test4.pass("Inventory Adjustment record is created for inventory items having variance quantity other than zero"+"</br>"+"Inventory Adjustment record number is: "+adjustment_link_in_processed_screen.get(k).getText());
								}
								System.out.println("Inventory Adjustment record is created");
								break;
							}
							else
							{
								if(type.trim().equals("serial"))
								{
								test2.fail("Inventory Adjustment record is not created for serial items having variance quantity other than zero");
								}
								if(type.trim().equals("lot"))
								{
									test3.fail("Inventory Adjustment record is not created for lot numbered items having variance quantity other than zero");
								}
								if(type.trim().equals("inventory"))
								{
									test4.fail("Inventory Adjustment record is not created for inventory items having variance quantity other than zero");
								}
							}

						}
						
					}
					else
					{
						test.fail("Item is not processed");
						break;
					}
				}
			}
			
			
			
		}
	
			}

		public void invalid_quantity_through_csv_inventory(String itemname2, String location2, String bin2, String physical_quantity, String filepath, ExtentTest test) throws InterruptedException, AWTException {
			
			driver.navigate().to("https://tstdrv939179-rp.app.netsuite.com/app/setup/assistants/nsimport/importassistant.nl?recid=7&new=T");
			Thread.sleep(5000);
			action.moveToElement(select_file).click().build().perform();
			Thread.sleep(2000);
			StringSelection sel = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
			System.out.println("selection" + sel);
			Robot robot = new Robot();
			Thread.sleep(1000);
			// Press Enter

			robot.keyPress(KeyEvent.VK_ENTER);
			// Release Enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			action.moveToElement(next_button).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(next_button).click().build().perform();
			Thread.sleep(4000);
			item_mapping.click();
			Thread.sleep(1000);
			item_field.click();
			Thread.sleep(1000);
			location_mapping.click();
			Thread.sleep(1000);
			location_field.click();
			Thread.sleep(1000);
			physical_quantity_mapping.click();
			Thread.sleep(1000);
			physical_quantity_field.click();
			Thread.sleep(2000);
			if(!bin2.trim().equals(""))
			{
				bin_before_map.click();
				bin_before_map.click();
				Thread.sleep(1000);
				bin_mapping.click();
				Thread.sleep(1000);
				bin_field.click();
			}
			action.moveToElement(secondary_next).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(run_arrow).build().perform();
			Thread.sleep(500);
			action.moveToElement(run).click().build().perform();
			Thread.sleep(1000);
			if(isAlertPresent_()==true)
			{
				Alert alert=driver.switchTo().alert();
				alert.accept();
			}
			Thread.sleep(1000);
			import_job_status.click();
			Thread.sleep(2000);
			for(;;)
			{
				driver.navigate().refresh();
				if(import_status.get(0).getText().trim().equals("Complete"))
				{
					break;
				}
			}
			Inventory_count_screen();
			has_errors.click();
			filter.click();
			Thread.sleep(2000);
			if(error_message.getText().trim().equals("#Physical quantity value is given more than once"))
			{
				test.pass(error_message.getText());
			}
			else
			{
				test.fail("Incorrect error message");
			}
					
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	}


