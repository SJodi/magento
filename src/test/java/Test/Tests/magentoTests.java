package Test.Tests;

import Test.Steps.magentoSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class magentoTests {

    @Steps
    magentoSteps    magentoSteps;


    @Given("user on login page")
    public void user_on_login_page() {
        magentoSteps.user_on_login_page();
    }

    @When("user fill login fields email {string} password {string}")
    public void user_fill_login_fields_email_password(String email, String password) {
        magentoSteps.user_fill_login_fields(email, password);
        magentoSteps.click_button_sign_in();
    }

    @Then("user successfully login")
    public void user_successfully_login() {
        magentoSteps.user_successfully_login();
    }

    @Given("user on listing product page")
    public void user_on_listing_product_page() {
        magentoSteps.user_on_login_page();
        magentoSteps.user_fill_login_fields("setiawandodi17@gmail.com", "Password!");
        magentoSteps.click_button_sign_in();
    }
    @When("user add {int} jackets into cart")
    public void user_add_jackets_into_cart(Integer numOfJackets) {
        magentoSteps.go_to_jacket_listing_page();
        magentoSteps.add_jackets_into_cart(numOfJackets);
    }

    @When("user processed checkout")
    public void user_processed_checkout() {
        magentoSteps.user_processed_checkout();
    }
    @When("user fill out address")
    public void user_fill_out_address() {
        magentoSteps.user_fill_out_address();
    }
    @When("user placed order")
    public void user_placed_order() {
        magentoSteps.user_placed_order();
    }
    @Then("order should be successfully created")
    public void order_should_be_successfully_created() {
        magentoSteps.order_should_be_successfully_created();
    }
}
