Feature: Products


  @fauzan @product
  Scenario Outline: get product with valid page
    Given user get product with valid page <page>
    When send request get product
    Then API should return code 200 OK
    And response body should match product json schema validator
    Examples:
    |page|
    |1   |
    |2   |
    |3   |


    @fauzan @product
    Scenario Outline: get product exceeded page limit
      Given user get product with exceeded page limit <page>
      When send request get product
      Then API should return code 404 NOT FOUND
      And response body should match invalid product json schema validator
      Examples:
      |page|
      |11  |
      |12  |
      |13  |
      |14  |
      |15  |
      |16  |
      |17  |
      |18  |
      |19  |
      |20  |

    @fauzan @product
    Scenario Outline: get product with special char.
      Given user get product with special char. "<page>"
      When send request get product
      Then API should return code 400 BAD REQUEST
      And response body should match invalid product json schema validator
      Examples:
      |page|
      |^!@$%|
      |$%%^&*|

    @fauzan @product
    Scenario Outline: get product with decimal
      Given user get product with decimal <page>
      When send request get product
      Then API should return code 400 BAD REQUEST
      And response body should match invalid product json schema validator
      Examples:
      |page|
      |3,14|
      |27,77|
      |13,13|
      |1989,99|

    @fauzan @product
    Scenario Outline: get product with alphabet
      Given user get product with alphabet "<page>"
      When send request get product
      Then API should return code 400 BAD REQUEST
      And response body should match invalid product json schema validator
      Examples:
      |page|
      |ASDFGH|
      |qwerty|
      |uiop|
      |zxcVBN|
      |MNBvzxc|

    @fauzan @product
    Scenario Outline: get product with invalid parameter
      Given user get product with valid page <page>
      When send request get product with invalid parameter
      Then API should return code 404 NOT FOUND
      Examples:
      |page|
      |1   |
      |2   |

      @fauzan @product
    Scenario Outline: get product detail with valid id
       Given user get product detail with valid id <id>
        When send request get product detail
        Then API should return code 200 OK
        And response body should match product detail json schema validator
        Examples:
        |id|
        |40 |
        |68 |
        |77 |
        |81 |

      @fauzan @product
      Scenario Outline: get product detail with invalid id
        Given user get product with invalid id <id>
        When send request get product detail
        Then API should return code 404 NOT FOUND
        And response body should match invalid product detail json schema validator
        Examples:
        |id|
        |9999|
        |1019|
        |2129|
        |1945|
        |2045|

      @fauzan @product
      Scenario Outline: get product detail with special char.
        Given user get product detail with special char. "<id>"
        When send request get product detail
        Then API should return code 400 BAD REQUEST
        And response body should match invalid product detail json schema validator
        Examples:
          |id|
          |^!@$%|
          |$%%^&*|
          |&&%(**(|

      @fauzan @product
      Scenario Outline: get product detail with decimal
        Given user get product detail with decimal <id>
        When send request get product detail
        Then API should return code 400 BAD REQUEST
        And response body should match invalid product detail json schema validator
        Examples:
          |id|
          |3,14|
          |27,77|
          |13,13|
          |1989,99|

      @fauzan @product
      Scenario Outline: get product detail with alphabet
        Given user get product detail with alphabet "<id>"
        When send request get product detail
        Then API should return code 400 BAD REQUEST
        And response body should match invalid product detail json schema validator
        Examples:
          |id|
          |3,14|
          |27,77|
          |13,13|
          |1989,99|

      @fauzan @product
      Scenario Outline: get product detail with invalid parameter
        Given user get product detail with valid id <id>
        When send request get product detail with invalid parameter
        Then API should return code 404 NOT FOUND
        Examples:
          |id|
          |40 |
          |68 |
          |75 |
          |76 |
          |77 |
          |81 |
          |82 |
          |83 |