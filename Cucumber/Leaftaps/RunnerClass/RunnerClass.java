package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Leaftaps.feature", glue = "stepDefinition")
public class RunnerClass extends AbstractTestNGCucumberTests{
	
}
