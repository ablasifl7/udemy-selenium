Feature: Login page of Bugzilla
  To test the login page Bugzilla web side

  Scenario: Login with valid userId and password
    Given I shoud be at the login page
    And I provide valid userId and password
    When I click on login button
    Then I should be able to login inside the bugzilla
    And The title of web page should be Bugzilla Main page
