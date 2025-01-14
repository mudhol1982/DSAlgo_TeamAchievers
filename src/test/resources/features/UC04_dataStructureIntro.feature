Feature: Data Structures-Introduction

  Background: The user sign in to dsAlgo Portal

  Scenario: Verify that user is able to navigate to Data Structures-Introduction page
    Given The user is on the home page after sign in
    When The user clicks the Get Started button under Data Structures Introduction section
    Then The user should be directed to  Data Structure introduction Page
#
  #Scenario: Verify that user is able to navigate to Time Complexity page
    #Given The user is in the Data Structures - Introduction page
    #When The user clicks Time Complexity link
    #Then The user should be redirected to Time Complexity section of Data Structures Introduction page
#
  #Scenario: Verify that user is able to navigate to Try Editor page of Time Complexity page
    #Given The user is in the Time Complexity page
    #When The user clicks Try Here button in Time Complexity page
    #Then The user should be redirected to a page having a try Editor with Run button
#
  #Scenario: Verify that user does not get any response when clicked on Run button without entering code
    #Given The user is in the tryEditor page of Time Complexity page
    #When The user clicks the Run Button without entering the code in the Editor
    #Then The user should not see an error message
#
  #Scenario Outline: Verify that user receives error for invalid python code in Time Complexity Page
    #Given The user is in the tryEditor page of Time Complexity Page
    #When The user write the invalid code from sheetname "<Sheetname>" and row <RowNumber> and click Run Button
    #Then The user should be able to see an error message in alert window
#
    #Examples: 
      #| Sheetname   | RowNumber |
      #| InvalidCode |         2 |
#
  #Scenario Outline: Verify that user is able to see output for valid python code in Time Complexity Page
    #Given The user is in the tryEditor page of Time Complexity Page
    #When The user write the valid code from sheetname "<Sheetname>" and row <RowNumber> and click Run Button
    #Then The user should be able to see output in the console
#
    #Examples: 
      #| Sheetname   | RowNumber |
      #| InvalidCode |         3 |
#
  #Scenario: Verify that user is able to navigate to Practice Questions page
    #Given The user is in the Time Complexity page
    #When The user clicks the Practice Questions link
    #Then The user should be redirected to Practice Questions of Data structures Introduction
