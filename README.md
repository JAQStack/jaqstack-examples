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
- **Java 11+** - Modern Java with latest features
- **Maven 3.6+** - Dependency management and build automation
- **RESTful APIs** - Clean, scalable web services
- **JWT Authentication** - Secure token-based authentication
- **MongoDB/SQL** - Flexible database options

### Frontend Technologies
- **Angular 14+** - Modern reactive frontend framework
- **TypeScript** - Type-safe JavaScript development
- **Angular CLI** - Command-line interface for Angular
- **Node.js 14+** - JavaScript runtime for development tools

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

- **Java 11+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Node.js 14+** - [Download](https://nodejs.org/)
- **Angular CLI** - `npm install -g @angular/cli`
- **Maven 3.6+** - [Download](https://maven.apache.org/download.cgi)
- **MongoDB** (optional) - [Download](https://www.mongodb.com/try/download/community)

### Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/[your-username]/jaqstack-examples.git
   cd jaqstack-examples
   ```

2. **Explore the examples**
   ```bash
   # Basic Authentication example
   cd examples/basicauthentication
   mvn clean package
   mvn tomcat7:run
   ```

3. **Access the application**
   - Open your browser to `http://localhost:8080/basicauth`

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
│   └── README.md                  # Examples documentation
├── docs/                          # Documentation
└── README.md                      # This file
```

## 🎯 Available Examples

### 🔐 [Basic Authentication](./examples/basicauthentication/)
Complete authentication system with user management, JWT tokens, and MongoDB integration.

**Features:**
- User registration and login
- JWT token-based authentication
- MongoDB integration
- Angular authentication guards
- RESTful API endpoints

### ☁️ [Azure Blob Viewer](./examples/azureblobviewer/)
Azure Blob Storage integration for cloud file management and viewing.

**Features:**
- Azure Blob Storage integration
- File upload and download
- Image preview and management
- RESTful API for blob operations

## 🛠️ Development Workflow

### Backend Development
1. **Create Java services** in `src/main/java/`
2. **Build with Maven** - `mvn clean package`
3. **Run development server** - `mvn tomcat7:run`
4. **Test APIs** using Postman or browser

### Frontend Development
1. **Navigate to UI resources** - `cd ui.resources/`
2. **Install dependencies** - `npm install`
3. **Start development server** - `ng serve`
4. **Build for production** - `ng build --prod`

### Full-Stack Development
1. **Start backend** - `mvn tomcat7:run`
2. **Start frontend** - `cd ui.resources && ng serve`
3. **Access application** - `http://localhost:4200`

## 🏗️ Built With

JAQ Stack is built using industry-standard tools and frameworks:

- **Maven Archetype Webapp** - Standard Java web application structure
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
