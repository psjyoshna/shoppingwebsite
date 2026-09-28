package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By popup=By.xpath("(//button[@type='button'])[1]");
    private final By addToCartBtn = By.xpath("(//button[@data-slot='button'])[2]");
    private final By cartIcon = By.xpath("//a[@href='/cart']");
    private final By CouponInput=By.xpath("//input[@id='coupon']");
    private final By apply=By.xpath("(//button[@type='submit'])[2]");
    private final By checkoutBtn = By.xpath("//a[contains(@href, 'checkout')] | //button[contains(normalize-space(), 'Checkout')]");
    private final By fullNameInput = By.xpath("//input[@id='name']");
    private final By emailInput = By.xpath("//input[@id='email']");
    private final By addressInput = By.xpath("//input[@id='street']");
    private final By cityInput = By.xpath("//input[@id='city']");
    private final By postalCodeInput = By.xpath("//input[@id='pin']");
    private final By continueToPaymentBtn = By.xpath("//html/body/main/section/div[2]/div/form/button");
    private final By paylater = By.xpath("//input[@value='pay-later']");
    private final By mobileNumberInput = By.xpath("//input[@id='mobile']");
    private final By reviewOrderBtn = By.xpath("(//button[@type='submit'])[2]");
    private final By confirmOrderBtn = By.xpath("(//button[@type='button'])[2]");
    private final By buttonduplicate = By.xpath("(//button[@id='button'])[2]");
    private final By confirmationBanner = By.xpath("//h1[text() ='Thanks for shopping.']");
    public CheckoutPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void popup(){
        wait.until(ExpectedConditions.elementToBeClickable(popup)).click();

    }
    public void addProductToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
    public void cartIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
    public void couponApplies(String couponCode){


        wait.until(ExpectedConditions.visibilityOfElementLocated(CouponInput)).sendKeys(couponCode);

    }
    public void apply(){

        wait.until(ExpectedConditions.elementToBeClickable(apply)).click();
    }


    public void clickCheckout() {

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();


    }

    public void details(String name,String email,String street,String city,String postalCode) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameInput)).sendKeys(name);
            driver.findElement(emailInput).sendKeys(email);
            driver.findElement(addressInput).sendKeys(street);
            driver.findElement(cityInput).sendKeys(city);
            driver.findElement(postalCodeInput).sendKeys(postalCode);
    }

    public void proceedToPaymentSection() {
            wait.until(ExpectedConditions.elementToBeClickable(continueToPaymentBtn)).click();
    }

    public void selectPaymentMethod(String provider) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//input[@value='pay-later']", provider, provider)))).click();
    }

    public void selectPayLaterWithMobile(String mobileNumber) {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(paylater));
        try {
            option.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }

        WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberInput));
        mobileField.clear();
        mobileField.sendKeys(mobileNumber);
    }


    public void reviewAndConfirmOrder() {
            wait.until(ExpectedConditions.elementToBeClickable(reviewOrderBtn)).click();
            wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();
    }

    public String getConfirmationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationBanner)).getText();
    }


}