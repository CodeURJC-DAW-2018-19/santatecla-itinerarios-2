# our base image
FROM openjdk:8-jdk-alpine

# copy files required for the app to run
COPY target/itinerary-0.0.1-SNAPSHOT.jar webapp.jar

# tell the port number the container should expose
EXPOSE 8443

# run the application
CMD ["java", "-jar", "webapp.jar"]