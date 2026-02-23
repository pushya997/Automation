package listernerUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import config.BaseClass;


public class ListernerImplementation implements ITestListener,ISuiteListener {
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report config", true);
		Date date=new Date();
		String newdate = date.toString().replace(" ", "_").replace(":", "_");
		spark=new ExtentSparkReporter("./advanceReport/report_"+newdate+".html");
		spark.config().setDocumentTitle("CRM");
		spark.config().setReportName("Ninza CRM Reports");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Window11");
		report.setSystemInfo("browser", "edge");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("execution backup", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "===Execution has started");
		Reporter.log("execution started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("execution successfully done", true);
		test.log(Status.PASS, "===Execution completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log("execution fail", true);
		Date date=new Date();
		String newdate = date.toString().replace(" ", "_").replace(":", "_");
		
		TakesScreenshot ts= (TakesScreenshot) BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp,testname+newdate);
		test.log(Status.FAIL, "===Execution failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("execution skipped", true);
		test.log(Status.SKIP, "===Execution skipped");
	}
	
	

}
