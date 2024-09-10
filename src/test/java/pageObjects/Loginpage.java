package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

	public Loginpage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']")WebElement txt_emailId;
	@FindBy(xpath="//input[@id='input-password']")WebElement txt_password;
	@FindBy(xpath="//input[@value='Login']")WebElement btn_login;

	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")WebElement linkforgotpwd;


	public void setEmailid(String email_id)
	{
		txt_emailId.sendKeys(email_id);
	}
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	public void clickinglogin()
	{
		btn_login.click();
	}

	public void clickinglinkforgotpwd()
	{
		linkforgotpwd.click();
	}


}
