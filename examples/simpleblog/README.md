# Simple Blog

A simple blog application built with the JAQ Stack (Java, Angular, Helidon, MongoDB).

## Technology Stack

- **Java**: 21
- **Helidon MP**: 4.3.1
- **Angular**: 20.0.0
- **MongoDB**: 3.9.1 (Java Driver)
- **Maven**: For build and dependency management

## Features

- Create, read blog posts
- RESTful API backend with Helidon MP
- Modern Angular 20 frontend
- MongoDB database integration
- CORS support for cross-origin requests

## Prerequisites

- JDK 21 or higher
- Maven 3.6+
- Node.js 18+ (for Angular development)
- MongoDB (running locally on default port 27017)

## Database Setup

The application uses MongoDB with the following configuration:
- **Database**: `jaqstack`
- **Collection**: `blogposts`

Make sure MongoDB is running before starting the application.

## Building the Application

### Backend (Helidon MP)

```bash
mvn clean package
```

This will create an executable JAR file at `target/simpleblog.jar`.

### Frontend (Angular)

```bash
cd ui.resources
npm install
ng build
```

The built frontend will be in `ui.resources/dist/` and will be automatically copied to the JAR during the Maven build.

## Running the Application

### Start MongoDB

Make sure MongoDB is running on `localhost:27017`.

### Start the Backend

```bash
java -jar target/simpleblog.jar
```

The server will start on `http://localhost:8080`.

### Start the Frontend (Development)

```bash
cd ui.resources
ng serve
```

The Angular app will be available at `http://localhost:4200`.

## API Endpoints

### Blog Posts

- **GET** `/blog/posts` - Get all blog posts
- **GET** `/blog/post/{id}` - Get a blog post by ID
- **POST** `/blog/post` - Create a new blog post

### Example: Create a Blog Post

```bash
curl -X POST http://localhost:8080/blog/post \
  -H "Content-Type: application/json" \
  -d '{"title":"My Blog Post","content":"This is the content","author":"John Doe"}'
```

### Example: Get All Blog Posts

```bash
curl http://localhost:8080/blog/posts
```

## Project Structure

```
simpleblog/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/jaqstack/helidon/simpleblog/
│       │       ├── BlogPost.java          # Blog post model
│       │       ├── BlogResource.java      # REST endpoints
│       │       ├── BlogService.java       # Business logic
│       │       ├── DataService.java       # MongoDB operations
│       │       └── Main.java              # Application entry point
│       └── resources/
│           └── META-INF/
│               ├── beans.xml               # CDI configuration
│               └── microprofile-config.properties
├── ui.resources/                           # Angular frontend
│   ├── src/
│   │   └── app/
│   │       ├── app.component.*            # Root component
│   │       ├── home/                      # Home page component
│   │       ├── blog-detail/               # Blog detail component
│   │       └── blog.service.ts            # API service
│   └── dist/                               # Built frontend (copied to JAR)
└── pom.xml                                 # Maven configuration
```

## CORS Configuration

The application includes CORS headers to allow the Angular frontend (running on port 4200) to communicate with the backend (running on port 8080). CORS is configured in `BlogResource.java` with support for preflight OPTIONS requests.

## Building a Native Image

The generation of native binaries requires an installation of GraalVM 22.1.0+.

You can build a native binary using Maven as follows:

```bash
mvn -Pnative-image install -DskipTests
```

The generation of the executable binary may take a few minutes to complete depending on your hardware and operating system. When completed, the executable file will be available under the `target` directory.

## Health Check

```bash
curl -s -X GET http://localhost:8080/health
```

## Metrics

```bash
# Prometheus Format
curl -s -X GET http://localhost:8080/metrics

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
```

## Building the Docker Image

```bash
docker build -t simpleblog .
```

## Running the Docker Image

```bash
docker run --rm -p 8080:8080 simpleblog:latest
```

## License

MIT
