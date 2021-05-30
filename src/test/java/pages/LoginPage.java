package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public RemoteWebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@id='Email']")
	public WebElement userId;

	@FindBy(how = How.XPATH, using = "//*[@id='Password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "(//*[@type='submit'])[2]")
	public WebElement login;

	@FindBy(how = How.XPATH, using = "(//*[@class='account'])[1]")
	public WebElement accountIdLocator;

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillUserId(String x) {
		userId.sendKeys(x);
	}

	public void fillPassword(String x) {
		password.sendKeys(x);
	}

	public void clickOnLogin() {
		login.click();
	}

	public String getAccountId() {
		String accountId = accountIdLocator.getText();
		return (accountId);
	}

	public boolean isLoginPagedisplayed() {
		boolean b = login.isDisplayed();
		return b;
	}
}
