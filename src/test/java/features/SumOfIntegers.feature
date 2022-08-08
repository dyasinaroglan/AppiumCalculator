Feature: Calculator functionality

  Scenario: Sum of two number in calculator
    Given user on start page
    When user sum the following numbers
    |1|
    |2|
    |3|
    Then the result should be 6