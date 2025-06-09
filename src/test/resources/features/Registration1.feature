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
Feature: Lumo Registration

  Scenario Outline: Register new user
    Given user goto create an account tab
    When user entered First_Name <firstname> Last_Name <lastname> Email <email> Password <password> confirm_password <confPassword>
    Then user should register successfully
    And Redirected to My Account page

    Examples: 
      | firstname | lastname | email          | password   | confPassword |
      # | "john"    | "luck"   | "jj12@hh.com"  | "123!Qa45" | "123!Qa45"   |
      # | "llll"     | "kkkk"   | "lkk1@jh.com" | "1234!Qaa" | "1234!Qaa"   |
      # | "llmm"     | "kkjj"   | "lk21@jh.com" | "1234!Qaa" | "1234!Qaa"   |
      | "john"    | "luck"   | "jj11@hh.com"  | "123!Qa45" | "123!Qa45"   |
      
 
      