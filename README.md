# spring-core-api

**How to run this SpringBoot Application?**

**1- Run it in local machine (development environment)**
For development environment, an **embedded Derby database** is used.
you can build this application (mvn install -DskipTests) and run it on your local machine :
'java -jar CourseApiData-0.0.1-SNAPSHOT.jar' 

**2- Run it within docker container (production enviroment)**
For production deployments, **MySQL database is used (within its own container)**
In this case, SpringBoot application and MySql run in separate containers.
you can find all scripts (for building the application and docker images) within the folder **'DockerizeApp'**.
NOTE: if scripts dont work, change them to executables -> chmod +x startup-docker-link.sh

**NOTE**: to use either MySQL or Derby, you need to make sure following files are refereing to the proper Database
**application.properties
pom.xml**

**DockerizeApp/Method 1: (docker --link)**
    
following script runs your spring application in a container(MySQL server in a separate container).
        It uses legacy 'dcoker --link' to connect both containers
        you can access your application from : http://localhost:8089/  
   
        ./startup-docker-link.sh 

         you can use following script to stop the application (and remove the containers/images).
 
        ./stopandremove.sh


**DockerizeApp/Method 2: (docker-compose)**







