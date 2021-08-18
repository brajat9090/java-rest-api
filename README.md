# java-rest-api

Apache tomcat server: 9.0
Java: 1.8
Database: MySQL
ORM: Hibernate

Usage guide
1) Download the project and open it in Eclipse or Spring Tool Suite
2) Set Apache tomcat server 9.0 and Java 1.8
3) Create Database (Name should be url_manager)
4) Create table using following command
	create table url_data(id int(10) PRIMARY KEY AUTO_INCREMENT, url VARCHAR(100), short_key VARCHAR(20), usage_count INT(5) DEFAULT 0)
5) Configure hibernate.cfg.xml file accordingly.
6) Run project on Apache tomcat server 9.0.
7) Use postman to test the API.


These are APIs that I have created

	1) Method=POST
		URL: http://localhost:8082/urlManagerRest/storeurl?url=hello
	2) Method=GET
		URL: http://localhost:8082/urlManagerRest/get?url=hello
	3) Method=GET
		URL: http://localhost:8082/urlManagerRest/count?url=hello
	4) Method=GET
		URL: http://localhost:8082/urlManagerRest/list?page=1&size=3

Features Implemented
1) The API "storeurl" takes a URL as a parameter and save that into a table with a unique short key and a count(usage count) initialised to 0.
2) The API "get" takes a URL as a parameter and return the unique short key after incrementing the usage count.
3) The API "count" takes a URL as a parameter and return the latest usage count.
4) The API "list" returns all urls and counts with pagination in JSON format.
5) APIs can be simultaneously executed by multi-users. 
6) Data persistence using a database (MySQL) so that even if the application is restarted, the data is permanently stored. 

Improved (While testing)
1) Now random shortKey cannot be same.
2) Duplicate URL cannot be inserted now.
