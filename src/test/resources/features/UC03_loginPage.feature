Feature: DS Portal Login Feature
  I want to use this template for Login process

  #TC01
  Scenario Outline: Verify that user receives error message for all empty fields during Login
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after leaving the Username textbox and Password textbox empty from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message "Please fill out this field." appears below Username textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         0 |

  #TC02
  Scenario Outline: Verify that user receives error message for empty Username field during Login
    When The user clicks login button after entering the Password only from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message "Please fill out this field." appears below Username textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         1 |

  #TC03
  Scenario Outline: Verify that user receives error message for empty Password field during Login
    When The user clicks login button after entering the Username and leaves Password textbox empty from sheetname "<Sheetname>" and row <RowNumber>
    Then The error message "Please fill out this field." appears below Password textbox

    Examples: 
      | Sheetname | RowNumber |
      | login     |         2 |

  #TC04
  Scenario Outline: Verify that user receives error message for invalid Username and invalid Password fields during Login
    When The user clicks login button after entering invalid username and invalid password from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message "Invalid Username and Password"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         3 |

  #TC05
  Scenario Outline: Verify that user receives error message for invalid Username field during Login
  
    When The user clicks login button after entering invalid username and valid password "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message "Invalid Username and Password"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         4 |

  #TC06
  Scenario Outline: Verify that user receives error message for invalid Password field during Login
    When The user clicks login button after entering valid username and invalid password from "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message "Invalid Username and Password"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         5 |

  #TC07
  Scenario Outline: Verify that user able to land on Home page after entering valid Username and Password fields
    When The user clicks login button after entering valid username and valid password from "<Sheetname>" and row <RowNumber>
    Then The user should land in Data Structure Home Page with message "You are logged in"

    Examples: 
      | Sheetname | RowNumber |
      | login     |         6 |

  #TC08
  Scenario: Verify that user is able to view options for Data Structures dropdown on home page after Sign in
    When The user clicks the Data Structures dropdown
    Then The user should be able to see six options like Arrays Linked List Stack Queue Tree Graph in dropdown menu

  #TC09
  Scenario: Verify that user able to navigate to Array page when Array drop down option is selected
    When The user selects Arrays from the drop down after Sign in
    Then The user should able to see Array details page

  #TC10
  Scenario: Verify that user able to navigate to Linked List page when Linked List drop down option is selected
    Given The user clicks Data Structures drop down
    When The user selects Linked List from the drop down after Sign in
    Then The user should able to see Linked List details page

  #TC11
  Scenario: Verify that user able to navigate to Stack page when Stack drop down option is selected
    Given The user clicks Data Structures drop down
    When The user selects Stack from the drop down after Sign in
    Then The user should able to see Stack details page

  #TC12
  Scenario: Verify that user able to navigate to Queue page when Queue drop down option is selected
    Given The user clicks Data Structures drop down
    When The user selects Queue from the drop down after Sign in
    Then The user should able to see Queue details page

  #TC13
  Scenario: Verify that user able to navigate to Tree page when Tree drop down option is selected
    Given The user clicks Data Structures drop down
    When The user selects Tree from the drop down after Sign in
    Then The user should able to see Tree details page

  #TC14
  Scenario: Verify that user able to navigate to Graph page when Graph drop down option is selected
    Given The user clicks Data Structures drop down
    When The user selects Graph from the drop down after Sign in
    Then The user should able to see Graph details page

  #TC15
  Scenario: Verify that user able to sign out successfully when clicked on Sign Out link
    Given The user clicks Data Structures drop down
    When The user clicks Sign Out link
    Then The user should able to sign out successfully from ds algo portal
