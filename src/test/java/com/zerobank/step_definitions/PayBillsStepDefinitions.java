package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.OnlineBanking;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PayBillsStepDefinitions {
    LoginPage loginPage = new LoginPage();
    OnlineBanking onlineBanking = new OnlineBanking();

    PayBills payBills = new PayBills();

    @Given("User is online banking page")
    public void user_is_online_banking_page() {
        loginPage.onlineBanking.click();
    }

    @When("User clicks payBills button")
    public void user_clicks_pay_bills_button() {
        onlineBanking.payBillsButton.click();
    }

    @Then("user is  on paybill page")
    public void user_is_on_paybill_page() {

        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertEquals("Zero - Pay Bills", title);

    }


    @When("User chooses {string} as payee")
    public void user_chooses_as_payee(String string) {

        Select select = new Select(payBills.payeeDropDown);


    select.selectByVisibleText(string);
    }

    @When("User chooses {string} as account")
    public void user_chooses_as_account(String string) {

        Select select = new Select(payBills.accountDropDown);
        select.selectByVisibleText(string);

    }

    @When("User enters {string} as amount")
    public void user_enters_as_amount(String string) {
        payBills.amountButton.sendKeys(string);
    }

    @When("User chooses {string} as date")
    public void user_chooses_as_date(String string) {
        payBills.date.sendKeys(string);

    }

    @When("User enters {string} as description")
    public void user_enters_as_description(String string) {
        payBills.description.sendKeys(string);
    }

    @When("User clicks payButton")
    public void user_clicks_pay_button() {
        payBills.payButton.click();

    }

    @Then("The payment is successfully submitted")
    public void the_payment_is_successfully_submitted() {
    Assert.assertTrue(payBills.successPayment.isDisplayed());

    }

    @When("User does not enter  amount")
    public void user_does_not_enter_amount() {
        payBills.amountButton.sendKeys("");

    }

    @Then("The payment is Not submitted.")
    public void the_payment_is_not_submitted() {
        payBills.payButton.click();

        System.out.println( payBills.amountButton.getAttribute("validationMessage"));
    }

}
