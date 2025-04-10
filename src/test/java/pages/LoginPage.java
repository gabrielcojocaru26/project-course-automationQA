package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import locators.LoginPageLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.loginButton)).click();
    }

    public void enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(LoginPageLocators.submitButton).click();
    }

    public void isLoginSuccessful(String expectedUsername) {
        WebElement loggedInElement = wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.loggedInUser));
        Assert.assertTrue(loggedInElement.getText().contains(expectedUsername), "Login-ul nu a functionat corect!");
    }

    public void login(String username, String password) {
        clickLoginButton();
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
    }

    public void logout() {
        clickLogoutButton();
        waitForLogoutToComplete();
    }

    private void clickLogoutButton() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
        logoutButton.click();
    }

    private void waitForLogoutToComplete() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginFailsWithMessage(String message) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(message), "Mesajul de eroare nu este corect!");
    }
}
