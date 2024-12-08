@run
Feature: Login to OrangeHRM site

  Scenario: Log into to OrangeHRM site as Admin role successfully
    Given Open the application URL
    When Log into OrangeHRM site as Admin role
    Then The "Dashboard" page will displayed
