package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListnersImplimentation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->"+"STARTED SUCESSFULLY");
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->"+"PASSED SUCESSFULLY");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->"+"FAILED");
		Webdriver_Utility wu=new Webdriver_Utility();
		Java_Utility ju=new Java_Utility();
		String screenshotname=methodname+"-"+ju.getSystemdateInFormat();
		try {
			String path=wu.Take_ScreenShot(BaseClass.sDriver,screenshotname);
			
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->"+"SKIPPED");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\V_Tiger_Reports"+new Java_Utility().getSystemdateInFormat()+".html");
		htmlreport.config().setDocumentTitle("V-Tiger Execution ReportA");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("V TIGER REPORTS");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BROWSER","FIREFOX");
		report.setSystemInfo("URL","localhost:8080");
		report.setSystemInfo("REPORTER NAME","UPENDAR BATHULA");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
