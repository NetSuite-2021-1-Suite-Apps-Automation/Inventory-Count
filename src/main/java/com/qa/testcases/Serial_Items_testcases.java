package com.qa.testcases;

import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.exceldataReader.ExcelReader;
import com.qa.exceldataReader.ExcelReaderbycolumnname;
import com.qa.pages.ItemScanning;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;
public class Serial_Items_testcases extends TestBase {
	TestUtil testUtil;
	ItemScanning item;
	ExcelReaderbycolumnname reader;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String file_path="C:\\Users\\Sindhuja\\Desktop\\serial number with bins.xlsx";

	@BeforeTest
	public void setExtent() {
		// specify location of the report
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/SerialItemsReport/SerialItemsReport.html");

		htmlReporter.config().setDocumentTitle("Serial Items Test Report"); // Tile of report
		htmlReporter.config().setReportName("Serail Items Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// Passing General information
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Sindhuja"); 
	}
	public void send_email() throws EmailException {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("./SerialItemsReport/SerialItemsReport.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		// attachment.setDescription("Test Report");
		// attachment.setName("Bulk Email Invoices");
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sindhuja.b@tvarana.com", "Sindhu@123"));
		email.setSSLOnConnect(true);
		email.addTo("sindhuja.b@tvarana.com", "Sindhu");
		email.setFrom("sindhuja.b@tvarana.com", "Sindhuja");
		email.setSubject("Serial Items Test Report");
		email.setMsg("Here is the report please find the attachment");
		email.attach(attachment);
		email.send();
	}

	@AfterTest
	public void endReport() throws EmailException {
		extent.flush();
		send_email();
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		testUtil=new TestUtil();
		testUtil.setUp();
	}
	
	 @Test(priority = 5)
	 public void invalid_Data() throws InterruptedException, IOException
	 { 
		reader=new ExcelReaderbycolumnname();
		String [] itemname=reader.excelReader(file_path, 0, "itemname");
		String[] location=reader.excelReader(file_path, 0, "location");
		String[] bin=reader.excelReader(file_path, 0, "bin");
		String[] serial=reader.excelReader(file_path, 0, "serial");
		String[] quantity=reader.excelReader(file_path, 0, "quantity");
		String[] testcase=reader.excelReader(file_path, 0, "testcase");
		String[] error_message=reader.excelReader(file_path, 0, "error_message");
		String[] error=reader.excelReader(file_path, 0, "error");
		
		for(int i=0;i<itemname.length;i++)
		{
		try
		{
		 test = extent.createTest("Testcase is" + " " +testcase[i]);
		 item=new ItemScanning();
		 item.Inventory_count();   
		 item.invalid_data(itemname[i], location[i], bin[i], serial[i], quantity[i],testcase[i],error_message[i],error[i],test);	 
		}
		catch (Exception e) 
		{
			test.fail("Exception is:" +e.fillInStackTrace());
		
		}
		
		}
	 }
	 
	 @Test(priority = 4)
	 public void bin_Mismatch() throws InterruptedException, IOException
	 {
		 reader=new ExcelReaderbycolumnname();
			String [] itemname=reader.excelReader(file_path, 1, "itemname");
			String[] location=reader.excelReader(file_path, 1, "location");
			String[] bin=reader.excelReader(file_path, 1, "bin");
			String[] serial=reader.excelReader(file_path, 1, "serial");
			String[] quantity=reader.excelReader(file_path, 1, "quantity");
			String[] testcase=reader.excelReader(file_path, 1, "testcase");
			
			for(int i=0;i<itemname.length;i++)
			{
				try {
				 test = extent.createTest("Testcase is" + " " +testcase[i]);
				 item=new ItemScanning();
				 item.Inventory_count();   
				 item.bin_mismatch_serial(itemname[i], location[i], bin[i], serial[i], quantity[i],testcase[i],test);
				}
				catch(Exception e)
				{
					test.fail("Exception is: " +e.fillInStackTrace());
				}
			}
	 }
	
	 @Test(priority = 3)
	 public void Without_serial_nrs() throws InterruptedException, IOException
	 {
		 reader=new ExcelReaderbycolumnname();
		 	String [] itemname=reader.excelReader(file_path, 2, "itemname");
			String[] location=reader.excelReader(file_path, 2, "location");
			String[] bin=reader.excelReader(file_path, 2, "bin");
			String[] serial=reader.excelReader(file_path, 2, "serial");
			String[] quantity=reader.excelReader(file_path, 2, "quantity");
			String[] testcase=reader.excelReader(file_path, 2, "testcase");
			for(int i=0;i<itemname.length;i++)
			{
				try
				{
			 test = extent.createTest("Testcase is" + " " +testcase[i]);
			 item=new ItemScanning();
			 item.Inventory_count();   
			 item.without_giving_serial_numbers(itemname[i], location[i], bin[i], serial[i], quantity[i], testcase[i],test);
				}
				catch (Exception e) 
				{
					test.fail("Exception is: "+e.fillInStackTrace());
				}
			}
	 }
	
	 @Test(priority = 2)
	 public void Processing_without_bins() throws Exception
	 {
		 reader=new ExcelReaderbycolumnname();
		 	String [] itemname=reader.excelReader(file_path, 4, "itemname");
			String[] location=reader.excelReader(file_path, 4, "location");
			String[] bin=reader.excelReader(file_path, 4, "bin");
			String[] serial=reader.excelReader(file_path, 4, "serial");
			String[] quantity=reader.excelReader(file_path, 4, "quantity");
			String[] testcase=reader.excelReader(file_path, 4, "testcase");
			String[] new_serial=reader.excelReader(file_path, 4, "new_serial");
			String[] new_quantity=reader.excelReader(file_path, 4, "new_quantity");
			
			for(int i=0;i<itemname.length;i++)
			{
			 try
			 {
			 test = extent.createTest("Testcase is" + " " +testcase[i]);
			 item=new ItemScanning();
			 item.Inventory_count();   
			 item.serial_items_numbers_adding_with_bins(itemname[i], location[i], bin[i], serial[i], quantity[i], testcase[i],new_serial[i],new_quantity[i],test);
			 }
			 catch(Exception e)
			 {
				 test.fail("Exception is: "+e.fillInStackTrace());
			 }
			}
			
	 }

	 @Test(priority = 1)
	 public void Processing_with_bins() throws Exception
	 {
		 	reader=new ExcelReaderbycolumnname();
		 	String [] itemname=reader.excelReader(file_path, 3, "itemname");
			String[] location=reader.excelReader(file_path, 3, "location");
			String[] bin=reader.excelReader(file_path, 3, "bin");
			String[] serial=reader.excelReader(file_path, 3, "serial");
			String[] quantity=reader.excelReader(file_path, 3, "quantity".trim());
			String[] testcase=reader.excelReader(file_path, 3, "testcase".trim());
			String[] new_serial=reader.excelReader(file_path, 3, "new_serail".trim());
			String[] new_quantity=reader.excelReader(file_path, 3, "new_quantity".trim());
			
		 for(int i=0;i<itemname.length;i++)
		 {
			 try
			 {
		     test = extent.createTest("Testcase is" + " " +testcase[i]);
			 item=new ItemScanning();
			 item.Inventory_count();   
			 item.serial_items_numbers_adding_with_bins(itemname[i], location[i], bin[i], serial[i], quantity[i],testcase[i],new_serial[i],new_quantity[i],test);
			 }
			 catch (Exception e) 
			 {
				 test.fail("Exception is:" +e.fillInStackTrace());
			 }
		}
	 }
	 @Test(priority = 6)
	 public void automatic_comma_and_quantity() throws IOException
	 {
		 reader=new ExcelReaderbycolumnname();
		 	String [] itemname=reader.excelReader(file_path, 5, "itemname");
			String[] location=reader.excelReader(file_path, 5, "location");
			String[] bin=reader.excelReader(file_path, 5, "bin");
			String[] serial=reader.excelReader(file_path, 5, "serial");
			String[] quantity=reader.excelReader(file_path, 5, "quantity".trim());
			String[] testcase=reader.excelReader(file_path, 5, "testcase".trim());
			for(int i=0;i<itemname.length;i++)
			 {
				 try
				 {
			     test = extent.createTest("Testcase is" + " " +testcase[i]);
				 item=new ItemScanning();
				 item.Inventory_count();   
				 item.automatic_updation(itemname[i], location[i], bin[i], serial[i], quantity[i],testcase[i],test);
				 }
				 catch (Exception e) 
				 {
					 test.fail("Exception is:" +e.fillInStackTrace());
				 }
			}
			
		 
	 }
	 @Test(priority = 7)
	 public void conolidate_through_item_scanning() throws IOException
	 {
		 	reader=new ExcelReaderbycolumnname();
		 	String [] itemname=reader.excelReader(file_path, 6, "itemname");
			String[] location=reader.excelReader(file_path, 6, "location");
			String[] bin=reader.excelReader(file_path, 6, "bin");
			String[] serial=reader.excelReader(file_path, 6, "serial");
			String[] quantity=reader.excelReader(file_path, 6, "quantity".trim());
			String[] testcase=reader.excelReader(file_path, 6, "testcase".trim());
			for(int i=0;i<itemname.length;i++)
			 {
				 try
				 {
			     test = extent.createTest("Testcase is" + " " +testcase[i]);
				 item=new ItemScanning();
				 item.Inventory_count();   
				 item.consolidate_checkbox_itemscanning(itemname[i], location[i], bin[i], serial[i], quantity[i],testcase[i],test);
				 }
				 catch (Exception e) 
				 {
					 test.fail("Exception is:" +e.fillInStackTrace());
				 }
			}
			
		 
	 }
	 @Test(priority = 8)
	 public void consolidate_inventory_count_screen() throws Exception
	 {
		 reader=new ExcelReaderbycolumnname();
		 	String [] itemname=reader.excelReader(file_path, 7, "itemname");
			String[] location=reader.excelReader(file_path, 7, "location");
			String[] bin=reader.excelReader(file_path, 7, "bin");
			String[] serial=reader.excelReader(file_path, 7, "serial");
			String[] quantity=reader.excelReader(file_path, 7, "quantity".trim());
			String[] testcase=reader.excelReader(file_path, 7, "testcase".trim());
			for(int i=0;i<itemname.length;i++)
			 {
				 
				 {
			     test = extent.createTest("Testcase is" + " " +testcase[i]);
				 item=new ItemScanning();
				 item.consolidate_through_inventory_count(itemname[i], location[i], bin[i], serial[i], quantity[i],testcase[i],test);
				 
				 }
				
			}
		 
	 }
	 @Test(priority = 9)
		public void processed_report() throws IOException, InterruptedException
		{
			reader=new ExcelReaderbycolumnname();
			String [] itemname=reader.excelReader(file_path, 8,"itemname");
			String [] location=reader.excelReader(file_path, 8, "location");
			String [] bin=reader.excelReader(file_path, 8, "bin");
			String [] quantity=reader.excelReader(file_path, 8, "quantity");
			String [] serial=reader.excelReader(file_path, 8, "serial");
			String[] type=reader.excelReader(file_path, 8, "type");
			test=extent.createTest("Verifying Processed Inventory Count Data report");
			item=new ItemScanning();
			for(int i=0;i<itemname.length;i++)
			{
				item.processed_report(itemname[i], location[i], bin[i], quantity[i], serial[i],type[i], test);
			}
			
		}

}


