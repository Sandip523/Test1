package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class a_adactine_Login_page 
{
     //1.  data members/variables should be declared globally with access level private by
	 // using @findby Annotation

	 @FindBy(xpath="//input[@id='username']") private WebElement UN;
	 @FindBy(xpath="//input[@id='password']") private WebElement PSW;
	 @FindBy(xpath="//input[@id='login']") private WebElement LOGIN;
	 
	//2. Initialize within a constructor with access level public using PageFactory Class
	 
	 public a_adactine_Login_page (WebDriver driver)  
	 {
		 PageFactory.initElements(driver,this);
	 } 
	 
	//3. Utilize within a method with access level public
	 
	 public void enterUSERNAME(String USERNAME)
	 {
		 UN.sendKeys(USERNAME);
	 }
	 
	 public void enterPASSWORD(String PASSWORD)
	 {
		 PSW.sendKeys(PASSWORD);
	 }
	 
	 public void clickLOGINbtn()
	 {
		 LOGIN.click();
	 }
	
}
