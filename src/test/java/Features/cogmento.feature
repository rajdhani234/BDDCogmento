Feature: EndToEnd Cogmento Functionality

  Scenario: Validate login page functionality
    Given user is on login page
    When user enters valid username and password
    Then user click on login button

  Scenario: Validate Home Page Functionality
    Then user validate home page Title
    And user validate logo
    And user validate home page URL

  Scenario: Validate Contact page Functionality
    When user click on contact link
    And click on create button
    And Enter first name, last name , email, select status
    Then click on save button
    And delete the contact

  Scenario: Validate logout Functionality
    When user click on profile icon
    And click on logout
    Then user will logout from application
