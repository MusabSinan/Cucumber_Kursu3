#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption      | GradeLevelOption |
#| Math exam sin1   | academicPeriod2              | gradeLevel4  |
#| IT exam sin1     | academicPeriod2              | gradeLevel2  |
#| Oracle exam sin1 | academicPeriod2              | gradeLevel3  |
#| Math exam  sin1  | academicPeriod2              | gradeLevel1  |



Feature: Enterance Exam Functionality


  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly


  Scenario Outline: Create and Delete an Exam

    And Click on the element in the left Nav
      | enteranceExam |
      | Setup         |
      | EnteranceExam |

    And Click on the element in the Dialog

      | addButton |

    And User sending the keys in Dialog content

      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriod         |
      | <AcademicPeriodOption> |
      | gradeLevel             |
      | <GradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed


    And Click on the element in the left Nav
      | enteranceExam |
      | Setup         |
      | EnteranceExam |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:

      | ExamName         | AcademicPeriodOption | GradeLevelOption |
      | Math exam sin1   | academicPeriod1      | gradeLevel2      |
      | IT exam sin1     | academicPeriod1      | gradeLevel2      |
      | Oracle exam sin1 | academicPeriod1      | gradeLevel2      |
      | Math exam  sin1  | academicPeriod1      | gradeLevel2      |