Feature: DSportal App HomePage

  Scenario: Verify that user is able to open the dsAlgo Portal-home page
    #Given The user has browser open
    When The user enter correct dsAlgo portal URL <URL>
    Then The user should be able to land on dsAlgo portal with Get Started button
    
  Scenario: Validate user navigate to DS Intro Page
    #Given The user should open the DS Algo Portal URL in any supported browser
    When The user clicks the Get Started button
    Then The user should land in Data Structure Introduction Page with register and Sign in links
    
   
