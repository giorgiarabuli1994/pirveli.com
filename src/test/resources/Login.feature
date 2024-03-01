Feature: Login functionality

  Scenario Outline: Log in with valid credentials
    Given user is on the login page
    And user inserts valid <username> and <password>
    When the user clicks on the login button
    Then the user is redirected to the main page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | visual_user             | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
