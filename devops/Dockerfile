FROM openjdk:8

ENV MAROLOK="bWFyb2xvayB0ZXN0Cg=="

ADD build/libs/demo*.jar /app/demo.jar
ADD devops/git_clone.sh /cert/git_clone.sh

CMD sh /cert/git_clone.sh

EXPOSE 8080