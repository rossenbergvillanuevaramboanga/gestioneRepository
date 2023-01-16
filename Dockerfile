FROM maven:3-adoptopenjdk-11 as builder
WORKDIR /opt
COPY . .

RUN mvn package

FROM openjdk:11

COPY --from=builder /opt/target/*.jar /opt/app.jar

EXPOSE 8081
CMD java -jar /opt/app.jar