FROM openjdk:8-jdk-alpine
COPY ./target/cleantipsapi.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch cleantipsapi.jar'
ENTRYPOINT ["java","-jar","cleantipsapi.jar"]  