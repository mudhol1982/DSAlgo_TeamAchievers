Feature: User Navigation to 'Graph' Data Structure Page

  Background: 
    Given the user is in the Home page after signing in

  Scenario: Verify that the user is able to navigate to the 'Graph' data structure page
    Given the user is in the Home page after signing in
    When the user clicks the "Getting Started" button in the Graph Panel
    Then the user must be redirected to the 'Graph' data structure page
     
