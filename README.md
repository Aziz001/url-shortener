# url-shortner
A url-shortner developed by playframework (using java), that encodes the ID of a url (instead of the url itself) and gives back a tiny url.

### Testing the API

Do the following steps:
- activator run
- run the evolution script from localhost:9000

### Documentation

- POST    /shorten   (shortens the request body if it is validated as url)   
- GET     /*token    (gives back the real url from a short url as json)
