package com.isortegah.aspects;

import cucumber.api.Scenario;
import gherkin.formatter.Reporter;
import gherkin.I18n;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Step;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;


/**
 *
 * @author ISORTEGAH
 */
@Aspect
public class TakeScreenShotAspect {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getCanonicalName());

    /**
     *
     * @param featurePath
     * @param step
     * @param reporter
     * @param i18n
     */
    @Pointcut("execution (* cucumber.runtime.Runtime.runStep(..)) && " +
         "args (featurePath, step, reporter, i18n)")
    protected void runStep(String featurePath, Step step, Reporter reporter, I18n i18n) {

    }

    @After(value = "runStep(featurePath, step, reporter, i18n)")
    public void afterRunStep(JoinPoint jp,String featurePath, Step step, Reporter reporter, I18n i18n) throws Throwable {
        
        System.out.println("-----> "+step.getName());
    }

    @Pointcut("execution (public void cucumber.runtime.model.CucumberFeature.scenario(..)) && "
            + "args(scenario)")
    protected void scenario(Scenario scenario) {}

    @Before(value="scenario(scenario)")
    public void beforeScenario(Scenario scenario){
        System.out.println("Hola before");
    }

    @Pointcut("execution (public void cucumber.runtime.model.CucumberTagStatement.run(..))")
    protected void runScenario() {}

    @Before( value = "runScenario()")
    public void beforeRunScenario(){
        System.out.println("Antes de correr el escenario ");
    }
    
    @After( value = "runScenario()")
    public void afterRunScenario(){
        System.out.println("Despues de correr el escenario ");
    }

    @Pointcut("execution (void cucumber.runtime.ScenarioImpl.add(..)) && args(result)")
    protected void scenarioImpl(Result result){}

    @Before( value ="scenarioImpl(result)")
    public void beforeScenarioImpl(Result result){
        System.out.println("Antes de guardar el resultado");
    }
    
    @After( value ="scenarioImpl(result)")
    public void afterScenarioImpl(Result result){
        System.out.println("Despues de guardar el resultado");
    }
}
