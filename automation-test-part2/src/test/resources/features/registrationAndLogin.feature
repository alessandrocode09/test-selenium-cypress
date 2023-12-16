@test
Feature: Registration and Login
  I as a user want to be able to register a user on the application
  If the user is registered successfully
  I want also to be able to log into the application

  @test
  Scenario: The customer creates a user and logs into the application
    Given User goes to the home page
    Then User navigates to the Sign In page and validate the text "Please enter your username and password." match
    And User navigates to the Register Now page
    Then User validate if the Register page is displayed by the text "User Information"
    And The user registers a new user
    And The user logs into the application with the registered user
    Then The application shows the registered user logged