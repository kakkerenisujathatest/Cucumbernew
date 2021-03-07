Feature: Login page feature notes

Scenario: Login page title
Given user is on logins page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given  user is on logins page
Then forgot your password link should be diaplayed

Scenario: Login with correct  credentials
Given  user is on logins page
When user enters username "vuduthasujatha@gmail.com"
And user enters  password "Honey2003"
Then user clicks on Login button
