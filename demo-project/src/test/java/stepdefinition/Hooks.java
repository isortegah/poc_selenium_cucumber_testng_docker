package stepdefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 *
 * @author ISORTEGAH
 */
public class Hooks {
    @Before
    public void initializeTest(){
        System.out.println("Al iniciar el escenario");
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
    
}
