package locators;

import org.openqa.selenium.By;

public class CartPageLocators {
    public static final By monitorsCategory = By.xpath("//a[@id='itemc' and contains(text(),'Monitors')]");
    public static final By appleMonitor24 = By.xpath("//a[contains(text(),'Apple monitor 24')]");
    public static final By addToCartButton = By.xpath("//a[contains(@onclick, 'addToCart') and contains(text(),'Add to cart')]");
    public static final By laptopsCategory = By.xpath("//a[@id='itemc' and contains(text(),'Laptops')]");
    public static final By macBookPro = By.xpath("//a[@href='prod.html?idp_=15']");
    public static final By cartButton = By.xpath("//a[@id='cartur']"); // Păstrată varianta originală
    public static final By phonesCategory = By.xpath("//a[@id='itemc' and contains(text(),'Phones')]");
    public static final By nexus6 = By.xpath("//a[contains(text(),'Nexus 6')]");
    public static final By iphone6_32GB = By.xpath("//a[@href='prod.html?idp_=5' and contains(text(),'Iphone 6 32gb')]");
    public static final By placeOrderButton = By.xpath("//button[contains(@data-target,'#orderModal')]");
    public static final By nameField = By.id("name");
    public static final By countryField = By.id("country");
    public static final By cityField = By.id("city");
    public static final By cardField = By.id("card");
    public static final By monthField = By.id("month");
    public static final By yearField = By.id("year");
    public static final By purchaseButton = By.xpath("//button[contains(@onclick,'purchaseOrder()')]");
    public static final By confirmationMessage = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
}