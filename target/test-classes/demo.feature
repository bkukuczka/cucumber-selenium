Feature: Title display

  Scenario: User enters the sub-page women and see title

    Given website loads
    When user clicks woman sub-page button
    Then title exist in sub-page
