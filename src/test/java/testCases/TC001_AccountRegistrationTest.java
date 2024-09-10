
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test(groups={"Regression", "Master"})

	public void verify_account_registration()
	{
		logger.info("***************Strting TC001 _AccountRegistrationTest****************");

		try {


		Homepage hp=new Homepage( driver); //v r calling from pageObject package v created Homepage class and import up too

		hp.clickmyAccount();
		hp.clickmyRegister();
		logger.info("***************Clicked on MyAccount Link****************");

		AccountRegistrationPage regpage=new AccountRegistrationPage(driver); //same here too

		logger.info("***************Providing customer details****************");

		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());

		String password=randomeAlphaNumric();//if v dont assign to variable ,it can change that value in confirm password
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setEmail(randomeString()+"@gmail.com");//ramdomly generated the email
		regpage.setPhoneNo( randomeNumber());

		regpage.clickingonchkPolicy();
		regpage.clickingoncontinueButton();
		logger.info("***************Validation Message****************");
		//where v will get ,v think, v need to give logger.info



		String confmsg=regpage.getConformationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Dedug logs--- ");
			Assert.assertTrue(false);
		}


		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{

			Assert.fail();
		}

		logger.info("**********************Finished TC001_AccountRegistrationTest*******************");
	}






}
