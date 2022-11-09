Feature: Get booking detail
  Background:
    Given Get booking pendaki history with valid path "booking"
    When Send request to get booking pendaki history
    Then Should return 200 OK
    And Should return body contain message "success get booking history"
    And Send id booking to global environment
    And Assert booking id is not 0

  Scenario: Get booking detail with all valid value
    Given Get booking detail with valid id
    When Send request get booking detail
    Then Should return 200 OK
    And Should return body contain message "success get booking detail"


  Scenario Outline: Get booking detail invalid id outside maximal expected value
    Given Get booking detail invalid id outside maximal expected value "<id>"
    When Send request get booking detail
    Then Should return 404 Not Found
    Examples:
      | id  |
      |99999|
      |984290|

  Scenario Outline: Get booking detail invalid id with value string
    Given Get booking detail invalid id with value string "<id>"
    When Send request get booking detail
    Then Should return 404 Not Found
    Examples:
      | id  |
      |jik&kqo|
      |#&*(@@(|
      |7583jf4|

  Scenario: Get booking detail without authorization
    Given Get booking detail with valid id without authorization
    When Send request get booking detail
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  Scenario: Get booking detail invalid authorization
    Given Get booking detail with valid id invalid authorization
    When Send request get booking detail
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"

