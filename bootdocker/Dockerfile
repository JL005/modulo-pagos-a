FROM adoptopenjdk/openjdk17
COPY sitas-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/app.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8020
ENTRYPOINT ["java","-jar","/usr/src/bootdocker/app.jar"]