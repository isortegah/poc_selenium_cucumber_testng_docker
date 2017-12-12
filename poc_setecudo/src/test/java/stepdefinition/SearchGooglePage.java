package stepdefinition;

import com.isortegah.poc_setecudo.TestRunner;
import cucumber.api.java.en.Given;
import org.testng.Assert;

/**
 *
 * @author ISORTEGAH
 */
public class SearchGooglePage extends TestRunner{
    @Given("^I am on google page$")
    public void googlePage() throws Throwable {
        System.out.println("Desde el Given");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }
}
