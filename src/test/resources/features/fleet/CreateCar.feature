Feature: As user, I want to be able to create new cars

  @add_car @smoke
  Scenario: 1. Add some car
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | SDET |
      | Model Year    | 2021 |
    And user clicks on save and close button

  @add_car_scenario_outline
  Scenario Outline: Add some car for <licence plate> plates and <model year> year
    Given user is on the login page
    And user logs in as a "<role>"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | <license Plate> |
      | Model Year    | <model Year>    |
    And user clicks on save and close button

    Examples: auto test data
      | license Plate | model Year | role          |
      | QA            | 2021       | store manager |
      | RAMAZAN       | 2030       | store manager |
      | SDET          | 1999       | sales manager |