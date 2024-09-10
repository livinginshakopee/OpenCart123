package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;

public class TC002_Logintest extends BaseClass {


	@Test(groups={"Sanity","Master"})
	public void Login()
	{
		logger.info("*****************String TC002Logintest**************");
		try {

			Homepage hp=new Homepage(driver);
			hp.clickmyAccount();
			hp.clickLogin();

			logger.info("******************Clicked Login button*************");


			Loginpage lp=new Loginpage(driver);

			logger.info("*********************Going to login my Account**************");

			lp.setEmailid(p.getProperty("email")); //getting values from config.properties file from src/test/resources.
			lp.setPassword(p.getProperty("password"));
			lp.clickinglogin();
			logger.info("******************Clicking login button****************");

			MyAccountpage map=new MyAccountpage(driver);
				boolean myAccount = map.isMyAccountPageExists();

					Assert.assertTrue(myAccount);
			// (or	Assert.assertEquals(myAccount,true,"Login failed")	//first 2 values r compares thired if it is fail fives that msg
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		  logger.info("************I logined my Account**********");

	}
}
