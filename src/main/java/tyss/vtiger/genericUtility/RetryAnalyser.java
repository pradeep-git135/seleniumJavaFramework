package tyss.vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	int count = 0;
	int retryCount = 2;
	public boolean retry(ITestResult result) {
		while (count<retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
