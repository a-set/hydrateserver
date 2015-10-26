# hydrateserver

This a Back-end Service build for In4matx 241 Hydarate with Friends Project. The goal of the project is to build a smart coaster that can keep track of the amount of water a person drinks in a day. 

How it works ?
====================

Whenever a user pours water into a glass kept on a smart coaster, the arduino chip embedded in the coaster it records the amount of water in the glass. When the user lifts the cup and keeps it back on the coaster, it again records the weight of the glass. We estimate the different of the two weights to be the amount of water the user has had. The arduino then sends two parameters to a backend service as an HTTP POST request. These parameters are

1. amount (the amount of water the user has had in Litres)
2. timestamp (the time at which the event was recorded) [ this is not handled at the moment with this back-end service but will be added soon] 

How to use this service ?
========================
The service is located at 
http://<Server-domain-name>:8080/hydrateserver/sendHydrationData

Send a POST request at this url with payload containing "amount" parameter. This will ensure that this event is stored in a MySQL server that can be accessed using phpMyAdmin running at http://<Server-domain-name>/phpMyAdmin , with the correct username and password

There is also a test url available to generate a sample POST request, located at http://<Server-domain-name>:8080/hydrateserver/Index.html













