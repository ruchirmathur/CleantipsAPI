FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar cleantipsapi.jar
ENTRYPOINT ["java","-jar","/cleantipsapi.jar"]