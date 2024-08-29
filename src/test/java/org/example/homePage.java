package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.signUp;
import pages.home;

import java.time.Duration;

public class homePage {
    public WebDriver driver;
    public signUp signUpPage;
    public home home;
    public WebDriverWait wait;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        signUpPage = new signUp(driver);
        home = new home(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("the user at home page")
    public void navigateToHomePage(){
        driver.get("https://www.bribooks.com/login?back=account/mybooks");
        wait.until(ExpectedConditions.urlToBe("https://www.bribooks.com/login?back=account/mybooks"));
driver.manage().window().maximize();
        home.enterLogin();
        home.login();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/login?back=account/mybooks");


    }

    @When("the user click on every link on home page verify it navigated to corresponding links")
    public void verifyTheLinks() throws Exception{
        home.clickMyProfile();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/account/profile");
        home.clickMyBooks();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/account/mybooks");
        home.clickOnAccept();
        wait.until(ExpectedConditions.elementToBeClickable(home.myPurchasedBooksLink));
        home.clickMyPurchasedBooks();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/account/ebooks");
        home.clickMyOrders();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/account/myorders");
        home.clickMyEarnings();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/account/myearnings");
        home.clickMyCertificates();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/account/mycertificates?active=achievement");
        home.clickMyNotification();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/notification");
        wait.until(ExpectedConditions.elementToBeClickable(home.settingsLink));
        home.clickSettings();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/account/setting");
        wait.until(ExpectedConditions.elementToBeClickable(home.logoutLink));
        home.clickLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bribooks.com/login");
    }

    @And("Verify that the content displayed is correct and properly formatted.")
    public void verifyContentIsDisplayedOrNot(){
        home.clickMyProfile();
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@class='s-5 ms-2'])[1]")).getText(),"No author bio, click on Edit Profile to update");
        home.clickMyBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Seems like you haven’t written any book yet')]")).getText(),"Seems like you haven’t written any book yet");
        home.clickOnAccept();
        wait.until(ExpectedConditions.elementToBeClickable(home.myPurchasedBooksLink));
        home.clickMyPurchasedBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Here are your Purchased Books, tony']")).getText(),"Here are your Purchased Books, tony");
        home.clickMyOrders();
        Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Go to Book Store']")).getText(),"Go to Book Store");
        home.clickMyCertificates();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Please write, publish & promote your book to earn ')]")).getText(),"Please write, publish & promote your book to earn your Author Certificates.");
        home.clickMyNotification();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='pb-3 fs-2 fw-bolder mt-5']")).getText(),"We're here to support you throughout your writing journey and ensure that you're always equipped with the latest news and insights.");
    }

    @And("Check the website's responsiveness on different devices and screen sizes.")
    public void differentDisplays(){
        driver.manage().window().setSize(new Dimension(1024, 768));
        home.clickMyProfile();
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@class='s-5 ms-2'])[1]")).getText(),"No author bio, click on Edit Profile to update");
        home.clickMyBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Seems like you haven’t written any book yet')]")).getText(),"Seems like you haven’t written any book yet");
        home.clickOnAccept();
        wait.until(ExpectedConditions.elementToBeClickable(home.myPurchasedBooksLink));
        home.clickMyPurchasedBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Here are your Purchased Books, tony']")).getText(),"Here are your Purchased Books, tony");
        home.clickMyOrders();
        Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Go to Book Store']")).getText(),"Go to Book Store");
        home.clickMyCertificates();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Please write, publish & promote your book to earn ')]")).getText(),"Please write, publish & promote your book to earn your Author Certificates.");
        home.clickMyNotification();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='pb-3 fs-2 fw-bolder mt-5']")).getText(),"We're here to support you throughout your writing journey and ensure that you're always equipped with the latest news and insights.");
        driver.manage().window().setSize(new Dimension(1400, 800));
        home.clickMyProfile();
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@class='s-5 ms-2'])[1]")).getText(),"No author bio, click on Edit Profile to update");
        home.clickMyBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Seems like you haven’t written any book yet')]")).getText(),"Seems like you haven’t written any book yet");
        home.clickOnAccept();
        wait.until(ExpectedConditions.elementToBeClickable(home.myPurchasedBooksLink));
        home.clickMyPurchasedBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Here are your Purchased Books, tony']")).getText(),"Here are your Purchased Books, tony");
        home.clickMyOrders();
        Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Go to Book Store']")).getText(),"Go to Book Store");
        home.clickMyCertificates();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Please write, publish & promote your book to earn ')]")).getText(),"Please write, publish & promote your book to earn your Author Certificates.");
        home.clickMyNotification();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='pb-3 fs-2 fw-bolder mt-5']")).getText(),"We're here to support you throughout your writing journey and ensure that you're always equipped with the latest news and insights.");
        driver.manage().window().setSize(new Dimension(2000, 1000));
        home.clickMyProfile();
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@class='s-5 ms-2'])[1]")).getText(),"No author bio, click on Edit Profile to update");
        home.clickMyBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Seems like you haven’t written any book yet')]")).getText(),"Seems like you haven’t written any book yet");
        home.clickOnAccept();
        wait.until(ExpectedConditions.elementToBeClickable(home.myPurchasedBooksLink));
        home.clickMyPurchasedBooks();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Here are your Purchased Books, tony']")).getText(),"Here are your Purchased Books, ");
        home.clickMyOrders();
        Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Go to Book Store']")).getText(),"Go to Book Store");
        home.clickMyCertificates();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Please write, publish & promote your book to earn ')]")).getText(),"Please write, publish & promote your book to earn your Author Certificates.");
        home.clickMyNotification();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='pb-3 fs-2 fw-bolder mt-5']")).getText(),"We're here to support you throughout your writing journey and ensure that you're always equipped with the latest news and insights.");

    }

    // Sometimes few element aren't clickable and not visible
    // Below 1000 width all elements of slide bar aren't displayed

    @After
    public void tearDown(){
        driver.quit();
    }

}
