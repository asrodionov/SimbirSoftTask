package ru.simbirsoft.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ComposeMailPage {
    private final WebDriver driver;

    private final By addressField = By.cssSelector(".MultipleAddressesDesktop-Field .composeYabbles");
    private final By subjectField = By.className("ComposeSubject-TextField");
    private final By mailTextWrapper = By.cssSelector(".cke_contents_ltr div");
    private final By mailTextArea = By.cssSelector(".composeReact__message-body textarea");
    private final By composeBtn = By.className("ComposeSendButton");
    private final By successAlert = By.className("ComposeDoneScreen-Title");

    public ComposeMailPage(WebDriver driver){
        this.driver = driver;
    }

    public void composeMail(String amountMail) {
        String js = "arguments[0].innerHTML += 'simbtask@yandex.ru'";
        ((JavascriptExecutor) driver).executeScript(js, driver.findElement(addressField));

        driver.findElement(subjectField).sendKeys("Simbirsoft Тестовое задание. Родионов");

        String js1 = "arguments[0].innerHTML = '"+amountMail+"'";
        ((JavascriptExecutor) driver).executeScript(js1, driver.findElement(mailTextWrapper));

        String js2 = "arguments[0].innerHTML = '"+amountMail+"'";
        ((JavascriptExecutor) driver).executeScript(js2, driver.findElement(mailTextArea));

        driver.findElement(composeBtn).click();
    }

    public String getSuccessAlert(){
        return driver.findElement(successAlert).getText();
    }

}
