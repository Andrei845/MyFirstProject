Feature: Add new address in Address Book and do checkout using the new address

  Scenario: User is on home page
    Given Home page is loaded, window is maximized and pop-ups are closed
    When User clicks on the Sign in/Register link
    Then Sign in/Register page is loaded
    When User types valid username, "andreiungureanu854" and password, "Pearson854"
    And User clicks on the sign in button
    Then Home page is loaded
    And User clicks on My Account button
    And User clicks on Address Book link
    Then Address book page is loaded
    And User deletes any addresses present here, if any
    And User clicks on Add Address link
    Then Add Address page is loaded
    And Address Form is displayed
    And User chooses "United States" from Country dropdown
    And User chooses "PHD" from Title dropdown
    And User types "Andrei" in the First name input field
    And User types "Ungureanu" in the Last name input field
    And User types "Street 21" in the field Street address
    And User types "Apartment 22" in the field Apartment
    And User types "Phoenix" in the input field City
    And User chooses "Arizona" from State/Province dropdown
    And User types "85006" in the Zip Code input field
    And User types "andreiungureanu854@gmail.com" in the input field Email address(optional)
    And User types phone number "201-555-0123 " in the field Phone number(optional)
    And User clicks on Save button
    Then Address book page is loaded



