#Connectivity and REST

* Many times we want to use our Android app as a client, in a client-server relationship
* Android supports normal socket programming, through Java's standard libraries
* Most client-server now is done through HTTP and some kind of web services
* Android includes two http clients, Apache's HttpClient and HttpUrlConnection

## XML, SOAP etc

* XML solves the syntax problem when communicating
* We defined web services with SOAP, which gives us either RPC or message based services
* SOAP is now considered heavy, disciplined and 'enterprisey'
* performance may be a problem

## [REST](http://en.wikipedia.org/wiki/Representational_state_transfer) and [JSON](http://json.org/)

* Roy Fielding (one of the creators of the apache web server) proposed the REST model in his [PhD dissertation](http://www.ics.uci.edu/~fielding/pubs/dissertation/top.htm)
	* URLs represent objects or resources
	* idea, implemented many ways; not a formal standard
	* use all HTTP methods
		* GET is for reading
		* POST is for creating
		* PUT is for replacing (updating)
		* DELETE is for deleting
		
* communication is usually done in Json, not XML
	* JSON stands for JavaScript Object Notation
	* Basically the notation for values in javascript, similar to other languages
	* Objects in JSON are defined with a list of `name : value` pairs, separated by commas, inside {}
	* `{ age: 3, name:"Orlando"}`
	* strings can be single or double quoted; field names can be quoted (need to be quoted if containing spaces etc)
	
## Http Connections in Android
* Apache's HttpClient
* HttpUrlConnection

