package pageObjectRepository;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MobileTestingObject {
	
	static WebDriver driver;
	public MobileTestingObject(WebDriver driver1) {	
		this.driver=driver1;	
	}

	//home page objects	
		public By btn_accident=By.xpath("//div/button[text()='Accident']");
		public By btn_dental=By.xpath("//div/button[text()='Dental']");
		public By btn_vision=By.xpath("//div/button[text()='Vision']");
		
		//Accident, dental, vision Enroll for insurance
		public By inp_frstname=By.xpath("//input[@id='fullName']");
		public By inp_frstname1=By.xpath("//input[@id='firstName']");
		public By inp_lastname=By.xpath("//input[@id='lastName']");
		public By btn_age=By.xpath("//button[@name='age']");
		public By inp_email=By.xpath("//input[@name='email']");
		public By btn_continue=By.xpath("//div/button[text()='Continue']");
		public By btn_finish=By.xpath("//div/button[text()='Finish']");
		
		//Payment details
		public By btn_payment=By.xpath("//button[@name='paymentMethod']");	
		public By inp_routing=By.xpath("//input[@name='bankInformation.routingNumber']");
		public By inp_accountnum=By.xpath("//input[@name='bankInformation.accountNumber']");
		public By btn_accounttype=By.xpath("//button[@name='bankInformation.type']");
		public By btn_chck_auth=By.xpath("//input[@name='isACHPaymentAuthorized' and @type='checkbox']");
		
		//customer details
		public By int_address=By.xpath("//div/input[@id='address.addressLine1']");
		public By int_city=By.xpath("//div/input[@id='address.city']");
		public By int_zipcode=By.xpath("//div/input[@id='address.zipCode']");
		public By slct_Plan=By.xpath("//span[contains(text(),'A couple times a year, for cleaning and the occasional filling')]");
		public By btn_chck_cavity=By.xpath("//input[@name='multiple_select' and @type='checkbox' and @value='cavity_fillings']");
		public By btn_chck_root=By.xpath("//input[@name='multiple_select' and @type='checkbox' and @value='root_canals']");
		public By btn_chck_tooth=By.xpath("//input[@name='multiple_select' and @type='checkbox' and @value='teeth_whitening']");
		public By btn_chck_extrct=By.xpath("//input[@name='multiple_select' and @type='checkbox' and @value='extractions']");
		public By btn_enroll=By.xpath("//div/button[text()='Enroll now']");
		public By btn_submit=By.xpath("//div/button[text()='Submit']");
		public By inp_dob=By.xpath("//input[@name='dateOfBirth']");
		public By btn_next=By.xpath("//div/button[text()='Next']");
		public By btn_agree=By.xpath("//button[text()='I agree']");
		public By inp_reentermail=By.xpath("//input[@id='confirm_email']");
		public By btn_agree_finish=By.xpath("//button[text()='Agree & finish']");

		
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
