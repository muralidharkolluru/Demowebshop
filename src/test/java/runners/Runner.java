package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
	   tags = "@test",
		monochrome=true,
				 plugin = {"json:target/cucumber-report/cucumber.json","pretty","html:target/cucumber-html-report.html"}
			)
public class Runner extends AbstractTestNGCucumberTests
{
}
