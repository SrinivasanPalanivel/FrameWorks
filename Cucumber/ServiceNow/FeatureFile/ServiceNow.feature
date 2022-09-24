Feature: ServiceNow UI Flow
Background:
Given Edgebrowser Opened
And Switch Window
And Load Application URL
And Maximize window and Set Timeouts
And Provide Login Credentials
And Click All
And Click Incidents in Filter navigator

Scenario: TC001 - Create a New Incident
And Click on Create new option
And Fill the mandatory fields
Then Clicked in Submit
And Close the Browser

Scenario: TC002 - Edit a Incident
And Click on the Incident
And Change the Urgency
And Change the State
And Change the Discription
Then Click Update
And Close the Browser

Scenario: TC003 - Delete a Incident
And Click on the Incident
Then Click Delete
And Close the Browser
