Feature: Delete booking plan
  Background:
    Given User already login
    And Get booking pendaki history with valid path "booking"
    When Send request to get booking pendaki history
    Then Should return 200 OK
    And Should return body contain message "success get booking history"
    And Send id booking to global environment
    And Assert booking id is not 0

  Scenario: Delete booking plan with all valid value
    Given Delete booking plan with created id
    When Send request delete booking plan by id
    Then Should return 200 OK
    And Should return body contain message "success delete data."

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

