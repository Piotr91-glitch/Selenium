Feature: add new address war1
  Scenario Outline: add new addresses
    Given SetUp
    When user must login
    And the logged in user adds a new address <alias>,<address>,<city>,<zip>,<country>,<phone>
    #Then check if the data is correct
    Then check if the data is correct <alias>,<address>,<city>,<zip>,<country>,<phone>
  And will delete the above address
    And will check if the address has been removed

    Examples:
      | alias    | address    | city   | zip            | country           | phone       |
      | karton91 | Zachlapany | Brudne | 32-050         | United Kingdom    | 502-123-999 |