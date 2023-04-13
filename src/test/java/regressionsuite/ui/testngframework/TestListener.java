package regressionsuite.ui.testngframework;

import com.magentoapplication.utility.Log4j;
import com.magentoapplication.utility.TakeScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;
public class TestListener implements ITestListener {

    Log4j log=new Log4j();

    TakeScreenShot takeScreenShot=new TakeScreenShot();

    static List<ITestNGMethod> passedTests=new ArrayList<>();

    static List<ITestNGMethod> failedTests=new ArrayList<>();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testName=iTestResult.getName();
        log.testStart(testName+"Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        String testName=iTestResult.getName();
        log.info(testName+"Test Passed");
        passedTests.add(iTestResult.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testName=iTestResult.getName();
        log.error(testName+"Test FAILED!!");
        takeScreenShot.takeScreenShot(iTestResult.getMethod().getMethodName().trim()+"-fail",
                (WebDriver) iTestResult.getTestContext().getAttribute("driver"));
        failedTests.add(iTestResult.getMethod());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String testName=iTestResult.getName();
        log.error(testName+"Test Skipped Check Code!!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        String testName=iTestContext.getName();
        log.testStart(testName+"Test Started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        String testName=iTestContext.getName();
        log.testEnd(testName+"Test Ended");

    }
}
