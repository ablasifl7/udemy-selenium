Feature: File Upload Funcionality
  To test the file upload feature of the web site

  Background: 
    Given User should be logged in
    And User should be at file upload page
    When I click on File upload button
    Then File upload dialog box should appear
    And Title of the dialog should be FileUplood

  Scenario: Uploading single file
    Then I upload single file

  Scenario: Uploading multiple file
    Then I upload multiple file

  Scenario: Uploading file with long name
    Then I upload single file
    But I upload a file with name more than 256 characters