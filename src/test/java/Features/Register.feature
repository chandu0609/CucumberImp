Feature: Rahul Shetty Login Page Test #https://rahulshettyacademy.com/client/#/auth/register
Scenario Outline: User Enter Details to Register

Given User navigates to Home Page
And Clicks On Register Link
When user enters user details with user id "<username>" password "<password>" email "<email>"
And clicks on Register Button
Then user should be registered
And Close the browser

Examples:
|username | password  | email        |
|chandra  | chandra123| c@chandra.com|
|swetha   | swetha123 | c@swetha.com|
|karthik  | karthik123| c@karthik.com|