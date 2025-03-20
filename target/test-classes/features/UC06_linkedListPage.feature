Feature: Linked List

  Scenario: Verify that user is able to navigate to Linked List page
    #TC01
    Given The user is landed on the home page after sign-in
    When The user clicks the Get Started button of Linked List section
    Then The user should be directed to Linked List page

  #TC02(Introduction page)
  Scenario: Verify that user is able to navigate to Introduction page
    Given The user is on the Linked List page
    When The user clicks the Introduction link
    Then The user should be redirected to Introduction page

  #TC03
  Scenario: Verify that user is able to navigate to try Editor page under introduction page
    Given The user is in the Introduction page
    When The user clicks Try Here button in Introduction page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC04
  Scenario: Verify that user sees no changes when clicked on Run button without entering code for introduction page
    When The user clicks the Run button without entering the code in the Editor
    Then The user should not see any error message as an alert

  #TC05
  Scenario Outline: Verify that user receives error for invalid python code for Introduction page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC06
  Scenario Outline: Verify that user is able to see output for valid python code
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC07(Creating Linked LIst page)
  Scenario: Verify that user is able to navigate to Creating Linked LIst page
    Given The user is on the Linked List page of DS
    When The user clicks the Creating Linked LIst link
    Then The user should be redirected to  Creating Linked LIst link page

  #TC08
  Scenario: Verify that user is able to navigate to try Editor page under Creating Linked LIst page
    Given The user is on the Creating Linked LIst page
    When The user clicks Try Here button in Creating Linked LIst page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC09
  Scenario: Verify that user does not receive error when click on Run button without entering code for Creating Linked List page
    When The user clicks the Run button without entering the code in the Editor
    Then The user should not see any error message as an alert

  #TC10
  Scenario Outline: Verify that user receives error for invalid python code for Creating Linked List page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC11
  Scenario Outline: Verify that user is able to see output for valid python code for Creating Linked List page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC12 (Types of Linked List)
  Scenario: Verify that user is able to navigate to Types of Linked List page
    Given The user is on the Linked List page of DS
    When The user clicks the Types of Linked List link
    Then The user should be redirected to Types of Linked List page

  #TC13
  Scenario: Verify that user is able to navigate to try Editor page under Types of Linked List page
    Given The user is on the Types of Linked List page of Linked List
    When The user clicks Try Here button in Types of Linked List page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC14
  Scenario: Verify that user does not receive error when click on Run button without entering code for Types of Linked List page
    When The user clicks the Run button without entering the code in the Editor
    Then The user should not see any error message as an alert

  #TC15
  Scenario Outline: Verify that user receives error for invalid python code for Types of Linked List page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC16
  Scenario Outline: Verify that user is able to see output for valid python code for Types of Linked List page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC017 (Implement Linked List in Python)
  Scenario: Verify that user is able to navigate to Implement Linked List in Python page
    Given The user is on the Linked List page of DS
    When The user clicks the Implement Linked List in Python page link
    Then The user should be redirected to Implement Linked List in Python page

  #TC018
  Scenario: Verify that user is able to navigate to try Editor page under Implement Linked List in Python page
    Given The user is on the Implement Linked List in Python page
    When The user clicks Try Here button in Implement Linked List in Python page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC019
  Scenario: Verify that user does not receive error when click on Run button without entering code for Implement Linked List in Python page
    When The user clicks the Run button without entering the code in the Editor
    Then The user should not see any error message as an alert

  #TC20
  Scenario Outline: Verify that user receives error for invalid python code for Implement Linked List in Python page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC21
  Scenario Outline: Verify that user is able to see output for valid python code for Implement Linked List in Python page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC22(Traversal)
  Scenario: Verify that user is able to navigate to Traversal page
    Given The user is on the Linked List page of DS
    When The user clicks the Traversal page link
    Then The user should be redirected to Traversal page

  #TC23
  Scenario: Verify that user is able to navigate to try Editor page under Traversal page
    Given The user is on the Traversal page
    When The user clicks Try Here button in Traversal page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC24
  Scenario: Verify that user does not receive error when click on Run button without entering code for Traversal page
    When The user clicks the Run button without entering the code in the Editor
    Then The user should not see any error message as an alert

  #TC25
  Scenario Outline: Verify that user receives error for invalid python code for Traversal page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC26
  Scenario Outline: Verify that user is able to see output for valid python code for Traversal page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC27(Insertion)
  Scenario: Verify that user is able to navigate to Insertion page
    Given The user is on the Linked List page of DS
    When The user clicks the Insertion page link
    Then The user should be redirected to Insertion page

  #TC28
  Scenario: Verify that user is able to navigate to try Editor page under Insertion page
    Given The user is on the Insertion page
    When The user clicks Try Here button in Insertion page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC29
  Scenario: Verify that user does not receive error when click on Run button without entering code for Insertion page
    When The user clicks the Run button without entering the code in the Editor
    Then The user should not see any error message as an alert

  #TC30
  Scenario Outline: Verify that user receives error for invalid python code for Insertion page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC31
  Scenario Outline: Verify that user is able to see output for valid python code for Insertion page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC32(Deletion)
  Scenario: Verify that user is able to navigate to Deletion page
    Given The user is on the Linked List page of DS
    When The user clicks the Deletion page link
    Then The user should be redirected to Deletion page

  #TC33
  Scenario: Verify that user is able to navigate to try Editor page under Deletion page
    Given The user is on the Deletion page
    When The user clicks Try Here button in Deletion page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC34
  Scenario: Verify that user does not receive error when click on Run button without entering code for Deletion page
    When The user clicks the Run button without entering the code in the Editor
    Then The user should not see any error message as an alert

  #TC35
  Scenario Outline: Verify that user receives error for invalid python code for Deletion page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC36
  Scenario Outline: Verify that user is able to see output for valid python code for Deletion page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #Practice Questions page scenarios from all sub pages under Linked List DS -> TC37 to TC43
  #TC37 (Practice Questions page)
  Scenario: Verify that user is able to navigate to Practice Questions page under Introduction page
    Given The user is in the Introduction page
    When The user clicks Practice Questions link
    Then The user should be redirected to try Editor page with a Run button

  #TC38
  Scenario: Verify that user is able to navigate to Practice Questions page under Creating Linked LIst page
    Given The user is on the Creating Linked LIst page
    When The user clicks Practice Questions link
    Then The user should be redirected to try Editor page with a Run button

  #TC39
  Scenario: Verify that user is able to navigate to Practice Questions page under Types of Linked List page
    Given The user is on the Types of Linked List page of Linked List
    When The user clicks Practice Questions link
    Then The user should be redirected to try Editor page with a Run button

  #TC40
  Scenario: Verify that user is able to navigate to Practice Questions page under Implement Linked List in Python page
    Given The user is on the Implement Linked List in Python page
    When The user clicks Practice Questions link
    Then The user should be redirected to try Editor page with a Run button

  #TC41
  Scenario: Verify that user is able to navigate to Practice Questions page under Traversal page
    Given The user is on the Traversal page
    When The user clicks Practice Questions link
    Then The user should be redirected to try Editor page with a Run button

  #TC42
  Scenario: Verify that user is able to navigate to Practice Questions page under Insertion page
    Given The user is on the Traversal page
    When The user clicks Practice Questions link
    Then The user should be redirected to try Editor page with a Run button

  #TC43
  Scenario: Verify that user is able to navigate to Practice Questions page under Deletion page
    Given The user is on the Deletion page
    When The user clicks Practice Questions link
    Then The user should be redirected to try Editor page with a Run button
