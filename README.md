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
* JPA is an ORM (Object Relational Mapping) tool. ORM is third-party tool, that will store the data and also convert the data (which is in table-row, col-based) into an object.
* If we do not use ORM, we have to write the SQL query for db. Here ORM plays an important role, it will fetch the data from the table and convert it into an object. Here we don't have to write the SQL query. ORM will also convert the object into SQL.
* Hibernate is an implementation of JPA.
* JPA provides us <b>EntityManagerFactory(provides EntityManager's object), EntityManager(provides CRUD operations).</b>

### How Spring Boot Makes it Easier to Perform Operations with JPA
* Add spring-boot-starter-data-jpa dependency. It will configure all the dependencies automatically.
* Now we have to perform some operations on a user (example) then create UserRepository (same as DAO) which extends CRUDRepository. If we don't want to extend the CRUDRepository, then we can use JPARepository which is a child of CRUDRepository that will provide more functionality. CRUDRepository and JPARepository both are interface. 
