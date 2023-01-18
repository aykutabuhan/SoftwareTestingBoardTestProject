package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class Listeners implements ITestListener{

    protected static WebDriver ms_webDriver;
    @Override
    public void onTestStart(ITestResult result) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ms_webDriver = new ChromeDriver();
        ms_webDriver.manage().window().maximize();
        System.out.println(result.getName() + " test case started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the testcase passed is :" +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the testcase failed is :" +result.getName());

        File src = ((TakesScreenshot) ms_webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(String.format("src/test/java/%s.png",
                    result.getMethod().getMethodName())));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase skipped is : " +result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        ms_webDriver.quit();
    }
}
