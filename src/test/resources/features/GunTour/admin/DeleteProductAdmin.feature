Feature: Delete Product
  Background: Login Admin
    Given set post login with body json
    When send request post login admin
    Then API should return 202 accepted
    And API send token to dynamic variable
    And assert token not 0
    Given set post valid request body to json data
    When send request post add new product
    Then should return 200 ok
    And post add new product json schema
    And API send productID to dynamic variable
    And assert productID not 0

  @positive @admin-027
  Scenario: Delete product with valid product id
    Given set path to delete product from id "productID"
    When send request delete product
    Then response should return 200 ok
    And delete product json schema validator

  @negative @admin-028
  Scenario Outline: Delete product with unregistered product id
    Given set path to delete product <id_product>
    When send request delete product
    Then should return 404 not found
    And response body should contain message "data not found."
    And delete product invalid json schema validator
    Examples:
    |id_product|
    |9999|

  @negative @admin-029
  Scenario Outline: Delete product with invalid string product id
    Given set path to delete product with invalid id "<id_product>"
    When send request delete product
    Then should return 400 bad request
    And response body should contain message "invalid id"
    And delete product invalid json schema validator
    Examples:
      |id_product|
      |satu|
      |@$%^|
