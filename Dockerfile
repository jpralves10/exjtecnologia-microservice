FROM adoptopenjdk/openjdk11:alpine-jre

RUN apk update

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /env/exjtecnologia
RUN chmod -R 777 /env/exjtecnologia

RUN cd /
WORKDIR /env/splunk
RUN chmod -R 777 /env/splunk

WORKDIR /

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar","/app.jar"]