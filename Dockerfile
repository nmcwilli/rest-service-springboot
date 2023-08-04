# Dockerfile build script for Spring Boot Rest Service
# By Neil McWilliam (Note this is a starter)

# creates a layer from an existing Java base image that exists
# locally or in any container registry that runs our container.
# JDK used will be Liberica JDK 17
FROM bellsoft/liberica-openjdk-alpine:17

# Creates a specific space to persist some data in your container. The tmp folder will store information.
VOLUME /tmp

# Exposes port 8080 - Informs Docker that the container listens to the specified network ports at
# runtime. This is the port to access to the Spring Boot container and will be used to run the
# container.
EXPOSE 8080

# Defines a variable that can be passed to the application at runtime.
# For example, we pass the location of the final jar file within the
# target folder and save it in a JAR_FILE variable. You can also pass more
# arguments like credentials, keys, and environment variables with their
# respective values.
ARG JAR_FILE=build/libs/rest-service-0.0.1-SNAPSHOT.jar

# Renames Jar file as app.jar
ADD ${JAR_FILE} app.jar

# Copies new files, directories or remote file URLs from the source and
# adds them to the filesystem of the image at the provided path. In our case
# we add the Spring Boot application to the Docker image from the source path
# (the JAR_FILE variable) to a destination named app.jar.
ENTRYPOINT ["java","-jar","/app.jar"]

