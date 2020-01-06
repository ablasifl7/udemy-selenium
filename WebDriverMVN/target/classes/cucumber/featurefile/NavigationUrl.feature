Feature: To check for all hyperlink present in the webpage

  Background: 
    Given User should be at home page "http://localhost:5001/"

  #  Scenario: To check for links
  #    When I click on the link I assert for the title
  #      | linkName | title                          |
  #      | Home     | Bugzilla Main Page             |
  #      | New      | Log in to Bugzilla             |
  #      | Browse   | Browse                         |
  #      | Reports  | Reporting and Charting Kitchen |
  #    And I close the browser
  Scenario Outline: To check for links
    When I click on the link "<linkName>"
    Then I assert for the "<title>"
    And I close the "<browserName>"

    Examples: 
      | linkName | title                          | browserName |
      | Home     | Bugzilla Main Page             | Iexplorer   |
      | New      | Log in to Bugzilla             | Firefox     |
      | Browse   | Browse                         | Chrome      |
      | Reports  | Reporting and Charting Kitchen | Safari      |
