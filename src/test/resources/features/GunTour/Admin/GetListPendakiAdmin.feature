Feature: Retrieves list pendaki
  Background: Login Admin
    Given set post login with body json
    When send request post login admin
    Then API should return 202 accepted
    And API send token to dynamic variable
    And assert token not 0

  @positive @admin-005
  Scenario: Get list pendaki without parameter
    Given set path to get list pendaki
    When send request get list pendaki
    Then response should return 200 ok
#    And get list pendaki json schema validator

  @negative @admin-006
  Scenario: Get list pendaki with invalid string path
    Given set path to get list pendaki
    When send request get list string pendaki
    Then should return 404 not found
    And response body should contain message "Not Found"
    And get list pendaki invalid json schema validator

  @negative @admin-007
  Scenario: Get list pendaki with invalid special char path
    Given set path to get list pendaki
    When send request get list special char pendaki
    Then should return 404 not found
    And response body should contain message "Not Found"
    And get list pendaki invalid json schema validator

  @negative @admin-008
  Scenario: Get list pendaki with invalid int path
    Given set path to get list pendaki
    When send request get list int pendaki
    Then should return 404 not found
    And response body should contain message "Not Found"
    And get list pendaki invalid json schema validator


