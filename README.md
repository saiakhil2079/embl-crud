REST Web Service for CRUD operations
REST web service using Spring JPA, Spring MVC and Spring Boot.

Spring web service of a CRUD of persons using Spring JPA, Spring MVC and Spring Boot, including GET, PUT, POST and DELETE operations for a person entity.
Attributes: firstName, lastName, age, favouriteColour, hobby.

Requeriments
Java - 1.8.x
Maven - 3.x.x
Spring - 2.1.7.RELEASE (inclued in pom.xml)

How to run

1. Clone the repository.

git clone https://github.com/saiakhil2079/embl-crud.git

2. Application uses in-memory database (h2). In order to connect to that, use the below link
   http://<hostname>:8080/h2-console

   We can also configure the application to use MySQL or MariaDB as well through the below mentioned parameters which are available in application.yml
   set the required driver-class-name, url, username and password for db

3. Username and password for h2 are sa and sa
4. Build and run the app using Maven
   mvn package
   java -jar target/embl-crud-1.0.0.jar
   
   Also, you can run the app without packaging it using:
mvn spring-boot:run

   The app will start running at http://localhost:8080
   
How to use the API
	The current version of the API is v1.0.  Endpoints are secured with spring basic security. The username and password used for authorization are mentioned below.

	username: admin
	password: password
	
	1. Creating a new Person using POST	/store
	   http://<hostname>:8080/store
	   
	   example: {
                  "firstName":"Sarah",
                  "lastName":"Raven",
                  "age":54,
                  "favouriteColour":"blue",
                  "hobby":["chess"]
                }
				
	2. Retrieving all Persons using GET /retrieve	
       http://<hostname>:8080/retrieve

    3. Updating a person info using POST /update
	   Since personId is not given assumed combination of firstName, lastName and age as the primary key.
	   http://<hostname>:8080/update

    4. Deleting a person info using DELETE /delete
	   Combination of firstName, lastName and age are combined together to get the unique record from the database. So if we want to delete a person entry firstName, lastName and age are mandatory.
	   http://<hostname>:8080/delete/Sarah/Raven/54