Feature: DSportal App HomePage

  Given The user clicks Data Structures drop down

  Scenario: Verify that user is able to open the dsAlgo Portal-home page
    When The user enter correct dsAlgo portal URL <URL>
    Then The user should be able to land on dsAlgo portal with Get Started button

  Scenario: Validate user navigate to DS Intro Page
    #Given The user should open the DS Algo Portal URL in any supported browser
    When The user clicks the Get Started button
    Then The user should land in Data Structure Introduction Page with register and Sign in links

  Scenario: Verify that user is able to view options for Data Structures dropdown on home page without Sign in
    When The user clicks the Data Structures dropdown
    Then The user should be able to see six options like Arrays Linked List Stack Queue Tree Graph in dropdown menu

  Scenario: Verify that user able to see warning message while selecting Arrays from the drop down without Sign in
    When The user selects Arrays from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Array drop down option

  Scenario: Verify that user able to see warning message while selecting Linked List from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Linked List from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Linked List drop down option

  Scenario: Verify that user able to see warning message while selecting Stack from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Stack from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Stack drop down option

  Scenario: Verify that user able to see warning message while selecting Queue from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Queue from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Queue drop down option

  Scenario: Verify that user able to see warning message while selecting Tree from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Tree from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Tree drop down option

  Scenario: Verify that user able to see warning message while selecting Graph from the drop down without Sign in.
    Given The user clicks Data Structures drop down
    When The user selects Graph from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Graph drop down option

  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Data Structures-Introduction on the home page without Sign in
    When The user clicks Get Started buttons of Data Structures-Introduction on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in
