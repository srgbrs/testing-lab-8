@ApiTests
Feature: Api testing with help of Cucumber

  Scenario: Get users by route
    Given route is "users"
    When user try to get order by id
    Then user receive status code 200
    And response don't equal zero


  Scenario: Get users by route FAIL
    Given route is "pages"
    When user try to get order by id
    Then user receive status code 200
    And response don't equal zero
