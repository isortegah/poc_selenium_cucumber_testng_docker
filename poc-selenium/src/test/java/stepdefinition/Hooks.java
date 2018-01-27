package stepdefinition;

import com.isortegah.poc_setecudo.utils.BrowserDriver;
import com.isortegah.poc_setecudo.utils.Common;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author ISORTEGAH
 */
public class Hooks {
    
    public static WebDriver driver;
    
    @Before("@Web")
    public void initializeTest() throws MalformedURLException{
        System.out.println("Al iniciar el escenario");
        BrowserDriver.setUpDriver(Common.webdriver , Common.browserType);
        driver = BrowserDriver.getDriver();
        
    }
 
    @After
    public void embedScreenshot(Scenario scenario) {
        System.out.println("Al terminar el escenario");
        if (scenario.isFailed()) {
            try {
                System.out.println("Al terminar el escenario");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @After("@Web")
    public void afterWeb(){
        driver.quit();
    }
    
}
