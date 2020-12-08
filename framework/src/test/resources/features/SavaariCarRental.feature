Feature: Savari car rental
@param2
Scenario: Search car available for rent for oneway trip
Given user is on the savaari home page
When user enters from , to ,  enters pickup date and time
And user clicks on the select car
Then search results based on the entered details should be displayed
