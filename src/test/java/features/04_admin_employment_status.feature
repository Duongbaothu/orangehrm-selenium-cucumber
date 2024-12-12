Feature: Add new Employment Status

  Scenario: Add new Employment Status fail when input empty data
    Given Open "Admin" in main menu
    And Navigate to "Employment Status" page in header menu "Job"
    When Click to "Add" button
    And Click to "Save" button
    Then Error Message "Required" displayed under "Name" textbox

  Scenario Outline: Add new Employment Status successfully
    Given Open "Admin" in main menu
    And Navigate to "Employment Status" page in header menu "Job"
    When Click to "Add" button
    And Input to "Name" textbox with value "<employmentStatusName>"
    And Click to "Save" button
    Then Success message "Successfully Saved" displayed
    And wait a second
    And The column "Employment Status" will display value "<employmentStatusName>"

    Examples:
      | employmentStatusName |
      | full-time            |
