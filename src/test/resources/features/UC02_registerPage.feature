Feature: DS Portal Registration Process

  This template is used for Registration process
  
  Background: DS Portal New User Registration Page
    
  
  Scenario Outline: Verify that user receives error message for all empty fields during registration
  Given:The user is on the new user registration page
  When The user clicks Register button with all fields empty from the sheetname "<Sheetname>" and row <RowNumber>
  Then The error Please fill out this field appears below Username textbox
  
  Examples:
  |Sheetname|RowNumber|
  |register |        0| 
  
  

