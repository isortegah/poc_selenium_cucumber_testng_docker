package stepdefinition;

import com.isortegah.poc_setecudo.TestRunner;
import com.isortegah.poc_setecudo.utils.BrowserDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 * @author ISORTEGAH
 */
public class SearchGooglePage {
    WebElement element = null;
            
    @Given("^I am on google page$")
    public void googlePage() throws Throwable {
        Hooks.driver.get("http://google.com");
        String title = Hooks.driver.getTitle();
        Assert.assertEquals(title, "Google");
    }
    
    @Then("^I type the word Cheese!")
    public void findElement(){
        element = Hooks.driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
    }
    
    @And("^I submit request")
    public void submitRequest(){
        element.submit();
        BrowserDriver.pause(5000);
    }
}
