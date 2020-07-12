@web
Feature: As an user I want to select best itenary based on the fastest and cheapest travel

  Scenario: Verify Search results page
    Given User on home page
    When User search with source "DOH" and destination "LHR"
    And User verify title of the search page
    Then User select fastest and cheapest ticket

