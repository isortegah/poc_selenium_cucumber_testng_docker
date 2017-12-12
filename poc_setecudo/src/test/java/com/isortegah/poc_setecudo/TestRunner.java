package com.isortegah.poc_setecudo;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author isortegah
 */
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue = {"stepdefinition"} ,
        tags = {"@SearchGoogle"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
    public static Properties config = null;
    public static WebDriver driver = null;
    
    
    public void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
    }
    
    public void openBrowser() throws Exception {
		LoadConfigProperty();
		if (config.getProperty("browserType").equals("Firefox")) {
                        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.19.1/bin/geckodriver");
			driver = new FirefoxDriver();
		} else if (config.getProperty("browserType").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//test//resources//drivers/chromedriver");
			driver = new ChromeDriver();
		}
    }
    
    public void closeBrowser() throws Exception {
        driver.quit();
    }
    
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void pageLoad(int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
    
    public void setEnv() throws Exception {
        LoadConfigProperty();
        String baseUrl = config.getProperty("siteUrl");
        driver.get(baseUrl);
    }
    
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
         openBrowser();
        maximizeWindow();
        implicitWait(30);
        deleteAllCookies();
        setEnv();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() throws Exception {
        closeBrowser();
    }
    
}
