Feature: Delete booking plan
  Scenario: This scenario to create and delete created ID
    Given Add booking plan without input any product
    When Send request post add booking plan
    Then Should return 201 Created
    And Should return body contain message "success add booking plan"
    And Get created booking id
    And Assert that booking id is not 0

  Scenario: Delete booking plan with all valid value
    Given Delete booking plan with created id
    When Send request delete booking plan by id
    Then Should return 200 OK
    And Should return body contain message "success delete data."

  Scenario: Delete booking plan invalid id with deleted id
    Given Delete booking plan with deleted id
    When Send request delete booking plan by id
    Then Should return 404 Not Found

  Scenario Outline: Delete booking plan invalid id with value string
    Given Delete booking plan with invalid id "<id>"
    When Send request delete booking plan by id
    Then Should return 404 Not Found
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

