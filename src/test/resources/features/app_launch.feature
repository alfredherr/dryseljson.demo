Feature: Open Web App 

UserStory:
  As an owner of my Awesome Web App
  I want an ability to open my app in web-browsers
  
@now 
Scenario: Open Awesome Web App in Firefox 
	Given Joe is a user 
	When Joe enters correct URL of the web app 
	Then login page of the web app should be displayed