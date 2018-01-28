package com.isortegah.pocselenium.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static stepdefinition.Hooks.driver;

/**
 *
 * @author ISORTEGAH
 */
public class BrowserDriver {

    public BrowserDriver() {
    }

    public void defaultConfig(){
        maximizeWindow();
    }
    
    public static void setUpDriver(String webdriver, String browserType) throws MalformedURLException {
        if(webdriver.equals("local")){
            if(browserType.equals("Firefox")){
                System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.19.1/bin/geckodriver");
                driver = new FirefoxDriver();
            } else if ( browserType.equals("Chrome")){
                System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") 
                                                + "//src//test//resources//drivers/chromedriver");
                driver = new ChromeDriver();
            }
        }else{
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(browserType.toLowerCase());
            driver = new RemoteWebDriver(new URL(webdriver), dc);
        }
    }
    
    public static WebDriver getDriver(){
        return driver;
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
    
    public static void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }
}
