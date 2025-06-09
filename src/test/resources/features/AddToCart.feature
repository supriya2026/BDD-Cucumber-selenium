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
Feature: Addcart

  # Background:
  # When User selects the item
  # And AddtoCart
  @tag1
  Scenario: Product add to cart as guest
    Given User on homepage
    When User selects the item
    And AddtoCart
    When User fills shipping details
  | email       | firstname | lastname | address       | city    | state   | zipcode | phone    |
  | kk1@gg.com | kay       | lastname | 36544 ggfrfgh | Atlanta | Georgia | 25554   | 12345678 |
    And User does the payment
    Then User checks "Thank you for your purchase!" message
    When User presses Continue shopping
    Then HomePage should be visible

  @smoke
  Scenario: User login and add the product to cart
    Given User on hompage and navigates to sign in tab
    When User enters user details
      | Email        | Password |
      | jk123@gg.com | 1234!Qaa |
    Then User checks "Welcome" message in navigation tab
    When User selects the item
    And AddtoCart and do the payment
    Then User checks "Thank you for your purchase!" message
    When User presses Continue shopping
    Then HomePage should be visible

  @sanity
  Scenario: User empties cart after login
    Given User on hompage and navigates to sign in tab
    When User enters user details
      | Email        | Password |
      | jk123@gg.com | 1234!Qaa |
    And User deletes the item in the cart
    Then if empty then "You have no items in your shopping cart." should be displayed
    #When User clicks the continue shooping link
    #Then HomePage should be visible
