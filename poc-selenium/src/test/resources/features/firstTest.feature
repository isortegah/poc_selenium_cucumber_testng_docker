Feature: To search cucumber in google
  @SearchGoogle @Web
  Scenario: Cucumber Google
    Given I am on google page
    Then I type the word Cheese!
    And I submit request
        
