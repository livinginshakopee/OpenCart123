package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage {



	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")WebElement txt_FirstName;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txt_LastName;
	@FindBy(xpath="//input[@id='input-email']")WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-telephone']")WebElement txt_Phone_No;
	@FindBy(xpath="//input[@id='input-password']")WebElement txt_pwd;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement txt_cfm_pwd;
	@FindBy(xpath=" //input[@value='Continue']")WebElement continueBtn;
	@FindBy(xpath="//input[@name='agree']")WebElement chkPolicy;
	@FindBy(xpath=" //h1[normalize-space()='Your Account Has Been Created!']")WebElement SuccesMsg;

	public void setFirstName(String firstname)
	{
		txt_FirstName.sendKeys(firstname);
	}
	public void setLastName(String lastname)
	{
		txt_LastName.sendKeys(lastname);

	}
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);

	}
	public void setPhoneNo(String Ph_no)
	{
		txt_Phone_No.sendKeys(Ph_no);

	}
	public void setPassword(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd)
	{
		txt_cfm_pwd.sendKeys(pwd);
	}

	public void clickingonchkPolicy()
	{
		chkPolicy.click();
	}
	public void clickingoncontinueButton()
	{
		//sol1
		continueBtn.click();


		//sol2 these all solutions are if button doesnt work v use any one these 6 solutions
	//	continueBtn.submit();

		//sol3
	//	Actions act=new Actions(driver);
	//	act.moveToElement(continueBtn).click().perform();

		//sol4
	//	JavascriptExecutor js=(JavascriptExecutor)driver;
	//	js.executeScript("arguements[0].click()",continueBtn);

		//sol5
	//	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//	mywait.until(ExpectedCondition.elementToBeClickable(continueBtn));

		//sol6
	//	continueBtn.sendKeys(Keys.RETURN);
	}

	public String getConformationMsg()
	{ //v dont write any conditions in pageObjects classes thats why v r using try catch here.
		try {
			return(SuccesMsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}



}
