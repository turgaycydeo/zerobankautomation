package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the main page")
    public void user_is_on_the_main_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }

    @When("User clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.signInButton.click();
    }

    @When("User enters valid username")
    public void user_enters_valid_username() {
        loginPage.userLoginButton.sendKeys(ConfigurationReader.getProperty("username"));
    }

    @When("User enters valid password")
    public void user_enters_valid_password() {
        loginPage.userPassword.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @When("User clicks Signin button")
    public void user_clicks_signin_button() {
        loginPage.userSignInButton.click();
        Driver.getDriver().navigate().back();
    }

    @When("user clicks on account summary button")
    public void user_clicks_on_account_summary_button() {
        loginPage.onlineBanking.click();
        loginPage.accountSummary.click();

    }

    @Then("Account summary page is displayed")
    public void account_summary_page_is_displayed() {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Zero - Account Summary", actualTitle);

    }

    @When("User enters invalid password")
    public void user_enters_invalid_password() {
        loginPage.userPassword.sendKeys("");
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());


    }
}
