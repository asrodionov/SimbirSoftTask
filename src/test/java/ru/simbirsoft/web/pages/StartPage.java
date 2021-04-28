package ru.simbirsoft.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
    private final WebDriver driver;

    private final By entranceBtn = By.className("HeadBanner-Button-Enter");

    public StartPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLoginBtn() {
        driver.findElement(entranceBtn).click();
        return new LoginPage(driver);
    }

}
