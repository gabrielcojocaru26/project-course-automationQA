package pages;

import locators.ContactPageLocators;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ContactPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openContactForm() {
        wait.until(ExpectedConditions.elementToBeClickable(ContactPageLocators.CONTACT_BUTTON)).click();
    }

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactPageLocators.EMAIL_FIELD));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterName(String name) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactPageLocators.NAME_FIELD));
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterMessage(String message) {
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactPageLocators.MESSAGE_FIELD));
        messageField.clear();
        messageField.sendKeys(message);
    }

    public void sendMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(ContactPageLocators.SEND_BUTTON)).click();
    }

    public void validateAlertMessage() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Thanks for the message!!", "Mesajul alertei nu este cel așteptat!");
        alert.accept();
    }
}