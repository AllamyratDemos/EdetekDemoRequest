Feature: Request a demo

  Scenario: user navigates to request demo window
    Given user is on Home page
    When user clicks on Request a Demo button on Home page
    Then request demo form should be displayed
  @demo
# A happy path
  Scenario: user is able to request a demo
    Given user is on request a demo form window
    When user fills in all required fields
    Then user should be able to click on A Request a Demo button
    And system should display successful message

  # a negative scenario
  Scenario: user doesn't fill in any of required fields
    Given user is on request a demo form window
    When  user clicks on A Request a Demo button
    Then system should display error message to fill all the required fields

  # Scenarios can be written for each incomplete required field or other combinations to validate the error message,
  # following is one example
  Scenario: user doesn't fill in all the required fields
    Given user is on request a demo form window
    When user fills in only a name field
    And user clicks on A Request a Demo button
    Then system should display error message to fill the required fields

# a lot of validation test cases can be written if requirements are give,
#followings are some examples I could figure out
  Scenario Outline: user enters a valid phone number in Contact Phone Field
    Given user is on request a demo form window
    When user fills in all required fields
    And user enters "<phoneNumber>" in Contact Phone field
    Then user clicks on A Request a Demo button
    And system should display successful message
  Examples:
    |phoneNumber         |
    |123456789           |
    | 6                  |
    |+178940026112       |
    |+(178)940026112     |
    |(178)-940-026-112   |
    |012 345 6789        |


    # a lot of validation test cases can be written if requirements are give,
    #followings are some examples I could figure out
  Scenario Outline: user enters an invalid phone number in Contact Phone Field
    Given user is on request a demo form window
    When user fills in all required fields
    And user enters "<phoneNumber>" in Contact Phone field
    Then user clicks on A Request a Demo button
    And system should display error message for input phone number
  Examples:
      |phoneNumber         |
      |123456789+          |
      |number              |
      |12ab56789           |
      |x                   |

