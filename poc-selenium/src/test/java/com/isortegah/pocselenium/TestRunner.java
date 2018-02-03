package com.isortegah.pocselenium;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author isortegah
 */
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue = {"stepdefinition"} ,
        tags = {"@SearchGoogle,@Web"} ,
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
    public static String currentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String cal1 = dateFormat.format(cal.getTime());
        return cal1;
    }
    
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
       
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
    
    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() throws Exception {
    }
    
    @AfterClass(alwaysRun = true)
    public void takeScreenshot() throws IOException {
        /*File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//screenshots/screenshot.png"));*/

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownr(ITestResult result) throws IOException {
        /*if (result.isSuccess()) {
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String failureImageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
            File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
            FileUtils.copyFile(imageFile, failureImageFile);
        }*/

    }
}
