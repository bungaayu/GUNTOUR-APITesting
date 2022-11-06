Feature: Edit booking plan
  Scenario: Edit booking plan with all valid value
    Given Edit booking plan with all valid value
    When Send request put edit booking plan
    Then Should return 202 Accepted

  Scenario: Edit booking plan invalid id with string
    Given Edit booking plan with invalid id "<id>"
    When Send request put edit booking plan
    Then Should return 404 Not Found

