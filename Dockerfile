FROM openjdk:latest

EXPOSE 8080

ADD target/OrderSystem-0.0.1-SNAPSHOT.jar /home/app.jar
WORKDIR /home
ENTRYPOINT ["java","-jar","/app.jar"]