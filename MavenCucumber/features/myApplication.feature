Feature: Test Facebook smoke scenario

  Scenario: Test login with valid credantials
    Given Open chrome and start applications
    When I eneter valud name "mukesh@gmail.com" and "selenium@123"
    Then user should be able to login successfully
    And application should be closed