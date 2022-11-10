Feature: Add booking plan
  Background: User already login
    Given User already login

  @positive @booking
  Scenario: Add booking plan with all valid value
    Given Add booking plan with all valid value "booking"
    When Send request post add booking plan with all valid body request
    Then Should return 201 Created
    And Should return body contain message "success add booking plan"
    And Assert booking plan json schema validator

  @negative @booking
  Scenario: Add booking plan empty authorization
    Given Add booking plan empty authorization valid path "booking"
    When Send request post add booking plan with all valid body request
    Then Should return 400 Bad Request
    And Should return body contain message "missing or malformed jwt"

  @negative @booking
  Scenario Outline: Add booking plan invalid path with string
    Given Add booking plan with all valid path "<path>" with string
    When Send request post add booking plan with all valid body request
    Then Should return 404 Not Found
    And Should return body contain message "Not Found"
    Examples:
      |  path   |
      |47394    |
      |boooking |
      |bokingg  |
      |#&^#@    |

  @negative @booking
  Scenario: Add booking plan without input start date
    Given Add booking plan without input start date
    When Send request post add booking plan
    Then Should return 400 Bad Request

  @negative @booking
  Scenario: Add booking plan without input end date
    Given Add booking plan without input end date
    When Send request post add booking plan
    Then Should return 400 Bad Request

  @negative @booking
  Scenario: Add booking plan without input entrance gate
    Given Add booking plan without input entrance gate
    When Send request post add booking plan
    Then Should return 400 Bad Request

  @negative @booking
  Scenario: Add booking plan without input number of ticket
    Given Add booking plan without input number of ticket
    When Send request post add booking plan
    Then Should return 400 Bad Request

  @positive @booking
  Scenario: Add booking plan without input any product
    Given Add booking plan without input any product
    When Send request post add booking plan
    Then Should return 201 Created
    And Should return body contain message "success add booking plan"
    And Assert booking plan without input product json schema validator

  @negative @booking
  Scenario: Add booking plan empty request body
    Given Add booking plan without input body request
    When Send request post add booking plan
    Then Should return 400 Bad Request

  @positive @booking
  Scenario: Add booking plan without input ranger
    Given Add booking plan without input ranger
    When Send request post add booking plan
    Then Should return 201 Created
    And Should return body contain message "success add booking plan"

  @negative @booking
  Scenario: Add booking plan invalid authorization
    Given Add booking plan invalid authorization
    When Send request post add booking plan
    Then Should return 401 Unauthorized
    And Should return body contain message "invalid or expired jwt"

  @negative @booking
  Scenario: Add booking plan without input gross amount
    Given Add booking plan without input gross amount
    When Send request post add booking plan
    Then Should return 400 Bad Request