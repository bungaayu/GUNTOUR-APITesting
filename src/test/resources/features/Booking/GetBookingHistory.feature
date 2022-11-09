Feature: Get booking pendaki history
  Background:
    Given User already login

  Scenario: Get booking pendaki history with all valid value
    Given Get booking pendaki history with valid path "booking"
    When Send request to get booking pendaki history
    Then Should return 200 OK
    And Should return body contain message "success get booking history"

  Scenario Outline: Get booking pendaki history invalid path with string value
    Given Get booking pendaki history invalid path "<path>" with string value
    When Send request to get booking pendaki history
    Then Should return 404 Not Found
    Examples:
      |  path  |
      |bookinghhistory|
      |^*#@)($(|
      |840114  |

  Scenario Outline: Get booking pendaki history invalid path with integer value
    Given Get booking pendaki history invalid path <path> with integer value
    When Send request to get booking pendaki history
    Then Should return 404 Not Found
    Examples:
      |  path  |
      |35355   |
      |4837484 |
  Scenario: Get booking pendaki history without authorization
    Given Get booking pendaki history valid path "booking" empty authorization
    When Send request to get booking pendaki history
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  Scenario: Get booking pendaki history invalid authorization
    Given Get booking pendaki history valid path "booking" invalid authorization
    When Send request to get booking pendaki history
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"