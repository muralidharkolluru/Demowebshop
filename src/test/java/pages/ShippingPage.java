package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage {
	public RemoteWebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@name='billing_address_id']")
	public WebElement element_BillingAddress;

	@FindBy(how = How.XPATH, using = "//*[@id='BillingNewAddress_CountryId']")
	public WebElement element_CountryID;

	@FindBy(how = How.XPATH, using = "//*[@name='shipping_address_id']")
	public WebElement elemnt_ShippingAddress;

	@FindBy(how = How.XPATH, using = "//*[@id='BillingNewAddress_FirstName']")
	public WebElement firstName;

	@FindBy(how = How.XPATH, using = "//*[@id='BillingNewAddress_City']")
	public WebElement cityName;

	@FindBy(how = How.XPATH, using = "//*[@id='BillingNewAddress_Address1']")
	public WebElement address1;

	@FindBy(how = How.XPATH, using = "//*[@id='BillingNewAddress_ZipPostalCode']")
	public WebElement zipCode;

	@FindBy(how = How.XPATH, using = "//*[@id='BillingNewAddress_PhoneNumber']")
	public WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "(//*[@title='Continue'])[1]")
	public WebElement continue1;

	@FindBy(how = How.XPATH, using = "(//*[@title='Continue'])[2]")
	public WebElement continue2;

	@FindBy(how = How.XPATH, using = "//*[@id='shippingoption_1']")
	public WebElement shippingMethod;

	@FindBy(how = How.XPATH, using = "(//*[@value='Continue'])[3]")
	public WebElement continue3;

	@FindBy(how = How.XPATH, using = "//*[@id='paymentmethod_0']")
	public WebElement paymentMethod;

	@FindBy(how = How.XPATH, using = "(//*[@value='Continue'])[4]")
	public WebElement continue4;

	@FindBy(how = How.XPATH, using = "//*[text()='You will pay by COD']")
	public WebElement cashOnDelivery;

	@FindBy(how = How.XPATH, using = "(//*[@value='Continue'])[5]")
	public WebElement continue5;

	@FindBy(how = How.XPATH, using = "//*[@value='Confirm']")
	public WebElement confirm;

	@FindBy(how = How.XPATH, using = "//*[text()='Your order has been successfully processed!']")
	public WebElement orderSuccessMessage;

	@FindBy(how = How.XPATH, using = "//*[@class='details']/li")
	public WebElement orderNumber;

	@FindBy(how = How.XPATH, using = "//*[@value='Continue']")
	public WebElement continue6;

	@FindBy(how = How.XPATH, using = "//*[@href='/logout']")
	public WebElement logout;

	public ShippingPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectNewAddressFromDropDown(WebElement element_BillingAddress1) {
		Select s = new Select(element_BillingAddress1);
		s.selectByVisibleText("New Address");

	}

	public void selectCountryFromDropDown(WebElement element_CountryID) {

		Select s1 = new Select(element_CountryID);
		s1.selectByVisibleText("India");
	}

	public void selectShippingAddressFromDropDown(WebElement elemnt_ShippingAddress) {

		Select s2 = new Select(elemnt_ShippingAddress);
		s2.selectByVisibleText("pqrst test, Ramnagar, Hyderabad 500020, India");

	}

	public void firstName(String x) {
		firstName.sendKeys(x);
	}

	public void cityName(String x) {
		cityName.sendKeys(x);
	}

	public void address1(String x) {

		address1.sendKeys(x);
	}

	public void zipPostalCode(String x) {
		zipCode.sendKeys(x);
	}

	public void phoneNumber(String x) {
		phoneNumber.sendKeys(x);
	}

	public void continue1() {
		continue1.click();
	}

	public void continue2() {
		continue2.click();
	}

	public void ShippingMethod() {
		shippingMethod.click();
	}

	public void continue3() {
		continue3.click();
	}

	public void paymentMethod() {
		paymentMethod.click();
	}

	public String paymentInformation() {

		String paymentmessage = cashOnDelivery.getText();
		return (paymentmessage);
	}

	public String orderSucessMessage() {

		String successMessage = orderSuccessMessage.getText();
		return (successMessage);
	}

	public String orderNumberMessage() {

		String orderNumberMessage = orderNumber.getText();
		return (orderNumberMessage);
	}

	public void continue4() {
		continue4.click();
	}

	public void confirm() {
		confirm.click();
	}

	public void continue5() {
		continue5.click();
	}

	public void continue6() {
		continue6.click();
	}

	public void logOut() {
		logout.click();
		driver.quit();
	}
}
