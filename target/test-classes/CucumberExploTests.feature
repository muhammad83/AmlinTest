Feature: Exploratory Tests for Amlin Pensions Delay Calculator Page

  @TestCase1
  Scenario: Check Reset Button resets all fields
    Given I have provided all the details on the Pensions Delay Calculator form
    When I click on "Reset" button.
    Then I should see all the fields reset to 0

  @TestCase2
  Scenario: Check Update button is updating Results section
    Given I have provided all the details on the Pensions Delay Calculator form
    When I click "Update" button
    Then the “Tax relief from the taxman”, “Your contribution” fields and “Results” section apart from “If you delay starting your pension by” field of the page should display calculated values.

  @TestCase3
  Scenario: Check Update button is updating Results section
    Given I have provided all the details on the Pensions Delay Calculator form
    When I update “Year you were born” field
    And I click on "Update" button.
    Then I should see the “Results” section of the page with updated results.

  @TestCase4
  Scenario: Check Update button is updating Results section 2
    Given I have provided all the details on the Pensions Delay Calculator form
    When I update “Retirement age” field
    And I click on "Update" button
    Then I should see the “Results” section of the page with updated results.

  @TestCase5
  Scenario: Check Update button is updating Results section 3
    Given I have provided all the details on the Pensions Delay Calculator form
    When I update “Annual salary before tax (£)” field
    And I click on "Update" button
    Then I should see the “Results” section of the page with updated results.

  @TestCase6
  Scenario: Check Update button is updating Results section 4
    Given I have provided all the details on the Pensions Delay Calculator form
    When I update “Gross pension contribution (£)” field
    And I click on "Update" button
    Then I should see the “Results” section of the page with updated results.

  @TestCase7
  Scenario: Check Update button is updating Results section 5
    Given I have provided all the details on the Pensions Delay Calculator form
    When I update “If you delay starting your pension by” field
    And I click on "Update" button
    Then I should see the “Your total delayed pension pot could be” and “Delayed annual pension in real terms” fields with updated results.

  @TestCase8
  Scenario: Non numeric values response
    Given I have provided non numeric values for all the fields
    When I click on "Update" button
    Then I should get “NaN” in the Results sections of the page.

  @TestCase9
  Scenario: Negative values behaviour
    Given I have provided negative values for “Year you were born” and “Retirement age”.
    When I click on "Update" button
    Then I should get “NaN” in the Results sections of the page.

  @TestCase10
  Scenario: Check year of birth with 2 digits
    Given I have provided 2 digits for “Year you were born”
    When I click on "Update" button
    Then I should get “NaN” in the Results sections of the page.

  @TestCase11, @run
  Scenario: Check Yearly dropdown option
    Given I have provided all the details and selected “Gross pension contribution” drop down option as “Yearly”
    When I click on "Update" button
    Then I should get the “Results” page calculations done with yearly contribution.

  @TestCase12
  Scenario: Negative values behaviour
    Given I have provided correct values for “Year you were born”,“Retirement age” fields
    And negative values for “Annual salary before tax (£)”,“Gross pension contribution (£)”
    When I click on “Update” button
    Then I should get “NaN” in the Results sections of the page.

  @TestCase13
  Scenario: Negative value in delay pensions field
    Given I have provided correct values for “Year you were born”,“Retirement age”. “Annual salary before tax (£)”,“Gross pension contribution (£)” fields
    And negative value for “If you delay starting your pension by”
    When I click on “Update” button
    Then I should get “NaN” in the Results fields “Your total delayed pension pot could be” and “Delayed annual pension in real terms”

  @TestCase14
  Scenario: Change focus
    Given I have provided all the details on the Pensions Delay Calculator form
    When I focus out of all the entered fields.
    Then I should get the “Results” section calculations.

  @TestCase15
  Scenario: Year of birth and retirement age relation
    Given I provide “Year you were born” field with values which calculate the “Retirement age” field greater than my current age.
    When I click on “Update” button
    Then I should get “NaN” in the Results sections of the page.

  @TestCase16
  Scenario: Delay pension and retirement age relation
    Given I have provided all the details on the Pensions Delay Calculator form
    And I have provided “If you delay starting your pension by” field with a value greater than the value I provided in the “retirement age”.
    When I click on “Update” button
    Then I should get “NaN” in the Results sections of the page.
