# Use Node.js 18 as base image, then add Java
FROM node:18-slim

# Set working directory
WORKDIR /app

# Install Java 11 JDK and Maven
RUN apt-get update && \
    apt-get install -y openjdk-11-jdk-headless maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Install Yarn and Angular CLI globally
RUN npm install -g yarn @angular/cli

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
