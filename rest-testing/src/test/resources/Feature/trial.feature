Feature: Trial Testing a REST API
  Users should be able to submit GET and POST requests to a web service, represented by WireMock

  @posttrial
  Scenario: Trial Data Upload to a web service
    When users upload data on a project
    Then the server should handle it and return a success status

  Scenario: Trial Data retrieval from a web service
    When users want to get information on the 'Cucumber' project
    Then the requested data is returned

  @getTrial
  Scenario Outline: Get method
    Given users send request with GET method for "<several>"
    When initiate browser
    And navigates to the web page based on "<several>" data
    Then the list is displayed
    When initiate browser
    And navigates to another web page
    Then the element is displayed
    Examples:
    | several |
    | 1       |
    | all     |
