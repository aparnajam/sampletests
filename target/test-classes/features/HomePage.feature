Feature: Homepage

  @full_regression
  Scenario: User accesses home page
    Given User goes to homepage
    Then  verify sweetgreen logo is displayed

  @full_regression
  Scenario: Able to access Menu page
    Given User goes to homepage
    Then Verify user is able to access menu page

  @full_regression
  Scenario: Able to access Locations page
    Given User goes to homepage
    Then Verify user is able to access locations page

  @full_regression
  Scenario: Able to access Contact page
    Given User goes to homepage
    Then Verify user is able to access contact page

  @full_regression
  Scenario: Able to access Sweetlife festival page
    Given User goes to homepage
    Then Verify user is able to access festival page

