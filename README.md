# Instructions

Clone this repo locally and do the following :

1. Go to **application.properties** and add your own API Key from **https://openweathermap.org/**
2. Set up the run configuration for the sprint boot app
3. Run the app in the local browser.

## Note 

1. The API works only for the US zip codes due to the vendor limitation so please refer https://codigo-postal.co/en-us/usa/ for the zipcodes
2. The forecast is cached at the individual zipcode level for 30 minutes fromt time of writing into the cache. This can be altered in the **application.properties.**
3. We can also change it so that the TTL is counted from the last access.
   

Gentle request, Please ignore the test case coverage  as I had an emergency.
