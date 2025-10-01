        # Use Node.js 18 as base image, then add Java
FROM node:18-slim

# Set working directory
WORKDIR /app

# Install Java 17 JDK and Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk-headless maven && \    
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Install Angular CLI globally (Yarn is already available in Node.js image)
# Use Angular CLI 17 to match the project's Angular version
RUN npm install -g --unsafe-perm @angular/cli@17

# Copy Maven files first for better caching
COPY examples/basicauthentication/pom.xml /app/pom.xml

# Copy source code
COPY examples/basicauthentication/src /app/src

# Copy UI resources
COPY examples/basicauthentication/ui.resources /app/ui.resources

# Build the Angular frontend first
WORKDIR /app/ui.resources
# Use npm instead of yarn for better Docker reliability
# Add network timeout and retry configurations
RUN npm config set fetch-retry-mintimeout 20000 && \
    npm config set fetch-retry-maxtimeout 120000 && \
    npm config set fetch-retries 5 && \
    npm install && \
    npm run build

# Go back to app directory and build the Java application
WORKDIR /app
RUN mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Set environment variables
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Run the application
CMD ["java", "-jar", "target/jaq-stack-webapp.war"]
