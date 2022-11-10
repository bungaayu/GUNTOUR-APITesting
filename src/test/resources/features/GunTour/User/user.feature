Feature: User Register
  Background: User already login
    Given Post login user update with valid json file
    When Send request post update login user
    Then API response status login user update code should be 202 accepted
    And Get auth token
    And Auth token not null

  @UserPost
  Scenario: Post register user with all valid data
    Given Post register user with valid json file
    When Send request post register user
    Then API response status code should be 201 created

  @UserPost
  Scenario: Post Register without full name
    Given Post register user without full name in json file
    When Send request post register user
    Then API response status code should be 400 bad request

  @UserPost
  Scenario: Post Register without email
    Given Post register user without email in json file
    When Send request post register user
    Then API response status code should be 400 bad request

  @UserPost
  Scenario: Post Register without password
    Given Post register user without password in json file
    When Send request post register user
    Then API response status code should be 400 bad request

  @UserPost
  Scenario: Post Register without all data
    Given Post register user without all data in json file
    When Send request post register user
    Then API response status code should be 400 bad request

  @UserPost
  Scenario: Post Register with invalid parameter
    Given Post register user with valid json file
    When Send request post register user invalid path
    Then API response status code should be 404 not found

  @UserPut
  Scenario: Update user with all valid data on json file
    Given Set request update user with all valid data
    When Send request update user
    Then API response status code should be 202 Accepted

  @UserDelete
  Scenario: Delete user with already registered
    Given Set request delete user with already registered
    When Send request delete user valid path
    Then API response status code should be 200 ok
