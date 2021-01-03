How to run this SpringBoot Application?

Method 1: (docker --link)
following script runs your spring application in a container(MySQL server in a separate container).
 It uses legacy 'dcoker --link' to connect both containers
 you can access your application from : http://localhost:8089/  
   
  ./start-docker-link.sh 

you can use following script to stop the application (and remove the containers/images).
 
 ./stop-docker-link.sh


Method 2: (docker-compose)
delegating all the build image and run containers (port mapping, mounting volumes,..) to YAML file (docker-compose.yml), you can start and stop the application using:

docker-compose up
docker compose down


NOTE: if scripts dont work, change them to executables -> chmod +x startup-docker-link.sh



------- how to connect to the MySQL dcoker container?

log into the container and run the mysql clinent from inside the container -> 
docker container ls
docker exec -it CONTAINER_ID sh
mysql -uroot -proot

using host machine mysql client to connect into the conainer ->
mysql -uroot -proot -h127.0.0.1 -P6033
mysql -uroot -proot -h127.0.0.1 -P6033 < mysql-startip.sql
