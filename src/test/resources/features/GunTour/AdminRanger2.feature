Feature: admin ranger invalid id


    Scenario Outline: put status apply ranger with invalid id and accepted body
      Given admin update status ranger to accepted <id>
      When send request put update ranger
      And API should return code 400 BAD REQUEST
      Then put update ranger invalid json schema validator
      Examples:
        |id|
        |9999999  |
        |123456   |
        |12335678 |


    Scenario: put status apply ranger with no id and accepted body
      Given admin update status ranger to accepted with no id
      When send request put update ranger with no id
      And API should return code 405 METHOD NOT ALLOWED
      Then put update ranger invalid json schema validator



    Scenario Outline: put status apply ranger with invalid id and no body request
      Given admin update status ranger with invalid body <id>
      When send request put update ranger
      And API should return code 400 BAD REQUEST
      Examples:
        |id|
        |9999999  |
        |123456   |
        |12335678 |


    Scenario Outline: put status apply ranger with invalid id and rejected body
      Given admin update status ranger to accepted <id>
      When send request put update ranger
      And API should return code 400 BAD REQUEST
      Then put update ranger invalid json schema validator
      Examples:
        |id|
        |9999999  |
        |123456   |
        |12335678 |


    Scenario: put status apply ranger with no id and rejected body
      Given admin update status ranger to rejected with no id
      When send request put update ranger with no id
      And API should return code 405 METHOD NOT ALLOWED
      Then put update ranger invalid json schema validator