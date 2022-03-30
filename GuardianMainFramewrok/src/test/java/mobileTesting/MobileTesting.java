package mobileTesting;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectRepository.MobileTestingObject;

public class MobileTesting {
	
	
	static WebDriver driver;
	public static final String url="https://oauth-saimakeup123-9ad9b:688d5ee5-13b7-4f07-9abc-ac12a0a29820@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("appium:deviceName", "Google Pixel 3a GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "11.0");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "1.20.2");
		caps.setCapability("sauce:options", sauceOptions);
// Android reult url: https://app.eu-central-1.saucelabs.com/tests/bd3894b2a56d47749634b62d38552eaa
		/*
		//copy saucelab configurator for chrome appium device
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "10.0");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "1.20.2");
		caps.setCapability("sauce:options", sauceOptions);
//chrome Result url: https://app.eu-central-1.saucelabs.com/tests/1fed79e3923147ab9be5a875400ccf92
			*/
		// Call remote driver url
		WebDriver driver = new RemoteWebDriver(new java.net.URL(url), caps);
		
		driver.get("https://www.guardiandirect.com/");
		MobileTestingObject obj=new MobileTestingObject(driver);
	
		
		driver.findElement(obj.btn_dental).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(obj.inp_frstname).click();
		driver.findElement(obj.inp_frstname).sendKeys("Kathrine");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(obj.btn_age)).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(obj.inp_email).click();
		driver.findElement(obj.inp_email).sendKeys("kathrine789@gmail.com");
		driver.findElement(obj.btn_continue).click();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,50);
		JavascriptExecutor JS=(JavascriptExecutor)driver;	
		WebElement Cust_details=driver.findElement(By.xpath("//div/input[@id='address.addressLine1']"));
		wait.until(ExpectedConditions.visibilityOf(Cust_details));
		driver.findElement(obj.int_address).sendKeys("MNO Appartments");
		driver.findElement(obj.int_city).sendKeys("Los Angeles");
		driver.findElement(obj.int_zipcode).sendKeys("90005");
		driver.findElement(obj.btn_continue).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(obj.slct_Plan).click();
		driver.findElement(obj.btn_continue).click();
		action.moveToElement(driver.findElement(obj.btn_chck_cavity)).click().moveToElement(driver.findElement(obj.btn_chck_root)).click().moveToElement(driver.findElement(obj.btn_chck_tooth)).click().moveToElement(driver.findElement(obj.btn_chck_extrct)).click().build().perform();
		driver.findElement(obj.btn_continue).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(obj.btn_enroll).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(obj.inp_frstname1).sendKeys("Kathrine");
		action.moveToElement(driver.findElement(obj.inp_lastname)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
		driver.findElement(obj.inp_lastname).sendKeys("D");		
		driver.findElement(obj.inp_dob).sendKeys("10211990");
		driver.findElement(obj.btn_next).click();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(obj.btn_payment)).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(obj.inp_routing).sendKeys("121138990");
		driver.findElement(obj.inp_accountnum).sendKeys(obj.account_num());
		action.moveToElement(driver.findElement(obj.btn_accounttype)).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		WebElement chckAuth=driver.findElement(By.xpath("//input[@name='isACHPaymentAuthorized' and @type='checkbox']"));
		action.moveToElement(chckAuth).click().build().perform();
		driver.findElement(obj.btn_submit).click();
		driver.findElement(obj.btn_agree).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(obj.inp_reentermail).sendKeys("kathrine789@gmail.com");
		driver.findElement(obj.btn_agree).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(obj.btn_agree).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(obj.btn_agree).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(obj.btn_agree_finish).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
	
	}
}
