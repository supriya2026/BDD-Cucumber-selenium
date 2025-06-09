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
Feature: Login to Lumo website
 Background:
   Given User on hompage and navigates to sign in tab
    
    

  @smoke
  Scenario: User Login valid Credentials
    When User enters user details
      | Email        | Password |
      | jk123@gg.com | 1234!Qaa |
    Then User verfies "Welcome" on navigation bar
    When User presses signout button using "Welcome" on navigation bar
    Then "You are signed out" message should be displayed
    And  Redirected to HomePage

  Scenario: User Login invalid Credentials
    When User enters user details
      | Email        | Password |
      | jk123@gg.com | 1234!Qaa |
    Then Error message showing "incorrect" should display
    And LoginPage should be visible
  @tag2
   Scenario: User login and adds item to cart first time after registration
       When User enters user details
      | Email        | Password |
      | lk21@jh.com | 1234!Qaa |
       
       When User selects item
       And AddtoCart
       When User fills in shipping details
 | address       | city    | state   | zipcode | phone    |
 | 36544 ggfrfgh | Atlanta | Georgia | 25554   | 12345678 |
    And User does the payment
    Then User checks "Thank you for your purchase!" message
    When User presses Continue shopping
    Then HomePage should be visible
       
   
