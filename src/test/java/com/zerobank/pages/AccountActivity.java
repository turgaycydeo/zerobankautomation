package com.zerobank.pages;

import io.cucumber.java.bs.I;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity extends BasePage{

    @FindBy(id="account_activity_link")
    public WebElement checkAccountButton;

   @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

   @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> transactionTable;

   @FindBy(xpath = "//li[@class='ui-state-default ui-corner-top']") //Find Transactions
    public WebElement findTransactionButton;

   @FindBy(id = "aa_fromDate")
    public WebElement fromDateInput;

   @FindBy(id = "aa_toDate")
    public WebElement toDateInput;

   @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement findButton;

   @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[1]")
    public List<WebElement> transactionDates;


}

