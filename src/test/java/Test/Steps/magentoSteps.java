package Test.Steps;

import Test.Pages.magentoPages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class magentoSteps {

    magentoPages    magentoPages;

    public void user_on_login_page(){
        magentoPages.open();
        magentoPages.clickButtonLogin();
    }

    public void user_fill_login_fields(String email, String password){
        magentoPages.inputEmail(email);
        magentoPages.inputPassword(password);
    }

    public void click_button_sign_in(){
        magentoPages.clickButtonSignIn();
    }

    public void user_successfully_login(){
        magentoPages.verifyUserPage();
    }

    public void go_to_jacket_listing_page(){
        magentoPages.goToJacketListingPage();
    }

    private final List<String> productNames;
    private final List<String> productPrices;

    public magentoSteps() {
        productNames = new ArrayList<>();
        productPrices = new ArrayList<>();
    }
    public void add_jackets_into_cart(Integer   numOfJackets){
        List<String> jacketProductNames = Arrays.asList(magentoPages.getProductName(numOfJackets));
        List<String> jacketProductPrices = Arrays.asList(magentoPages.getProductPrize(numOfJackets));
        productNames.addAll(jacketProductNames);
        productPrices.addAll(jacketProductPrices);
        magentoPages.addJacketsIntoCart(numOfJackets);

    }

    public void user_processed_checkout(){
        magentoPages.goToCart();
        magentoPages.validateProductName(productNames, productPrices);
        magentoPages.clickButtonProceedOrder();
    }

    public void user_fill_out_address(){
        magentoPages.clickButtonCreateNewAddress();
        magentoPages.fillAddress("Indonesia", "Setiawan", "Jodi", "Magento", "Jl. Joglo Raya", "Joglo","Kembangan","Jakarta barat","Jakarta","11640","081270709098");
    }

    public void user_placed_order(){
        magentoPages.clickButtonShipHere();
        magentoPages.clickButtonNext();
        magentoPages.clickButtonPlaceOrder();
    }

    private String singleProductName;
    public void order_should_be_successfully_created(){
        singleProductName = magentoPages.getSingleProductName();
        magentoPages.goToMyOrder();
        magentoPages.clickFirstMatchingViewOrderLink(singleProductName);
        magentoPages.validateOrderDetail(productNames,productPrices);
    }
}
