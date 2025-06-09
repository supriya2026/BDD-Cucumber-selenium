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
Feature: User Account 
   Background: 
    Given User on hompage and navigates to sign in tab
    When User enters user details
      | Email        | Password |
      | jk123@gg.com | 1234!Qaa |
    When User logins and navigates to My Account in  profile dropdown menu 

  @tag1
  Scenario: My Account Page
    Then User verifies "My Account" title
    
 @tag2
  Scenario: My order Page
    When User Clicks My order tab
    Then User verifies "My Orders" myorders title
 @tag3
  Scenario: User views order
    When User Clicks view order link
    Then User verifies  order page
 @tag4
  Scenario: User  reorders
    When User Clicks reorder link
    Then redirected to Shopping Cart page
    
