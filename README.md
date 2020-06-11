#### Spring5Test & Docker

Project with tests for Spring 5 and Docker.

##### Build and start application

Build application
> gradle clean build

Start application
> java -jar ./build/libs/Spring5Test-0.0.1-SNAPSHOT.jar 

##### Docker build and start
Docker build
> docker build -f devops/Dockerfile -t spring5test-001 .

Docker run
> docker run -p 127.0.0.1:80:8080 spring5test-001
>
> docker run -e MAROLOK=base64 -p 127.0.0.1:80:8080 spring5test-001

Docker list container
> docker ps

Docker stop container
> docker stop container_id
