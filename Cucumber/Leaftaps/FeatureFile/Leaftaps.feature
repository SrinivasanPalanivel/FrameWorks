Feature: Leaftaps UI CreateLad Flow

Background:
Given Edge Browser is Opened
And Switch bt Window
And Load the Application URL
And Maximize the window and Set the Timeouts
And Provide the valid Login Credentials
And Click the CRMSFA

Scenario Outline: TC001 - CreateLead
And Click the Leads
And Click the Create Lead
And Enter the Company <cname>
And Enter the Firstname <fname>
And Enter the lastname <lname>
When Create Lead is Clicked
Then View Lead Should be Displayed
Then Close Browser

Examples:
|cname|fname|lname|
|'PayPal'|'Ajith'|'AK'|

Scenario Outline: TC002 - EditLead
And Click the Leads
And Click the Find Leads
And Enter <fname>
And Click Find Lead button
And Click on the first result
And Verify title
And Click Edit
And Change <cname>
When Click Update Button
And Confirm name change
Then Close Browser

Examples:
|fname|cname|
|'Srini'|'Nightmare'|

Scenario Outline: TC003 - DeleteLead
And Click the Leads
And Click the Find Leads
And Click Phone
And Enter Phone Number <phone>
And Click Find Lead button
And Capture the Lead ID
And Click on the First ID
And Click Delete Button
And Click the Find Leads
And Enter Captured Lead ID
When Click Find Lead button
And Verify Message
Then Close Browser

Examples:
|phone|
|'9'|
