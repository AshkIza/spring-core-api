#!/bin/bash

echo 'removing MySql and spring-core-api  containers ..'
docker stop docker-mysql spring-myql-dockerlink
docker container prune -f

echo 'removing spring-core docker image'
docker image rm spring-core-api
#docker image rm mysql:5.6 





