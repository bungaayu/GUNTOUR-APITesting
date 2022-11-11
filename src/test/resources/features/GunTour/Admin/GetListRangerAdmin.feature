Feature: Retrieves list ranger
  Background: Login Admin
    Given set post login with body json
    When send request post login admin
    Then API should return 202 accepted
    And API send token to dynamic variable
    And assert token not 0

  @positive @admin-009
  Scenario: Get list ranger without parameter
    Given set path to get list ranger
    When send request get list ranger
    Then response should return 200 ok

  @negative @admin-010
  Scenario: Get list ranger with invalid string path
    Given set path to get list ranger with invalid path
    When send request get list string ranger
    Then should return 404 not found
    And response body should contain message "Not Found"
    And get list ranger invalid json schema validator

  @negative @admin-011
  Scenario: Get list ranger with invalid special char path
    Given set path to get list ranger with invalid path
    When send request get list special char ranger
    Then should return 404 not found
    And response body should contain message "Not Found"
    And get list ranger invalid json schema validator

  @negative @admin-012
  Scenario: Get list ranger with invalid int path
    Given set path to get list ranger with invalid path
    When send request get list int ranger
    Then should return 404 not found
    And response body should contain message "Not Found"
    And get list ranger invalid json schema validator