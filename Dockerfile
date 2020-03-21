# Start with a base image containing Java runtime
FROM java:8

# Add a volume to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/book-boot-aws-1.0-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} boot-aws.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/boot-aws.jar"]
