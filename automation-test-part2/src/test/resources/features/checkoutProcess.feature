@test
Feature: Checkout Process (Ship to Different Address)
  I as a user want to do the checkout process and ship to a different address

  @test
  Scenario: The user do the checkout process and send to a different address
    Given User goes to the home page
    Then User navigates to the Sign In page and validate the text "Please enter your username and password." match
    And User navigates to the Register Now page
    Then User validate if the Register page is displayed by the text "User Information"
    And The user registers a new user
    And The user logs into the application with the registered user
    Then The application shows the registered user logged
    And User types the product "Adult Male Finch" on the search input field
    And User clicks on the search button
    Then The application shows the result for the product successfully
    And User clicks on the product and add it to the cart
    And On the cart user clicks on Proceed to Checkout
    And User clicks on the "Ship to different address..." checkbox
    Then The application shows the "Shipping Address" page form successfully
    And The user change the address
    And User clicks on the Confirm button
    Then The application will show the "Thank you, your order has been submitted." message confirmation successfully