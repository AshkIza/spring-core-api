# spring-core-api

**How to run this SpringBoot Application?**

**1- Run it in local machine (development environment)**

For development environment, an **embedded Derby database** is used.
You can build this application (mvn install -DskipTests) and run it on your local machine :
'java -jar CourseApiData-0.0.1-SNAPSHOT.jar'. Application is listening on port 8080 (http://localhost:8080/).

**2- Run it within docker container (production enviroment)**

For production deployments, **MySQL database is used (within its own container)**.
In this case, SpringBoot application and MySql run in separate containers.
Application is listening on port 8089 (http://localhost:8089/).


**NOTE**: to use either MySQL or Derby, you need to make sure following files are refereing to the proper Database

     application.properties
      
     pom.xml

---------------------------------------------------------------------------------------------------------------------
**How to Access the docker image for this Springboot Application?**

you can either

  - **pull the image** from the DockerHub (      ), or
  
  - **build the image** locally using the provided scripts.You can find all scripts (for building the application and docker images) 
         within the folder **'DockerizeApp'**.
        
If you look at the 'DockerizeApp' folder, you you see two startup scripts. 

    'startup-docker-link.sh'  is using legacy docker --link, wheras,
    'startup-docker-compose.sh' is using docker-compose to build/deploy both containers.

**DockerizeApp/Method 1: (docker --link)**
    
following script runs your spring application in a container(MySQL server in a separate container).
        It uses legacy 'dcoker --link' to connect both containers
        you can access your application from : http://localhost:8089/  
   
        ./startup-docker-link.sh 

         you can use following script to stop the application (and remove the containers/images).
 
        ./stopandremove.sh

NOTE: if scripts dont work, change them to executables -> chmod +x startup-docker-link.sh

**DockerizeApp/Method 2: (docker-compose)**







-------------------------------------------------------------------------------------------

Following links help you  to fill in the knowledge gap:

MySQL Docker Container Tutorial: https://phoenixnap.com/kb/mysql-docker-container

How to Create and Use Bash Scripts : https://www.taniarascia.com/how-to-create-and-use-bash-scripts/

Docker With Spring Boot and MySQL : https://dzone.com/articles/all-about-hibernate-manytomany-association

Persistent data in Docker volumes : https://codeblog.dotsandbrackets.com/persistent-data-docker-volumes/
