Feature: Ranger

  @fauzan @ranger
  Scenario: post ranger with valid body
    Given user apply as ranger with valid data
    When send request post ranger
    Then API should return code 201 CREATED
#    And post ranger json schema validator


  @fauzan @ranger
  Scenario: post ranger without fullname
    Given user apply as ranger without fullname
    When send request post ranger
    Then API should return code 400 BAD REQUEST
    And post ranger invalid json schema validator


  @fauzan @ranger
  Scenario: post ranger without ttl
    Given user apply as ranger without ttl
    When send request post ranger
    Then API should return code 400 BAD REQUEST
    And post ranger invalid json schema validator


  @fauzan @ranger
  Scenario: post ranger without address
    Given user apply as ranger without address
    When send request post ranger
    Then API should return code 400 BAD REQUEST
    And post ranger invalid json schema validator


  @fauzan @ranger
  Scenario: post ranger without phone
    Given user apply as ranger without phone
    When send request post ranger
    Then API should return code 400 BAD REQUEST
    And post ranger invalid json schema validator


  @fauzan @ranger
  Scenario: post ranger without gender
    Given user apply as ranger without gender
    When send request post ranger
    Then API should return code 400 BAD REQUEST
    And post ranger invalid json schema validator


  @fauzan @ranger
  Scenario: post ranger without docs
    Given user apply as ranger without docs
    When send request post ranger
    Then API should return code 400 BAD REQUEST
    And post ranger invalid json schema validator


  @fauzan @ranger
  Scenario: post ranger with invalid parameter
    Given user apply as ranger with valid data
    When send request post ranger with invalid parameter
    Then API should return code 404 NOT FOUND


  @fauzan @ranger
  Scenario: post ranger without parameter
    Given user apply as ranger with valid data
    When send request post ranger without parameter
    Then API should return code 404 NOT FOUND


  @fauzan @ranger
  Scenario Outline: get ranger with valid data format
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger
    Then API should return code 200 OK
#    And get ranger json schema validator
    Examples:
    |date_start|date_end|
    |1945-08-17|2045-08-17|
    |2001-09-11|2022-09-11|


  @fauzan @ranger
  Scenario Outline: get ranger with invalid data format
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger
    Then API should return code 400 BAD REQUEST
    And get ranger invalid json schema validator
    Examples:
      |date_start|date_end|
      |17-08-1945|17-08-1945|
      |11-09-2001|11-09-2022|


  @fauzan @ranger
  Scenario Outline: get ranger without date of month
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger
    Then API should return code 400 BAD REQUEST
    And get ranger invalid json schema validator
    Examples:
      |date_start|date_end|
      |1945-08-|2045-08-|
      |2001-09-|2022-09-|


  @fauzan @ranger
  Scenario Outline: get ranger without month
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger
    Then API should return code 400 BAD REQUEST
    And get ranger invalid json schema validator
    Examples:
      |date_start|date_end|
      |1945--17|2045--17|
      |2001--11|2022--11|


  @fauzan @ranger
  Scenario Outline: get ranger without year
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger
    Then API should return code 400 BAD REQUEST
    And get ranger invalid json schema validator
    Examples:
      |date_start|date_end|
      |-08-17|-08-17|
      |-09-11|-09-11|


  @fauzan @ranger
  Scenario Outline: get ranger without input anything
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger
    Then API should return code 400 BAD REQUEST
    And get ranger invalid json schema validator
    Examples:
      |date_start|date_end|
      |--|--|
      |--|--|


  @fauzan @ranger
  Scenario Outline: get ranger with invalid parameter
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger with invalid parameter
    Then API should return code 404 NOT FOUND
    Examples:
      |date_start|date_end|
      |1945-08-17|2045-08-17|
      |2001-09-11|2022-09-11|


  @fauzan @ranger
  Scenario Outline: get ranger without parameter
    Given user get ranger list with date format "<date_start>" "<date_end>"
    When send request get ranger without parameter
    Then API should return code 404 NOT FOUND
    Examples:
      |date_start|date_end|
      |1945-08-17|2045-08-17|
      |2001-09-11|2022-09-11|