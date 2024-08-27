Feature: User Registration with Phone Number Verification

  Scenario: Successful user registration with phone number and OTP verification
    Given the user is on the registration page
    When the user enters name in the name field
    And the user enters email in the email field
    And the user enters number in the phone Number field
    And the user clicks on the Get opt button
    Then the user should receive an OTP on the provided phone number
    When the user enters the correct OTP in the OTP field
    And the registration should be successful
    Then the user should be redirected to the Welcome page


  Scenario: Attempt to register with empty name, email, phone number, and radio button with UI
    Given the user is on the registration page
    When the user leaves the Name field empty and verify it
    And the user leaves the Email field empty and verify it
    And the user does not select the Yes option on the Receive Updates radio button and verify it
    And verify the text of the button
    Then the user should remain on the registration page



