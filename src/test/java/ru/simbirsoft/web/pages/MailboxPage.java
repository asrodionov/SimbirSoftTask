package ru.simbirsoft.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailboxPage {
    private final WebDriver driver;

    private final By mailSubject = By.cssSelector(".mail-MessageSnippet-Item_subject [title='Simbirsoft Тестовое задание']");
    private final By composeMail = By.className("mail-ComposeButton");

    public MailboxPage(WebDriver driver){
        this.driver = driver;
    }

    public int getAmountMail() {
        List<WebElement> mails = driver.findElements(mailSubject);
        return mails.size();
    }

    public ComposeMailPage createNewMail(){
        driver.findElement(composeMail).click();
        return new ComposeMailPage(driver);
    }

}
