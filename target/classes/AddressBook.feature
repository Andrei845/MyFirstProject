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
    And User navigates to the Products by Acronym page
    Then Store page is loaded
    When User clicks on "Adaptive Behavior Assessment System | Third Edition (ABAS-3)" program link
    Then The program page is displayed
    And User closes the feedback pop-up
    When User clicks on product tile "All products" and adds the product "0158009177" to the cart
    Then The pop-up Add to cart is displayed
    When User clicks X from the pop-up
    Then The pop-up Add to cart is closed
    And User adds in the cart the product with isbn "0158009169"
    Then The pop-up Add to cart is displayed
    When User clicks on View cart from the pop-up Add to cart
    Then Check if According page is loaded
    And User modifies the quantity of the product with ISBN "0158009177" to "3"
    And User removes the product with ISBN "0158009169" from cart
    When User clicks on the Checkout button
    Then Accounts for checkout page is loaded
    When User clicks on My Account radio button
    And User clicks on the button Continue
    Then Secure checkout page is loaded
    And User types "Phoenix, AZ, 85006" in the search input field
    And User chooses from the results the address that matches "Phoenix, AZ, 85006"
    And User clicks on Next button from the form addressForm
    And User clicks on the Next button
    And User types valid details in the form Payment and billing
    And User checks the checkbox privacy policy and terms of use
    Then The button Place order becomes enabled
    When User clicks on button Back to cart
    Then Check if According page is loaded
    And User removes all the products remained in cart
    And User clicks on My Account button from Cart page
    And User clicks on Address Book link from Cart page
    Then Address book page is loaded
    And User deletes all the addresses containing "Phoenix" on the page




