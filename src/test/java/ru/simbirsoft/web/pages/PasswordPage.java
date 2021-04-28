package ru.simbirsoft.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private final WebDriver driver;

    private final By passwordField = By.id("passp-field-passwd");
    private final By passwordBtn = By.className("passp-sign-in-button");

    public PasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public MailboxPage passwUser(String password) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordBtn).click();
        return new MailboxPage(driver);
    }

}
