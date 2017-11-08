Feature: Saving of user information 

UserStory:
  As a user of the Awesome Web App
  I should be able to save my demographic information
  
@now 
Scenario: Allow user to save demographic information 
	Given Joe has opened user information page 
	When Joe saves his demographics information 
	Then the demographic information should be displayed in information pan