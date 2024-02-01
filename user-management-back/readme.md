***Pre-requirements:***

- for compiling the project
  - maven 3
  - JDK 17 or greater
  
- for running the project
    - a Postgresql DB
    - JRE 17

***Compile the project***

```mvn clean install```

***Launch the project:***
- 
- run your postgres database

- run ```java -jar target/userManagement-0.0.1-SNAPSHOT.jar```

- launch on a browser the url http://localhost:8080/users

- the first time you launch the app, an empty json array should be returned ```[]```
