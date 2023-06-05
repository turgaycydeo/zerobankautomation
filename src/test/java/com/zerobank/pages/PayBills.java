package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBills extends BasePage{

    @FindBy(xpath = "//*[@id=\"sp_payee\"]")
    public WebElement payeeDropDown;

    @FindBy(id="sp_account")
    public WebElement accountDropDown;


    @FindBy(id = "sp_amount")
    public WebElement amountButton;

    @FindBy(id = "sp_date")
    public WebElement date;


    @FindBy(id = "sp_description")
    public  WebElement description;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id=\'alert_content\']")
    public WebElement successPayment;




}
