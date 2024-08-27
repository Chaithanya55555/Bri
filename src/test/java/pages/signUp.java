package pages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class signUp {


       public WebDriver driver;

        // Selectors
       public By nameInput = By.id("formName");
       public By emailInput = By.id("formEmail");
       public By phoneInput = By.cssSelector("input[type='tel']");
       public By getOtpButton = By.xpath("//button[contains(text(),'Get Otp')]");
       public By otpInput = By.cssSelector(".otp");
       public By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");
       public By yesRadioButton = By.xpath("//input[@id='yes']");
       public By noRadioButton = By.xpath("//input[@id='no']");
       public By loginLink = By.xpath("//a[contains(text(),'Login')]");
        public signUp(WebDriver driver) {
            this.driver = driver;
        }

        public void enterName(String name) {
            driver.findElement(nameInput).sendKeys(name);
        }

        public void enterEmail(String email) {
            driver.findElement(emailInput).sendKeys(email);
        }

        public void enterPhone(String phone) {
            driver.findElement(phoneInput).sendKeys(phone);
        }

        public boolean isGetOtpButtonEnabled() {
            return driver.findElement(getOtpButton).isEnabled();
        }

        public boolean isOtpDisplay(){
            return driver.findElement(otpInput).isDisplayed();
        }
        public void clickOtpButton() {
            driver.findElement(getOtpButton).click();
        }

        public void selectYes() {
            driver.findElement(yesRadioButton).click();
        }

        public void selectNo() {
            driver.findElement(noRadioButton).click();
        }

        public boolean isSignUpButtonEnabled() {
            return driver.findElement(signUpButton).isEnabled();
        }

        public void clickLoginLink() {
            driver.findElement(loginLink).click();
        }



        public void clickSignUpButton(){
            driver.findElement(signUpButton).click();
        }


}
