package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("---------------------- Starting Execution ------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("---------------------- Ending Execution ------------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Started ------------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Passed ------------------");
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file= new File("./test-recordings/"+test.getName()+".avi");
        if (file.delete())
            System.out.println("file deleted successfully");
        else
            System.out.println("failed to deleted file" );
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("---------------------- Test "  + test.getName() + " Failed ------------------");

        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveScreenShoot();

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("---------------------- Skipping Test "  + test.getName()+"----------------------");
    }

    @Attachment (value = "screen-shoot",type ="image/png" )
    public byte[] saveScreenShoot()
    { return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

    }
}
