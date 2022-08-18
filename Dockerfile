FROM gradle:6.7.1-jdk15 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11.0.9-jre-slim

RUN mkdir /app

COPY --from=build /home/gradle/src/app/build/libs/ /app/

ENTRYPOINT ["java","-jar","/src/app.jar"]