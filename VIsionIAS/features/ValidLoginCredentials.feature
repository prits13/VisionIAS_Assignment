Feature: Valid login 

Scenario: Successful Student login with positive credentials and verify homepage title
	Given User Launch browser
	When User opens url "http://www.visionias.in/student/login-form.php"
	And User enters Email as "priteshjsakhare@gmail.com" and password as "pritesh@123"
	And Click on login
	Then Page title should be "Vision IAS StudentZone Login Form"
	
	
	Scenario: Unsuccessful Student login with negative credentials and verify popup and extract message
	Given User Launch browser
	When User opens url "http://www.visionias.in/student/login-form.php"
	And User enters Email as "priteshjsakhare@gmail.com" and password as "pritesh123"
	And Click on login
	And Verify popup message should be "Incorrect Email ID and/or Password."
	Then Accept popup