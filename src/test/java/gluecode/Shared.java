package gluecode;

import java.io.FileReader;
import java.util.Properties;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilites.Testutility;

public class Shared {
	public String projectpath;
	public RemoteWebDriver driver; // SWD class
	public Scenario scenario; // cucumber-java class
	public Properties properties; // JDK class
	public Testutility testUtility;

	// method to be executed before for every "Scenario:" or "Scenario Outline:"
	// iterations
	@Before
	public void method1(Scenario scenario) throws Exception {
		// define driver object as null by default
		driver = null;
		// Create "Scenario" class object to work for current "Scenario:" or "Scenario
		// Outline:"
		this.scenario = scenario;
		// Load properties file
		projectpath = System.getProperty("user.dir");
		FileReader fr = new FileReader(projectpath + "\\src\\test\\resources\\properties\\config.properties");
		properties = new Properties();
		properties.load(fr);
		// Create object to TestUtility class
		testUtility = new Testutility();

	}
}
