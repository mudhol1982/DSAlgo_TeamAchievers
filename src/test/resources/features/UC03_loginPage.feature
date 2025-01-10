Feature: DS Portal Login Feature
  I want to use this template for Login process

  Scenario Outline: Verify that user receives error message for all empty fields during Login
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after leaving the Username textbox and Password textbox empty from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message "Please fill out this field." appears below Username textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         0 |

  Scenario Outline: Verify that user receives error message for empty Username field during Login
    When The user clicks login button after entering the Password only from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message "Please fill out this field." appears below Username textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         1 |

  Scenario Outline: Verify that user receives error message for empty Password field during Login
    When The user clicks login button after entering the Username and leaves Password textbox empty from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message "Please fill out this field." appears below Password textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         2 |

  Scenario Outline: Verify that user receives error message for invalid Username and invalid Password fields during Login
    When The user clicks login button after entering invalid username and invalid password from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message "Invalid Username and Password"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         3 |

  Scenario Outline: Verify that user receives error message for invalid Username field during Login
    When The user clicks login button after entering invalid username and valid password "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message "Invalid Username and Password"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         4 |

  Scenario Outline: Verify that user receives error message for invalid Password field during Login
    When The user clicks login button after entering valid username and invalid password from "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message "Invalid Username and Password"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         5 |

  Scenario Outline: Verify that user able to land on Home page after entering valid Username and Password fields
    When The user clicks login button after entering valid username and valid password from "<Sheetname>" and row <RowNumber>
    Then The user should land in Data Structure Home Page with message "You are logged in"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         6 |

      