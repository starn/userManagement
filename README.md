# userManagement

The project is separated into 2 parts:
- back in Java / Spring boot
- front in Javascript / Angular

pre-requirements:
- having a postgresql server running on localhost with the default settings (or edit the file application.properties):
  - spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
  - spring.datasource.username=postgres
  - spring.datasource.password=postgres
 
      

- build the back with ```mvn clean install```
- run the back by launching the main springboot class UserManagementApplication
- the server listen on the port 8080. you can test the server by accessing with an internet browser the url http://localhost:8080/api/users
 
- build the front with ```npm install```
- launch the front server with ```npm start```
- open the url http://localhost:4200/
