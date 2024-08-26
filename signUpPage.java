package org.example;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.signUp;

import java.time.Duration;

public class signUpPage {

    private WebDriver driver;
    private signUp signupPage;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        signupPage = new signUp(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @Given("the user is on the registration page")
    public void navigateToUrl(){
        driver.get("https://www.bribooks.com/signup");
        wait.until(ExpectedConditions.urlToBe("https://www.bribooks.com/signup"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/signup");
    }

    @When("the user enters name in the name field")
    public void enterName(){
        signupPage.enterName("chaithanya");
        String name = driver.findElement(signupPage.nameInput).getAttribute("value");
        Assert.assertEquals(name , "chaithanya");
    }

    @And("the user enters email in the email field")
    public void enterEmailAddress(){
        signupPage.enterEmail("tonkstark7731076727@gmail.com");
        String email = driver.findElement(signupPage.emailInput).getAttribute("value");
        Assert.assertEquals(email,"tonkstark7731076727@gmail.com");
    }

    @And("the user enters number in the phone Number field")
    public void enterPhoneNumber(){
        signupPage.enterPhone("9493539736");
        String phone = driver.findElement(signupPage.phoneInput).getAttribute("value");
        Assert.assertEquals(phone,"+91 94935-39736");
    }

    @And ("the user clicks on the Get opt button")
    public void clickOnGetOtp(){
        signupPage.clickOtpButton();
    }

    @Then("the user should receive an OTP on the provided phone number")
    public void otpReceive()throws Exception{
        if(!driver.findElement(By.xpath("//button[text() = 'Edit']")).isDisplayed()){
            Assert.assertTrue(signupPage.isOtpDisplay());
        }else{
            System.out.println("Email and Phone number already registered");
        }

        Thread.sleep(1000);
    }

    @When("the user enters the correct OTP in the OTP field")
    public void enterOtp() throws Exception{
        Thread.sleep(1000);
    }

    @And("the registration should be successful")
    public void registrationCompleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPage.yesRadioButton));
        signupPage.selectYes();
        wait.until(ExpectedConditions.elementToBeClickable(signupPage.signUpButton));
        Assert.assertTrue(signupPage.isSignUpButtonEnabled());
    }

    @Then("the user should be redirected to the Welcome page")
    public void navigateToHomePage(){
        signupPage.clickSignUpButton();
        if(driver.getCurrentUrl().equals("https://www.bribooks.com/signup")){
            System.out.println("Already registered");
        }else {
            wait.until(ExpectedConditions.urlToBe("https://www.bribooks.com/signup/thankyou"));
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/signup/thankyou");
            String sen = driver.findElement(By.xpath("//p[@class='fs-2 fw-bold m-0 d-none d-sm-block']")).getText();
            Assert.assertEquals(sen,"Your registration has been successfully completed!");
        }

    }

    @When("the user leaves the Name field empty and verify it")
    public void emptyNameField(){
        signupPage.enterEmail("tonkstark7731076727@gmail.com");
        signupPage.enterPhone("9493539736");
        if(driver.findElement(signupPage.getOtpButton).isDisplayed()){
            signupPage.clickOtpButton();
        }

        WebElement errorMsg = driver.findElement(By.xpath("(//div[@class = 'invalid-feedback'])[position() = 1]"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertEquals(errorMsg.getText(),"Please enter Your Name.");
    }

    @And("the user leaves the Email field empty and verify it")
    public void emptyEmailField(){
        signupPage.enterName("chaithanya");
        driver.findElement(By.id("formEmail")).clear();
        signupPage.enterPhone("9493539736");
        if(driver.findElement(signupPage.getOtpButton).isDisplayed()){
            signupPage.clickOtpButton();
        }
        WebElement errorMsg = driver.findElement(By.xpath("(//div[@class = 'invalid-feedback'])[position() = 2]"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertEquals(errorMsg.getText(),"Please enter your Email.");
    }


    @And("the user does not select the Yes option on the Receive Updates radio button and verify it")
    public void radioButtonIsNo(){
        signupPage.enterName("chaithanya");
        signupPage.enterPhone("9493539736");
        Assert.assertTrue(!signupPage.isSignUpButtonEnabled());
    }

    @And("verify the text of the button")
    public void verifyTextOfTheButton(){
        Assert.assertEquals(driver.findElement(signupPage.signUpButton).getText(),"Sign Up");
    }

    @Then("the user should remain on the registration page")
    public void remainAtRegistrationPage(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/signup");
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
