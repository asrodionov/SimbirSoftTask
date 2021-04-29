package ru.simbirsoft.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ComposeMailPage {
    private final WebDriver driver;

    private final By addressField = By.cssSelector(".MultipleAddressesDesktop-Field .composeYabbles");
    private final By subjectField = By.className("ComposeSubject-TextField");
    private final By mailTextWrapper = By.cssSelector(".cke_contents_ltr div");
    private final By composeBtn = By.className("ComposeSendButton");
    private final By successAlert = By.className("ComposeDoneScreen-Title");

    public ComposeMailPage(WebDriver driver){
        this.driver = driver;
    }

    public void composeMail(String amountMail, String to, String subject) {
        driver.findElement(addressField).sendKeys(Keys.chord(to));
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(mailTextWrapper).sendKeys(Keys.chord(amountMail));
        driver.findElement(composeBtn).click();
    }

    public String getSuccessAlert(){
        return driver.findElement(successAlert).getText();
    }

}
