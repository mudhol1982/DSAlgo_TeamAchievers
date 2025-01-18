Feature: Graph

 # Background: 
  #  Given the user is in the Home page after signing in

  Scenario: Verify that the user is able to navigate to the Graph data structure page
    Given the user is in the Home page after signing in
    When the user clicks the Get Started button in the Graph Panel
    Then the user must be redirected to the Graph data structure page
    
    Scenario: Verify that the user is able to navigate to the topics Graph page
   Given the user is on the Graph page after signing in
    When the user clicks the Graph link
   Then the user should be redirected to the topics covered Graph page
   
    Scenario: Navigate to Try Editor for Graph Data Structure
Given The user is on the Graph page in the DS Algo portal
When The user clicks Try Here button on the page
Then The user is redirected to a page having Editor with run button


Scenario: User clicks the Run button without entering any code
    
    Given the user is on the tryEditor page of Graph with an empty code editor
    When the user clicks on the Run button without entering any code
    Then nothing happens and no error message is displayed
    
    
   Scenario: User writes invalid Python code and clicks Run button
    
  Given the user is on the tryEditor page of Graph with an empty code editor
   When the user writes invalid Python code in the editor and clicks the Run button
  Then the user should see an error message in an alert window
    
   Scenario: User writes valid Python code and clicks Run button
    
   Given the user is on the tryEditor page of Graph with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button
    Then the user should be able to see output in the console
   
   # Graph Representations
   
   Scenario: Verify that the user is able to navigate to the Graph Representations page
  Given the user is on the Graph page after signing in
  When the user clicks the Graph Representationslink
  Then the user should be redirected to the Graph Representations page
   
   
   # try here - graph representations(graph)
   
    Scenario: Navigate to Try Editor for Graph Data Structure
Given The user is on the Graph Representations page in the DS Algo portal
When The user clicks Try Here button on the page
Then The user is redirected to a page having Editor with run button


Scenario: User clicks the Run button without entering any code
    
    Given the user is on the tryEditor page of Graph with an empty code editor
    When the user clicks on the Run button without entering any code
    Then nothing happens and no error message is displayed
    
    
   Scenario: User writes invalid Python code and clicks Run button
    
  Given the user is on the tryEditor page of Graph with an empty code editor
   When the user writes invalid Python code in the editor and clicks the Run button
 Then the user should see an error message in an alert window
    
     Scenario: User writes valid Python code and clicks Run button
    
   Given the user is on the tryEditor page of Graph with an empty code editor
   When the user writes valid Python code in the editor and clicks the Run button
   Then the user should be able to see output in the console
   
  Scenario: Graph Practice Questions

Given The user is on the Graph Representations page
When The user clicks Practice Questions link for Graph
Then The user is redirected to Practice Questions page for Graph.
    
     
     
