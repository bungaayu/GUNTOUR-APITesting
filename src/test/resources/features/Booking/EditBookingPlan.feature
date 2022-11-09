Feature: Edit booking plan
  Background:
    Given User already login
    And Get booking pendaki history with valid path "booking"
    When Send request to get booking pendaki history
    Then Should return 200 OK
    And Should return body contain message "success get booking history"
    And Send id booking to global environment
    And Assert booking id is not 0

  Scenario: Edit booking plan with all valid value
    Given Edit booking plan with all valid created ID booking
    When Send request put edit booking plan
    Then Should return 201 Created
    And Assert json schema edit booking plan

  Scenario Outline: Edit booking plan invalid id outside maximum expected value
    Given Edit booking plan with invalid id "<id>"
    When Send request put edit booking plan
    Then Should return 404 Not Found
    Examples:
    |  id  |
    |827492|
    |8398095|

  Scenario: Edit booking plan without authorization
    Given Edit booking plan without authorization with id
    When Send request put edit booking plan
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  Scenario: Edit booking plan invalid authorization
    Given Edit booking plan invalid authorization with id
    When Send request put edit booking plan
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"

  Scenario: Edit booking plan without input start date
    Given Edit booking plan valid id without input start date
    When Send request put edit booking plan
    Then Should return 201 Created
    And Should return body contain message "success edit booking plan"
    And Assert json schema edit booking plan without input start date

  Scenario: Edit booking plan without input end date
    Given Edit booking plan valid id without input end date
    When Send request put edit booking plan
    Then Should return 201 Created
    And Should return body contain message "success edit booking plan"
    And Assert json schema edit booking plan without input end date

  Scenario: Edit booking plan without input entrance
    Given Edit booking plan valid id without input entrance
    When Send request put edit booking plan
    Then Should return 201 Created
    And Should return body contain message "success edit booking plan"
    And Assert json schema edit booking plan without input entrance

  Scenario: Edit booking plan without input ticket
    Given Edit booking plan valid id without input ticket
    When Send request put edit booking plan
    Then Should return 201 Created
    And Should return body contain message "success edit booking plan"
    And Assert json schema edit booking plan without input ticket

  Scenario: Edit booking plan without input ranger
    Given Edit booking plan valid id without input ranger
    When Send request put edit booking plan
    Then Should return 201 Created
    And Should return body contain message "success edit booking plan"
    And Assert json schema edit booking plan without input ranger

  Scenario: Edit booking plan without input status
    Given Edit booking plan valid id without input status
    When Send request put edit booking plan
    Then Should return 201 Created
    And Should return body contain message "success edit booking plan"
    And Assert json schema edit booking plan without input status

  Scenario: Edit booking plan without input body request
    Given Edit booking plan valid id without input body request
    When Send request put edit booking plan
    Then Should return 400 Bad Request
    And Should return body contain message "an invalid client request."