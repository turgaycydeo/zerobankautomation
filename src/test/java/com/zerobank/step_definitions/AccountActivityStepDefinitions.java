package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountActivityStepDefinitions {
    AccountActivity accountActivity = new AccountActivity();

    @When("User clicks oc checking account activity button")
    public void user_clicks_oc_checking_account_activity_button() {
        accountActivity.checkAccountButton.click();
    }

    @Then("User is on the account activity page")
    public void user_is_on_the_account_activity_page() {
        String title = Driver.getDriver().getTitle();
        //System.out.println("title = " + title);
        Assert.assertEquals("Zero - Account Activity", title);

    }

    @Then("In the Account drop down default option should be {string}")
    public void in_the_account_drop_down_default_option_should_be(String string) {
        Select select = new Select(accountActivity.accountDropdown);

        Assert.assertEquals(string, select.getFirstSelectedOption().getText());

    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> accountDrop) {
        Select select = new Select(accountActivity.accountDropdown);
        List<WebElement> accountDropDown = select.getOptions();
        List<String> accountDropDownS = new ArrayList<>(accountDropDown.size());

        for (WebElement each : accountDropDown
        ) {
            accountDropDownS.add(each.getText());
        }
        //System.out.println("accountDrop = " + accountDrop);
        //System.out.println("accountDropDownS = " + accountDropDownS);
        Assert.assertEquals(accountDrop, accountDropDownS);

    }

    @Then("Transaction table should have column names")
    public void transaction_table_should_have_column_names(List<String> transactionTable) {
        List<String> transactionS = new ArrayList<>(accountActivity.transactionTable.size());
        for (WebElement each : accountActivity.transactionTable
        ) {
            transactionS.add(each.getText());
        }

        Assert.assertEquals(transactionTable, transactionS);
    }

    @When("user clicks on find transactions button")
    public void user_clicks_on_find_transactions_button() {
        accountActivity.findTransactionButton.click();
    }

    @When("user enters date range from {string} to {string}")
    public void user_enters_date_range_from_to(String string, String string2) {

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        accountActivity.fromDateInput.sendKeys(string);
        accountActivity.toDateInput.sendKeys(string2);

    }

    @When("user clicks on find button")
    public void user_clicks_on_find_button() {
        accountActivity.findButton.click();
    }

    @Then("results should be sorted by most recent date")
    public void results_should_be_sorted_by_most_recent_date() {

        List<String> dateList = new ArrayList<>();
        for (WebElement each : accountActivity.transactionDates
        ) {
            dateList.add(each.getText());

        }

        List<String> sortedDateList=new ArrayList<>(dateList);
       Collections.sort(sortedDateList,Collections.reverseOrder());

        System.out.println("dateList = " + dateList);
        System.out.println("sortedDateList = " + sortedDateList);

        Assert.assertEquals(dateList,sortedDateList);
    }


}
