# SpringBoot

## How to create JSP Views 
* <b>STEPS</b> <br>
  👉<i>Create a Controller class in src/main/java</i><br>
  ![Screenshot (154)](https://github.com/SnehaVarshney11/SpringBoot/assets/78306516/5fef3aa0-3ff8-4f73-b64b-a0457dc97542)
  👉<i>Add suffix and prefix in application.properties file for view name </i><br>
  👉<i>Add webapp and views folders in src/main/webapp/view. Create jsp files here </i><br>
  ![Screenshot (155)](https://github.com/SnehaVarshney11/SpringBoot/assets/78306516/88b941f1-48c4-41d4-8bf2-10fe9867af94)
  👉<i>In pom.xml add tomcat-embed-jasper dependency otherwise It will not show the content of jsp page, it will download the file</i><br>
  
* <b>Use of application.properties file </b><br>
  👉 This is a configuration file. <br>
  👉 Spring Boot provides a preconfigured application, If we want to customize the properties, we can do it in this file.
  Ex- If we are running the project and it shows that the server is already in use, we can write our port number to run the application.<br>
  👉 So It contains a key-value pair. Ex- server.port = 8081  <br>

## JPA (Java Persistence API)
* Persistence means storing something permanently.
* JPA is an ORM (Object Relational Mapping) tool. ORM is a third-party tool, that will store the data and also convert the data (which is in table-row, col-based) into an object.
* If we do not use ORM, we must write the SQL query for db. Here ORM plays an important role, it will fetch the data from the table and convert it into an object. Here we don't have to write the SQL query. ORM will also convert the object into SQL.
* Hibernate is an implementation of JPA.
* JPA provides us <b>EntityManagerFactory(provides EntityManager's object), EntityManager(provides CRUD operations).</b>

### How Spring Boot Makes it Easier to Perform Operations with JPA
* Add spring-boot-starter-data-jpa dependency. It will configure all the dependencies automatically.
* Now we have to perform some operations on a user (example) and then create UserRepository (same as DAO) which extends CRUDRepository. If we don't want to extend the CRUDRepository, then we can use JPARepository, a child of CRUDRepository that will provide more functionality. CRUDRepository and JPARepository are both interfaces.
* While working on JPA project, we need to add dependencies of MySql driver, JPA, and web (if working on a web project)
* To save and get the entities, we need to write a Repository interface for them which will be created in the DAO package.
* JPA with Spring boot configuring database information in application.properties file.
* Need to install MySql workbench.

### STEPS to setting up a basic JPA example. (Code in JPAExample folder)
1. Create an entity class(ex- user.java) define the properties (name, city etc.)
```
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 @Entity
   public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String city;
     private String status;
    // Getters and setters, constructors, and other methods...
    }

```
2. Create a Dao class (ex-UserRepository.java)
```
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries can be defined here if needed
}
```
3. In application.properties file add all the imortant configurations.
 ```
spring.datasource.url=jdbc:mysql://localhost:3306/your_schema_name
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
4. Create schema in Mysql workbench.
```
You can create the schema manually or let Hibernate create it for you if spring.jpa.hibernate.ddl-auto=update is set. Be cautious with this in a production environment.
```
7. Create the object of entity to get all the properties which are defined in entity class.
```
package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaExampleApplication.class, args);
		UserRepository ur = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("Sneha");
		user.setCity("Delhi");
		user.setStatus("I am Java Programmer");
		
		User obj = ur.save(user);
		System.out.println(obj);
	}

}
```

### Custom Finder Method
* By default, CRUDRepository provides us find methods - findById(), findAll(), findAllById(). If we want to find data by name, by name and password, by name or password, starting/ending name by suffix/prefix. In this case, SpringBoot allows us to create custom methods or Derived Query Methods.
* These methods will be created in the interface (UserRepository.java)
* These methods work on JPQL (Java Persistence Query Language).
```
package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	// Custom Finder Method
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name, String city);
}
```
* <b>Supported Keywords</b> - <a href="https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html">DOCS</a>

### Executing JPQL and Native Queries with Spring Data JPA
* We can execute queries using @Query annotation.
```
package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	//Custom Query 
	@Query("select u from User u") //JPQL 
	public List<User> getAllUser();
	
	@Query("select u from User u where u.name =:n") //JPQL
	public List<User> getUserByName(@Param("n") String name);
	
	@Query(value = "select * from User", nativeQuery = true) //SQL 
	public List<User> getUsers();
}
```

## API
* API means Application Programming Interface.
* It is a set of rules that allows programs to talk to each other. The developers create the API on the server and allow the client to talk to it.
* Example- In FaceBook/Instagram, we upload our pics. Pics are uploaded by using API.
### REST (Representational State Transfer) API
* A set of constraints for creating web services(API). In simple words, It's a rule to create APIs.
* It is a part of API.
* Ex- Client-Server Architecture, Stateless Architecture, Cacheable, Layered etc.
* <b>Rules - </b> The important methods of HTTP are-
  1. GET- It reads a resource.
  2. POST-It creates a new resource.
  3. PUT- It updates an existing resource.
  4. DELETE- It deletes a resource.
  ![Screenshot (157)](https://github.com/SnehaVarshney11/SpringBoot/assets/78306516/5b4f7fef-ce0e-484f-96ce-8b4be9e04c05)"
* HTTP also defined the following status-
  1. 404 - Page/Resource not found
  2. 200 - Success
  3. 201 - Created
  4. 401 - Unauthorized
  5. 500 - Server Error
* When there is any request on the server, will be handled by the controller.
* While using rest API, use @RestController instead of @Controller
 
## Spring Boot DevTools
* DevTools stands for Development Tool. This tool aims to reduce the time of development while working on spring-boot. Spring boot dev tools pickup the changes and restart the application. 
* Add a dependency in the pom.xml file.
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<Scope>runtime</scope>
</dependency>
```
* Features -
  1. Property Default - By using this tool, code will not be stored in cache memory. Sometimes we are providing color in our template and color doesn't work because of the cache and in this case, we have to clear the cache. This problem will be handled by this tool.
  2. Automatic restart - After some changes, it will automatically restart the application.
  3. Live Reload

## Creation of API
* There is a client called Postman. It will create, read, update, and delete the user (Ex- Book).
1. READ - <br>
   ⭕ On the Server Side - Create the controller, it will process it and give a response in JSON format. <br>
   ⭕ On Client Side (Postman) - send URL - ip/books to a server, receive a response from the server. <br>
   ⭕ Method will be GET. <br>
2. CREATE - <br>
   ⭕ IP Address - /name (ex- /books) but the method will be POST. <br>
3. DELETE - <br>
   ⭕ IP Address - /name/{id} but the method will be DELETE. <br>
4. UPDATE - <br>
   ⭕ IP Address - /name/{id} (ex- /books) but the method will be PUT. <br>

## ResponseEntity
* Used to handle HttpStatus while creating REST API.
* Extension of HttpEntity that adds an HttpStatusCode status code.
* Used in RestTemplate as well as in @Controller methods.
<table>
  <tr>
    <th>Http method</th>
    <th>URI</th>
    <th>Description</th>
    <th>Valid HTTP Status Code</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/books</td>
    <td>Create a book</td>
    <td>201</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/books/{bookId}</td>
    <td>Read a Book</td>
    <td>200</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/books/{bookId}</td>
    <td>Update a Book</td>
    <td>200</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/books/{bookId}</td>
    <td>Delete a Book</td>
    <td>204</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/books</td>
    <td>Retrive all Books</td>
    <td>200, 204, 206</td>
  </tr>
</table>
