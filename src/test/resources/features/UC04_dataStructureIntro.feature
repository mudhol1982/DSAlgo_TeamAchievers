Feature: Data Structures-Introduction

  Background: The user sign in to dsAlgo Portal
    Given The user is landed on the home page after sign-in

  Scenario: Verify that user is able to navigate to Data Structures - Introduction page
    When The user clicks the Get Started button of Data Structure Introduction section
    Then The user should be directed to  Data Structure introduction Page

  Scenario: Verify that user is able to navigate to Time Complexity page
    Given The user is in the Data Structures-Introduction page
    When The user clicks Time Complexity link
    Then The user should be redirected to Time Complexity page of  Data Structure introduction
    
  #Scenario: Verify that user is able to navigate to try Editor page for Time Complexity page
    #Given The user is in the Time Complexity page
    #When The user clicks Try Here button in Time Complexity page
    #Then The user should be redirected to a page having an try Editor with a Run button
#
  #Scenario Outline: Verify that user does not get any error message  when clicked on Run button without any code
    #Given The user is in the tryEditor page of Time Complexity page
    #When The user clicks the Run button without entering the code in the text area editor from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should not get any error message in alert window
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         0 |
#
  #Scenario Outline: Verify that user receives error for invalid python code
    #Given The user is in the tryEditor page of Time Complexity page
    #When The user clicks run button by entering invalid code from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should able to see an error message in alert window
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         1 |
#
  #Scenario Outline: Verify that user is able to see console output for valid code
    #Given The user is in the tryEditor page of Time Complexity page
    #When The user clicks run button by entering valid code from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should able to see console output for valid code from sheetname "<Sheetname>" and row <RowNumber>
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         2 |
      #| tryEditorCode |         3 |
#
  #Scenario: Verify that user is able to navigate to Practice Questions page
    #Given The user is in the Time Complexity page
    #When The user clicks Practice Questions link
    #Then The user should be redirected to Practice Questions page of Data structures Introduction
    
#///////      //////////////////////////////////////////////////////////////////////////////      
  #Background: The user sign in to dsAlgo Portal
   #Given The user is on the home page after sign in 
#
  #Scenario: Verify that user is able to navigate to Data Structures Introduction page
    #When The user clicks the Get Started button under Data Structures Introduction section
    #Then The user should be directed to  Data Structure introduction Page
#
  #Scenario: Verify that user is able to navigate to Time Complexity page
    #Given The user is in the Data Structures - Introduction page
    #When The user clicks Time Complexity button
    #Then The user should be redirected to Time Complexity section of Data Structures Introduction page
#
    #
  #Scenario: Verify that user is able to navigate to Try here page
    #When The user clicks Try Here button
    #Then The user should be redirected to a page having a try Editor and  Run button
#
  #Scenario: Verify that user does not get any response when clicked on Run button without entering code
    #When The user clicks the Run Button without entering the code in the Editor
    #Then The user should not see an error message
#
  #Scenario Outline: Verify that user receives error for invalid python code in Time Complexity Page
    #Given The user is in the tryEditor page of Time Complexity Page
    #When The user write the invalid code as "sdfdfgsdjkghj"
    #When The user write the invalid code from sheetname "<Sheetname>" and row <RowNumber> and click Run Button
    #Then The user should able to see an error message in alert window
#
       #Examples: 
      #| Sheetname   | RowNumber |
      #| InvalidCode |         2 |
