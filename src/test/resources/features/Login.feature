Feature: Login functionality

  Background:
    Given User is on the main page
    When User clicks on the sign in button

  Scenario: User should be able to login to the application with valid credentials
    And User enters valid username
    And User enters valid password
    And User clicks Signin button
    And user clicks on account summary button
    Then Account summary page is displayed


  Scenario: User should NOT be able to login to the application with INVALID credentials
    And User enters valid username
    And User enters invalid password
    And User clicks Signin button
    Then Error message should be displayed

