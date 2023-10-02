package Library_files;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class d_Base_class 
{
	public WebDriver  driver;
	
    public void InitializeBrowser()
    {
    	
		 ChromeOptions CO=new ChromeOptions();
		 CO.addArguments("--remote-allow-Origins=*", "ignore-certificate-errors");
		 driver=new ChromeDriver(CO); 
		
		 driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
    }
}
