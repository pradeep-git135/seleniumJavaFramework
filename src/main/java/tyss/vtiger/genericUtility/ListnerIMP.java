package tyss.vtiger.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerIMP implements ITestListener {
			
    public void onFinish(ITestContext arg0) {					
        System.out.println("Act like @AfterSuite");
    }		

  		
    public void onStart(ITestContext arg0) {					
        System.out.println("Act like @before suite");				
        		
    }		

    		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult result) {					
    	System.out.println(result.getMethod().getMethodName()+" is failed "+" Status: "+result.getStatus());
    	System.out.println("\n"+result.getThrowable());
    }		

   		
    public void onTestSkipped(ITestResult result) {					
    System.out.println(result.getMethod().getMethodName()+" is skipped "+" Status: "+result.getStatus());			
        		
    }		

   		
    public void onTestStart(ITestResult result) {					
        System.out.println("\nExecuting =============="+result.getMethod().getMethodName());				
        		
    }		

    		
    public void onTestSuccess(ITestResult result) {					
       System.out.println(result.getMethod().getMethodName()+" is passed "+" And Status: "+result.getStatus());	
       System.out.println(result.getTestName());
        		
    }
}
