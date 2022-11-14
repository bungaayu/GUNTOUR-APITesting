Feature: Update product
  Background: Login Admin
    Given set post login with body json
    When send request post login admin
    Then API should return 202 accepted
    And API send token to dynamic variable
    And assert token not 0

  @positive @admin-022
  Scenario: Put update product with valid id and json data
    Given set path to put update product from id "id_product"
    When send request put update product
    Then should return 200 ok
    And put update product json schema

  @negative @admin-023
  Scenario Outline: Put update product with unavailable id
    Given set path to put update product unavailable <id_product>
    When send request put update product
    Then should return 400 bad request
    And response body should contain message "an invalid client request."
    And put invalid update product json schema
    Examples:
    |id_product|
    |9999|

  @negative @admin-024
  Scenario: Put update product with valid id and empty json data
    Given set path to put empty product from id "id_product"
    When send request put update product
    Then should return 200 ok
    And put invalid update product json schema

  @negative @admin-025
  Scenario: Put update product with valid id and incomplete json data
    Given set path to put incomplete product from id "id_product"
    When send request put update product
    Then should return 200 ok
    And put invalid update product json schema

  @negative @admin-026
  Scenario: Put update product with valid id and invalid json data
    Given set path to put invalid product from id "id_product"
#    And set put invalid request body json
    When send request put update product
    Then should return 400 bad request
    And put invalid update product json schema
#    Examples:
#      |id_product|
#      |40|






#  @positive @admin-022
#  Scenario Outline: Put update product with valid id and json data
#    Given set path to put update product with <id_product>
#    And set request body put
#    When send request put update product
#    Then should return 200 ok
#    And put update product json schema
#    Examples:
#      |id_product|
#      |40|