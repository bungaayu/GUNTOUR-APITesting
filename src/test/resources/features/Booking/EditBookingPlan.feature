Feature: Edit booking plan
  Scenario: Edit booking plan with all valid value
    Given Edit booking plan with all valid value id "3"
    When Send request put edit booking plan
    Then Should return 202 Accepted

  Scenario Outline: Edit booking plan invalid id outside maximum expected value
    Given Edit booking plan with invalid id "<id>"
    When Send request put edit booking plan
    Then Should return 404 Not Found
    Examples:
    |  id  |
    | 827492|
    |8398095|

  Scenario: Edit booking plan without authorization
    Given Edit booking plan without authorization with id "3"
    When Send request put edit booking plan
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  Scenario: Edit booking plan invalid authorization
    Given Edit booking plan invalid authorization with id "3"
    When Send request put edit booking plan
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"

  Scenario: Edit booking plan without input start date
    Given Edit booking plan valid id "3" without input start date
    When Send request put edit booking plan
    Then Should return 202 Accepted
    And Should return body contain message "success edit booking plan"

  Scenario: Edit booking plan without input end date
    Given Edit booking plan valid id "3" without input end date
    When Send request put edit booking plan
    Then Should return 202 Accepted
    And Should return body contain message "success edit booking plan"

  Scenario: Edit booking plan without input entrance
    Given Edit booking plan valid id "3" without input entrance
    When Send request put edit booking plan
    Then Should return 202 Accepted
    And Should return body contain message "success edit booking plan"

  Scenario: Edit booking plan without input entrance
    Given Edit booking plan valid id "3" without input ticket
    When Send request put edit booking plan
    Then Should return 202 Accepted
    And Should return body contain message "success edit booking plan"

  Scenario: Edit booking plan without input entrance
    Given Edit booking plan valid id "3" without input ranger
    When Send request put edit booking plan
    Then Should return 202 Accepted
    And Should return body contain message "success edit booking plan"