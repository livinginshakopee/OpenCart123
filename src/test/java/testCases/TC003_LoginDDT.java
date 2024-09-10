package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid-login success-test pass-logout
 * Data is valid -login failed-test is fail
 *
 * data is invalid --login success --test fail-logout
 * data is invalid --login failed --test pass
 */

public class TC003_LoginDDT extends BaseClass {



	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")	//DataProviders class is in another package
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		try {


		logger.info("***************************starting TC003_LoginDDT Method**************");
		Homepage hp=new Homepage(driver);
		hp.clickmyAccount();
		hp.clickLogin();

		//Login
		Loginpage lp=new Loginpage(driver);
		lp.setEmailid(email);
		lp.setPassword(pwd);
		lp.clickinglogin();

		//MyAccount
		MyAccountpage macc=new MyAccountpage(driver);
		boolean myaccount=macc.isMyAccountPageExists();

		if(exp.equalsIgnoreCase("valid"))
		{
			if(myaccount)
			{
				macc.clickinglogout(); //assertion after statements doesnt execute
				Assert.assertTrue(true);

			}
			else
			{
				Assert.assertTrue(false);
			}
		}

		if(exp.equalsIgnoreCase("invalid"))
		{
			if(myaccount)
			{
				macc.clickinglogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			System.out.println (e);
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***************************finished TC003_LoginDDT Method**************");
	}
}
