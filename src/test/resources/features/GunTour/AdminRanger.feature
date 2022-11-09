Feature: admin ranger valid id

    Background:
      Given get ranger applied ranger list
      When send request get applied ranger list
      And API send dynamic ID to variable
      And API should return code 200 OK


    Scenario: put status apply ranger with valid id and accepted body
      Given admin update status ranger to accepted
      When send request put update ranger
      And API should return code 202 ACCEPTED
      And assert ID not 0
      Then put update ranger json schema validator


    Scenario: put status apply ranger with valid id and no body request
      Given admin update status ranger without body 48
      When send request put update ranger
      And API should return code 400 BAD REQUEST
      And assert ID not 0


    Scenario: put status apply ranger valid id and rejected body
      Given admin update status ranger to rejected
      When send request put update ranger
      And API should return code 202 ACCEPTED
      And assert ID not 0
      Then put update ranger json schema validator