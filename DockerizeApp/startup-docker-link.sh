#!/bin/bash
echo 'this will run your spring boot application and MySql server in seperate containers. application accessible @ http://localhost:8089/ '

#this script:
#1- pulls a MySql image(mysql:5.6) and runs its a container(docker-mysql),
#2- builds the spring application (.jar file), then creates its docker image (spring-core-api)
#3- runs Spring application as a container(spring-myql-dockerlink), and links MySql and Spring containers together (docker --link)

#1-pull a mysql image and run a container on host port 6033 (also creating database lms) 
docker pull mysql:5.6
docker images | grep 'mysql'
docker run -d -p 6033:3306 --name docker-mysql -e MYSQL_ROOT_PASSWORD=root  -e MYSQL_PASSWORD=root -e MYSQL_DATABASE=lms mysql:5.6
# using  mysql-startup.sql for DDL
#mysql -uroot -proot -h127.0.0.1 -P6603 < mysql-startup.sql

# 2-building the spring boot application, build its images from Dockerfile and run it as container (and linking it to mysql container - using docker --link)
mvn -f ../ clean install -DskipTests
docker build -f ../Dockerfile -t spring-core-api ../

#3- running and linking both containers (docker-mysql / spring-myql-dockerlink) together
docker run -t --link docker-mysql:mysql --name spring-myql-dockerlink -p 8089:8089 spring-core-api





