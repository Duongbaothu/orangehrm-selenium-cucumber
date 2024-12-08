
Feature: Add new Job Title

  Scenario: Add new Job Title fail when input empty data
    Given Open "Admin" in main menu
    And Navigate to "Job Titles" page in header menu "Job"
    When Click to "Add" button
    And Click to "Save" button
    Then Error Message "Required" displayed under "Job Title" textbox

  Scenario Outline: Add new Job Title successfully
    Given Open "Admin" in main menu
    And Navigate to "Job Titles" page in header menu "Job"
    When Click to "Add" button
    And Input to "Job Title" textbox with value "<jobTitle>"
    And Upload a file for "<uploadTitle>"
    And Verify file uploaded successfully in "<uploadTitle>"
    And Click to "Save" button
    Then Success message "Successfully Saved" displayed
    And wait a second
    And The column "Job Titles" will display value "<jobTitle>"

    Examples:
      | jobTitle | uploadTitle       |
      | Tester   | Job Specification |
