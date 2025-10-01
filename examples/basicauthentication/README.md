# Basic Authentication Example With Angular and Java

This module includes all the primary sources required to build and develop a web application using JAQ Stack with Basic Authentication feature.

## Prerequisites

Before building and running this project, ensure you have the following installed:

* [Java 11+](https://www.oracle.com/java/technologies/downloads/)
* [Node.js 14+](https://nodejs.org/en/download/)
* [Angular CLI](https://cli.angular.io/) - Install globally with `npm install -g @angular/cli`
* [MongoDB](https://www.mongodb.com/try/download/community)
* [Apache Maven 3.6+](https://maven.apache.org/download.cgi)

## Project Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/[your-username]/jaqstack-examples.git
   cd jaqstack-examples/examples/basicauthentication
   ```

2. **Install Node.js dependencies**
   ```bash
   cd ui.resources
   npm install
   cd ..
   ```

3. **Build the Angular frontend**
   ```bash
   cd ui.resources
   ng build --prod
   cd ..
   ```

## How to Build

1. **Build the Java application**
   ```bash
   mvn clean package
   ```

2. **Verify the build**
   - The build will generate a WAR file: `target/basicauth.war`
   - Ensure no build errors are present

## How to Run

### Option 1: Using Maven Tomcat Plugin (Recommended for Development)

1. **Start MongoDB**
   ```bash
   # On Windows
   mongod
   
   # On macOS/Linux
   sudo systemctl start mongod
   ```

2. **Run the application**
   ```bash
   mvn tomcat7:run
   ```

3. **Access the application**
   - Open your browser and navigate to: `http://localhost:8080/basicauth`
   - You should see the Angular application with authentication features

### Option 2: Deploy to External Tomcat Server

1. **Start MongoDB** (as shown above)

2. **Deploy to Tomcat**
   - Copy the generated `target/basicauth.war` file to your Tomcat `webapps` directory
   - Start Tomcat server
   - Access the application at: `http://localhost:8080/basicauth`

3. **Using Tomcat Manager (Alternative)**
   - Open Tomcat Manager: `http://localhost:8080/manager/html`
   - Upload the `basicauth.war` file
   - Deploy the application
   - Access at: `http://localhost:8080/basicauth`

## Testing the Application

### Main Application
- **URL**: `http://localhost:8080/basicauth`
- **Expected Result**: You should see the Angular application with authentication features

![jaq-stack-sample-screen-browser](https://user-images.githubusercontent.com/902972/39284861-0d430d80-48db-11e8-8b96-16719b595e96.png)
*Sample jaq-stack-webapp page on browser*


# REST Endpoints
* Show all users - `/basicauth/service/auth/users`
  * Sample URL `http://localhost:8080/basicauth/service/auth/users`
  * Request type: GET
  * Sample output
  ```json
  [{"username":"xyz","password":"test123","firstName":null,"lastName":null},{"username":"123456","password":"123456","firstName":null,"lastName":null}]
   ``` 
* Add a new user - `/basicauth/service/auth/register`
  * Sample URL `http://localhost:8080/basicauth/service/auth/register`
  * Request type: POST
  * JSON input `{"username":"meenu", "password":"test", "firstname":"Mee", "lastname":"Kon"}`
  * Sample output `User mee added successfully.` 
* Find Username and Password - `/basicauth/service/auth/login`
  * Sample URL `http://localhost:8080/basicauth/service/auth/login`
  * Request type: POST
  * JSON input `{"username":"mee", "password":"test"}`
  * Sample output `{"token":"xxxxxxxxxxx"}` 


## MongoDB Setup

### Installation
1. **Download and Install MongoDB**
   - Download MongoDB Community Edition from [mongodb.com](https://www.mongodb.com/try/download/community)
   - Follow the installation instructions for your operating system

2. **Start MongoDB Service**
   ```bash
   # Windows
   mongod
   
   # macOS/Linux
   sudo systemctl start mongod
   # or
   sudo service mongod start
   ```

### Database Configuration

1. **Connect to MongoDB**
   ```bash
   mongo
   ```

2. **Create Database and Collection**
   ```bash
   # Create and switch to the database
   use jaqstack
   
   # Create the users collection
   db.createCollection("users")
   
   # Insert sample user data
   db.users.insert({
     username: "suren", 
     password: "test", 
     firstname: "Sur", 
     lastname: "Kon"
   })
   
   # Verify the data
   db.users.find()
   ```

3. **Exit MongoDB**
   ```bash
   exit
   ```

## Troubleshooting

### Common Issues and Solutions

#### 1. Angular CLI Issues
**Problem**: `mvn package` fails with Angular CLI errors
**Solution**:
```bash
# Install Angular CLI globally
npm install -g @angular/cli

# If installation goes into infinite loop, try:
mkdir ~/.npm-global
npm config set prefix ~/.npm-global
export PATH=~/.npm-global/bin:$PATH
source ~/.profile
```

#### 2. MongoDB Connection Issues
**Problem**: Application cannot connect to MongoDB
**Solutions**:
- Ensure MongoDB is running: `mongod` or `sudo systemctl start mongod`
- Check MongoDB is listening on default port 27017
- Verify database and collection exist (see MongoDB Setup section)

#### 3. Port Conflicts
**Problem**: Port 8080 is already in use
**Solutions**:
- Stop other services using port 8080
- Change Tomcat port in `pom.xml` or server configuration
- Use different port: `mvn tomcat7:run -Dmaven.tomcat.port=8081`

#### 4. Build Failures
**Problem**: Maven build fails
**Solutions**:
- Clean and rebuild: `mvn clean package`
- Check Java version: `java -version` (should be 11+)
- Verify Maven installation: `mvn -version`
- Clear Maven cache: `mvn dependency:purge-local-repository`

#### 5. Node.js/NPM Issues
**Problem**: npm install fails
**Solutions**:
- Clear npm cache: `npm cache clean --force`
- Delete node_modules and package-lock.json, then run `npm install`
- Update npm: `npm install -g npm@latest`






