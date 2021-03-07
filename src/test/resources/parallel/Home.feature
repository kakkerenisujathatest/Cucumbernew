Feature: Account feature page

Background:
Given user had already logged in to application
|username|password|
|vuduthasujatha@yahoo.com|Honey2003|

Scenario: Accounts page title
Given user is  on Account page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Accounts section count
Given user is  on Account page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|

And accounts section count  should be 6
