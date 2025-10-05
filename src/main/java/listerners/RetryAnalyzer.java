package listerners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import config.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int retryCount =0;
	private int maxRetryCount =2;
			//Integer.parseInt(new ConfigReader().getProperty("maxRetrycount"));
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(retryCount<maxRetryCount) {
			retryCount++;
			System.out.println("Retrying test"+result.getMethod().getMethodName());
			return true;
		}
		
		return false;
	}

}
