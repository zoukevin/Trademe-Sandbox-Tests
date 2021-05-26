Test case 1.
	I scraped a part of the TradeMe site which allowed me to gather all instances of used cars for sale and printed all the desired values. I also included a conditional to trigger if any of the wanted properties of the car weren't in the listing.

Test case 2.
	By using an API, I retrieved a list of all the charities and printed them all in tidy format using regex, taking care to highlight the St John listing and also adding a case if St John does not appear of on the list.
	
Test case 3.
	I had difficulties with this case as I was not sure if the API's functionality was working or not. I tested the APIs with REQBin.com as well as self testing on multiple APIs. A few of the API's needed for this case did not work namely, the motors search and general search. I was however able to query the row parameter even though the category parameter was unqueryable. 
	
	I was able to successfully authenticate myself using oAuth but I was not able to search for the href tags in the XML to gather all instances of used cars. Instead I used a similar method I used in part one to gather the API URLs. If I was able to do it differently, I would have used the "General search"$category or the "Query motors search" to obtain all the available cars. I was recieving an error 500 message when I tried to access this particular API