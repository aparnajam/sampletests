package functional_tests.stepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"}
        ,format = {"pretty","html:TestResults/cucumber","junit:TestResults/junit/junit.xml"}

)

public class RunnerTest {}
