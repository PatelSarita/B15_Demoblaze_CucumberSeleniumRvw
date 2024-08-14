package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

public BasePage(){
    PageFactory.initElements(Driver.get(),this);
}
    protected Alert alert;
    protected WebDriverWait wait=new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
    protected Faker faker=new Faker();

    @FindBy(id = "login2")
    public WebElement l_homePage_loginBtn;

    public void navigateToMenu(String menu){
        By l_menu= By.partialLinkText(menu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(l_menu)).click();
    }

}
