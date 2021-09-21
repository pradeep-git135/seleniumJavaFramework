package tyss.vtiger.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerIMP implements ITestListener {
	 ExtentReports report;
	 ExtentTest test;
	 
	 
    public void onFinish(ITestContext arg0) {					
//        System.out.println("Act like @AfterSuite");
    	
    	report.flush();
    }		

    public void onStart(ITestContext arg0) {					
//        System.out.println("Act like @before suite");	
    	
    	//report configuration
    	
//    	path where to generate report
    	ExtentSparkReporter reporter = new ExtentSparkReporter("./extentReports/report.html");
//    	setting the theme color
    	reporter.config().setTheme(Theme.STANDARD);
//    	setting the title of the report
    	reporter.config().setDocumentTitle("VTIGER");
//    	setting the name of the report
    	reporter.config().setReportName("SMOKE");
    	
// attach all the configuration   
    	 report = new ExtentReports();
    	 report.attachReporter(reporter);
        		
    }		

    		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult result) {					
//    	System.out.println(result.getMethod().getMethodName()+" is failed "+" Status: "+result.getStatus());
//    	System.out.println("\n"+result.getThrowable());
    	Base b = new Base();
    	try {
			b.getScreenshot(result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String destinationPath = null;
		try {
			destinationPath = b.getScreenshot(result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
    	test.addScreenCaptureFromPath(destinationPath);
    	test.log(Status.FAIL, result.getThrowable());
    }		

   		
    public void onTestSkipped(ITestResult result) {					
//    System.out.println(result.getMethod().getMethodName()+" is skipped "+" Status: "+result.getStatus());	
    	
    	test.log(Status.SKIP, result.getMethod().getMethodName()+" test skipped ");
    	test.log(Status.FAIL, result.getThrowable());

        		
    }		

   		
    public void onTestStart(ITestResult result) {					
//        System.out.println("\nExecuting =============="+result.getMethod().getMethodName());	
    	
    	test = report.createTest(result.getMethod().getMethodName());
        		
    }		

    		
    public void onTestSuccess(ITestResult result) {					
//       System.out.println(result.getMethod().getMethodName()+" is passed "+" And Status: "+result.getStatus());	
//       System.out.println(result.getTestName());
    	
    	test.log(Status.PASS, result.getMethod().getMethodName()+" is passed ");
    	
    	
        		
    }
}
