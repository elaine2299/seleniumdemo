Feature: Login to the page

  Scenario Outline: Login with valid inputs
    Given View the Webpage
    And Navigate to Login page
    When The users enters username as "<emailAddress>" and password as "<password>"
    And Clicks on the Submit button
    Then Verify the login was "<expectedResult>"

    Examples:
      |emailAddress|password| expectedResult|
      |selenium_java_123@gmail.com |Elaine12345*|Successful|
