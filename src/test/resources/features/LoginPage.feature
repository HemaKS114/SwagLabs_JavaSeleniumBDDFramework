Feature: Launch the application and Login

Scenario: Launch the app and login
Given I launch the application
When I enter the 'username' in 'loginPage_username' field
And I enter the 'Password' in 'loginPage_password' field
Then I click on the 'loginPage_loginButton'

