package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public RemoteWebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[text()='Log in']")
	public WebElement login;

	@FindBy(how = How.XPATH, using = "//*[text()='Welcome, Please Sign In!']")
	public WebElement welcomeMessageLocator;

	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogin() {
		login.click();
	}

	public String getWelcomeMessage()

	{
		String actualMessage = welcomeMessageLocator.getText();
		return actualMessage;
	}
}