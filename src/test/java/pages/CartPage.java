package pages;

import locators.CartPageLocators;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static locators.CartPageLocators.appleMonitor24;
import static locators.CartPageLocators.macBookPro;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickMonitorsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.monitorsCategory)).click();
    }

    public void selectAppleMonitor24() {
        wait.until(ExpectedConditions.elementToBeClickable(appleMonitor24)).click();
    }

    public void clickLaptopsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.laptopsCategory)).click();
    }

    public void selectMacBookPro() {
        wait.until(ExpectedConditions.elementToBeClickable(macBookPro)).click();
    }

    public void clickPhonesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.phonesCategory)).click();
    }

    public void selectNexus6() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.nexus6)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.addToCartButton)).click();
    }

    public void validateProductAdded() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains("Product added"), "Mesajul de confirmare nu este corect!");
        alert.accept();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.cartButton)).click();
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.placeOrderButton)).click();
    }

    public void fillOrderDetails(String name, String country, String city, String card, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.countryField)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.cityField)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.cardField)).sendKeys(card);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.monthField)).sendKeys(month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.yearField)).sendKeys(year);
    }

    public void confirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(CartPageLocators.purchaseButton)).click();
    }

    public void validatePurchase() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.confirmationMessage));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Confirmarea achizitiei nu a aparut!");
    }

    public void validateProductsInCart(String... productNames) {
        for (String productName : productNames) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + productName + "')]")));
            List<WebElement> productElements = driver.findElements(By.xpath("//td[contains(text(), '" + productName + "')]"));
            Assert.assertFalse(productElements.isEmpty(), "Produsul " + productName + " NU este în coș!");
        }
    }

    public void validateProductsInCartAfterLogout() throws InterruptedException {
        System.out.println("Navigăm la coșul de cumpărături după logout");

        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        cartButton.click();
        Thread.sleep(2000);

        WebElement cartTableBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tbodyid")));
        List<WebElement> cartRows = cartTableBody.findElements(By.tagName("tr"));

        Assert.assertTrue(cartRows.isEmpty(), "Eroare: Coșul NU este gol după logout!");
    }

    public void deleteProductFromCart() {
        driver.findElement(By.xpath("(//a[contains(text(),'Delete')])[1]")).click();

    }

    public void removeAllProductsFromCart() {
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[text()='Delete']"));

        while (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
            wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0)));
            deleteButtons = driver.findElements(By.xpath("//a[text()='Delete']"));
        }
    }

    public boolean isCartEmpty() {
        List<WebElement> productsInCart = driver.findElements(By.xpath("//tbody/tr"));
        return productsInCart.isEmpty();
    }

    public int getProductCountInCart() {
        List<WebElement> productsInCart = driver.findElements(By.xpath("//tbody/tr"));
        return productsInCart.size();
    }
}