Feature: User changes the qualification level by editing the fields on the page

  Scenario: User has Qualification level "A"
    Given Home page is loaded, window is maximized and pop-ups are closed
    When User clicks on the Sign in link
    Then Sign in/Register page is loaded
    When User types valid username, "andreiungureanu854" and password, "Pearson854"
    And User clicks on the sign in button
    Then Home page is loaded
    When User clicks on My Account button
    And User clicks on Qualifications link
    Then Qualifications page is loaded accordingly
    And User clicks on Edit button from "Degree" section
    And User closes the feedback pop-up
    And User chooses "Doctor Of Education" from Degree dropdown
    And User types "Education" in the Major/Field input field
    And User types "University ABC" in the Institution input field
    