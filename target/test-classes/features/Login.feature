Feature: Application Login
Scenario Outline: Home page default login
Given Initialise the browser with Chrome
And Navigate to "http://qaclickacademy.com" site
And click on Sign in button to land on sign in page
When User login into login page with <username> and <password>
Then verify the user is successfully logged in
And close browser

Examples:
|username	|password|	
|test99@gmail.com	|123456|	
|abc@gmail.com	|562839|	