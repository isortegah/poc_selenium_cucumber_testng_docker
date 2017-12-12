package stepdefinition;

import com.isortegah.poc_setecudo.TestRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 * @author ISORTEGAH
 */
public class SearchGooglePage extends TestRunner{
    WebElement element = null;
            
    @Given("^I am on google page$")
    public void googlePage() throws Throwable {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }
    
    @Then("^I type the word Cheese!")
    public void findElement(){
        element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
    }
    
    @And("^I submit request")
    public void submitRequest(){
        element.submit();
        pause(5000);
    }
}
