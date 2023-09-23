package Module1_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.d_Base_class;
import Library_files.e_utility_class;
import Module1.a_adactine_Login_page;
import Module1.b_adactine_welcome_Homepage;

public class c_test_class extends d_Base_class 
{
	// WebDriver driver; & InitializeBrowser() method- which is non static method..we can call non static method from non static method
	 a_adactine_Login_page Login1;
	 b_adactine_welcome_Homepage homepage1;
	 String TestCaseID;  //TC100   //TC101
	 
	@BeforeClass
	public void OpenBrowser()
	{
	   InitializeBrowser(); // non static method call from another non static method
	   
	   // create an object of pom - I
	    Login1 = new a_adactine_Login_page(driver);
	   // create an object of pom - II
	    homepage1 = new b_adactine_welcome_Homepage(driver);
	}
	
	//-------------------------------------------------------------------
	
	@BeforeMethod
    public void LoginToApp() throws IOException
    {
    	// Enter Username
		  Login1.enterUSERNAME(e_utility_class.getDataFromPF1("Username"));
		// Enter Password
		  Login1.enterPASSWORD(e_utility_class.getDataFromPF1("PassWord"));
		// Click login button
		  Login1.clickLOGINbtn();
	
    }
	
    //---------------------------------------------------
	
	@Test (priority=1)                     
	public void VerifyUserName() throws EncryptedDocumentException, IOException 
	{
		TestCaseID="TC100";
		
		//ActualUserName  
	String	ActualUserName=homepage1.getusername();  
	
		//ExpectedUsername
	String ExpectedUsername=e_utility_class.getDatafromExcelsheet(0,0); 
	System.out.println(ExpectedUsername);
	
	Assert.assertEquals(ActualUserName,ExpectedUsername); 
	
	}
	//=========================================================
	
	@Test (priority=2)
	public void getTitleofapp() throws EncryptedDocumentException, IOException
	{
	
		TestCaseID="TC101";
		String ActualTitle = driver.getTitle();
		String ExpectedTitle=e_utility_class.getDatafromExcelsheet(1,0); 
		Assert.assertEquals(ActualTitle,ExpectedTitle);
	}
	//=========================================================
	
	@Test(priority=3)
	public void BookAHotel() throws EncryptedDocumentException, IOException
	{
		TestCaseID="TC102";
	
	homepage1.SelectLocation(e_utility_class.getDatafromExcelsheet(2, 0)); // Sydney
	homepage1.SelectHotels(e_utility_class.getDatafromExcelsheet(3, 0)); //Hotel Sunshine
	homepage1.SelectRoomType(e_utility_class.getDatafromExcelsheet(4, 0)); // Double
	homepage1.SelectNumberofRooms(e_utility_class.getDatafromExcelsheet(5, 0)); //4 - Four
	homepage1.EnterCheckInDate(e_utility_class.getDatafromExcelsheet(6, 0)); //15-10-2023
	homepage1.EnterCheckOutDate(e_utility_class.getDatafromExcelsheet(7, 0)); //18-10-2023
	homepage1.SelectAdultsperRoom(e_utility_class.getDatafromExcelsheet(8, 0)); //2 - Two
	homepage1.SelectChildrenperRoom(e_utility_class.getDatafromExcelsheet(9, 0));//1 - One
	homepage1.ClickSearchButton();
	homepage1.SelectRadioButton();
	homepage1.ClickContinueButton();
	homepage1.EnterFirstName(e_utility_class.getDatafromExcelsheet(0, 1)); //Java
	homepage1.EnterLastName(e_utility_class.getDatafromExcelsheet(1, 1)); //Selenium
	homepage1.EnterBillingAddress(e_utility_class.getDatafromExcelsheet(2, 1)); //ABCD Road Pune
	homepage1.EnterCreditCardNo(e_utility_class.getDatafromExcelsheet(3, 1)); //1234567890123450
	homepage1.SelectCreditCardType(e_utility_class.getDatafromExcelsheet(4, 1));// VISA
	homepage1.SelectEDMonth(e_utility_class.getDatafromExcelsheet(5, 1));//March
	homepage1.SelectEDYear(e_utility_class.getDatafromExcelsheet(6, 1)); //2030
	homepage1.EnterCVVNumber(e_utility_class.getDatafromExcelsheet(7, 1));//1987
	homepage1.ClickBookNowButton();
	}


	@AfterMethod
	public void LogOutFromApp(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)  //false  true
		{
			e_utility_class .CaptureScreenshot(driver, TestCaseID);  //TC100   //TC101
		}

		 homepage1.logout();
		 homepage1.clickReloginBTN();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();	
	}
	
}
