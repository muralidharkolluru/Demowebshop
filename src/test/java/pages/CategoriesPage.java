package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
	public RemoteWebDriver driver;
	@FindBy(how = How.XPATH, using = "(//*[text()='Shopping cart'])[1]")
	public WebElement clickOnShopping;

	@FindBy(how = How.XPATH, using = "//span[@class='cart-qty']")
	public WebElement getCartQuantity;

	@FindBy(how = How.XPATH, using = "(//*[@type='checkbox'])[1]")
	public WebElement clickOnCheckBox;

	@FindBy(how = How.XPATH, using = "//*[@name='updatecart']")
	public WebElement updteCart;

	@FindBy(how = How.XPATH, using = "(//*[@href='/books'])[1]")
	public WebElement books;

	@FindBy(how = How.XPATH, using = "(//*[@href='/computing-and-internet'])[1]")
	public WebElement computingAndInternet;

	@FindBy(how = How.XPATH, using = "//*[@itemprop='price']")
	public WebElement price;

	@FindBy(how = How.XPATH, using = "(//*[@type='text'])[3]")
	public WebElement noOfInputs;

	@FindBy(how = How.XPATH, using = "(//*[@value='Add to cart'])[1]")
	public WebElement addToCart;

	@FindBy(how = How.XPATH, using = "(//*[@class='cart-label'])[1]")
	public WebElement shippingCart;

	@FindBy(how = How.XPATH, using = "(//*[@class='product-price'])[1]")
	public WebElement totalPrice;

	@FindBy(how = How.XPATH, using = "//*[@id='termsofservice']")
	public WebElement temsAndConditions;

	@FindBy(how = How.XPATH, using = "//*[@id='checkout']")
	public WebElement checkOut;

	public CategoriesPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clearCartIfItemsAvalibleInCart() {
		clickOnShopping.click();
		String x = getCartQuantity.getText();
		String a = x.replaceAll("[^0-9]", "");
		System.out.println(a);
		int b = Integer.parseInt(a);
		if (b != 0) {
			clickOnCheckBox.click();
			updteCart.click();
		}

	}

	public void clickOnBooksCategory() {
		books.click();
	}

	public void computerAndInternet() {
		computingAndInternet.click();
	}

	public String getPrice() {
		String x = price.getText();
		return (x);
	}

	public void numberOfInputs(String x) {
		noOfInputs.clear();
		noOfInputs.sendKeys(x);

	}

	public void addToCart() {
		addToCart.click();

	}

	public void shoppingCart() {
		shippingCart.click();
	}

	public String totalPrice() {
		String x = totalPrice.getText();
		return (x);
	}

	public void termsOfService() {
		temsAndConditions.click();
	}

	public void checkOut() {
		checkOut.click();
	}

}
