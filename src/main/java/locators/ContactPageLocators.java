package locators;

import org.openqa.selenium.By;

public class ContactPageLocators {
    public static final By CONTACT_BUTTON = By.xpath("//a[@class='nav-link' and @data-toggle='modal' and @data-target='#exampleModal']");
    public static final By EMAIL_FIELD = By.id("recipient-email");
    public static final By NAME_FIELD = By.id("recipient-name");
    public static final By MESSAGE_FIELD = By.id("message-text");
    public static final By SEND_BUTTON = By.xpath("//button[@class='btn btn-primary' and text()='Send message']");
}