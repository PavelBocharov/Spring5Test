FROM openjdk:8
# Secret or file in Base64 for copy in container
ENV MAROLOK="bWFyb2xvayB0ZXN0Cg=="

#Copy application JAR
ADD build/libs/Spring5Test*.jar /app/Spring5Test.jar
ADD devops/git_clone.sh /cert/git_clone.sh

#Start script for create file and start application
CMD sh /cert/git_clone.sh

# Port for connect to application
EXPOSE 8080