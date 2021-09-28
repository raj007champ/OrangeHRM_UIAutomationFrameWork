package com.hrm.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrm.base.TestBase;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class TestListener extends TestBase implements ITestListener{
	TestCase testCase;
	TestLinkAPI api;
	TestPlan testPlan;
	Build[] builds;
	Build build;
	
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	try {
    		takeScreenShotForFailedTestCase(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	api.reportTCResult(testCase.getId(), null, testPlan.getId(), ExecutionStatus.FAILED, build.getId(), null,
				"Executed Failed", null, null, null, null, null, null);
	}
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			String testDescription=result.getMethod().getDescription();
			String testid=testDescription.split(":")[0];
			api = new TestLinkAPI(new URL(TestConfig.SERVER_URL), TestConfig.API_KEY);
			testCase = api.getTestCaseByExternalId(testid, null);
			testPlan = api.getTestPlanByName(TestConfig.TEST_PLAN_NAME, TestConfig.PROJECT_NAME);
			builds = api.getBuildsForTestPlan(testPlan.getId());
			build = null;
			for (Build buildInArray : builds) {
				if (buildInArray.getName().equals(TestConfig.BUILD_NAME)) {
					build = buildInArray;
					break;
				}
			}
		} catch (TestLinkAPIException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		
		api.reportTCResult(testCase.getId(), null, testPlan.getId(), ExecutionStatus.PASSED, build.getId(), null,
				"Executed successfully", null, null, null, null, null, null);
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
	 // List of test results which we will delete later
        List<ITestResult> testsToBeRemoved = new ArrayList<>();
        
        // collect all id's from passed test
        Set <Integer> passedTestIds = new HashSet<>();
        for (ITestResult passedTest : context.getPassedTests().getAllResults()) {
            passedTestIds.add(getId(passedTest));
        }

        Set <Integer> failedTestIds = new HashSet<>();
        for (ITestResult failedTest : context.getFailedTests().getAllResults()) {
            int failedTestId = getId(failedTest);

            // if we saw this test as a failed test before we mark as to be deleted
            // or delete this failed test if there is at least one passed version
            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }
        
        Set <Integer> skippedTestIds = new HashSet<>();
        for (ITestResult skippedTest : context.getSkippedTests().getAllResults()) {
            int skippedTestId = getId(skippedTest);

            // if we saw this test as a Skipped test before we mark as to be deleted
            // or delete this skipped test if there is at least one passed version
            if (skippedTestIds.contains(skippedTestId) || passedTestIds.contains(skippedTestId) || failedTestIds.contains(skippedTestId)){
                testsToBeRemoved.add(skippedTest);
            } else {
                failedTestIds.add(skippedTestId);
            }
        }

        // finally delete all tests that are marked
        for (Iterator<ITestResult> iterator = context.getFailedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
                iterator.remove();
            }
        }
        
        for (Iterator<ITestResult> iterator = context.getSkippedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
                iterator.remove();
            }
        }

	}
	
	public static int getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = 31 * id + result.getMethod().getMethodName().hashCode();
        id = 31 * id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
        return id;
    }


}
