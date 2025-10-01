# Build only the basicauthentication example
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Install Maven for building
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copy only the basicauthentication example files
COPY examples/basicauthentication/pom.xml /app/pom.xml
COPY examples/basicauthentication/src /app/src
COPY examples/basicauthentication/ui.resources /app/ui.resources

# Build the Java application (skip frontend build for now)
RUN mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Set environment variables
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Run the application
CMD ["java", "-jar", "target/basicauth.war"]
