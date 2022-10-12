Feature: ApachePOI Citizen Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to Citizenship page

  Scenario: Create citizenship from Excel
    When User create citizenship with ApachePOI

  Scenario: delete citizenship from Excel
    Then User delete citizenship with ApachePOI