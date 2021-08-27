FROM adoptopenjdk/openjdk11:alpine

# Add Maintainer Info
LABEL maintainer="andrelgfranco@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8085 available to the world outside this container
EXPOSE 8081

# The application's jar file
ARG JAR_FILE=./build/libs/signature.jar

# Add the application's jar to the container
ADD ${JAR_FILE} signature.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/signature.jar"]