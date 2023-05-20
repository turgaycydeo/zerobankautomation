package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
@FindBy(id="signin_button")
   public WebElement signInButton;

@FindBy(id = "user_login")
   public WebElement userLoginButton;

@FindBy(id="user_password")
   public WebElement userPassword;

@FindBy(xpath = "//input[@class='btn btn-primary']")
   public WebElement userSignInButton;

@FindBy(xpath = "//*[@id=\"online-banking\"]")
   public  WebElement onlineBanking;

@FindBy(xpath = "//span[@id='account_summary_link']")
   public WebElement accountSummary;

@FindBy(xpath = "//*[@id=\"login_form\"]/div[1]")
public WebElement errorMessage;

}
