package ru.simbirsoft.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By loginField = By.id("passp-field-login");
    private final By loginBtn = By.className("passp-sign-in-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public PasswordPage loginUser() {
        driver.findElement(loginField).sendKeys("simbtask");
        driver.findElement(loginBtn).click();
        return new PasswordPage(driver);
    }

}
