@web
Feature: As an user I want to select best itenary based on the fastest and cheapest travel

  Scenario: Verify Search results page
    Given User on home page
    When User search with source "LHR" and destination "DOH"
    And User verify title of the search page
    Then User select fastest and cheapest ticket

