package Test.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class magentoPages extends PageObject {

    @FindBy(xpath = "//div[@class='panel header']//a[contains(.,'Sign In')]")
    WebElement loginHeader;
    public void clickButtonLogin(){
        element(loginHeader).click();
    }

    @FindBy(id = "email") WebElement emailField;
    @FindBy(id = "pass") WebElement passwordField;
    public void inputEmail(String email){
        element(emailField).sendKeys(email);
    }
    public void inputPassword(String password){
        element(passwordField).sendKeys(password);
    }

    @FindBy(id = "send2") WebElement buttonSignIn;
    public void clickButtonSignIn(){
        element(buttonSignIn).click();
    }

    @FindBy(xpath = "//div[@class='panel header']//button[@class='action switch']") WebElement dropdownProfileMenu;
    @FindBy(xpath = "//li[@class='customer-welcome active']//a[.='My Account']") WebElement myAccountDropDown;
    @FindBy(css = ".box-information") WebElement emailInfo;
    public void verifyUserPage(){
        element(dropdownProfileMenu).waitUntilVisible();
        element(dropdownProfileMenu).click();
        element(myAccountDropDown).click();
        element(emailInfo).shouldBeVisible();
    }

    @FindBy(id = "ui-id-5") WebElement menMenu;
    @FindBy(id = "ui-id-17") WebElement topsMenu;
    @FindBy(id = "ui-id-19") WebElement jacketsMenu;
    @FindBy(id = "mode-list") WebElement listDisplay;
    @FindBy(xpath = "//div[.='XS']") WebElement jacketSize;
    public void goToJacketListingPage(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(menMenu).perform();
        actions.moveToElement(topsMenu).perform();
        element(jacketsMenu).click();
        element(listDisplay).click();
        element(jacketSize).waitUntilVisible();
    }

    @FindBy(xpath = " //div[@class='minicart-wrapper']//span[@class='counter qty']") WebElement cartCounter;
    public void addJacketsIntoCart(Integer   numOfJackets){
        List<WebElement> sizeElements = getDriver().findElements(By.xpath("//div[.='XS']"));
        List<WebElement> buttonElements = getDriver().findElements(By.xpath("//ol[@class='products list items product-items']/li//button[@class='action tocart primary']"));
        List<WebElement> colorElements = getDriver().findElements(By.xpath("//div[@class='swatch-attribute color']/div[@class='swatch-attribute-options clearfix']/div[1]"));
        for (int i = 0; i < numOfJackets && i < sizeElements.size() && i < buttonElements.size() && i < colorElements.size(); i++){
            sizeElements.get(i).click();
            colorElements.get(i).click();
            buttonElements.get(i).click();

            try {
                Thread.sleep(1000); // Add one-second wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        element(cartCounter).waitUntilVisible();
    }

    public String[] getProductName(int count){
        String[] reference = new String[count];
        List<WebElement> elements = getDriver().findElements(By.xpath("//strong[@class='product name product-item-name']"));
        for (int i = 0 ; i < count; i++){
            reference[i] = elements.get(i).getText();
        }
        return  reference;
    }

    public String[] getProductPrize(int count){
        String[] reference = new String[count];
        List<WebElement> elements = getDriver().findElements(By.xpath("//ol[@class='products list items product-items']//span[@class='price-wrapper ']/span[@class='price']"));
        for (int i = 0 ; i < count; i++){
            reference[i] = elements.get(i).getText();
        }
        return  reference;
    }

    public void validateProductName(List<String> product, List<String> price) {
        List<WebElement> productElements = getDriver().findElements(By.xpath("//table[@id='shopping-cart-table']//strong[@class='product-item-name']"));
        List<WebElement> priceElements = getDriver().findElements(By.xpath("//table[@id='shopping-cart-table']//td[@class='col subtotal']//span[@class='price']"));

        if (product.size() != price.size()) {
            throw new IllegalArgumentException("Product and price lists should have the same length");
        }

        for (int i = 0; i < product.size(); i++) {
            String actualProductName = productElements.get(i).getText();
            String expectedProductName = product.get(i);

            if (!actualProductName.equals(expectedProductName)) {
                throw new AssertionError("Product name does not match at index " + i + ". Expected: " + expectedProductName + ", Actual: " + actualProductName);
            }

            String actualPrice = priceElements.get(i).getText();
            String expectedPrice = price.get(i);

            if (!actualPrice.equals(expectedPrice)) {
                throw new AssertionError("Price does not match at index " + i + ". Expected: " + expectedPrice + ", Actual: " + actualPrice);
            }
        }
    }

    @FindBy(xpath = "//div[@class='minicart-wrapper']/a[@href='https://magento.softwaretestingboard.com/checkout/cart/']") WebElement cartMenu;
    @FindBy(xpath = "//a[contains(.,'View and Edit Cart')]") WebElement viewCart;
    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody//a[contains(.,'Remove item')]") WebElement deleteButton;
    public void goToCart(){
        element(cartMenu).waitUntilVisible();
        element(cartMenu).click();
        element(viewCart).click();
        element(deleteButton).waitUntilVisible();

    }

    @FindBy(xpath = "//ul[@class='checkout methods items checkout-methods-items']//button[@class='action primary checkout']") WebElement buttonCheckout;
    public void clickButtonProceedOrder(){
        element(buttonCheckout).waitUntilVisible();
        element(buttonCheckout).click();
    }


    @FindBy(xpath = "//button[@class='action action-show-popup']") WebElement buttonCreateNewAddress;
    public void clickButtonCreateNewAddress(){
        element(buttonCreateNewAddress).waitUntilVisible();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", buttonCreateNewAddress);
    }
    @FindBy(xpath = "//input[@name='firstname']") WebElement firstNameField;
    @FindBy(xpath = "//input[@name='lastname']") WebElement lastNameField;
    @FindBy(xpath = "//input[@name='company']") WebElement companyField;
    @FindBy(xpath = "//fieldset[@class='field street admin__control-fields required']//div[@class='field _required']//input[@class='input-text']") WebElement streetAddressField;
    @FindBy(xpath = "//fieldset[@class='field street admin__control-fields required']//div[2]//input[@class='input-text']") WebElement streetAddress2Field;
    @FindBy(xpath = "//fieldset[@class='field street admin__control-fields required']//div[3]//input[@class='input-text']") WebElement streetAddress3Field;
    @FindBy(xpath = "//input[@name='city']") WebElement cityField;
    @FindBy(xpath = "//input[@name='region']") WebElement stateField;
    @FindBy(xpath = "//input[@name='postcode']") WebElement zipCodeField;
    @FindBy(xpath = "//select[@name='country_id']") WebElement countryField;
    @FindBy(xpath = "//input[@name='telephone']") WebElement phoneNumberField;
    @FindBy(xpath = "//input[@class='radio']") WebElement selectShippingMethod;
    @FindBy(xpath = "//input[@id='shipping-save-in-address-book']") WebElement saveAddressCheckBox;

    public void fillAddress(String country, String firstName, String lastName, String company, String street1, String street2, String street3, String city, String state, String zipCode, String phoneNumber){
        element(countryField).waitUntilVisible();
        element(countryField).selectByVisibleText(country);
        element(firstNameField).clear();
        element(firstNameField).sendKeys(firstName);
        element(lastNameField).clear();
        element(lastNameField).sendKeys(lastName);
        element(companyField).sendKeys(company);
        element(streetAddressField).sendKeys(street1);
        element(streetAddress2Field).sendKeys(street2);
        element(streetAddress3Field).sendKeys(street3);
        element(cityField).sendKeys(city);
        element(stateField).sendKeys(state);
        element(zipCodeField).sendKeys(zipCode);
        element(phoneNumberField).sendKeys(phoneNumber);
        element(saveAddressCheckBox).click();
    }

    @FindBy(xpath = "//button[@class='button action continue primary']") WebElement buttonNext;
    @FindBy(xpath = "//li[@id='opc-shipping_method']/div[@class='loading-mask']") WebElement loadingMask;
    @FindBy(xpath = "//img[@alt='Loading...']") WebElement loadingImage;
    public void clickButtonNext(){
        element(loadingMask).waitUntilNotVisible();
        element(loadingImage).waitUntilNotVisible();
        getDriver(). manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        element(buttonNext).waitUntilVisible();
        element(buttonNext).click();
    }

    @FindBy(xpath = "//button[@class='action primary action-save-address']") WebElement buttonShipHere;
    public void clickButtonShipHere() {
        element(buttonShipHere).waitUntilVisible();
        element(buttonShipHere).click();
    }

    @FindBy(xpath = "//button[@class='action primary checkout']") WebElement buttonPlaceOrder;
//    @FindBy(xpath = ".loading-mask") WebElement loadingIcon;
    public void clickButtonPlaceOrder(){
        element(loadingMask).waitUntilNotVisible();
        element(loadingImage).waitUntilNotVisible();
        element(buttonPlaceOrder).waitUntilPresent();
        element(buttonPlaceOrder).click();
    }

    public String getSingleProductName() {
        WebElement element = getDriver().findElement(By.xpath("//a[strong]"));
        return element.getText();
    }

    @FindBy(xpath = "//a[.='My Orders']") WebElement    myOrdersMenu;
    public void goToMyOrder(){
        element(dropdownProfileMenu).click();
        element(myAccountDropDown).click();
        element(myOrdersMenu).waitUntilVisible();
        element(myOrdersMenu).click();
    }

    public void clickFirstMatchingViewOrderLink(String singleProductName) {
        List<WebElement> elements = getDriver().findElements(By.cssSelector("tbody > tr > .id"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.getText().equals(singleProductName)) {
                List<WebElement> viewOrderLinks = getDriver().findElements(By.xpath("//a['a']/span[.='View Order']"));
                if (viewOrderLinks.size() > i) {
                    viewOrderLinks.get(i).click();
                    return;
                } else {
                    throw new NoSuchElementException("No matching View Order link found for product " + singleProductName);
                }
            }
        }
        throw new NoSuchElementException("No matching product found with name " + singleProductName);
    }

    public void validateOrderDetail(List<String> expectedProducts, List<String> expectedPrices) {

        if(expectedProducts.size() != expectedPrices.size()) {
            throw new IllegalArgumentException("Expected products and prices lists must be the same length");
        }

        List<WebElement> productElements = getDriver().findElements(By.cssSelector("tbody .product"));
        List<WebElement> priceElements = getDriver().findElements(By.xpath("//tbody//td[@class='col price']//span[@class='price']"));

        for(int i = 0; i < expectedProducts.size(); i++) {

            String actualProduct = productElements.get(i).getText();
            String expectedProduct = expectedProducts.get(i);
            assertEquals(expectedProduct, actualProduct, "Product name does not match at index " + i);

            String actualPrice = priceElements.get(i).getText();
            String expectedPrice = expectedPrices.get(i);
            assertEquals(expectedPrice, actualPrice, "Price does not match at index " + i);

        }

    }

    // Helper assert equals method
    private void assertEquals(String expected, String actual, String errorMessage){
        if(!expected.equals(actual)) {
            throw new AssertionError(errorMessage);
        }
    }
}
