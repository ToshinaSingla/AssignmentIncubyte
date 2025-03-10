#Author: Toshina Singla

Feature: I want to test create new account scenario

  Background: User lands on Home Page and opens the page Create an Account.
    When user opens the App
    And user is on Home Page
    And user clicks on the header button Create an Account
    Then user is on the page Create an Account

  Scenario: User clicks on the button Create an Account to check all the mandatory fields.
    Given user is on the page Create an Account
    When user clicks on the button Create an Account
    Then user compares the count of warnings with the count of mandatory fields

  Scenario: User provides Personal Information.
    Given user is on the page Create an Account
    When user enters the first name
    And user enters the last name

  Scenario: User enters an invalid email address.
    Given user enters the first name
    And user enters the last name
    When user enters an invalid email address
    And user clicks on the button Create an Account
    Then user reads the warning for the invalid email address

  Scenario: User enters a valid email address.
    Given user enters the first name
    And user enters the last name
    When user enters a valid email address
    And user clicks on the button Create an Account
    Then user is unable to find the warning for the email address

  Scenario: User enters weak password with only two chars and check for the strength meter.
    Given user enters the first name
    And user enters the last name
    When user enters two characters only as the password
    Then user checks the password strength for weak

  Scenario: User enters weak password with only special chars and check for the strength meter.
    Given user enters the first name
    And user enters the last name
    When user enters only special characters only as the password
    Then user checks the password strength for weak

  Scenario: User enters medium password and check for the strength meter.
    Given user enters the first name
    And user enters the last name
    When user enters three out of four classes of characters in password
    Then user checks the password strength for medium

  Scenario: User enters strong password and check for the strength meter.
    Given user enters the first name
    And user enters the last name
    When user enters a valid password
    Then user checks the password strength for strong

  Scenario: User enters mismatched password for confirm password.
    Given user enters the first name
    And user enters the last name
    And user enters a valid email address
    And user enters a valid password
    When user enters mismatched password in the text box confirm password
    And user clicks on the button Create an Account
    Then user reads the warning for the mismatched password

  Scenario: User enters matched password for confirm password.
    Given user enters the first name
    And user enters the last name
    And user enters a valid email address
    And user enters a valid password
    And user enters correct password in the text box confirm password
    And user clicks on the button Create an Account
    Then user gets navigated to the page my account
    And user checks the confirmation of account creation
