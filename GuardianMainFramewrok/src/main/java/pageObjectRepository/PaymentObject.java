package pageObjectRepository;

import static org.testng.Assert.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentObject {
	
	static WebDriver driver;
	
	//Payment details
	@FindBy (xpath="//button[@name='paymentMethod']")
	WebElement btn_payment;	
	@FindBy (xpath="//input[@name='bankInformation.routingNumber']")
	WebElement inp_routing;
	@FindBy (xpath="//input[@name='bankInformation.accountNumber']")
	WebElement inp_accountnum;
	@FindBy (xpath="//button[@name='bankInformation.type']")
	WebElement btn_accounttype;
	@FindBy (xpath="//input[@name='isACHPaymentAuthorized' and @type='checkbox']")
	WebElement btn_chck_auth;
	@FindBy (xpath="//div/button[text()='Submit']")
	WebElement btn_submit;
	@FindBy (xpath="//button[text()='I agree']")
	WebElement btn_agree;
	@FindBy (xpath="//input[@id='confirm_email']")
	WebElement inp_reentermail;
	@FindBy (xpath="//button[text()='Agree & finish']")
	WebElement btn_agree_finish;
		
	public PaymentObject(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public void Account_Payment(String firstName, String lastName, String emailID, String DOB) {
		
		Actions action=new Actions(driver);
		action.moveToElement(btn_payment).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		inp_routing.sendKeys("121138990");
		inp_accountnum.sendKeys(account_num());
		action.moveToElement(btn_accounttype).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		WebElement chckAuth=driver.findElement(By.xpath("//input[@name='isACHPaymentAuthorized' and @type='checkbox']"));
		action.moveToElement(chckAuth).click().build().perform();
		String actualTitle=driver.getTitle();
		String expectedTitle="Insurance Payment Checkout Confirmation | Thank You From Guardian Direct";
		assertEquals(actualTitle, expectedTitle, "PaymentpageTitle as Expected");
		btn_submit.click();
		btn_agree.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		inp_reentermail.sendKeys(emailID);
		btn_agree.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		btn_agree.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		btn_agree.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		btn_agree_finish.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}	
	
	public String account_num() {
		Random rand=new Random();
		String a[]=new String[10];
		for(int i=0;i<10;i++) {
			int routing_num=rand.nextInt(10);
			a[i]=Integer.toString(routing_num);
		}
		String b=a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7]+a[8]+a[9]+"13";
		return b;
	}

}
