#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Create and Delete Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create a Fee ,delete Fee

    And Click on the element in the left Nav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in the Dialog

      | addButton |

    And User sending the keys in Dialog content

      | nameInput       | <Feename>  |
      | codeInput       | <Feecode>  |
      | integrationCode | <Feecode2> |
      | priorityCode    | <Pricode>  |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | <Feename> |

    And Success message should be displayed
    Examples:
      | Feename | Feecode | Feecode2 | Pricode |
      | sin1    | 3584    | 1995     | 789     |
      | sin5    | 1700    | 1988     | 753     |
      | sin3    | 1071    | 1903     | 951     |
      | sin4    | 1053    | 2020     | 159     |