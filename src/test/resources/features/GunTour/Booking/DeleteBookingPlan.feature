Feature: Delete booking plan
  Background:
    Given User already login
    And Get booking pendaki history with valid path "booking"
    When Send request to get booking pendaki history
    Then Should return 200 OK
    And Should return body contain message "success get booking history"
    And Send id booking to global environment
    And Assert booking id is not 0

  @positive @booking
  Scenario: Delete booking plan with all valid value
    Given Delete booking plan with created id
    When Send request delete booking plan by id
    Then Should return 200 OK
    And Should return body contain message "success delete data."

  @negative @booking
  Scenario Outline: Delete booking plan invalid id with value string
    Given Delete booking plan with invalid id "<id>"
    When Send request delete booking plan by id
    Then Should return 400 Bad Request
    And Should return body contain message "id booking must integer"
    Examples:
    |  id  |
    |bonkngs|
    |^$*(#@ |
    |74298ys|

  @negative @booking
  Scenario: Delete booking plan without authorization
    Given Delete booking plan with invalid id "2" empty authorization
    When Send request delete booking plan by id
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  @negative @booking
  Scenario: Delete booking plan invalid authorization
    Given Delete booking plan with invalid id "3" invalid authorization
    When Send request delete booking plan by id
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"

