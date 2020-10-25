@Login

Feature: As user I want to be able to login under different roles
# this is a comment
  #Backround - test pre=conditions
  # will be excuted before every snerio in the particular feature file

  Background: common steps
    Given user is on the landing


  Scenario: Login as a sales manger
    When user logs in
    Then user should see dashboard page

  @parametrized_test @BUG_VYT3242
  Scenario: Parametrized login
    When user logs in as a "store manager"
    Then user should see dashboard page

  @negative_login
  Scenario: Invalid password
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

