Feature: Get booking ranger
  Background:
    Given User already login as ranger

  @positive @booking
  Scenario: Get booking ranger with all valid value
    Given Get booking ranger with valid path "ranger"
    When Send request get booking ranger
    Then Should return 200 OK
    And Should return body contain message "success get booking ranger"

  @negative @booking
  Scenario Outline: Get booking ranger invalid path with value string
    Given Get booking ranger with invalid path "<path>"
    When Send request get booking ranger
    Then Should return 400 Bad Request
    And Should return body contain message "id booking must integer"
    Examples:
      |path|
      |*$@&)!|
      |rangersr|
      |yt492840|

  @negative @booking
  Scenario: Get booking ranger without authorization
    Given Get booking ranger with valid path "ranger" without authorization
    When Send request get booking ranger
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  @negative @booking
  Scenario: Get booking ranger invalid authorization
    Given Get booking ranger with valid path "ranger" invalid authorization
    When Send request get booking ranger
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"

