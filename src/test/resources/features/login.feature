
Feature: Login Test
  # Agile Story : As a user , I should be able to login with valid credentials
  Background:
    Given The user navigates to website


  Scenario: positive login test 1 without parameter
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message


  Scenario: positive login test 2 with parameter
    When The user clicks on login button and enters "JhonyQ" and "Test1234"
    Then The user verifies welcome message contains "JhonyQ"


  Scenario Outline:  positive login test 3  with scenario outline
    When The user clicks on login button and enters "<username>" and "<password>"
    Then The user verifies welcome message contains "<username>"
    Examples:
      | username | password |
      | JhonyQ   | Test1234 |


  Scenario Outline: positive login test 4  with scenario outline and data table
    When The user clicks on login button and enters following credentials
      | user_name     | <username> |
      | user_password | <password> |
    Then The user verifies welcome message contains "<username>"
    Examples:
      | username | password |
      | JhonyQ   | Test1234 |


  Scenario Outline: Negative Login Test 5
    When The user clicks on login button and enters "<invalid_username>" and "<invalid_password>"
    Then The user verifies invalid access message is "<message>"
    Examples:
      | invalid_username | invalid_password | message                                |
      | JhonyQQQQ        | Test1234         | User does not exist.                   |
      | JhonyQQQQ        | Test1            | User does not exist.                   |
      | JhonyQ           | Test1            | Wrong password.                        |
      |                  | Test1234         | Please fill out Username and Password. |
      | JhonyQ           |                  | Please fill out Username and Password. |
      |                  |                  | Please fill out Username and Password. |
