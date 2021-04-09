package com.qa.testcases;

import java.awt.AWTException;
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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.exceldataReader.CSVFileReader;
import com.qa.exceldataReader.ExcelReaderbycolumnname;
import com.qa.pages.ItemScanning;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;
public class Inventory_Items_Testing extends TestBase {
	TestUtil testUtil;
	ItemScanning item;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String file_path="C:\\Users\\Sindhuja\\Desktop\\inventory_items_testing.xlsx";
	ExcelReaderbycolumnname reader;
	
	public void send_email() throws EmailException {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("./InventoryItemsReport/Inventory_items_report.html");
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
		email.setSubject("Inventory Items Test Report");
		email.setMsg("Here is the report please find the attachment");
		email.attach(attachment);
		email.send();
	}

	@BeforeTest
	public void setExtent() {
		// specify location of the report
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/InventoryItemsReport/Inventory_items_report.html");

		htmlReporter.config().setDocumentTitle("Inventory Items Test Report"); // Tile of report
		htmlReporter.config().setReportName("Inventory Items Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// Passing General information
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Sindhuja");
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
	public void setUp() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.setUp();
	}
	@Test(priority = 8)
	public void invalidQuantity() throws IOException, InterruptedException
	{
		
		reader=new ExcelReaderbycolumnname();
		String [] itemname=reader.excelReader(file_path, 0, "itemname");
		String [] location=reader.excelReader(file_path, 0, "location");
		String[] bin=reader.excelReader(file_path, 0, "bin");
		String[] serial=reader.excelReader(file_path, 0, "serial");
		String[] quantity=reader.excelReader(file_path, 0, "quantity");
		String[] testcase=reader.excelReader(file_path, 0, "testcase");
		String [] error_message=reader.excelReader(file_path, 0, "error_message");
		String [] error=reader.excelReader(file_path, 0, "error");
		for(int i=0;i<itemname.length;i++)
		{
			try
			{
			test = extent.createTest("Testcase is "+testcase[i]);
			item = new ItemScanning();
			item.Inventory_count();
			item.invalid_data(itemname[i], location[i], bin[i], serial[i], quantity[i], testcase[i],error_message[i],error[i],test);
			}
			catch(Exception e)
			{
				System.out.println("Exception is: "+e.fillInStackTrace());
			}
			
		}	
	}
	@Test(priority = 6)
	public void differentQuantites() throws Exception
	{
		reader=new ExcelReaderbycolumnname();
		String [] itemname=reader.excelReader(file_path, 2,"itemname");
		String [] location=reader.excelReader(file_path, 2, "location");
		String [] bin=reader.excelReader(file_path, 2, "bin");
		String [] quantity=reader.excelReader(file_path, 2, "quantity");
		String [] testcase=reader.excelReader(file_path, 2, "testcase");
		String [] type=reader.excelReader(file_path, 2, "type");

		for(int i=0;i<location.length;i++)
		{
			try
			{
			test = extent.createTest("Testcase is" + " " + testcase[i]);
			item = new ItemScanning();
			item.Inventory_count();
			item.inventory_adjustment_test(itemname[i], location[i], bin[i], quantity[i], testcase[i],type[i],test);
			}
			catch(Exception e)
			{
				System.out.println("Exception is: "+e.fillInStackTrace());
			}
		}
		
	}
	
	@Test(priority = 4)
	public void invalidBin() throws IOException, InterruptedException
	{
		reader=new ExcelReaderbycolumnname();
		String[] itemname=reader.excelReader(file_path, 1, "itemname");
		String[] location=reader.excelReader(file_path, 1, "location");
		String[] bin=reader.excelReader(file_path, 1, "bin");
		String[] quantity=reader.excelReader(file_path, 1, "quantity");
		String[] testcase=reader.excelReader(file_path, 1, "testcase");
		
		for(int i=0;i<itemname.length;i++)
		{
			try
			{
			test = extent.createTest("Testcase is" + " " + testcase[i]);
			item = new ItemScanning();
			item.Inventory_count();
			item.bin_mismatch_inventory(itemname[i], location[i], bin[i], quantity[i], testcase[i],test);
			}
			catch(Exception e)
			{
				System.out.println("Exception is: "+e.fillInStackTrace());
			}
		}


	}
	@Test(priority = 7)
	public void assembly_inventory_consolidation_through_inventory_count() throws Exception
	{
		reader=new ExcelReaderbycolumnname();
		String [] itemname=reader.excelReader(file_path, 3,"itemname");
		String [] location=reader.excelReader(file_path, 3, "location");
		String [] bin=reader.excelReader(file_path, 3, "bin");
		String [] quantity=reader.excelReader(file_path, 3, "quantity");
		String [] testcase=reader.excelReader(file_path, 3, "testcase");
		String [] variance=reader.excelReader(file_path, 3, "variance");
		String [] serial=reader.excelReader(file_path, 3, "serial");

		for(int i=0;i<itemname.length;i++)
		{
			test = extent.createTest("Testcase is" + " " + testcase[i]);
			item = new ItemScanning();
			item.inventory_consolidation(itemname[i],location[i],bin[i],quantity[i],testcase[i],serial[i],variance[i],test);
		}

		
	}
	@Test(priority = 1)
	public void assembly_inventory_consolidation_through_item_scanning() throws Exception
	{
		reader=new ExcelReaderbycolumnname();
		String [] itemname=reader.excelReader(file_path, 4,"itemname");
		String [] location=reader.excelReader(file_path, 4, "location");
		String [] bin=reader.excelReader(file_path, 4, "bin");
		String [] quantity=reader.excelReader(file_path, 4, "quantity");
		String [] testcase=reader.excelReader(file_path, 4, "testcase");
		String [] variance=reader.excelReader(file_path, 4, "variance");
		String [] serial=reader.excelReader(file_path, 4, "serial");

		for(int i=0;i<itemname.length;i++)
		{
			test = extent.createTest("Testcase is" + " " + testcase[i]);
			item = new ItemScanning();
			item.inventory_consolidation_item_scanning(itemname[i],location[i],bin[i],quantity[i],testcase[i],serial[i],variance[i],test);
		}

		
	}
	@Test(priority = 3)
	public void consolidation_checkbox() throws InterruptedException, IOException
	{
		reader=new ExcelReaderbycolumnname();
		String [] itemname=reader.excelReader(file_path, 5,"itemname");
		String [] location=reader.excelReader(file_path, 5, "location");
		String [] bin=reader.excelReader(file_path, 5, "bin");
		String [] quantity=reader.excelReader(file_path, 5, "quantity");
		String [] serial=reader.excelReader(file_path, 5, "serial");
		test=extent.createTest("Verifying Consolidation checkbox functionality");
		item=new ItemScanning();
		item.consolidated_checkbox(itemname,location,bin,quantity,serial,test);
			
}
	@Test(priority = 5)
	public void processed_report() throws IOException, InterruptedException
	{
		reader=new ExcelReaderbycolumnname();
		String [] itemname=reader.excelReader(file_path, 6,"itemname");
		String [] location=reader.excelReader(file_path, 6, "location");
		String [] bin=reader.excelReader(file_path, 6, "bin");
		String [] quantity=reader.excelReader(file_path, 6, "quantity");
		String [] serial=reader.excelReader(file_path, 6, "serial");
		String[] type=reader.excelReader(file_path, 6, "type");
		test=extent.createTest("Verifying Processed Inventory Count Data report");
		item=new ItemScanning();
		for(int i=0;i<itemname.length;i++)
		{
			item.processed_report(itemname[i], location[i], bin[i], quantity[i], serial[i],type[i], test);
		}
		
	}
	@Test(priority = 2)
	public void invalid_quantity_through_csv() throws IOException, InterruptedException, AWTException
	{
		String itemname=null;
		String location=null;
		String bin=null; 
		String physical_quantity=null;
		item=new ItemScanning();
		reader=new ExcelReaderbycolumnname();
		CSVFileReader reader1 = new CSVFileReader();
		String [] filepath=reader.excelReader(file_path, 7,"Filelocation");
		String[] testcase=reader.excelReader(file_path, 7, "testcase");
		System.out.println(filepath.length);
		for(int i=0;i<filepath.length;i++)
		{
		itemname = reader1.CSVData("Item", filepath[i]);
		location = reader1.CSVData("Location(ware house)", filepath[i]);
		bin = reader1.CSVData("Bin", filepath[i]);
	    physical_quantity = reader1.CSVData("Physical Quantity", filepath[i]);
		test=extent.createTest(testcase[i]);	
		item.invalid_quantity_through_csv_inventory(itemname,location,bin,physical_quantity,filepath[i],test);
		}
	}
}

