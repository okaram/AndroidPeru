#Databases and SQLite

Android contains the libraries for an embedded database, [sqlite](http://sqlite.org/). SQLite is not a replacement for a full-fledged DBMS (it's a replacement for fopen, not for PostgreSQL), but gives you something like a relational DBMS, but it does NOT enforce typing (you can write a string in an integer field) or FOREIGN KEY constraints, and supports most of the basic SQL (SQL-92) with a few limitations that depend on the version.

SQLite has now become almost the standard for embedded databases, given that both Android and iOS include it; you could include other DBMS libraries if you wanted (just include the jar file if they're pure java), but having it included with the OS saves space and hassle.

Android provides a few classes that make it easier to use sqlite.


