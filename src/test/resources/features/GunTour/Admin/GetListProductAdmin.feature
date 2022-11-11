Feature: Retrieves list product
  Background: Login Admin
    Given set post login with body json
    When send request post login admin
    Then API should return 202 accepted
    And API send token to dynamic variable
    And assert token not 0

  @negative @admin-017
  Scenario: Get list product without parameter
    Given set path to get list product
    When send request get list product
    Then should return 400 bad request
    And response body should contain message "page must integer"
    And get list product invalid json schema validator

  @positive @admin-018
  Scenario Outline: Get list product with valid page parameter
    Given set path to get list product with parameter page <page>
    When send request get list product with page
    Then response should return 200 ok and body page <page>
    And get list product json schema validator
    Examples:
    |page|
    |1   |

  @negative @admin-019
  Scenario Outline: Get list product with unavailable page parameter
    Given set path to get list product with parameter page <page>
    When send request get list product with page
    Then should return 404 not found
    And response body should contain message "page not found."
    And get list product invalid json schema validator
    Examples:
      |page|
      |6666|
      |9999|

  @negative @admin-020
  Scenario Outline: Get list product with invalid string page
    Given set path to get list product with string page "<page>"
    When send request get list product with page
    Then should return 400 bad request
    And response body should contain message "page must integer"
    And get list product invalid json schema validator
    Examples:
      |page|
      |satu|
      |@$%^|
