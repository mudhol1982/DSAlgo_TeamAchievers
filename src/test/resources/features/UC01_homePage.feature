Feature: DSportal App HomePage
  
  Given The user clicks Data Structures drop down

#TC01
@HomeTest01
  Scenario: Verify that user is able to open the dsAlgo Portal-home page
    When The user enter correct dsAlgo portal URL <URL>
    Then The user should be able to land on dsAlgo portal with Get Started button
#TC02
@HomeTest02
  Scenario: Validate user navigate to DS Intro Page
    #Given The user should open the DS Algo Portal URL in any supported browser
    When The user clicks the Get Started button
    Then The user should land in Data Structure Introduction Page with register and Sign in links

#TC03
@HomeTest03
  Scenario: Verify that user is able to view options for Data Structures dropdown on home page without Sign in
    When The user clicks the Data Structures dropdown
    Then The user should be able to see six options like Arrays Linked List Stack Queue Tree Graph in dropdown menu
    
#TC04
@HomeTest04
  Scenario: Verify that user able to see warning message while selecting Arrays from the drop down without Sign in
    When The user selects Arrays from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Array drop down option

#TC05
@HomeTest05
  Scenario: Verify that user able to see warning message while selecting Linked List from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Linked List from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Linked List drop down option
#TC06
@HomeTest06
  Scenario: Verify that user able to see warning message while selecting Stack from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Stack from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Stack drop down option
#TC07
@HomeTest07
  Scenario: Verify that user able to see warning message while selecting Queue from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Queue from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Queue drop down option
#TC08
@HomeTest08
  Scenario: Verify that user able to see warning message while selecting Tree from the drop down without Sign in
    Given The user clicks Data Structures drop down
    When The user selects Tree from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Tree drop down option
#TC09
@HomeTest09
  Scenario: Verify that user able to see warning message while selecting Graph from the drop down without Sign in.
    Given The user clicks Data Structures drop down
    When The user selects Graph from the drop down without Sign in
    Then The user should able to see an warning message You are not logged in for Graph drop down option
#TC10
@HomeTest10
  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Data Structures-Introduction on the home page without Sign in
    Given The user should land in Data Structure Introduction Page with register and Sign in links
    When The user clicks Get Started buttons of Data Structures-Introduction on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in for DS Introduction
#TC11
@HomeTest11
  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Array on the home page without Sign in
    Given The user should land in Data Structure Introduction Page with register and Sign in links
    When The user clicks Get Started buttons of Array on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in for Array
#TC12
@HomeTest12
  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Linked List on the home page without Sign in
    Given The user should land in Data Structure Introduction Page with register and Sign in links
    When The user clicks Get Started buttons of Linked List on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in for Linked List
#TC13
@HomeTest13
  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Stack on the home page without Sign in
    Given The user should land in Data Structure Introduction Page with register and Sign in links
    When The user clicks Get Started buttons of Stack on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in for Stack
#TC14
@HomeTest14
  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Queue on the home page without Sign in
    Given The user should land in Data Structure Introduction Page with register and Sign in links
    When The user clicks Get Started buttons of Queue on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in for Queue
#TC15
@HomeTest15
  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Tree on the home page without Sign in
    Given The user should land in Data Structure Introduction Page with register and Sign in links
    When The user clicks Get Started buttons of Tree on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in for Tree
#TC16
@HomeTest16
  Scenario: Verify that user able to see warning message on clicking Get Started buttons of Graph on the home page without Sign in
    Given The user should land in Data Structure Introduction Page with register and Sign in links
    When The user clicks Get Started buttons of Graph on the homepage without Sign in
    Then The user should able to see an warning message You are not logged in for Graph
