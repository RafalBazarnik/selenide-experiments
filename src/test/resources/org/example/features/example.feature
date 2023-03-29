Feature: Loop
  Scenario: User logs to application
    Given Loop page is open
    Then Login form is visible
    When User logs as "provider"
    Then User is logged as "Patryk"