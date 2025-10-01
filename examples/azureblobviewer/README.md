# Azure Blob Viewer - JAQ Stack Example

This module demonstrates Azure Blob Storage integration using the JAQ Stack framework. It provides a complete web application for viewing, managing, and interacting with Azure Blob Storage containers and files.

## 🎯 Features

- **Azure Blob Storage Integration** - Connect to and manage Azure Blob Storage accounts
- **File Management** - Upload, download, and delete blob files
- **Image Preview** - View images directly in the browser
- **Container Management** - List and manage blob containers
- **RESTful API** - Complete REST API for blob operations
- **Angular Frontend** - Modern, responsive user interface
- **Java Backend** - Robust server-side processing

## 🏗️ Technology Stack

### Backend
- **Java 11+** - Modern Java with latest features
- **Jersey 3.x** - RESTful web services framework
- **Azure Storage SDK** - Official Azure Blob Storage client
- **MongoDB** - Optional data storage
- **Maven** - Build and dependency management

### Frontend
- **Angular 16+** - Modern reactive frontend framework
- **TypeScript** - Type-safe development
- **Bootstrap** - Responsive UI components
- **RxJS** - Reactive programming

## 📋 Prerequisites

Before building and running this project, ensure you have:

- **Java 11+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Node.js 18+** - [Download](https://nodejs.org/)
- **Angular CLI 16+** - `npm install -g @angular/cli@16`
- **Maven 3.6+** - [Download](https://maven.apache.org/download.cgi)
- **Azure Storage Account** - [Create Azure Storage Account](https://azure.microsoft.com/en-us/services/storage/)

## 🚀 Quick Start

### 1. Clone and Setup
```bash
git clone https://github.com/JAQStack/jaqstack-examples.git
cd jaqstack-examples/examples/azureblobviewer
```

### 2. Install Dependencies
```bash
# Install Angular dependencies
cd ui.resources
npm install
cd ..
```

### 3. Build the Application
```bash
# Build Angular frontend
cd ui.resources
ng build --prod
cd ..

# Build Java application
mvn clean package
```

### 4. Run the Application
```bash
# Start the application
mvn tomcat7:run
```

### 5. Access the Application
- Open your browser to: `http://localhost:8080/jaqstack-azure-blobviewer`
- You should see the Azure Blob Viewer interface

## 🔧 Configuration

### Azure Storage Configuration

1. **Create Azure Storage Account**
   - Go to [Azure Portal](https://portal.azure.com)
   - Create a new Storage Account
   - Note down the account name and access key

2. **Configure Application**
   - Update the configuration in your application
   - Set the Azure Storage account name and key
   - Specify the container name to use

## 🛠️ Development

### Backend Development
1. **Modify Java services** in `src/main/java/`
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

## 📡 API Endpoints

### Blob Operations

#### List Blobs
- **URL**: `/service/blobservice/azure/fetch`
- **Method**: POST
- **Description**: Retrieve list of blobs from Azure Storage

**Request Body**:
```json
{
  "azureAccountName": "your-storage-account-name",
  "azureAccountKey": "your-storage-account-key",
  "azureContainer": "your-container-name"
}
```

**Response**:
```json
[
  {
    "blobName": "example.png",
    "blobURL": "https://yourstorageaccount.blob.core.windows.net/yourcontainer/example.png",
    "blobMimeType": "image/png"
  }
]
```

#### Upload Blob
- **URL**: `/service/blobservice/azure/upload`
- **Method**: POST
- **Description**: Upload file to Azure Blob Storage

#### Download Blob
- **URL**: `/service/blobservice/azure/download`
- **Method**: GET
- **Description**: Download blob from Azure Storage

#### Delete Blob
- **URL**: `/service/blobservice/azure/delete`
- **Method**: DELETE
- **Description**: Delete blob from Azure Storage

## 🧪 Testing

### Browser Testing
1. **Access the application**: `http://localhost:8080/jaqstack-azure-blobviewer`
2. **Navigate to the interface** and test blob operations
3. **Verify file upload/download** functionality

### API Testing with Postman

#### Test Blob Fetch
```bash
POST http://localhost:8080/jaqstack-azure-blobviewer/service/blobservice/azure/fetch
Content-Type: application/json

{
  "azureAccountName": "your-storage-account",
  "azureAccountKey": "your-access-key",
  "azureContainer": "your-container"
}
```

#### Test Blob Upload
```bash
POST http://localhost:8080/jaqstack-azure-blobviewer/service/blobservice/azure/upload
Content-Type: multipart/form-data

# Include file in form data
```

## 🚀 Deployment

### Option 1: Maven Tomcat Plugin (Development)
```bash
mvn tomcat7:run
```

### Option 2: External Tomcat Server
1. **Build the application**:
   ```bash
   mvn clean package
   ```

2. **Deploy to Tomcat**:
   - Copy `target/jaqstack-azure-blobviewer.war` to Tomcat `webapps` directory
   - Start Tomcat server
   - Access at: `http://localhost:8080/jaqstack-azure-blobviewer`

### Option 3: Tomcat Manager
1. **Open Tomcat Manager**: `http://localhost:8080/manager/html`
2. **Upload WAR file**: Select `jaqstack-azure-blobviewer.war`
3. **Deploy application**
4. **Access application**: `http://localhost:8080/jaqstack-azure-blobviewer`

## 🔒 Security Considerations

- **Azure Storage Keys**: Store securely, never commit to version control
- **HTTPS**: Use HTTPS in production environments
- **Access Control**: Implement proper authentication and authorization
- **CORS**: Configure CORS settings for cross-origin requests

## 🐛 Troubleshooting

### Common Issues

#### 1. Azure Storage Connection Issues
**Problem**: Cannot connect to Azure Storage
**Solutions**:
- Verify Azure Storage account name and key
- Check network connectivity
- Ensure storage account is accessible
- Verify container name exists

#### 2. Build Failures
**Problem**: Maven build fails
**Solutions**:
- Clean and rebuild: `mvn clean package`
- Check Java version: `java -version` (should be 11+)
- Verify Maven installation: `mvn -version`
- Clear Maven cache: `mvn dependency:purge-local-repository`

#### 3. Angular Build Issues
**Problem**: Angular build fails
**Solutions**:
- Update Angular CLI: `npm install -g @angular/cli@16`
- Clear npm cache: `npm cache clean --force`
- Delete node_modules and reinstall: `rm -rf node_modules && npm install`
- Check Node.js version: `node -v` (should be 18+)

#### 4. Port Conflicts
**Problem**: Port 8080 is already in use
**Solutions**:
- Stop other services using port 8080
- Change Tomcat port in configuration
- Use different port: `mvn tomcat7:run -Dmaven.tomcat.port=8081`

## 📚 Additional Resources

- [Azure Blob Storage Documentation](https://docs.microsoft.com/en-us/azure/storage/blobs/)
- [Angular Documentation](https://angular.io/docs)
- [Jersey REST Framework](https://eclipse-ee4j.github.io/jersey/)
- [Maven Documentation](https://maven.apache.org/guides/)

## 🤝 Contributing

1. **Fork the repository**
2. **Create a feature branch** - `git checkout -b feature/amazing-feature`
3. **Commit your changes** - `git commit -m 'Add amazing feature'`
4. **Push to the branch** - `git push origin feature/amazing-feature`
5. **Open a Pull Request**

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](../../LICENSE) file for details.

---

**Happy Coding with JAQ Stack Azure Blob Viewer! 🚀**


