Feature: DS Portal Login Feature
  I want to use this template for Login process

  Scenario Outline: Verify that user receives error message for all empty fields during Login
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after leaving the Username textbox and Password textbox empty from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message Please fill out this field. appears below Username textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         0 |

  Scenario Outline: Verify that user receives error message for empty Username field during Login
    When The user clicks login button after entering the Password only from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message Please fill out this field. appears below Username textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         1 |
      
  #Scenario Outline: Verify that user receives error message for empty Password field during Login
    #When The user clicks login button after entering the Username and leaves Password textbox empty "<Sheetname>" and row <RowNumber>
    #Then The error message Please fill out this field. appears below Password textbox
#
    #Examples: 
      #| Sheetname | RowNumber |
      #| login     |         2 |