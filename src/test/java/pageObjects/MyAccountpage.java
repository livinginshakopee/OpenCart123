package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends Basepage {

	public MyAccountpage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']")WebElement msgheading;

	@FindBy(xpath=" //a[@class='list-group-item'][normalize-space()='Logout']")WebElement Logout;


//f2 for rename file



	public void clickinglogout()
	{
		Logout.click();
	}
	public boolean isMyAccountPageExists()
	{
		try {
			return(msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
