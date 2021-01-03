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

**NOTE**: Since containers are supposed to be epehmeral, we mount a volume to the MySQL docker container. data volumes' life-cycle are beyond containers (they exist even after the docker container has been removed). 

we are using **dockerScripts/dockervolume in the host machine as the data volume**. If you don't have this directory. you can create it by running 
'mkdir -p dockerScripts/dockervolume '

---------------------------------------------------------------------------------------------------------------------
**How to Access the docker image for this Springboot Application?**

you can either

  - **pull the image** from the DockerHub (      ), or
  
  - **build the image** locally using the provided scripts.You can find all scripts (for building the application and docker images) 
         within the folder **'dockerScripts'**.
        


**Method 1 : dockerScripts/start-docker-link.sh (docker --link)**
    
following script runs your spring application in a container(MySQL server in a separate container).
        It uses legacy 'dcoker --link' to connect both containers
        you can access your application from : http://localhost:8089/  
   
        ./start-docker-link.sh  

         you can use following script to stop the application (and remove the containers/images).
 
       ./stop-docker-link.sh

NOTE: if scripts dont work, change them to executables -> chmod +x startup-docker-link.sh

**Method 2 : dockerScripts/docker-compose up/down: (docker-compose)**
By delegating 'build image' and 'run containers' (port mapping, mounting volumes,..) to **YAML file (docker-compose.yml)**, you can start and stop the application using:

          docker-compose up
          
          docker compose down







-------------------------------------------------------------------------------------------

Following links help you  to fill in the knowledge gap:

MySQL Docker Container Tutorial: https://phoenixnap.com/kb/mysql-docker-container

How to Create and Use Bash Scripts : https://www.taniarascia.com/how-to-create-and-use-bash-scripts/

Docker With Spring Boot and MySQL - docker --link: https://dzone.com/articles/all-about-hibernate-manytomany-association

**Docker With Spring Boot and MySQL - Docker Compose : https://dzone.com/articles/docker-with-spring-boot-and-mysql-docker-compose-p**

Persistent data in Docker volumes : https://codeblog.dotsandbrackets.com/persistent-data-docker-volumes/
