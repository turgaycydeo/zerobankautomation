package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineBanking extends PayBills{
    @FindBy(id = "pay_bills_link")
    public WebElement payBillsButton;
}
