Feature: Login User
  #Bisa Diganti User Atau Ranger
  @Login
  Scenario: Post login user with valid email & valid password
    Given Post login user with valid json file
    When Send request post login user
    Then API response status code should be 202 accepted

  @Login
  Scenario: User Login with valid email & invalid password
    Given Post login user with invalid password json file
    When Send request post login user
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: User Login with invalid email & valid password
    Given Post login user with invalid email json file
    When Send request post login user
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: User Login with invalid email & invalid password
    Given Post login user with invalid email & invalid password
    When Send request post login user
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: User Login without email
    Given Post login user without email
    When Send request post login user
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: User Login without password
    Given Post login user without password
    When Send request post login user
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: User Login without email & password
    Given Post login user without email & password
    When Send request post login user
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: User Login with invalid path
    Given User Login with invalid path
    When Send request post login user invalid path
    Then API response status code should be 404 Not Found

  #Admin
  @Login
  Scenario: Post login admin with valid email & valid password
    Given Post login admin with valid json file
    When Send request post login admin
    Then API response status code should be 202 accepted

  @Login
  Scenario: Admin Login with valid email & invalid password
    Given Post login Admin with invalid password json file
    When Send request post login admin
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: Admin Login with invalid email & valid password
    Given Post login admin with invalid email json file
    When Send request post login admin
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: Admin Login with invalid email & invalid password
    Given Post login admin with invalid email & invalid password
    When Send request post login admin
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: Admin Login without email
    Given Post login admin without email
    When Send request post login admin
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: Admin Login without password
    Given Post login admin without password
    When Send request post login user
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: Admin Login without email & password
    Given Post login admin without email & password
    When Send request post login admin
    Then API response status code should be 400 Bad Request

  @Login
  Scenario: Admin Login with invalid path
    Given Admin Login with invalid path
    When Send request post login admin invalid path
    Then API response status code should be 404 Not Found