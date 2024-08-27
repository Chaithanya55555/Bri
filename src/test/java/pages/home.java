package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class home {
    public WebDriver driver;

    public home(WebDriver driver) {
        this.driver = driver;
    }
    public By userNameButton = By.xpath("//button[text() = 'Username']");
    public By userName = By.cssSelector("input[name = 'username']");
    public By password = By.cssSelector("input[name = 'password']");
    public By loginButton = By.xpath("//button[text() = 'Login']");
    public By myProfileLink = By.linkText("My Profile");
    public By acceptButton = By.xpath("//button[text() = 'Accept']");
    public By myBooksLink = By.linkText("My Books");
    public By myPurchasedBooksLink = By.linkText("My Purchased Books");
    public By myOrdersLink = By.linkText("My Orders");
    public By myEarningsLink = By.linkText("My Earnings");
    public By myCertificatesLink = By.linkText("My Certificates");
    public By myNotificationLink = By.linkText("My Notification");
    public By settingsLink = By.xpath("//a[text() ='Setting']");
    public By logoutLink = By.xpath("//span[text() = 'Logout']");

    public void enterLogin(){
        driver.findElement(userNameButton).click();
    }

    public void enterName(String name){
        driver.findElement(userName).sendKeys(name);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void login(){
        enterName("tony8562");
        enterPassword("66caba8ed70b3");
        clickOnLoginButton();
    }

    public void clickOnAccept(){
        driver.findElement(acceptButton).click();
    }

    public void clickOnUsername(){
        driver.findElement(userNameButton).click();
    }
    public void clickMyProfile() {
        driver.findElement(myProfileLink).click();
    }

    public void clickMyBooks() {
        driver.findElement(myBooksLink).click();
    }

    public void clickMyPurchasedBooks() {
        driver.findElement(myPurchasedBooksLink).click();
    }

    public void clickMyOrders() {
        driver.findElement(myOrdersLink).click();
    }

    public void clickMyEarnings() {
        driver.findElement(myEarningsLink).click();
    }

    public void clickMyCertificates() {
        driver.findElement(myCertificatesLink).click();
    }

    public void clickMyNotification() {
        driver.findElement(myNotificationLink).click();
    }

    public void clickSettings() {
        driver.findElement(settingsLink).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

}
