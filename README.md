# Java Demo Application - Spring Boot REST API

A complete Spring Boot REST API project for Maven and DevOps teaching. This demonstrates how to build production-ready microservices that are:
- ✅ Built with Maven
- ✅ Packaged as executable JAR
- ✅ Ready for Docker containerization
- ✅ Kubernetes deployment ready
- ✅ DevOps monitoring enabled (health checks, metrics)

## Project Structure

```
.
├── pom.xml                              # Maven configuration with Spring Boot
├── src/
│   ├── main/
│   │   ├── java/com/demo/
│   │   │   ├── Application.java         # Spring Boot entry point
│   │   │   └── controller/
│   │   │       └── DemoController.java  # REST API endpoints
│   │   └── resources/
│   │       ├── application.properties   # Spring Boot configuration
│   │       └── static/
│   │           └── index.html           # Professional FinTech dashboard UI
│   └── test/java/com/demo/
│       └── ApplicationTest.java         # Integration tests
└── README.md
```

## Prerequisites

- **Java Development Kit (JDK)**: Version 11 or higher
  - Verify with: `java -version` and `javac -version`
- **Maven**: Version 3.6 or higher
  - Verify with: `mvn -version`

## Building the Project

### 1. Clean Build
```bash
cd /path/to/java_practice
mvn clean package
```

This command:
- Cleans previous build artifacts
- Compiles the source code
- Runs all integration tests
- Creates executable JAR: `target/java-demo-app-1.0.0.jar`
- **Spring Boot automatically creates proper manifest!**

### 2. Verify Build Success
```bash
ls -lh target/java-demo-app-1.0.0.jar
```

## Running the Application

### Start the Server (Port: 9090)
```bash
java -jar target/java-demo-app-1.0.0.jar
```

### Console Output
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_|\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 
Tomcat started on port(s): 9090
```
### Access the Application

**Option 1: Professional Dashboard UI (Recommended for Demo)**
```
http://localhost:9090
```
- Beautiful FinTech-style dashboard
- Interactive API test console
- Real-time system information display
- REST endpoint documentation
- Perfect for showing to students!

**Option 2: Direct REST API Endpoints**
```
http://localhost:9090/api/welcome
http://localhost:9090/api/info
http://localhost:9090/api/greet?name=YourName
http://localhost:9090/api/calculate?a=10&b=5
http://localhost:9090/actuator/health
```
## Quick Start Guide for Students (Windows & Mac)

### Step-by-Step Instructions:

**Step 1: Clone the repository**
```bash
git clone <your-repository-url>
cd java_practice
```

**Step 2: Build with Maven**
```bash
mvn clean package
```

**Step 3: Run the application**
```bash
java -jar target/java-demo-app-1.0.0.jar
```

**Step 4: Open in browser**
```
http://localhost:9090
```

**Step 4b: Or test individual endpoints**
```
http://localhost:9090/api/welcome
http://localhost:9090/api/info
http://localhost:9090/api/greet?name=YourName
http://localhost:9090/api/calculate?a=10&b=5
```

**Step 5: Done! ✅**
Your Spring Boot application is now running!

### Accessing from Another Machine on the Network:

**On Windows, run:**
```bash
ipconfig
```

**Find your IPv4 Address** (example: 192.168.10.50)

**From another PC, use:**
```
http://192.168.10.50:9090/api/welcome
http://192.168.10.50:9090/api/info
http://192.168.10.50:9090/api/greet?name=YourName
http://192.168.10.50:9090/actuator/health
```

### Why This Works Everywhere:

- ✅ Java is **cross-platform** (Mac, Windows, Linux)
- ✅ Spring Boot runs **identically** on all operating systems
- ✅ Maven build process is the **same everywhere**
- ✅ Port `9090` with `server.address=0.0.0.0` enables **network access**
- ✅ One JAR file runs on **any machine** with Java installed

---

## REST API Endpoints

### 1. Welcome Endpoint
```bash
curl http://localhost:9090/api/welcome
```

Response:
```json
{
  "title": "Welcome to Spring Boot REST API",
  "message": "This is a Java application built with Spring Boot and Maven",
  "features": "REST API, DevOps ready, Containerizable",
  "endpoints": "Visit http://localhost:9090/api/info for more details"
}
```

### 2. Application Info (System Information)
```bash
curl http://localhost:9090/api/info
```

Response includes:
- Application name and version
- Java version, vendor, and runtime info
- Operating system details
- Memory and processor info
- Build configuration (Maven, Spring Boot)

**Great for DevOps! Shows what's running on your server.**

### 3. Greeting Endpoint
```bash
curl "http://localhost:9090/api/greet?name=John"
```

Response:
```json
{
  "message": "Hello, John!",
  "status": "Success",
  "timestamp": "2024-09-24 10:30:45"
}
```

### 4. Calculator Endpoint
```bash
curl "http://localhost:9090/api/calculate?a=10&b=5"
```

Response:
```json
{
  "num1": 10,
  "num2": 5,
  "addition": 15,
  "subtraction": 5,
  "multiplication": 50,
  "division": 2.0
}
```

## DevOps Monitoring Endpoints (Actuator)

Spring Boot Actuator provides endpoints for monitoring and management:

### 1. Health Check (Kubernetes uses this!)
```bash
curl http://localhost:9090/actuator/health
```

Response:
```json
{
  "status": "UP",
  "components": { ... }
}
```

**Why it matters for DevOps:**
- Kubernetes probes this endpoint for liveness checks
- Docker health checks use this
- Load balancers check this to route traffic

### 2. All Actuator Endpoints
```bash
curl http://localhost:9090/actuator
```

Shows all available monitoring endpoints (metrics, env, etc.)

### 3. Application Metrics
```bash
curl http://localhost:9090/actuator/metrics
```

Shows system metrics for monitoring

## Maven Lifecycle Commands

```bash
# Compile code
mvn compile

# Run tests
mvn test

# Package JAR
mvn package

# View dependencies
mvn dependency:tree

# Run the app directly (without JAR)
mvn spring-boot:run

# Clean all build files
mvn clean
```

## Spring Boot vs Traditional Java

| Aspect | Traditional Java | Spring Boot |
|--------|------------------|------------|
| **Entry Point** | Must write main() | @SpringBootApplication |
| **Web Server** | Download Tomcat separately | Built-in Tomcat |
| **Configuration** | XML files | application.properties |
| **Manifest** | Must configure manually | Automatic! |
| **Dependencies** | Manual management | Smart auto-detection |
| **Logging** | Configure SLF4J | Ready to use |
| **Testing** | JUnit only | Full test framework |
| **DevOps Ready** | Requires setup | Built-in (Actuator) |

## Understanding Manifest in Spring Boot

**Spring Boot handles manifest automatically!**

Check the generated manifest:
```bash
jar xf target/java-demo-app-1.0.0.jar META-INF/MANIFEST.MF
cat META-INF/MANIFEST.MF
```

You'll see:
```
Manifest-Version: 1.0
Main-Class: org.springframework.boot.loader.JarLauncher
Start-Class: com.demo.Application
```

**Spring Boot does the heavy lifting so you don't have to!**

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test
```bash
mvn test -Dtest=ApplicationTest
```

Test Coverage:
- ✓ Application context loads successfully
- ✓ All REST endpoints return correct responses
- ✓ JSON responses are properly formatted
- ✓ Health endpoint works (DevOps monitoring)

## Containerization (Docker)

This application is Docker-ready! Create `Dockerfile`:

```dockerfile
FROM openjdk:11-jre-slim
COPY target/java-demo-app-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Build and run:
```bash
docker build -t my-app:1.0 .
docker run -p 9090:9090 my-app:1.0
```

## Kubernetes Deployment

Deploy to Kubernetes with health checks built-in:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: java-demo-app
spec:
  replicas: 3
  template:
    spec:
      containers:
      - name: app
        image: my-app:1.0
        ports:
        - containerPort: 9090
        livenessProbe:
          httpGet:
            path: /actuator/health
            port: 9090
        readinessProbe:
          httpGet:
            path: /actuator/health
            port: 9090
```

**Spring Boot's `/actuator/health` endpoint makes this easy!**

## Development Workflow

### 1. Edit Code
```bash
# Modify DemoController.java
nano src/main/java/com/demo/controller/DemoController.java
```

### 2. Rebuild
```bash
mvn clean package
```

### 3. Test Locally
```bash
java -jar target/java-demo-app-1.0.0.jar
# Open browser and visit: http://localhost:9090
# Or test API: curl http://localhost:9090/api/info
```

### 4. Containerize
```bash
docker build -t my-app:latest .
docker run -p 9090:9090 my-app:latest
```

### 5. Deploy
```bash
kubectl apply -f deployment.yaml
```

## Professional Dashboard Features

The application now includes a **professional FinTech-style dashboard** (`src/main/resources/static/index.html`):

✨ **UI Features:**
- Dark theme with cyan/blue accent colors (enterprise-grade)
- Responsive design (works on mobile and desktop)
- Real-time system information display
- Interactive API test console
- Professional stat cards showing API status, Java version, system health
- Activity feed with application status
- REST API documentation table
- Live JSON response display

🎓 **Perfect for Demos:**
- Shows students a complete full-stack application
- Demonstrates frontend + backend integration
- Professional appearance suitable for DevOps bootcamp
- Students can test APIs without using curl/Postman

## Key Teaching Points

✅ **Maven** - Builds and packages Java applications  
✅ **Spring Boot** - Simplifies Java microservices  
✅ **REST API** - Stateless HTTP endpoints  
✅ **Static Resources** - Serving HTML/CSS/JavaScript with Spring Boot  
✅ **Actuator** - DevOps monitoring built-in  
✅ **Manifest** - Spring Boot handles it automatically  
✅ **Executable JAR** - Single file deployment  
✅ **Full-Stack Demo** - Backend APIs + Frontend UI  
✅ **Docker** - Container your application  
✅ **Kubernetes** - Orchestrate containers  
✅ **DevOps** - Health checks, metrics, logs  

## Troubleshooting

| Issue | Solution |
|-------|----------|
| Port 9090 already in use | `java -jar app.jar --server.port=9999` |
| Application won't start | Check logs: `mvn spring-boot:run` |
| Tests fail | Run `mvn clean test` |
| JAR not created | Verify Maven version: `mvn -version` |

## Further Learning

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Boot Actuator Guide](https://spring.io/guides/gs/actuator-service/)
- [Maven Documentation](https://maven.apache.org/)
- [Docker Documentation](https://docs.docker.com/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)

---

**Built for DevOps bootcamp students to learn Maven, Spring Boot, and microservices!** 🚀
