package ru.simbirsoft.web.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.simbirsoft.web.pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MailInboxTests {
    WebDriver driver;
    String nodeURL;

    @BeforeEach()
    public void setUp() throws MalformedURLException {
        nodeURL = "http://192.168.0.100:5557/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @AfterEach
    public void afterTest(){
        driver.quit();
    }

    @Test
    void shouldBeCalculateAndComposeMailTest(){
        driver.get("https://mail.yandex.ru/");
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = startPage.clickLoginBtn();
        PasswordPage passwordPage = loginPage.loginUser();
        MailboxPage mailboxPage = passwordPage.passwUser();
        int amountMail = mailboxPage.getAmountMail();
        assertEquals(3,amountMail);
        ComposeMailPage composeMailPage = mailboxPage.createNewMail();
        composeMailPage.composeMail(Integer.toString(amountMail));
        assertEquals("Письмо отправлено",composeMailPage.getSuccessAlert());
    }

}
