@test
Feature: Adding and Removing items from the Cart
  I as a user want to be able to add a product and remove it from the cart
  @test
  Scenario: The user adds and removes items from the cart
    Given User goes to the home page
    And User types the product "Adult Male Finch" on the search input field
    And User clicks on the search button
    Then The application shows the result for the product successfully