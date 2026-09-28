package steps;

import io.cucumber.java.en.*;
import locators.CheckoutPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;


public class CheckoutSteps {
    private WebDriver driver;
    private CheckoutPage checkoutPage;

    @Given("the user is on the product detail page for {string}")
    public void the_user_is_on_the_product_detail_page_for(String product) {
        driver = new EdgeDriver();

        driver.get("https://everyday-shop-anirudh.cidirianirudh.chatgpt.site/products");
        checkoutPage = new CheckoutPage(driver);
    }
    @When("user clears popup")
    public void clears_popup(){
        checkoutPage.popup();

    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {

        checkoutPage.addProductToCart();
    }



    @When("the user clicks on cart Icon")
    public void the_user_clicks_on_checkout_button() {

        checkoutPage.cartIcon();
    }
    @When("the user applies coupon {string}")
    public void coupon_applies(String couponCode){

        checkoutPage.couponApplies(couponCode);

    }
    @When("user click on apply")
    public void click_apply(){
        checkoutPage.apply();
    }
    @When("the user click on checkout")
    public void checkout(){
        checkoutPage.clickCheckout();
    }

    @When("the user fills in shipping details with name  {string},email  {string},address {string}, city {string} and postal code {string}")
    public void Filling_details(String name, String email, String address, String city, String postalCode) {
        checkoutPage.details(name,email,address,city,postalCode);
    }
    @When("the user continues to payment")
    public void the_user_continues_to_payment() {

        checkoutPage.proceedToPaymentSection();
    }

    @When("the user selects payment method {string}")
    public void the_user_selects_payment_method(String provider) {
       if(provider.contains("paylater")) {
           checkoutPage.selectPaymentMethod(provider);
       }
    }

    @When("the user selects pay later with mobile number {string}")
    public void the_user_selects_pay_later_with_mobile_number(String number) {
        checkoutPage.selectPayLaterWithMobile(number);
    }

    @When("the user reviews and confirms the order")
    public void the_user_reviews_and_confirms_the_order() {

        checkoutPage.reviewAndConfirmOrder();
    }

    @Then("an order confirmation message {string} should be displayed")
    public void an_order_confirmation_message_should_be_displayed(String expectedMsg) {
        String actualMsg = checkoutPage.getConfirmationText();
        System.out.println("expectedmsg"+expectedMsg+"actual"+actualMsg);

        org.testng.Assert.assertEquals(expectedMsg, actualMsg);

        driver.quit();
    }



}