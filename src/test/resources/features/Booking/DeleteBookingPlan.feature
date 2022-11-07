Feature: Delete booking plan
  Scenario: Delete booking plan with all valid value
    Given Delete booking plan with created id
    When Send request delete booking plan by id
    Then Should return 200 OK
    And Should return body contain message "success delete data."

  Scenario: Delete booking plan invalid id with deleted id
    Given Delete booking plan with deleted id "2"
    When Send request delete booking plan by id
    Then Should return 500 Internal Server Error
    And Should return body contain message "no data"

  Scenario Outline: Delete booking plan invalid id with value string
    Given Delete booking plan with invalid id "<id>"
    When Send request delete booking plan by id
    Then Should return 500 Internal Server Error
    Examples:
    |  id  |
    |bonkngs|
    |^$*(#@ |
    |74298ys|

  Scenario: Delete booking plan without authorization
    Given Delete booking plan with valid id "2" empty authorization
    When Send request delete booking plan by id
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  Scenario: Delete booking plan invalid authorization
    Given Delete booking plan with valid id "3" invalid authorization
    When Send request delete booking plan by id
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"

