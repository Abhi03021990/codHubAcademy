Feature: Expedia flights
Scenario: Search one way flights
Given user is on expedia home page 
When user clicks on flights tab
And user clicks on oneway
And enter source , destination and departure date 
And user clicks on search button
Then the corresponding seartch results should be displayed

@param
Scenario Outline:Search one way flights for multiple data
Given user is on expedia home page 
When user clicks on flights tab
And user clicks on oneway
And enter <source> , <destination> and <departure date> 
And user clicks on search button
Then the corresponding seartch results should be displayed

Examples:
|"source"| "destination" | "departure date" |
|"delhi"| "bangalore"|"12/12/2020"|
|"kolkata"| "bangalore"|"12/12/2020"|
|"delhi"| "kolkata"|"12/12/2020"|
|"delhi"| "hyderabad"|"12/12/2020"|

