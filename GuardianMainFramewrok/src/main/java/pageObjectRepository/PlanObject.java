package pageObjectRepository;


import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanObject {
	
	static WebDriver driver;
	
	//customer details
		@FindBy (xpath="//div/input[@id='address.addressLine1']")
		WebElement int_address;
		@FindBy (xpath="//div/input[@id='address.city']")
		WebElement int_city;
		@FindBy (xpath="//div/input[@id='address.zipCode']")
		WebElement int_zipcode;
		@FindBy (xpath="//span[contains(text(),'A couple times a year, for cleaning and the occasional filling')]")
		WebElement slct_Plan;
		@FindBy (xpath="//input[@name='multiple_select' and @type='checkbox' and @value='cavity_fillings']")
		WebElement btn_chck_cavity;
		@FindBy (xpath="//input[@name='multiple_select' and @type='checkbox' and @value='root_canals']")
		WebElement btn_chck_root;
		@FindBy (xpath="//input[@name='multiple_select' and @type='checkbox' and @value='teeth_whitening']")
		WebElement btn_chck_tooth;
		@FindBy (xpath="//input[@name='multiple_select' and @type='checkbox' and @value='extractions']")
		WebElement btn_chck_extrct;
		@FindBy (xpath="//div/button[text()='Enroll now']")
		WebElement btn_enroll;
		@FindBy (xpath="//div/button[text()='Submit']")
		WebElement btn_submit;
		@FindBy (xpath="//input[@name='dateOfBirth']")
		WebElement inp_dob;
		@FindBy (xpath="//div/button[text()='Next']")
		WebElement btn_next;
		@FindBy (xpath="//button[text()='I agree']")
		WebElement btn_agree;
		@FindBy (xpath="//input[@id='confirm_email']")
		WebElement inp_reentermail;
		@FindBy (xpath="//button[text()='Agree & finish']")
		WebElement btn_agree_finish;
		@FindBy (xpath="//div/button[text()='Continue']")
		WebElement btn_continue;

		
	public PlanObject(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver, this);
		}


	public void Select_plan(String Address, String City, String Zipcode) {
			
		WebDriverWait wait=new WebDriverWait(driver,50);
		JavascriptExecutor JS=(JavascriptExecutor)driver;	
		WebElement Cust_details=driver.findElement(By.xpath("//div/input[@id='address.addressLine1']"));
		wait.until(ExpectedConditions.visibilityOf(Cust_details));
		int_address.sendKeys(Address);
		int_city.sendKeys(City);
		int_zipcode.sendKeys(Zipcode);
		btn_continue.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		slct_Plan.click();
		btn_continue.click();
		Actions action=new Actions(driver);
		action.moveToElement(btn_chck_cavity).click().moveToElement(btn_chck_root).click().moveToElement(btn_chck_tooth).click().moveToElement(btn_chck_extrct).click().build().perform();
		btn_continue.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle="Guardian Direct Insurance | Dental, Vision, Accident, Critical Illness & Pet";
		assertEquals(actualTitle, expectedTitle, "PlanPageTitle as Expected");
		btn_enroll.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
}
