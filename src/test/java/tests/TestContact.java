package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.ContactPage;

public class TestContact extends BaseTest {

    @Test
    public void testSendContactMessage() throws InterruptedException {
        ContactPage contactPage = new ContactPage(driver, wait);

        System.out.println("Deschidem pagina principală");
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);

        System.out.println("Deschidem formularul de contact");
        contactPage.openContactForm();
        Thread.sleep(2000);

        System.out.println("Introducem adresa de email");
        contactPage.enterEmail("numeprenume@gmail.com");
        Thread.sleep(2000);

        System.out.println("Introducem numele");
        contactPage.enterName("Gabriel Cojocaru");
        Thread.sleep(2000);

        System.out.println("Introducem mesajul");
        contactPage.enterMessage("Buna ziua, doresc sa comand un produs de pe site-ul dumneavoastra. Imi puteti confirma ca pot platii numerar la livrare? Multumesc");
        Thread.sleep(2000);

        System.out.println("Apăsăm butonul 'Send message'");
        contactPage.sendMessage();
        Thread.sleep(2000);

        System.out.println("Validăm mesajul alertei");
        contactPage.validateAlertMessage();
    }
}