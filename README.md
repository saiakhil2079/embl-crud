# REST Web Service for CRUD operations

### Spring web service of a CRUD of persons using Spring JPA, Spring MVC and Spring Boot, including GET, POST and DELETE operations for a person entity.

Attributes: firstName, lastName, age, favouriteColour, hobby.

### Requirements

Java - 1.8.x

JDK or OpenJDK - 1.8.x

Maven - 3.x.x

Spring - 2.1.7.RELEASE (inclued in pom.xml)

### How to run
1) Clone the repository.

   git clone https://github.com/saiakhil2079/embl-crud.git

2) Application uses in-memory database (h2). In order to connect to that, use the below link 

   http://localhost:8080/h2-console

   Person table will be created through liquibase script.We can cross check that by connecting to the above mentioned h2-console once we start the application. 
   
   We can also configure the application to use MariaDB through the below mentioned parameters which are available in application.yml. MariaDB dependency is already available in pom.xml.
   
   Set the required driver-class-name, url, username and password if you want to use mariadb instead of h2.

3) Username and password for h2 are sa and sa

4) Build and run the app using Maven

   mvn package
   
   java -jar target/embl-crud-1.0.0.jar
   
   Also, you can run the app without packaging it by using: mvn spring-boot:run
   
   The app will start running at http://localhost:8080

### How to use the API
The current version of the API is v1.0. Endpoints are secured with spring basic security. The username and password used for authorization are mentioned below.

username: admin

password: password

1) Creating new Persons/Person using POST /store 

   http://localhost:8080/store

for example: [{
           "firstName":"Sarah",
           "lastName":"Raven",
           "age":54,
           "favouriteColour":"blue",
           "hobby":["chess"]
         },
		 {
           "firstName":"John",
           "lastName":"Wick",
           "age":29,
           "favouriteColour":"blue",
           "hobby":["chess"]
         }]

2) Retrieving all Persons using GET /retrieve

   http://localhost:8080/retrieve

3) Updating Persons/Person info using POST /update
 
   Since personId is not available in the database, assumed the combination of firstName, lastName and age as the primary key. We can update multiple persons information as well.
   
   Assuming the above mentioned persons example is stored in database, we can use the below example to update their favouriteColour and hobby.
   
   If any person entry is not available in database, application will throw an exception saying person not found.
   
   http://localhost:8080/update
   
   for example: [{
           "firstName":"Sarah",
           "lastName":"Raven",
           "age":54,
           "favouriteColour":"black",
           "hobby":["chess"]
         },
		 {
           "firstName":"John",
           "lastName":"Wick",
           "age":29,
           "favouriteColour":"blue",
           "hobby":["Badminton", "Tennis"]
         }]

4) Deleting a person info using DELETE /delete 

   Combination of firstName, lastName and age are combined together to get the unique record from the database.
   So if we want to delete a person entry firstName, lastName and age are mandatory. 
   
   http://localhost:8080/delete/Sarah/Raven/54