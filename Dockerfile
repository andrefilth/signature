FROM adoptopenjdk/openjdk11:alpine

# Add Maintainer Info
LABEL maintainer="andrelgfranco@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=./target/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} signature.jar

ENV MONGO_HOST=mongodb
ENV MONGO_DATABASE=signaturedb

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/signature.jar"]