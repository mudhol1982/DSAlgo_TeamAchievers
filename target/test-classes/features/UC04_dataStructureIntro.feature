Feature: Data Structures-Introduction

  #TC01 (Data Structures - Introduction page)
  Scenario: Verify that user is able to navigate to Data Structures - Introduction page
    Given The user is landed on the home page after sign-in
    When The user clicks the Get Started button of Data Structure Introduction section
    Then The user should be directed to  Data Structure introduction Page

  #TC02 ( Time Complexity page of DS Introduction page)
  Scenario: Verify that user is able to navigate to  Time Complexity page of DS Introduction page
    Given The user is on the Data Structure introduction Page of ds algo portal after sign in
    When The user clicks on Time Complexity link of DS Introduction page
    Then The user should be directed to Time Complexity page of DS Intro page

  #TC03 (Try here from Time Complexity Page)
  Scenario: Verify that user is able to navigate to Try Editor from Time Complexity page for DS Introduction page
    Given The user is on the Time Complexity Page of DS Introduction page
    When The user clicks on Try here button of Time Complexity Page
    Then The user should be directed to a page having Editor with run button

  #TC04
  Scenario: Verify that user does not get any error message  when clicked on Run button without any code
    Given The user is in the tryEditor page of Time Complexity page
    When The user clicks the Run button without entering the code in the text area editor
    Then The user does not see any error message displayed

  #TC05
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is in the tryEditor page of Time Complexity page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname         | RowNumber |
      | tryEditorCode     |        1  |
      
      #TC06
    Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is in the tryEditor page of Time Complexity page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname         | RowNumber |
      | tryEditorCode     |         0 |
      
      
  #TC07
  Scenario: Verify that user is able to navigate to Practice Questions page
    #Given The user is on the Time Complexity Page of DS Introduction page
    When The user clicks Practice Questions link
    Then The user should be redirected to Practice Questions page 
    
