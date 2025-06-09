#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: ForgotPassword

  @tag1
  Scenario Outline: User resets password and a confirmation mail is received
    Given User clicks forgot password link on login page
    When User navigates to forgot password page enters <email> and clicks reset password button
    Then Login Page should be visible
    And A confirmation mail should be displayed on login page with the <email> address
    Examples:
        | email          |
        | "jk123@ga.com" |
        |"kkk12@ga.com"|
