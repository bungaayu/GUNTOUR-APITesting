Feature: Add new product by Admin
  Background: Login Admin
    Given set post login with body json
    When send request post login admin
    Then API should return 202 accepted
    And API send token to dynamic variable
    And assert token not 0

  @positive @Admin-013
  Scenario: Post add new product with valid request body
    Given set post valid request body to json data
    When send request post add new product
    Then should return 200 ok
    And post add new product json schema
    And API send productID to dynamic variable
    And assert productID not 0

  @negative @Admin-014
  Scenario: Post add new product with empty request body
    Given set post empty request body to json data
    When send request post add new product
    Then should return 400 bad request
    And post new product with invalid body json schema

  @negative @Admin-015
  Scenario: Post add new product with incomplete request body
    Given set post incomplete request body to json data
    When send request post add new product
    Then should return 400 bad request
    And post new product with invalid body json schema

  @negative @Admin-016
  Scenario: Post add new product with invalid request body
    Given set post invalid request body to json data
    When send request post add new product
    Then should return 400 bad request
    And post new product with invalid body json schema