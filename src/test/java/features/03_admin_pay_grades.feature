
Feature: Add new Pay Grades

  Scenario: Add new Pay Grades fail when input empty data
    Given Open "Admin" in main menu
    And Navigate to "Pay Grades" page in header menu "Job"
    When Click to "Add" button
    And Click to "Save" button
    Then Error Message "Required" displayed under "Name" textbox

  Scenario Outline: Add new Pay Grades successfully
    Given Open "Admin" in main menu
    And Navigate to "Pay Grades" page in header menu "Job"
    When Click to "Add" button
    And Input to "Name" textbox with value "<payGrade>"
    And Click to "Save" button
    And wait a second
    And wait a second
    Then Verify "Name" textbox text displays "<payGrade>"
    And Click to "Add" button of label "Currencies"
    And wait a second
    And The "Add Currency" page will displayed
    And Select item "<currency>" in dropdown "Currency"
    And Click to Save button of "Add Currency"
    And wait a second
    And Verify the table Currencies displays value "<currencySelected>" at column "Currency"
    When Navigate to "Pay Grades" page in header menu "Job"
    And The column "Name" will display value "<payGrade>"
    And The column "Currency" will display value "<currencySelected>"

    Examples:
      | payGrade | currency                   | currencySelected     |
      | 1        | USD - United States Dollar | United States Dollar |
