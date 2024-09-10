package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;


	String repName;

	public void onStart(ITestContext testContext)
	{
		/* SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Date dt=new Date();
		 String currentdatetimestamp=df.format(dt); */



		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //up 3 statements n this one is same for single line
				repName= "Test-Report-" +timeStamp + ".html";
		sparkReporter =new  ExtentSparkReporter(".\\reports\\" + repName);

		sparkReporter.config().setDocumentTitle("opencart Automation Report");//title of the report
		sparkReporter.config().setReportName("opencart Functional Testing"); //name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("sub Module" ,"Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");

		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System" , os);

		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())//xml groups
		{
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
	}

	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());//to display group reports
		test.log(Status.PASS,result.getName()+"  got successfully executed");

	}

	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL,result.getName()+"   got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());

		try{
			String imgPath=new BaseClass().captureScreen(result.getName()); //calling method from Baseclass
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}

	}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+"  got skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();

		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport); //it is opening report file automatically after run

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	/*	try
		{ URL url =new	URL("file:////"+System.getProperty("user.dir")+"\\reports\\"+repName);
		//Create the email message
		ImageHtmlEmail email=new ImageHtmlEmail();
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("smtp.googleemail.com"); //v have give company ID
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("punna1301@gmail.com","password"));
		email.setSSLOnConnect(true);
		email.setFrom("punna1301@gmail.com");//Sender
		email.setSubject("Test Result");
		email.setMsg("please find Attached Report.....");
		email.addTo("roja1307@gmail.com");//Receiver
		email.attach(url,"extent report","please check report....");
		email.send(); //send the email

		}
		catch(Exception e) { e.printStackTrace(); }
		}  */

	}

}
