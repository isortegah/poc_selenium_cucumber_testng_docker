package com.isortegah.aspects;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import gherkin.I18n;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.testng.Reporter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.logging.Logger;


/**
 *
 * @author ISORTEGAH
 */
@Aspect
public class TakeScreenShotAspect {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getCanonicalName());
    private String scenarioName = null;
    private Boolean execute = false;
    private List<String> tagsValids = null;
    private List<ScenarioRun> scenarios = new ArrayList<ScenarioRun>();
    private int numStep = 0 ;
    private String statusRunStep;


    @Pointcut("execution (public void cucumber.runtime.Runtime.runStep(..)) && "
            + "args (featurePath, step, reporter, i18n)")
    protected void takeScreenshotStar(String featurePath, Step step, Reporter reporter, I18n i18n) {

    }

    @After(value = "takeScreenshotStar(featurePath, step, reporter, i18n)")
    public void afterTakeScreenshotStar(JoinPoint jp, String featurePath, Step step, Reporter reporter, I18n i18n) throws Throwable {
        System.out.println("Hola");
        if(isExecute() && isStatusRunStepValid()){
            System.out.println("Hola");
        }
    }

    @Pointcut("execution (public void cucumber.runtime.model.CucumberFeature.scenario(..)) && "
            + "args(scenario)")
    protected void scenario(Scenario scenario) {}

    @Before(value="scenario(scenario)")
    public void beforeScenario(Scenario scenario){
        System.out.println("Hola");
        execute = false;
        scenarioName = scenario.getName();
    }

    @Pointcut("execution (public void cucumber.runtime.model.CucumberFeature.scenarioOutline(..)) && "
            + "args(scenarioOutline)")
    protected void scenarioOutline(ScenarioOutline scenarioOutline) {}

    @Before(value="scenarioOutline(scenarioOutline)")
    public void beforeScenarioOutline(ScenarioOutline scenarioOutline){
        System.out.println("Hola");
        saveScenarioOutlineData(scenarioOutline);
        execute = false;
        scenarioName = scenarioOutline.getName();
    }

    public TakeScreenShotAspect(){
        tagsValids = Arrays.asList("@Web");
    }

    private Boolean isExecute(){
        return execute;
    }

    private void saveScenarioOutlineData(ScenarioOutline scenarioOutline){
        ScenarioRun scenarioRun = new ScenarioRun();
        List<String> tagsScenario = new ArrayList<String>();
        scenarioRun.setScenarioName(scenarioOutline.getName());

        scenarioOutline.getTags().forEach((tag)->{
            tagsScenario.add(tag.getName());
        });
        scenarioRun.setTags(tagsScenario);
        scenarios.add(scenarioRun);
    }

    @Pointcut("execution (public void cucumber.runtime.model.CucumberTagStatement.run(..))")
    protected void runScenario() {}

    @Before( value = "runScenario()")
    public void beforeRunScenario(){
        System.out.println("Hola");
        if( scenarios.size()>0 ) {
            scenarioName = scenarios.get(0).getScenarioName();
            verifyExistenceTagsValids(scenarios.get(0).getTags());
        }
        numStep = 1;

    }

    @After( value = "runScenario()")
    public void afterRunScenario(){
        System.out.println("Hola");
        if( scenarios.size() > 0 ){
            scenarios.remove(0);
            execute = false;
        }
    }

    private void verifyExistenceTagsValids(List<String> tags) {
        tags.forEach((tag) -> {
            tagsValids.forEach((tagValid) ->{
                if(tagValid.equals(tag))
                    execute=true;
            });
        });
    }

    @Pointcut("execution (void cucumber.runtime.ScenarioImpl.add(..)) && args(result)")
    protected void scenarioImpl(Result result){}

    @Before( value ="scenarioImpl(result)")
    public void beforeScenarioImpl(Result result){
        statusRunStep = result.getStatus();
        System.out.println("Hola");
    }

    private Boolean isStatusRunStepValid(){
        String all = "ALL";
        switch (all){
            case "ALL":
                return true;
            case "FAIL":
                return !statusRunStep.equals("passed");
            case "PASS":
                return statusRunStep.equals("passed");
            default:
                return false;
        }
    }
}
