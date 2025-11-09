# JAQ Stack 🚀

**Build modern web applications quickly using Java, Angular, and NoSQL/SQL databases**

JAQ Stack is a comprehensive full-stack development framework that combines the power of Java backend services with modern Angular frontend applications, enabling rapid development of enterprise-grade web applications.

## 🎯 What is JAQ Stack?

JAQ Stack is a full-stack development framework that combines:
- **J**ava - Robust backend services and REST APIs
- **A**ngular - Modern, reactive frontend framework  
- **Q**uick - Rapid development and deployment

## 🏗️ The Technology Stack

### Backend Technologies
- **Java 11-21** - Modern Java with latest features (examples use Java 11+ or Java 21)
- **Helidon MP** - MicroProfile framework for microservices (used in Simple Blog)
- **Maven 3.6+** - Dependency management and build automation
- **RESTful APIs** - Clean, scalable web services
- **JWT Authentication** - Secure token-based authentication
- **MongoDB/SQL** - Flexible database options

### Frontend Technologies
- **Angular 14-20** - Modern reactive frontend framework (examples use Angular 14+ or Angular 20)
- **TypeScript** - Type-safe JavaScript development
- **Angular CLI** - Command-line interface for Angular
- **Node.js 18+** - JavaScript runtime for development tools

### Development Tools
- **Maven Tomcat Plugin** - Embedded development server
- **Angular Dev Server** - Hot-reload development environment
- **Git** - Version control and collaboration

## 🏛️ Architecture Overview

JAQ Stack follows a modern, layered architecture:

```
┌─────────────────────────────────────────┐
│              Frontend Layer             │
│  ┌─────────────────────────────────────┐ │
│  │         Angular Application         │ │
│  │  • Components & Services           │ │
│  │  • HTTP Client & Authentication    │ │
│  │  • Routing & Guards                 │ │
│  └─────────────────────────────────────┘ │
└─────────────────────────────────────────┘
                    │
                    │ HTTP/REST API
                    ▼
┌─────────────────────────────────────────┐
│              Backend Layer              │
│  ┌─────────────────────────────────────┐ │
│  │         Java Services               │ │
│  │  • REST Controllers                 │ │
│  │  • Business Logic                   │ │
│  │  • Authentication & Authorization  │ │
│  └─────────────────────────────────────┘ │
└─────────────────────────────────────────┘
                    │
                    │ Data Access
                    ▼
┌─────────────────────────────────────────┐
│              Data Layer                 │
│  ┌─────────────────────────────────────┐ │
│  │         Database                    │ │
│  │  • MongoDB (NoSQL)                  │ │
│  │  • SQL Databases                    │ │
│  │  • Data Models & Repositories       │ │
│  └─────────────────────────────────────┘ │
└─────────────────────────────────────────┘
```

## 🚀 Quick Start

### Prerequisites
Before getting started, ensure you have:

- **Java 11+** (Java 21 recommended for Simple Blog) - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Node.js 18+** - [Download](https://nodejs.org/)
- **Angular CLI** - `npm install -g @angular/cli`
- **Maven 3.6+** - [Download](https://maven.apache.org/download.cgi)
- **MongoDB** (optional, required for some examples) - [Download](https://www.mongodb.com/try/download/community)

### Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/[your-username]/jaqstack-examples.git
   cd jaqstack-examples
   ```

2. **Explore the examples**
   ```bash
   # Basic Authentication example (Tomcat-based)
   cd examples/basicauthentication
   mvn clean package
   mvn tomcat7:run
   # Access at http://localhost:8080/basicauth
   
   # Simple Blog example (Helidon MP)
   cd examples/simpleblog
   mvn clean package
   java -jar target/simpleblog.jar
   # Access at http://localhost:8080
   ```

3. **Access the applications**
   - Each example has its own README with specific instructions
   - Check the [Available Examples](#-available-examples) section for details

## 📁 Project Structure

```
jaqstack-examples/
├── core/                           # Core framework and utilities
│   ├── src/main/java/             # Core Java services
│   ├── src/main/webapp/           # Core web resources
│   └── ui.resources/              # Core Angular components
├── examples/                       # Example applications
│   ├── basicauthentication/       # Authentication example
│   ├── azureblobviewer/           # Azure integration example
│   ├── simpleblog/                # Simple blog with Helidon MP
│   └── README.md                  # Examples documentation
├── docs/                          # Documentation
└── README.md                      # This file
```

## 🎯 Available Examples

| Example | Description | Key Features |
|---------|-------------|--------------|
| 🔐 [Basic Authentication](./examples/basicauthentication/) | Complete authentication system with user management, JWT tokens, and MongoDB integration. | User registration and login, JWT token-based authentication, MongoDB integration, Angular authentication guards, RESTful API endpoints |
| ☁️ [Azure Blob Viewer](./examples/azureblobviewer/) | Azure Blob Storage integration for cloud file management and viewing. | Azure Blob Storage integration, File upload and download, Image preview and management, RESTful API for blob operations |
| 📝 [Simple Blog](./examples/simpleblog/) | A simple blog application built with Java, Angular, Helidon, and MongoDB. | Create and read blog posts, RESTful API backend with Helidon MP, Modern Angular 20 frontend, MongoDB database integration, CORS support |

## 🛠️ Development Workflow

### Backend Development
1. **Create Java services** in `src/main/java/`
2. **Build with Maven** - `mvn clean package`
3. **Run development server** - 
   - For Tomcat-based examples: `mvn tomcat7:run`
   - For Helidon MP examples: `java -jar target/[app-name].jar`
4. **Test APIs** using Postman or browser

### Frontend Development
1. **Navigate to UI resources** - `cd ui.resources/`
2. **Install dependencies** - `npm install`
3. **Start development server** - `ng serve`
4. **Build for production** - `ng build --prod`

### Full-Stack Development
1. **Start backend** - 
   - Tomcat-based: `mvn tomcat7:run`
   - Helidon MP: `java -jar target/[app-name].jar`
2. **Start frontend** - `cd ui.resources && ng serve`
3. **Access application** - `http://localhost:4200` (frontend) or `http://localhost:8080` (backend API)

## 🏗️ Built With

JAQ Stack is built using industry-standard tools and frameworks:

- **Maven Archetype Webapp** - Standard Java web application structure
- **Helidon MP** - MicroProfile framework for microservices
- **Angular CLI** - Modern Angular development tools
- **Bootstrap Themes** - Professional UI components
- **Initializr** - Modern web app boilerplate

## 🎨 Themes and UI

JAQ Stack includes modern, responsive themes:

- **Initializr 9** - [http://www.initializr.com/](http://www.initializr.com/)
- **Bootstrap Integration** - Responsive design framework
- **Angular Material** - Modern UI components
- **Custom Themes** - Extensible styling system

## 📚 Documentation

- **[Examples Documentation](./examples/README.md)** - Comprehensive examples guide
- **[Core Documentation](./core/README.md)** - Framework core documentation
- **[API Documentation](./docs/)** - Detailed API references

## 🤝 Contributing

We welcome contributions to JAQ Stack! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch** - `git checkout -b feature/amazing-feature`
3. **Commit your changes** - `git commit -m 'Add amazing feature'`
4. **Push to the branch** - `git push origin feature/amazing-feature`
5. **Open a Pull Request**

## 👥 Team

- **Suren Konathala** - Principal Architect/Developer [@ksurendra](https://twitter.com/ksurendra)
- **Viswa Patimalla** - Senior Developer

## 🙏 Credits

JAQ Stack is built on the shoulders of giants:

- **Java** - Oracle Corporation
- **Angular** - Google
- **Maven** - Apache Maven Project
- **MongoDB** - MongoDB Inc.
- **Bootstrap** - Twitter Bootstrap Team

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

- **Documentation** - Check the examples and docs directories
- **Issues** - Report bugs and request features on GitHub
- **Discussions** - Join the community discussions
- **Twitter** - Follow [@ksurendra](https://twitter.com/ksurendra) for updates

---

**Happy Coding with JAQ Stack! 🚀**
