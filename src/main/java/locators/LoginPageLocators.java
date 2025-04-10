package locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By loginButton = By.xpath("//a[@id='login2']");
    public static final By usernameField = By.xpath("//input[@id='loginusername']");
    public static final By passwordField = By.xpath("//input[@id='loginpassword']");
    public static final By submitButton = By.xpath("//button[contains(text(),'Log in')]");
    public static final By loggedInUser = By.xpath("//a[@id='nameofuser']");
}