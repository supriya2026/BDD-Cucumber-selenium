package testRunner;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "C:\\Workspaces\\BDD\\src\\test\\resources\\features\\AddToCart.feature",
		 glue = {"StepDefinitions","AppHooks"},
		 tags= "@smoke or @sanity",
		 dryRun = false,
		 plugin = {"pretty"},
		 monochrome = true)


public class TestDataRunner {
       
       
}
 