
Feature: Account Summary function

  Background:
    Given User is succesfully logged in
    And User is on account summary page
  @wip
  Scenario:
    Given  Account summary page is displayed
    Then Account summary page has the following account types
    |Cash Accounts|
    |Investment Accounts|
    |Credit Accounts|
    |Loan Accounts|
    Then Credit Accounts table must have columns
    |Account|
    |Credit Card|
    |Balance|