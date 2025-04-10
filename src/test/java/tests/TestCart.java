package tests;

import baseTest.BaseTest;
import locators.CartPageLocators;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;


public class TestCart extends BaseTest {

    @Test
    public void testAddProductToCart() throws InterruptedException {
        CartPage cartPage = new CartPage(driver, wait);
        driver.get("https://www.demoblaze.com/index.html");

        System.out.println("Navigam la categoria Monitors");
        cartPage.clickMonitorsCategory();
        Thread.sleep(2000);

        System.out.println("Selectam produsul Apple monitor 24");
        cartPage.selectAppleMonitor24();
        Thread.sleep(2000);

        System.out.println("Adaugam produsul in cos");
        cartPage.addToCart();
        Thread.sleep(2000);

        System.out.println("Validam mesajul de confirmare");
        cartPage.validateProductAdded();
    }

    @Test
    public void testAddMultipleProductsToCart() throws InterruptedException {
        CartPage cartPage = new CartPage(driver, wait);
        driver.get("https://www.demoblaze.com/index.html");

        System.out.println("Navigam la categoria Monitors");
        cartPage.clickMonitorsCategory();
        Thread.sleep(2000);

        System.out.println("Selectam produsul Apple monitor 24");
        cartPage.selectAppleMonitor24();
        Thread.sleep(2000);

        System.out.println("Adaugam produsul in cos");
        cartPage.addToCart();
        Thread.sleep(2000);

        System.out.println("Validam mesajul de confirmare");
        cartPage.validateProductAdded();
        Thread.sleep(2000);

        System.out.println("Ne intoarcem la pagina principala");
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

        System.out.println("Navigam la categoria Laptops");
        cartPage.clickLaptopsCategory();
        Thread.sleep(2000);

        System.out.println("Selectam produsul MacBook Pro");
        cartPage.selectMacBookPro();
        Thread.sleep(2000);

        System.out.println("Adaugam produsul in cos");
        cartPage.addToCart();
        Thread.sleep(2000);

        System.out.println("Validam mesajul de confirmare");
        cartPage.validateProductAdded();
        Thread.sleep(2000);

        System.out.println("Navigam la cosul de cumparaturi");
        cartPage.goToCart();
        Thread.sleep(2000);

        System.out.println("Validam ca ambele produse sunt in cos");
        cartPage.validateProductsInCart("Apple monitor 24", "MacBook Pro");

    }

    @Test
    public void testPlaceOrder() throws InterruptedException {
        CartPage cartPage = new CartPage(driver, wait);
        driver.get("https://www.demoblaze.com/index.html");

        System.out.println("Navigam la categoria Phones");
        cartPage.clickPhonesCategory();
        Thread.sleep(2000);

        System.out.println("Selectam produsul Nexus 6");
        cartPage.selectNexus6();
        Thread.sleep(2000);

        System.out.println("Adaugam produsul in cos");
        cartPage.addToCart();
        Thread.sleep(2000);

        System.out.println("Validam mesajul de confirmare");
        cartPage.validateProductAdded();
        Thread.sleep(2000);

        System.out.println("Navigam la cosul de cumparaturi");
        cartPage.goToCart();
        Thread.sleep(2000);

        System.out.println("Plasam comanda");
        cartPage.placeOrder();
        Thread.sleep(2000);

        System.out.println("Completam detaliile de plata");
        cartPage.fillOrderDetails("Gabriel Cojocaru", "Romania", "Bucuresti", "2222333344445555", "10", "2025");
        Thread.sleep(2000);

        System.out.println("Confirmam achizitia");
        cartPage.confirmPurchase();
        Thread.sleep(2000);

        System.out.println("Validam achizitia");
        cartPage.validatePurchase();
    }

    @Test
    public void testAddMultipleProductsToCartAndDeleteProduct() throws InterruptedException {
        CartPage cartPage = new CartPage(driver, wait);
        driver.get("https://www.demoblaze.com/index.html");

        System.out.println("Navigam la categoria Monitors");
        cartPage.clickMonitorsCategory();
        Thread.sleep(2000);

        System.out.println("Selectam produsul Apple monitor 24");
        cartPage.selectAppleMonitor24();
        Thread.sleep(2000);

        System.out.println("Adaugam produsul in cos");
        cartPage.addToCart();
        Thread.sleep(2000);

        System.out.println("Validam mesajul de confirmare");
        cartPage.validateProductAdded();
        Thread.sleep(2000);

        System.out.println("Ne intoarcem la pagina principala");
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

        System.out.println("Navigam la categoria Laptops");
        cartPage.clickLaptopsCategory();
        Thread.sleep(2000);

        System.out.println("Selectam produsul MacBook Pro");
        cartPage.selectMacBookPro();
        Thread.sleep(2000);

        System.out.println("Adaugam produsul in cos");
        cartPage.addToCart();
        Thread.sleep(2000);

        System.out.println("Validam mesajul de confirmare");
        cartPage.validateProductAdded();
        Thread.sleep(2000);

        System.out.println("Navigam la cosul de cumparaturi");
        cartPage.goToCart();
        Thread.sleep(2000);

        int initialProductCount = cartPage.getProductCountInCart();

        System.out.println("Stergem un produs din cos");
        cartPage.deleteProductFromCart();
        Thread.sleep(2000);

        int updatedProductCount = cartPage.getProductCountInCart();
        Assert.assertTrue(updatedProductCount < initialProductCount, "Numărul de produse din coș nu s-a actualizat corect după ștergerea produsului.");
    }

    @Test
    public void testLoginAddToCartLogoutAndVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

        String user = "gabriel_test";
        String pass = "Parola123!";
        System.out.printf("Facem login cu userul %s, cu parola %s\n", user, pass);
        loginPage.login(user, pass);
        Thread.sleep(2000);

        System.out.printf("Validam ca mesajul de succes este corect: %s\n", user);
        loginPage.isLoginSuccessful("gabriel_test");
        Thread.sleep(2000);

        System.out.println("Intrăm în coș și verificăm dacă sunt produse de șters");
        cartPage.goToCart();
        if (cartPage.isCartEmpty()) {
            System.out.println("Coșul este deja gol. Trecem la pasul următor.");
        } else {
            System.out.println("Ștergem toate produsele existente din coș.");
            cartPage.removeAllProductsFromCart();
            Thread.sleep(2000);
        }

        System.out.println("Navigăm pe pagina principală");
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

        System.out.println("Selectăm categoria Phones");
        cartPage.clickPhonesCategory();
        Thread.sleep(2000);

        System.out.println("Selectăm produsul Iphone 6 32GB");
        driver.findElement(CartPageLocators.iphone6_32GB).click();
        Thread.sleep(2000);

        System.out.println("Adăugăm produsul în coș");
        cartPage.addToCart();
        Thread.sleep(2000);

        System.out.println("Validăm că produsul a fost adăugat în coș");
        cartPage.validateProductAdded();
        Thread.sleep(2000);

        System.out.println("Navigăm în coș");
        cartPage.goToCart();
        Thread.sleep(2000);

        System.out.println("Facem log out");
        loginPage.logout();
        Thread.sleep(2000);

        System.out.println("Verificăm că produsul nu mai este în coș după logout");
        cartPage.validateProductsInCartAfterLogout();
        Thread.sleep(2000);

        System.out.println("Facem din nou log in");
        loginPage.login(user, pass);
        Thread.sleep(2000);

        System.out.println("Validăm că mesajul de succes este corect: " + user);
        loginPage.isLoginSuccessful("gabriel_test");
        Thread.sleep(2000);

        System.out.println("Verificăm dacă produsul mai este în coș după relogare");
        cartPage.validateProductsInCart("Iphone 6 32gb");
    }

}