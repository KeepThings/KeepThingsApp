Feature: Login screen to authenticate users

    Background:
    		Given I see an empty login form

	Scenario: Invalid email Invalid password
    	When I introduce an invalid email
    	And I introduce an valid password
    	And I press the login button
    	Then I see an error message saying 'This email address is invalid'

    Scenario: Valid email Invalid password
        When I introduce an valid email
        And I introduce an invalid password
        And I press the login button
        Then I see an error message saying 'This password is too short'

    Scenario: Invalid email valid password
        When I introduce an invalid email
        And I introduce an valid password
        And I press the login button
        Then I see an error message saying 'This email address is invalid'

    Scenario: Valid email Valid password
        When I introduce an valid email
        And I introduce an valid password
        And I press the login button
        Then I see an error message saying 'This password is incorrect'

    Scenario: Correct email Correct password
         When I introduce an correct email
         And I introduce an correct password
         And I press the login button
         Then I am logged in

