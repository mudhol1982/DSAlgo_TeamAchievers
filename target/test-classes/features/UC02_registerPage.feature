Feature: Registration
   This template is used for Registration process

  Background: DS Portal New user registration page
    Given The user is on the new user registration page

  Scenario Outline: Verify that user receives error message for all empty fields during registration
    When The user clicks Register button with all fields empty on registration form from sheetname "<Sheetname>" and row <RowNumber>
    Then The error Please fill out this field. appears below Username textbox

    Examples: 
      | Sheetname | RowNumber |
      | register  |         0 |

  Scenario Outline: Verify that user receives error message for empty Password and Password confirmation fields during registration
    When The user clicks Register button after entering Username with other fields empty from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message Please fill out this field. appears below Password textbox

    Examples: 
      | Sheetname | RowNumber |
      | register  |         1 |

  Scenario Outline: Verify that user receives error message for empty Password Confirmation field during registration
    When The user clicks Register button after entering Username and Password leaving Password Confirmation field empty from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message Please fill out this field. appears below  Password Confirmation textbox

    Examples: 
      | Sheetname | RowNumber |
      | register  |         2 |

  Scenario Outline: Verify that user receives error message for invalid username field during registration
    When The user clicks Register button after entering a username with spacebar characters other than digits and symbols from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see error msg after entering invalid data

    Examples: 
      | Sheetname | RowNumber |
      | register  |         3 |

  Scenario Outline: Verify that user receives error message for invalid password field during registration
    When The user clicks Register button after entering a password with only numeric data from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see error msg after entering invalid data in password fields

    Examples: 
      | Sheetname | RowNumber |
      | register  |         4 |

  Scenario Outline: Verify that user receives error message for Password field less than eight characters during registration
    When The user clicks Register button after entering a password with less than eight characters from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see error msg after entering less than eight characters

    Examples: 
      | Sheetname | RowNumber |
      | register  |         5 |

  Scenario Outline: Verify that user receives error message for mismatched Password and Password Confirmation field during registration
    When The user clicks Register button after entering different passwords in Password and Password Confirmation fields from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an pwd warning message password_mismatch:The two password fields didn’t match.

    Examples: 
      | Sheetname | RowNumber |
      | register  |         6 |

  Scenario Outline: Verify that user is able to successfully register using valid username and password details
    When The user clicks Register button after entering  with valid username password and password confirmation in related textboxes from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be redirected to Home Page of DS Algo with message New Account Created. You are logged in as username

    Examples: 
      | Sheetname | RowNumber |
      | register  |         7 |

  Scenario: Verify that user is able to click on login link from Registration page
    When The user clicks login link from Registration page
    Then The user should be landed on login page
 
    Scenario: Verify that user is able to click on Sign in link from Registration page
    When The user clicks Sign in link from Registration page
    Then The user should be landed on login page
    
  #Scenario: Verify that the user is able to log out of the application on clicking the Sign out link
    #Given The user is logged into the application
    #When The user clicks the Sign out link from the top-right corner of the Home Page
    #Then The user should be logged out of the application
    #And The user should be redirected to the homepage after logout
