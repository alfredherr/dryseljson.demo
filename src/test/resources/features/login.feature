Feature: Authorization 

UserStory:
  As an owner of my Awesome Web App
  I want an ability to allow authorized users to use my app
  
@now 
Scenario: Allow access to authorized users 
	Given Joe is an authorized user 
	When Joe enters correct user-name and password
	Then User information page should be displayed