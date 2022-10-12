Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: State Testing with JDBC
    And Click on the element in the left Nav
      | setup      |
      | parameters |
      | States     |
    Then Send the query the database "select * from States" and control match