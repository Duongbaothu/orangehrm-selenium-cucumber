@run
Feature: Add new Employee

  Scenario Outline: Add new Employee
    Given Open "PIM" in main menu
    And Navigate to "Add Employee" page in header menu
    When Input to "firstName" textbox name with value "<firstName>"
    And Input to "lastName" textbox name with value "<lastName>"
    And Remember "Employee Id"
    And Click to "Save" button
    Then Success message "Successfully Saved" displayed
    And wait a second
    And wait a second
    And Verify "firstName" textbox name displays "<firstName>"
    And Verify "lastName" textbox name displays "<lastName>"
    And Verify "Employee Id" textbox text displays "<employeeId>"
    When Navigate to "Employee List" page in header menu
    And Input to "Employee Id" textbox with value "<employeeId>"
    And Click to "Search" button
    Then Verify the column "Id" displays value "<employeeId>"
    And Verify the column "First (& Middle) Name" displays value "<firstName>"
    And Verify the column "Last Name" displays value "<lastName>"

    Examples:
      | firstName | lastName | employeeId |
      | John      | Brown    | 001        |

  Scenario Outline: Update Personal Details for employee
    Given Verify the column "Id" displays value "<employeeId>"
    And Verify the column "First (& Middle) Name" displays value "<firstName>"
    And Verify the column "Last Name" displays value "<lastName>"
    When Click on the "bi-pencil-fill" icon of employee has ID "<employeeId>"
    And The "Personal Details" page will displayed
    Then Verify "firstName" textbox name displays "<firstName>"
    And Verify "lastName" textbox name displays "<lastName>"
    And Verify "Employee Id" textbox text displays "<employeeId>"
    When Input Personal Detail information with data
      | licenseNumber   | licenseExpiryDate   | nationality   | maritalStatus   | dateOfBirth   | gender   |
      | <licenseNumber> | <licenseExpiryDate> | <nationality> | <maritalStatus> | <dateOfBirth> | <gender> |
    And Click to Save button of "Personal Details"
    Then Success message "Successfully Updated" displayed
    And wait a second
    And Personal Detail information displayed correct as input
      | licenseNumber   | licenseExpiryDate   | nationality   | maritalStatus   | dateOfBirth   | gender   |
      | <licenseNumber> | <licenseExpiryDate> | <nationality> | <maritalStatus> | <dateOfBirth> | <gender> |

    Examples: Personal Detail information
      | firstName | lastName | employeeId | licenseNumber | licenseExpiryDate | nationality | maritalStatus | dateOfBirth | gender |
      | John      | Brown    | 001        | D08954796     | 2024-01-03        | American    | Married       | 1998-03-02  | Male   |

  Scenario Outline: Upload Avatar for employee
    Given Click to Avatar picture
    And The "Change Profile Picture" page will displayed
    When Upload Avatar picture "<avatar>"
    Then Avatar picture "<avatar>" loaded successfully
    When Click to "Save" button
    Then Success message "Successfully Updated" displayed
    And wait a second

    Examples:
      | avatar      |
      | image01.jpg |

  Scenario Outline: Update Contact Details for employee
    Given Navigate to "Contact Details" page in header menu
    And The "Contact Details" page will displayed
    When Input Contact Detail information with data
      | street1   | city   | stateOrProvince   | zipOrPostalCode   | country   | mobile   | workEmail   |
      | <street1> | <city> | <stateOrProvince> | <zipOrPostalCode> | <country> | <mobile> | <workEmail> |
    And Click to "Save" button
    Then Success message "Successfully Updated" displayed
    And wait a second
    And Contact Detail information displayed correct as input
      | street1   | city   | stateOrProvince   | zipOrPostalCode   | country   | mobile   | workEmail   |
      | <street1> | <city> | <stateOrProvince> | <zipOrPostalCode> | <country> | <mobile> | <workEmail> |

    Examples: Contact Details information
      | street1            | city   | stateOrProvince | zipOrPostalCode | country       | mobile       | workEmail |
      | 2406 Valley Street | Camden | New Jersey      | 08102           | United States | 856-898-7280 | johnBrown |

  Scenario Outline: Update Emergency Contacts for employee
    Given Navigate to "Emergency Contacts" page in header menu
    And Click to "Add" button of label "Assigned Emergency Contacts"
    And The "Save Emergency Contact" page will displayed
    When Input Emergency Contacts information with data
      | emergencyContactName   | emergencyRelationship   | emergencyContactMobile   |
      | <emergencyContactName> | <emergencyRelationship> | <emergencyContactMobile> |
    And Click to "Save" button
    Then Success message "Successfully Saved" displayed
    And wait a second
    And Emergency Contacts information displayed correct as input
      | emergencyContactName   | emergencyRelationship   | emergencyContactMobile   |
      | <emergencyContactName> | <emergencyRelationship> | <emergencyContactMobile> |

    Examples: Emergency Contacts information
      | emergencyContactName | emergencyRelationship | emergencyContactMobile |
      | Anna Faris           | Wife                  | 678-399-4725           |

  Scenario Outline: Update Dependents for employee
    Given Navigate to "Dependents" page in header menu
    And Click to "Add" button of label "Assigned Dependents"
    And The "Add Dependent" page will displayed
    When Input to "Name" textbox with value "<dependentName>"
    And Select item "<dependentRelationship>" in dropdown "Relationship"
    And Input to "Date of Birth" textbox with value "<dependentDateOfBirth>"
    And Click to "Save" button
    Then Success message "Successfully Saved" displayed
    And wait a second
    And Verify the table "<tableName>" - column "Name" displays value "<dependentName>"
    And Verify the table "<tableName>" - column "Relationship" displays value "<dependentRelationship>"
    And Verify the table "<tableName>" - column "Date of Birth" displays value "<dependentDateOfBirth>"

    Examples:
      | dependentName | dependentRelationship | dependentDateOfBirth | tableName           |
      | Rosy Brown    | Child                 | 2022-07-04           | Assigned Dependents |

  Scenario Outline: Update Immigration for employee
    Given Navigate to "Immigration" page in header menu
    And Click to "Add" button of label "Assigned Immigration Records"
    And The "Add Immigration" page will displayed
    When Input Immigration information with data
      | documentType   | docNumber   | issuedDate   | expiryDate   | issuedBy   | eligibleReviewDate   |
      | <documentType> | <docNumber> | <issuedDate> | <expiryDate> | <issuedBy> | <eligibleReviewDate> |
    And Click to "Save" button
    Then Success message "Successfully Saved" displayed
    And wait a second
    And Immigration information displayed correct as input
      | documentType   | docNumber   | issuedDate   | expiryDate   | issuedBy   | eligibleReviewDate   |
      | <documentType> | <docNumber> | <issuedDate> | <expiryDate> | <issuedBy> | <eligibleReviewDate> |

    Examples:
      | documentType | docNumber | issuedDate | expiryDate | issuedBy      | eligibleReviewDate |
      | Passport     | 422016774 | 2017-24-12 | 2027-23-12 | United States | 2023-23-12         |

