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
Feature: Product
   Background: 
    Given User on hompage and navigates to sign in tab
    When User enters user details
      | Email        | Password |
      | jk123@gg.com | 1234!Qaa |
    When User enters "Women" in search bar
    And User selects the item category from dropdown menu
    And User selects the product

  @tag1
  Scenario: Search Product
    And AddtoCart and do the payment
    Then User checks "Thank you for your purchase!" message
    When User presses Continue shopping
    Then HomePage should be visible
  @smoke
  Scenario: Adding Product to WishList
    And  User clicks Add to WishList link
    Then User checks "My Wish List"
 @sanity
 Scenario: Adding product to compare List
    And User clicks Add to compare link
    Then User verifies "Compare Products" 
    

 