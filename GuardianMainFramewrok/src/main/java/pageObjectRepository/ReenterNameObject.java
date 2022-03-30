package pageObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReenterNameObject {
	
	static WebDriver driver;
	
	@FindBy (xpath="//input[@id='confirm_email']")
	WebElement inp_reentermail;
	@FindBy (xpath="//input[@id='firstName']")
	WebElement inp_frstname1;
	@FindBy (xpath="//input[@id='lastName']")
	WebElement inp_lastname;
	@FindBy (xpath="//button[@name='age']")
	WebElement btn_age;	
	@FindBy (xpath="//input[@name='dateOfBirth']")
	WebElement inp_dob;
	@FindBy (xpath="//div/button[text()='Next']")
	WebElement btn_next;
	@FindBy (xpath="//button[text()='Agree & finish']")
	WebElement btn_agree_finish;
	@FindBy (xpath="//div/button[text()='Continue']")
	WebElement btn_continue;
	
	public ReenterNameObject(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver, this);
		}
	
	public void Reenter_Name(String FirstName, String LastName, String EmailID, String DOB) throws InterruptedException {
	
	inp_frstname1.click();
	inp_frstname1.sendKeys(FirstName);
	Actions action=new Actions(driver);
	action.moveToElement(inp_lastname).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
	inp_lastname.sendKeys(LastName);		
	inp_dob.sendKeys(DOB);
	String actualTitle = driver.getTitle();
	String expectedTitle="Checkout | Personal Information | Guardian Direct Insurance Application";
	assertEquals(actualTitle, expectedTitle, "ReEnterNamePageTitle as Expected");
	btn_next.click();
	Thread.sleep(3000);
	}

}
