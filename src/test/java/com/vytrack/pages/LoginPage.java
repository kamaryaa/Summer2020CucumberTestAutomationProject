package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //To not use web elements directly in step definition classes
    @FindBy(id ="prependedInput")
    private WebElement username;


    @FindBy(id="prependedInput2")
    private WebElement password;


    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
    }



}
