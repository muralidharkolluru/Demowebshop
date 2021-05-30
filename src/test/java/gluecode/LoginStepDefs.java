package gluecode;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CategoriesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ShippingPage;

public class LoginStepDefs {

	public HomePage homePage;
	public LoginPage loginPage;
	public CategoriesPage categoriesPage;
	public ShippingPage shippingPage;
	public WebDriverWait wait;
	public Shared shared;
	public int expectedPrice;

	public LoginStepDefs(Shared sh) {
		this.shared = sh;
	}

	@Given("^launch site using chrome$")
	public void launchSiteUsingChrome() {
		shared.driver = shared.testUtility.getdriver();
		homePage = new HomePage(shared.driver);
		loginPage = new LoginPage(shared.driver);
		categoriesPage = new CategoriesPage(shared.driver);
		shippingPage = new ShippingPage(shared.driver);
		Integer MaxTime = Integer.parseInt((String) shared.properties.get("maxtime"));
		wait = new WebDriverWait(shared.driver, MaxTime);
		shared.testUtility.launchsite(shared.properties.getProperty("url"));
		wait.until(ExpectedConditions.visibilityOf(homePage.login));

	}

	@When("^click on login button$")
	public void clickOnLoginButton() {
		homePage.clickOnLogin();
	}

	@Then("^title should be \"(.*)\"$")
	public void validateTitle(String expected) {

		String actual = homePage.getWelcomeMessage();

		if (expected.equals(actual)) {

			shared.scenario.log("login test passed");
		} else {
			byte[] b = shared.driver.getScreenshotAs(OutputType.BYTES);
			shared.scenario.attach(b, "image/png", "login test failed");
		}
	}

	@Given("^login page is displayed$")
	public void isLoginPageDisplayed() {
		if (loginPage.isLoginPagedisplayed()) {
			shared.scenario.log("login page is displayed successfully");
		} else {
			byte[] b = shared.driver.getScreenshotAs(OutputType.BYTES);
			shared.scenario.attach(b, "image/png", "login page does not displayed");
		}
	}

	@When("^enter user id as \"(.*)\" and  password as \"(.*)\".$")
	public void enterUserId(String userid, String password) {
		loginPage.fillUserId(userid);
		loginPage.fillPassword(password);

	}

	@Then("^Account Id should be \"(.*)\".$")
	public void validateAccountId(String expectedUserid) {
		String ActualUserId = loginPage.getAccountId();
		if (expectedUserid.equalsIgnoreCase(ActualUserId))
			shared.scenario.log("Account Id Matched Succeessfully");
		else {
			byte[] b = shared.driver.getScreenshotAs(OutputType.BYTES);
			shared.scenario.attach(b, "image/png", "Account Id Does not Matched");
		}
	}

	@And("^hit login button$")
	public void clickOnLogin() {
		loginPage.clickOnLogin();
	}

	@When("^clear cart if items are available$")
	public void clearCart() {
		categoriesPage.clearCartIfItemsAvalibleInCart();

	}

	@And("^choose books category$")
	public void clickOnBooks() {
		categoriesPage.clickOnBooksCategory();
		;

	}

	@And("^select a book from the list displayed$")
	public void selectTheBook() {
		categoriesPage.computerAndInternet();
	}

	@And("^get the price details and enter the quantity as\"(.*)\".$")
	public void getPriceDetailsAndEnterQuantity(String quantity) {
		String priceOfOneItem = categoriesPage.getPrice();
		String[] x = priceOfOneItem.split("\\.");
		priceOfOneItem = x[0];
		categoriesPage.numberOfInputs(quantity);
		System.out.println(priceOfOneItem);
		expectedPrice = Integer.parseInt(priceOfOneItem) * Integer.parseInt(quantity);
	}

	@And("^Add items to cart and validate the Sub-Total$")
	public void addItemsToCartAndValidateTheSubTotal() {

		categoriesPage.addToCart();
		categoriesPage.shoppingCart();
		String actualPri = categoriesPage.totalPrice();
		String[] x = actualPri.split("\\.");
		int actualPrice = Integer.parseInt(x[0]);
		if (expectedPrice == actualPrice) {
			shared.scenario.log("SubTotal Test Passed Succeessfully");

		} else {
			byte[] b = shared.driver.getScreenshotAs(OutputType.BYTES);
			shared.scenario.attach(b, "image/png", "SubTotal Test Failed ");
		}

	}

	@When("^click on check out button$")
	public void checkOutButton() {
		categoriesPage.termsOfService();
		categoriesPage.checkOut();
	}

	@Then("^Address section will be displayed and select New Address$")
	public void selectAddress() {
		shippingPage.selectNewAddressFromDropDown(shippingPage.element_BillingAddress);
	}

	@And("^enter mandatory fields in Billing address and click on continue$")
	public void enterMandatoryData() {
		shippingPage.firstName("pqrst");
		shippingPage.cityName("Hyderabad");
		shippingPage.address1("Ramnagar");
		shippingPage.zipPostalCode("500020");
		shippingPage.phoneNumber("987654321");
		shippingPage.selectCountryFromDropDown(shippingPage.element_CountryID);
		shippingPage.continue1();
	}

	@Then("^select the Shipping Address as same as Billing Address and click on continue$")
	public void selectTheShippingAddressAsSameAsBillingAddress() {
		wait.until(ExpectedConditions.visibilityOf(shippingPage.elemnt_ShippingAddress));
		shippingPage.selectShippingAddressFromDropDown(shippingPage.elemnt_ShippingAddress);
		shippingPage.continue2();
	}

	@When("^choose  Next Day Air as shipping method and click on continue$")
	public void chooseNextDayAirAssSippingMethod() {
		wait.until(ExpectedConditions.visibilityOf(shippingPage.shippingMethod));
		shippingPage.ShippingMethod();
		wait.until(ExpectedConditions.visibilityOf(shippingPage.continue3));

		shippingPage.continue3();
	}

	@Then("^Payment section will be dispayed choose COD  as payment and click on continue$")
	public void selectPaymentAsCOD() {
		wait.until(ExpectedConditions.visibilityOf(shippingPage.paymentMethod));
		shippingPage.paymentMethod();
		shippingPage.continue4();
	}

	@Then("^You will pay by COD message will be displayed and click on continue$")
	public void validationOfCODMessage() {
		wait.until(ExpectedConditions.visibilityOf(shippingPage.cashOnDelivery));
		String paymentmessage = shippingPage.paymentInformation();
		shared.scenario.log(paymentmessage);
		shippingPage.continue5();

	}

	@When("^click on Confirm Order$")
	public void confirmOrder() {
		wait.until(ExpectedConditions.visibilityOf(shippingPage.confirm));
		shippingPage.confirm();

	}

	@Then("^Your order has been successfully processed message will be displayed$")
	public void confirmationMessageOfOrder() {
		wait.until(ExpectedConditions.visibilityOf(shippingPage.orderSuccessMessage));
		String successMessage = shippingPage.orderSucessMessage();
		shared.scenario.log(successMessage);

	}

	@And("^Print order number and click on continue$")
	public void printOrderNumber() {
		String orderNumber = shippingPage.orderNumberMessage();
		shared.scenario.log(orderNumber);
		wait.until(ExpectedConditions.visibilityOf(shippingPage.continue6));

		shippingPage.continue6();

	}

	@When("^click on logout button and logout successful$")
	public void clickOnLogout() {
		shippingPage.logOut();
		
	}

}
