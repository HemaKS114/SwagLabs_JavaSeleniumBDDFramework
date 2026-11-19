Feature: Launch the application and Login

@Execute
Scenario: LP_001 - Launch the app and login
Given I launch the application
When I enter the 'username' in 'loginPage_username' field
And I enter the 'Password' in 'loginPage_password' field
Then I click on the 'loginPage_loginButton'

@Dont
Scenario: LP_002 - Login with locked out user username
Given I launch the application
When I enter the 'username' in 'loginPage_username' field
And I enter the 'Password' in 'loginPage_password' field
Then I click on the 'loginPage_loginButton'
And I verify the 'LockedOutErrorMsg' on 'loginPage_errorMsg' space

@Dont
Scenario: LP_003 - Login with problem user username
Given I launch the application
When I enter the 'username' in 'loginPage_username' field
And I enter the 'Password' in 'loginPage_password' field
Then I click on the 'loginPage_loginButton'

