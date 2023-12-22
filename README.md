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
  👉 Spring Boot provides preconfigured application, If we want to customize the properties, we can do it in this file.
  Ex- If we are running the project and it shows that the server is already in use, we can write our port number to run the application.<br>
  👉 So It contains a key-value pair. Ex- server.port = 8081  <br>
