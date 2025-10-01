# Use OpenJDK 11 as base image
FROM openjdk:11-jre-slim

# Set working directory
WORKDIR /app

# Install Maven, Node.js, and Yarn
RUN apt-get update && \
    apt-get install -y maven curl && \
    curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get install -y nodejs && \
    npm install -g yarn @angular/cli && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copy Maven files first for better caching
COPY examples/basicauthentication/pom.xml /app/pom.xml

# Copy source code
COPY examples/basicauthentication/src /app/src

# Copy UI resources
COPY examples/basicauthentication/ui.resources /app/ui.resources

# Build the Angular frontend first
WORKDIR /app/ui.resources
RUN yarn install && yarn build

# Go back to app directory and build the Java application
WORKDIR /app
RUN mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Set environment variables
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Run the application
CMD ["java", "-jar", "target/jaq-stack-webapp.war"]
