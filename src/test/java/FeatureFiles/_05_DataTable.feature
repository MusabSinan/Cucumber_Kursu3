Feature: Datatable Functionality


  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: Create Country
    And Click on the element in the left Nav
      | setup      |
      | parameters |
      | Countries  |

    And Click on the element in the Dialog

      | addButton |

    And User sending the keys in Dialog content

      | nameInput | sinanCountry |
      | codeInput | 1071        |

    And Click on the element in the Dialog
      | saveButton |
    And Success message should be displayed

  Scenario: Create a Nationality
    And Click on the element in the left Nav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog

      | addButton |
    And User sending the keys in Dialog content

      | nameInput | mexican |

    And Click on the element in the Dialog
      | saveButton |
    And Success message should be displayed

    And User delete item from Dialog
      | mexican |

    And Success message should be displayed


  Scenario: Create a Fee ,delete Fee

    And Click on the element in the left Nav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in the Dialog

      | addButton |

    And User sending the keys in Dialog content

      | nameInput       | sinanFee |
      | codeInput       | 1807     |
      | integrationCode | 1995     |
      | priorityCode    | 1905     |


    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | sinanFee |

    And Success message should be displayed

 #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
    #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.

