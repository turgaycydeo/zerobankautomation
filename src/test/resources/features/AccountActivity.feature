
Feature: Account Activity

  Background:
    Given User is succesfully logged in
    And User clicks oc checking account activity button

  Scenario:
    When User is on the account activity page
    Then In the Account drop down default option should be "Savings"
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then Transaction table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

  Scenario:
    Given User is on the account activity page
    When user clicks on find transactions button
    And user enters date range from "2012-09-01" to "2012-09-06"
    And user clicks on find button
    Then results should be sorted by most recent date