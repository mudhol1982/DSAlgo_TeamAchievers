Feature: Queue

  Scenario: Verify that the user is able to navigate to the Queue data structure page
    Given the user is in the Home page after signing in for Queue
    When the user clicks the Get Started button in the Queue Panel
    Then the user must be redirected to the Queue data structure page
    
     Scenario: Verify that user is able to navigate to Queue data structure page through dropdown
   Given the user is in the home page of DS Algo portal after signing in for Queue
    When The user selects Queue item from the drop down menu
    Then the user must be redirected to the Queue data structure page
    
    
    Scenario: Verify that the user is able to navigate to the operations in Queue page
   Given the user is on the Queue page after signing in
    When the user clicks the operations in Queue link
   Then the user should be redirected to the operations in Queue page
   
    Scenario: Navigate to Try Editor for Queue Data Structure
Given The user is on the operations in Queue page in the DS Algo portal
When The user clicks Try Here button on the Queue page
Then The user is redirected to a page having Editor with run button of Queue


Scenario: User clicks the Run button without entering any code
    
    Given the user is on the tryEditor page of Queue with an empty code editor
    When the user clicks on the Run button without entering any code of Queue
    Then nothing happens and no error message is displayed for Queue
    
    
   Scenario: User writes invalid Python code and clicks Run button
    
  Given the user is on the tryEditor page of Queue with an empty code editor  
   When the user writes invalid Python code in the editor of Queue and clicks the Run button
  Then the user should see an error message in an alert window of Queue
    
   Scenario: User writes valid Python code and clicks Run button
    
   Given the user is on the tryEditor page of Queue with an empty code editor
    When the user writes valid Python code for Queue in the editor and clicks the Run button
    Then the user should be able to see output in the console for Queue
   
   Scenario: Verify that the user is able to navigate to the implementations using collections in Queue page
   Given the user is on the Queue page after signing in
    When the user clicks the  implementations using collections Queue link
   Then the user should be redirected to the  implementations using collections in Queue page
   
    Scenario: Navigate to Try Editor for implementations Queue Data Structure
Given The user is on the implementations in Queue page in the DS Algo portal
When The user clicks Try Here button on the Queue page
Then The user is redirected to a page having Editor with run button of Queue


Scenario: User clicks the Run button without entering any code
    
    Given the user is on the tryEditor page of Queue with an empty code editor
    When the user clicks on the Run button without entering any code of Queue
    Then nothing happens and no error message is displayed for Queue
    
    
   Scenario: User writes invalid Python code and clicks Run button
    
  Given the user is on the tryEditor page of Queue with an empty code editor  
   When the user writes invalid Python code in the editor of Queue and clicks the Run button
  Then the user should see an error message in an alert window of Queue
    
   Scenario: User writes valid Python code and clicks Run button
    
   Given the user is on the tryEditor page of Queue with an empty code editor
    When the user writes valid Python code for Queue in the editor and clicks the Run button
    Then the user should be able to see output in the console for Queue
   
      
   Scenario: Verify that the user is able to navigate to the implementations using array in Queue page
   Given the user is on the Queue page after signing in
    When the user clicks the  implementations using array Queue link
   Then the user should be redirected to the  implementations using array in Queue page
   
    Scenario: Navigate to Try Editor for implementations array Queue Data Structure
Given The user is on the implementations in array Queue page in the DS Algo portal
When The user clicks Try Here button on the Queue page
Then The user is redirected to a page having Editor with run button of Queue


Scenario: User clicks the Run button without entering any code
    
    Given the user is on the tryEditor page of Queue with an empty code editor
    When the user clicks on the Run button without entering any code of Queue
    Then nothing happens and no error message is displayed for Queue
    
    
   Scenario: User writes invalid Python code and clicks Run button
    
  Given the user is on the tryEditor page of Queue with an empty code editor  
   When the user writes invalid Python code in the editor of Queue and clicks the Run button
  Then the user should see an error message in an alert window of Queue
    
   Scenario: User writes valid Python code and clicks Run button
    
   Given the user is on the tryEditor page of Queue with an empty code editor
    When the user writes valid Python code for Queue in the editor and clicks the Run button
    Then the user should be able to see output in the console for Queue
    
     Scenario: Verify that the user is able to navigate to the in Queue operations page
   Given the user is on the Queue page after signing in
    When the user clicks the Queue operations link
   Then the user should be redirected to the Queue operations page
   
    Scenario: Navigate to Try Editor for Queue operations Data Structure
Given The user is on the Queue opeartions page in the DS Algo portal
When The user clicks Try Here button on the Queue page
Then The user is redirected to a page having Editor with run button of Queue


Scenario: User clicks the Run button without entering any code
    
    Given the user is on the tryEditor page of Queue with an empty code editor
    When the user clicks on the Run button without entering any code of Queue
    Then nothing happens and no error message is displayed for Queue
    
    
   Scenario: User writes invalid Python code and clicks Run button
    
  Given the user is on the tryEditor page of Queue with an empty code editor  
   When the user writes invalid Python code in the editor of Queue and clicks the Run button
  Then the user should see an error message in an alert window of Queue
    
   Scenario: User writes valid Python code and clicks Run button
    
   Given the user is on the tryEditor page of Queue with an empty code editor
    When the user writes valid Python code for Queue in the editor and clicks the Run button
    Then the user should be able to see output in the console for Queue
    
    
    Scenario: Queue Practice Questions

Given The user is on the Queue opeartions page for practice questions in the DS Algo portal
When The user clicks Practice Questions link for Queue
Then The user is redirected to Practice Questions page for Queue.
    
    