package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class b_adactine_welcome_Homepage 
{
     @FindBy(xpath="//input[@id='username_show']") private WebElement USERSHOW;
     @FindBy(xpath="//a[text() ='Logout']") private WebElement LOGOUTBTN;
     @FindBy(xpath="//a[text()='Click here to login again']") private WebElement ReloginBTN;
     
     @FindBy(xpath="//a[text()='Click here to login again']") private WebElement Loginagain;
     @FindBy(xpath="//select[@id='location']") private WebElement Location;
     @FindBy(xpath="//select[@id='hotels']") private WebElement Hotels;
     @FindBy(xpath="//select[@id='room_type']") private WebElement RoomType;
     @FindBy(xpath="//select[@id='room_nos']") private WebElement NumberofRooms;
     @FindBy(xpath="//input[@id='datepick_in']") private WebElement CheckInDate;
     @FindBy(xpath="//input[@id='datepick_out']") private WebElement CheckOutDate;
     @FindBy(xpath="//select[@id='adult_room']") private WebElement AdultsperRoom;
     @FindBy(xpath="//select[@id='child_room']") private WebElement ChildrenperRoom;
     @FindBy(xpath="//input[@id='Submit']") private WebElement Searchbtn;
     @FindBy(xpath="//input[@id='radiobutton_0']") private WebElement Radiobtn;
     @FindBy(xpath="//input[@id='continue']") private WebElement ContinueBtn;
     @FindBy(xpath="//*[@id='first_name']") private WebElement FN;
     @FindBy(xpath="//*[@id='last_name']") private WebElement LN;
     @FindBy(xpath="//*[@id='address']") private WebElement BillingAddress;
     @FindBy(xpath="//*[@id='cc_num']") private WebElement CCN;
     @FindBy(xpath="//*[@id='cc_type']") private WebElement CCT;
     @FindBy(xpath="//*[@id='cc_exp_month']") private WebElement EDMonth;
     @FindBy(xpath="//*[@id='cc_exp_year']") private WebElement EDYear;
     @FindBy(xpath="//*[@id='cc_cvv']") private WebElement CVV;
     @FindBy(xpath="//*[@id='book_now']") private WebElement BookNowBtn;
     
     public b_adactine_welcome_Homepage (WebDriver driver)
     {
    	 PageFactory.initElements(driver , this);
     }
     
     // Utilize within a method with access level public
     public String getusername ()
     {
    	 String s1 = USERSHOW.getAttribute("value");
    	 String A1[]=s1.split(" ");
    	 String z1 = A1 [0];
    	 String ActualUsername = A1 [1];
    	 
    	 return ActualUsername;
     }
     
     public void logout()
     {
    	 LOGOUTBTN.click();
     }
     
     
     public void clickReloginBTN()
     {
    	 ReloginBTN.click();
     }
    
     public void SelectLocation(String LOC) //Sydney
     {
     Select S1=new Select(Location);
     S1.selectByVisibleText(LOC); //Sydney
     }
     public void SelectHotels(String HO) //Hotel Sunshine
     {
     Select S1=new Select(Hotels);
     S1.selectByVisibleText(HO); //Hotel Sunshine
     }
     public void SelectRoomType(String RT) // Double
     {
     Select S1=new Select(RoomType);
     S1.selectByVisibleText(RT);
     }
     public void SelectNumberofRooms(String NOR) //4 - Four
     {
     Select S1=new Select(NumberofRooms);
     S1.selectByVisibleText(NOR);
     }
     public void EnterCheckInDate(String CD) //15-10-2023
     {
     CheckInDate.sendKeys(CD);//15-10-2023
     }
     public void EnterCheckOutDate(String CO)//18-10-2023
     {
     CheckOutDate.sendKeys(CO); //18-10-2023
     }
     public void SelectAdultsperRoom(String APR) //2 - Two
     {
     Select S1=new Select(AdultsperRoom);
     S1.selectByVisibleText(APR);
     }
     public void SelectChildrenperRoom(String CPR) //1 - One
     {
     Select S1=new Select(ChildrenperRoom);
     S1.selectByVisibleText(CPR);
     }
     public void ClickSearchButton()
     {
     Searchbtn.click();
     }
     public void SelectRadioButton()
     {
     Radiobtn.click();
     }
     public void ClickContinueButton()
     {
     ContinueBtn.click();
     }
     public void EnterFirstName(String FNM) //Java
     {
     FN.sendKeys(FNM); //Java
     }
     public void EnterLastName(String LNM) //Selenium
     {
     LN.sendKeys(LNM); //Selenium
     }
     public void EnterBillingAddress(String BA) //ABCD Road Pune
     {
     BillingAddress.sendKeys(BA); //ABCD Road Pune
     }
     public void EnterCreditCardNo(String CCNumber) //1234567890123450
     {
     CCN.sendKeys(CCNumber);
     }
     public void SelectCreditCardType(String CT) //VISA
     {
     Select S1=new Select(CCT);
     S1.selectByVisibleText(CT);
     }
     public void SelectEDMonth(String EDM) //March
     {
     Select S1=new Select(EDMonth);
     S1.selectByVisibleText(EDM);
     }
     public void SelectEDYear(String EDY) //2030
     {
     Select S1=new Select(EDYear);
     S1.selectByVisibleText(EDY);
     }
     public void EnterCVVNumber(String CVVN) //1987
     {
     CVV.sendKeys(CVVN);//1987
     }
     public void ClickBookNowButton()
     {
     BookNowBtn.click();
     }
     
} 
