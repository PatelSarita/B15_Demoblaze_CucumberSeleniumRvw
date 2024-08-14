@wip
Feature: The user should be able to place order from web page

  Background:
    Given The user navigates to website


  Scenario: Placing a successfully order
    When The user clicks on login button and enters "JhonyQ" and "Test1234"
    And The user adds "Samsung galaxy s7" product from "Phones" category
    And The user adds "Sony vaio i5" product from "Laptops" category
    And The user adds "MacBook Pro" product from "Laptops" category
    And The user adds "Apple monitor 24" product from "Monitors" category
    And The user removes "Sony vaio i5" chosen product from Cart page
    And The user places order and capture and log amount
    Then The user verifies purchase amount

  Scenario Outline: Placing a successfully order with different product
    When The user clicks on login button and enters "<username>" and "<password>"
    And The user adds following products  from related category to the cart and return Home page
      | firstColumn | secondColumn |
      | Phones      | <phone>      |
      | Laptops     | <laptop1>    |
      | Laptops     | <laptor2>    |
      | Monitors    | <monitor>    |
    And The user removes "<laptop1>" chosen product from "Cart" page
    And The user places order and capture and log amount
    Then The user verifies purchase amount
    Examples:
      | username | password | phone             | laptop1     | laptor2             | monitor      |
      | JhonyQ   | Test1234 | Samsung galaxy s6 | MacBook air | 2017 Dell 15.6 Inch | ASUS Full HD |