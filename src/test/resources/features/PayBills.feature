@wip
Feature: Pay bills feature

  Background:
    Given User is succesfully logged in
    And User is online banking page

  Scenario:User should perform payment operation

    When User clicks payBills button
    Then user is  on paybill page
    When User chooses "Wells Fargo" as payee
    And User chooses "Credit Card" as account
    And User enters "600" as amount
    And User chooses "2023-05-30" as date
    And User enters "Payment" as description
    And User clicks payButton
    Then The payment is successfully submitted

  Scenario:User should not perform payment operation without entering amount
    When User clicks payBills button
    Then user is  on paybill page
    When User chooses "Bank of America" as payee
    And User chooses "Loan" as account
    And User does not enter  amount
    And User chooses "2023-05-30" as date
    And User enters "Loan" as description
    Then The payment is Not submitted.




