package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class e_utility_class 
{
   @Test
   public static String getDataFromPF1(String key) throws IOException
     {
	  // to reach upto Property file
	  FileInputStream File = new FileInputStream("C:\\Users\\Server\\eclipse-workspace\\adactinhotelapp_selenium_maven\\propertyFile.properties");
	  
	  // create object of Properties Class
	  Properties prop = new Properties();
	  
	  // to open property file
	  prop.load(File);
	  
	  // to fetch data value from property file
	  String value1=prop.getProperty(key);
	  
	  return value1;
      }
	  //----------------------------------------------------------------------
	  
     @Test
     public static String getDatafromExcelsheet(int Rowindex, int Cellindex) throws EncryptedDocumentException, IOException
     {
    	FileInputStream file = new FileInputStream("C:\\Users\\Server\\eclipse-workspace\\adactinhotelapp_selenium_maven\\Test_Data\\New XLS Worksheet.xlsx");
    	String value6=WorkbookFactory.create(file).getSheet("Sheet3").getRow(Rowindex).getCell(Cellindex).getStringCellValue();
    	return value6;

     }
     
     //-------------------------
     
     @Test                                                           //TC101
 	public static void CaptureScreenshot(WebDriver driver, String TestCaseID) throws IOException
 	{
         File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		
 		System.out.println(Source);
 		                                                        //TC101
 		File Destination=new File("C:\\Users\\Server\\eclipse-workspace\\adactinhotelapp_selenium_maven\\ScreenShot"+TestCaseID+".jpg");
 		FileHandler.copy(Source,Destination);
 	}
     //Updated by Vishranti
 	
 
   }

