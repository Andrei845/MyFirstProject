Feature: Sing in and add proceed to checkout with two different products from Store having qualification level "C"

  Scenario: User is on the home page
    Given Home page is loaded, window is maximized and pop-ups are closed
    When User clicks on the Sign in/Register link
    Then Sign in/Register page is loaded
    When User types valid username, "andreiungureanu854" and password, "Pearson854"
    And User clicks on the sign in button
    Then Home page is loaded
    And User clicks on the link Store
    Then Store page is loaded
    When User clicks on ABAS program link
    Then The program page is displayed
    And User closes the feedback pop-up
    When User adds a product in the cart
    Then The pop-up Add to cart is displayed
    When User clicks X from the pop-up
    Then The pop-up Add to cart is closed
    And User adds a second product in the cart
    Then The pop-up Add to cart is displayed
    When Click on View cart from the pop-up Add to cart
    Then Check if According page is loaded
    When User clicks on the Checkout button
    Then Accounts for checkout page is loaded
    When User clicks on My Account radio button
    And User clicks on the button Continue
    Then Secure checkout page is loaded
    When User clicks on the Add a new address radio button
    Then The form address Form is displayed
    And User clicks on "Aruba" from Country dropdown
    And User clicks on the dropdown Title(optional)
    And User clicks on PHD from Title(optional) dropdown
    And User clicks on the input field First name and types "Andrei"
    And User clicks on the input field Last name and types "Ungureanu"
    And User clicks on the input field Street address and types "Street 21"
    And User clicks on the input field City and types 'Buenos Aires'
#    And User chooses an option from State/Province dropdown
    And User types "B17654" in the Postal Code input field
    And User clicks on the input field Email address(optional) and types "andreiungureanu854@gmail.com"
    And User types valid phone number "9 11 4565-6468" in the field Phone number(optional)
    And User clicks on Next button from the form addressForm
    And User clicks on the Next button
    And User types valid details in the form Payment and billing
    And User checks the checkbox privacy policy and terms of use
    Then The button Place order becomes enabled








