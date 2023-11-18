FROM --platform=linux/amd64 openjdk:18-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper files and the POM file to the container
COPY mvnw mvnw.cmd /app/
COPY pom.xml /app/
COPY ./.mvn /app/.mvn

# Copy the application source code to the container
COPY src /app/src

# Grant executable permissions to the mvnw script
RUN chmod +x mvnw

# Set environment variables
ENV DB_HOST=database
ENV DB_PORT=5432
ENV DB_NAME=postgres
ENV DB_USER=postgres
ENV DB_PASSWORD=postgres

# Build the application
RUN ./mvnw install -DskipTests

# Expose the port that your application will run on
EXPOSE 8080

# Command to run the application
CMD ["sh", "-c", "java -jar $(find ./target -name '*.jar' | head -n 1)"]
