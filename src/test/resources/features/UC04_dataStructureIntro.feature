Feature: Data Structures-Introduction

  Background: The user sign in to dsAlgo Portal

  #Given The user is on the home page after sign in
  Scenario: Verify that user is able to navigate to Data Structures Introduction page
    Given The user is on the home page after sign in
    When The user clicks the Get Started button under Data Structures Introduction section
    Then The user should be directed to  Data Structure introduction Page

  Scenario: Verify that user is able to navigate to Time Complexity page
    When The user clicks Time Complexity button
    Then The user should be redirected to Time Complexity section of Data Structures Introduction page

  Scenario: Verify that user is able to navigate to Try here page
    When The user clicks Try Here button
    Then The user should be redirected to a page having a try Editor and  Run button

  Scenario: Verify that user does not get any response when clicked on Run button without entering code
    When The user clicks the Run Button without entering the code in the Editor
    Then The user should not see an error message

  Scenario: Verify that user receives error for invalid python code
    When The user write the invalid code in Editor and click the Run Button
    Then The user should able to see an error message in alert window
