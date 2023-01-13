FROM openjdk:8u131-jdk-alpine
EXPOSE 7000
COPY ./target/christmasService.jar christmasService.jar
ENTRYPOINT ["java","-jar","/christmasService.jar"]