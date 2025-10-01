# JAQ Stack Examples

This repository contains comprehensive examples and sample applications built with the JAQ Stack framework. JAQ Stack combines Java backend services with Angular frontend applications to create modern, full-stack web applications.

## 🚀 What is JAQ Stack?

JAQ Stack is a full-stack development framework that combines:
- **J**ava - Backend services and REST APIs
- **A**ngular - Modern frontend framework
- **Q**uick - Rapid development and deployment

## 📋 Table of Contents

- [Available Examples](#available-examples)
- [Quick Start](#quick-start)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Getting Help](#getting-help)

## 🎯 Available Examples

### 1. [Basic Authentication](./basicauthentication/)
**Description**: Complete authentication system with user registration, login, and JWT token management.

**Features**:
- User registration and login
- JWT token-based authentication
- MongoDB integration
- Angular frontend with authentication guards
- RESTful API endpoints

**Technologies**: Java, Angular, MongoDB, JWT, Maven

**Quick Start**:
```bash
cd examples/basicauthentication
mvn clean package
mvn tomcat7:run
```

### 2. [Azure Blob Viewer](./azureblobviewer/)
**Description**: Azure Blob Storage integration for viewing and managing cloud storage files.

**Features**:
- Azure Blob Storage integration
- File upload and download
- Image preview and management
- RESTful API for blob operations
- Angular frontend with file management

**Technologies**: Java, Angular, Azure Blob Storage, Maven

**Quick Start**:
```bash
cd examples/azureblobviewer
mvn clean package
mvn tomcat7:run
```

## 🚀 Quick Start

### Prerequisites
Before running any example, ensure you have:

- **Java 11+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Node.js 14+** - [Download](https://nodejs.org/)
- **Angular CLI** - `npm install -g @angular/cli`
- **Maven 3.6+** - [Download](https://maven.apache.org/download.cgi)
- **MongoDB** (for Basic Authentication example) - [Download](https://www.mongodb.com/try/download/community)

### Running an Example

1. **Choose an example** from the list above
2. **Navigate to the example directory**
   ```bash
   cd examples/[example-name]
   ```

3. **Install dependencies** (if needed)
   ```bash
   cd ui.resources
   npm install
   ng build --prod
   cd ..
   ```

4. **Build and run**
   ```bash
   mvn clean package
   mvn tomcat7:run
   ```

5. **Access the application**
   - Open your browser to `http://localhost:8080/[example-name]`

## 📁 Project Structure

Each example follows a consistent structure:

```
examples/
├── [example-name]/
│   ├── src/main/java/          # Java backend code
│   ├── src/main/webapp/        # Web resources and JSPs
│   ├── ui.resources/           # Angular frontend
│   │   ├── src/app/           # Angular components and services
│   │   ├── package.json       # Node.js dependencies
│   │   └── dist/              # Built Angular assets
│   ├── pom.xml                # Maven configuration
│   └── README.md              # Example-specific documentation
```

### Backend Structure
- **Java Services**: RESTful APIs and business logic
- **Servlets**: HTTP request handling
- **Models**: Data transfer objects
- **Configuration**: Maven and web.xml settings

### Frontend Structure
- **Angular Components**: UI components and pages
- **Services**: API communication and business logic
- **Models**: TypeScript interfaces and types
- **Assets**: CSS, images, and static resources

## 🔧 Development Workflow

### For Backend Development
1. Make changes to Java code in `src/main/java/`
2. Run `mvn clean package` to build
3. Use `mvn tomcat7:run` for development server

### For Frontend Development
1. Navigate to `ui.resources/`
2. Run `ng serve` for development server
3. Run `ng build --prod` for production build

### Full Stack Development
1. Start MongoDB (if required)
2. Run backend: `mvn tomcat7:run`
3. Run frontend: `cd ui.resources && ng serve`
4. Access at `http://localhost:4200` (Angular) or `http://localhost:8080` (Java)

## 🆘 Getting Help

### Documentation
- Each example has its own detailed README.md
- Check the specific example directory for setup instructions
- Review the troubleshooting sections for common issues

### Common Issues
- **Port conflicts**: Change ports in configuration files
- **MongoDB connection**: Ensure MongoDB is running
- **Angular CLI issues**: Update to latest version
- **Build failures**: Clean and rebuild with `mvn clean package`

### Support
- Check the main project repository for issues and discussions
- Review example-specific documentation for detailed setup instructions
- Ensure all prerequisites are properly installed

## 🎯 Next Steps

1. **Explore Examples**: Start with the Basic Authentication example
2. **Customize**: Modify examples to fit your needs
3. **Build**: Create your own JAQ Stack applications
4. **Contribute**: Share improvements and new examples

---

**Happy Coding with JAQ Stack! 🚀**
