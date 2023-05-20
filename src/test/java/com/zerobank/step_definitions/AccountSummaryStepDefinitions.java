package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefinitions {

    AccountSummary accountSummary= new AccountSummary();
    LoginPage loginPage= new LoginPage();

    @Given("User is succesfully logged in")
    public void user_is_succesfully_logged_in() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.signInButton.click();
        loginPage.userLoginButton.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.userPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.userSignInButton.click();
        Driver.getDriver().navigate().back();

    }
    @Given("User is on account summary page")
    public void user_is_on_account_summary_page() {
        loginPage.onlineBanking.click();
        loginPage.accountSummary.click();
    }


    @Then("Account summary page has the following account types")
    public void account_summary_page_has_the_following_account_types(List<String> accountTypes) {

        List<String> newAccount= new ArrayList<>(accountSummary.accounts.size());
        for (WebElement each:accountSummary.accounts
             ) {
            newAccount.add(each.getText());
        }

        Assert.assertTrue(newAccount.equals(accountTypes));

            }
}
