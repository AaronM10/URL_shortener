#Step 1 - Building the service via gradle (hence the copying of gradle and AS builder being needed)
#Extra notes: JDK = Java Development Kit
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Copy wrapper files and configuration
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

#Copies source code
COPY src ./src

# Fix permissions and build
RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

#Step 2 - Creating the image
#Extra note: JRE = Java Run-time Enviornment
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the generated JAR file from the builder stage in step 1
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8081
# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
