package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends Basepage {

	public Homepage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[@title='My Account']")WebElement linkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")WebElement linkRegister;
	@FindBy(xpath="//a[normalize-space()='Login']")WebElement linkLogin;





	public void clickmyAccount()
	{
		linkMyaccount.click();
	}
	public void clickmyRegister()
	{
		linkRegister.click();
	}
	public void clickLogin()
	{
		linkLogin.click();
	}




}

