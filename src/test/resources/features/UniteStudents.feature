@UniteStudents
Feature: Find your student accommodation in Unite Students accomodation

  Scenario Outline: find_your_student_accomodation_in_<location>_<tc_id>
    Given The user search student accomodation in "<location>"
    When user click on "<hotel>" view rooms
    Then Validate "<hotel>" is displayed to book a viewing
    When user select "<rooms>" to book
    Then Validate checkout page displayed
    When the user enters new account details and continue


    Examples: 
      | tc_id | location  | hotel          | rooms                   |
      |   001 | Bath      | Charlton Court | Studio, Premium Range 1 |
      |   002 | Glasgow   | Blackfriars    | En-Suite, Classic       |
      |   003 | Edinburgh | Murano House   | Studio, Classic         |
