package utilites;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testutility {

	public RemoteWebDriver driver;

	public Testutility() {
		driver = null;
	}

	public RemoteWebDriver getdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return (driver);
	}

	public void launchsite(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void closesite() {
		driver.quit();
	}

}
