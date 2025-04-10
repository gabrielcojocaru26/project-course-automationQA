package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLogin extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        driver.get("https://www.demoblaze.com/index.html");
        String user = "gabriel_test";
        String pass = "Parola123!";
        System.out.printf("Facem login cu userul %s, cu parola %s\n", user, pass);
        loginPage.login(user, pass);
        System.out.printf("Validam ca mesajul de succes este corect: %s\n", user);
        loginPage.isLoginSuccessful("gabriel_test");
    }

    @Test
    public void testLoginWithEmptyCredentials() {
        LoginPage loginPage = new LoginPage(driver, wait);
        // Deschidem site-ul
        String errorMessage = "Please fill out Username and Password.";
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println("Facem login fara user si parola");
        loginPage.login("", "");
        System.out.printf("Verificam daca mesajul de eroare este corect: %s", errorMessage);
        loginPage.loginFailsWithMessage(errorMessage);
    }

    @Test
    public void testLoginWithCorrectUserWrongPassword() {
        LoginPage loginPage = new LoginPage(driver, wait);
        String user = "gabriel_test";
        String wrongPass = "WrongPassword123";
        String errorMessage = "Wrong password.";

        driver.get("https://www.demoblaze.com/index.html");
        System.out.printf("Facem login cu user corect: %s, dar cu parola gresita\n", user);
        loginPage.login(user, wrongPass);
        System.out.printf("Verificam daca mesajul de eroare este corect: %s\n", errorMessage);
        loginPage.loginFailsWithMessage(errorMessage);
    }

    @Test
    public void testLoginWithWrongUserCorrectPassword() {
        LoginPage loginPage = new LoginPage(driver, wait);
        String wrongUser = "wrong_user";
        String pass = "Parola123!";
        String errorMessage = "User does not exist.";

        driver.get("https://www.demoblaze.com/index.html");
        System.out.printf("Facem login cu user gresit: %s, dar cu parola corecta\n", wrongUser);
        loginPage.login(wrongUser, pass);
        System.out.printf("Verificam daca mesajul de eroare este corect: %s\n", errorMessage);
        loginPage.loginFailsWithMessage(errorMessage);
    }
}



