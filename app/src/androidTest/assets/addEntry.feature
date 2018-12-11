Feature: Login screen to authenticate users

	Scenario: Empty itemName
    	When I introduce a personn
    	And I introduce a dateFrom
    	And I introduce a dateTo
    	And I press the submit button
    	Then I see an error message saying 'Title can't be empty'

    Scenario: Empty Person
        When I introduce a itemNamee
        And I introduce a dateFrom
        And I introduce a dateTo
        And I press the submit button
        Then I see an error message saying 'Person can't be empty'

    Scenario: DateFrom after DateTo
        When I introduce a itemNamee
        And I introduce a person
        And I introduce a invalid dateFrom
        And I introduce a dateTo
        And I press the submit button
        Then I see an error message saying 'Please select a date before the end date.'

    Scenario: DateTo before DateFrom
        When I introduce a itemNamee
        And I introduce a person
        And I introduce a dateFrom
        And I introduce a invalid dateTo
        And I press the submit button
        Then I see an error message saying 'Please select a date before the end date.'

    Scenario: Valid Inputs
        When I introduce a itemName
        And I introduce a person
        And I introduce a dateFrom
        And I introduce a dateTo
        And I press the submit button
        Then I see an message saying 'Successly delivered the data!'



