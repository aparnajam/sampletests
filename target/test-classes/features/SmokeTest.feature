Feature: Smoke Tests

  @full_regression
  Scenario: User accesses online ordering
    Given User goes to homepage
    And   click orderonline button
    Then  user should be redirected to ordering site
