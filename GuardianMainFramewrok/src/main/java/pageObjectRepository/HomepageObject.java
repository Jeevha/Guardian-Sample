package pageObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageObject {
	
	static WebDriver driver;
	
	//home page objects	
		@FindBy (xpath="//div/button[text()='Accident']")
		WebElement  btn_accident;
		@FindBy (xpath="//div/button[text()='Dental']")
		WebElement btn_dental;
		@FindBy (xpath="//div/button[text()='Vision']")
		WebElement btn_vision;
	
	//Enroll customer in insurance 
		@FindBy (xpath="//input[@id='fullName']")
		WebElement inp_frstname;
		@FindBy (xpath="//input[@id='firstName']")
		WebElement inp_frstname1;
		@FindBy (xpath="//input[@id='lastName']")
		WebElement inp_lastname;
		@FindBy (xpath="//button[@name='age']")
		WebElement btn_age;
		@FindBy (xpath="//input[@name='email']")
		WebElement inp_email;
		@FindBy (xpath="//div/button[text()='Continue']")
		WebElement btn_continue;
		@FindBy (xpath="//div/button[text()='Finish']")
		WebElement btn_finish;
		

	public HomepageObject(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public void Customer_Enroll(String firstName, String lastName, String emailID, String DOB) throws InterruptedException {
		
		btn_dental.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		inp_frstname.click();
		inp_frstname.sendKeys(firstName);
		Actions action=new Actions(driver);
		action.moveToElement(btn_age).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		inp_email.click();
		inp_email.sendKeys(emailID);
		btn_continue.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}		

}

























