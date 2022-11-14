Feature: Add total pendaki by Admin
  Background: Login Admin
    Given set post login with body json
    When send request post login admin
    Then API should return 202 accepted
    And API send token to dynamic variable
    And assert token not 0

  @positive @Admin-001
  Scenario: Post add total pendaki with valid request body
    Given set post pendaki with valid request body to json data
    When send request post add total pendaki
    Then should return 201 created
    And post add total pendaki json schema
    And assert pendakiID not 0

  @negative @Admin-002
  Scenario: Post add total pendaki with invalid request body
    Given set post pendaki with invalid request body to json data
    When send request post add total pendaki
    Then should return 400 bad request
    And post total pendaki with invalid body json schema

  @negative @Admin-003
  Scenario: Post add total pendaki with empty request body
    Given set post pendaki with empty request body to json data
    When send request post add total pendaki
    Then should return 400 bad request
    And post total pendaki with invalid body json schema

  @negative @Admin-004
  Scenario: Post add total pendaki with incomplete request body
    Given set post pendaki incomplete request body to json data
    When send request post add total pendaki
    Then should return 400 bad request
    And post total pendaki with invalid body json schema

