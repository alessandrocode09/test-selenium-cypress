@test
Feature: Product Search
  I as a user want to be able to type the product names and search for it
  @test
  Scenario: The user search for a product
    Given User goes to the home page
    And User types the product "Adult Male Finch" on the search input field
    And User clicks on the search button
    Then The application shows the result for the product successfully