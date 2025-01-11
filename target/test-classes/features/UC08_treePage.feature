Feature: User Navigation to 'Tree' Data Structure Page

  Background: 
    Given the user is in the DS Algo portal after signing in

  Scenario: Verify that the user is able to navigate to the 'Tree' data structure page
    Given the user is in the DS Algo portal after signing in
    When the user clicks the "Get Started" button in the Tree panel
    Then the user should be redirected to the 'Tree' data structure page
      
