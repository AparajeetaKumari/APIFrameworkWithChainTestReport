package listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.generator.ChainTestSimpleGenerator;
import com.aventstack.chaintest.plugins.ChainTestListener;


public class MyTestNGListener implements ITestListener{
	
	 public void onTestSuccess(ITestResult result) 
	 {
		   ChainTestListener.log("Listner Test Passed "+result.getMethod().getMethodName());
	}
	 
	 public void onTestFailure(ITestResult result) 
	 {
		 ChainTestListener.log("Listner Test Failed "+result.getThrowable().getMessage());
	 }
	 
	 public void onTestSkipped(ITestResult result) 
	 {
		 ChainTestListener.log("Listner Test Skipped "+result.getThrowable().getMessage());
	}

	 public void onStart(ITestResult result)
	 {
		 ChainTestListener.log("Listner Test Started ");
		  }
	 
	 public void onFinish(ITestContext context) {
		 ChainTestListener.log("Listner Test Finished ");
		  }

}
