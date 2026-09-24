# Java Demo Application - Spring Boot REST API

A complete Spring Boot REST API project for Maven and DevOps teaching. This application demonstrates:

## What This Code Does

This is a **professional microservice** that:

1. **REST API Server** - Provides 4 functional endpoints:
   - `/api/welcome` - Welcome message with system information
   - `/api/info` - Detailed system & Java runtime information
   - `/api/greet?name=X` - Personalized greeting with timestamp
   - `/api/calculate?a=X&b=Y` - Math calculations (add, subtract, multiply, divide)

2. **Professional Dashboard UI** - Beautiful FinTech-style web interface:
   - Real-time system status monitoring
   - Interactive API test console
   - Responsive design (works on mobile/tablet/desktop)
   - Shows Java version, memory usage, system health

3. **DevOps Ready** - Production-grade features:
   - Spring Boot Actuator for health checks & metrics
   - Structured logging with different log levels
   - Graceful shutdown support
   - Network-accessible (0.0.0.0 binding for cross-machine access)

4. **Enterprise Integration** - Nexus artifact repository:
   - Build artifacts packaged as JAR
   - Automated deployment to Nexus repository
   - Perfect for CI/CD pipelines

## Technology Stack

- ✅ **Java 21** runtime with Spring Boot 3.1.5
- ✅ **Maven 3.6+** for build automation
- ✅ **Spring Framework 6.0** with embedded Tomcat 10.1
- ✅ **Nexus Repository** for artifact management
- ✅ **Cross-platform** (Mac, Windows, Linux)
- ✅ **DevOps monitoring** enabled (health checks, metrics)

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

## 🚀 Nexus Artifact Repository Deployment

This is where **DevOps magic happens!** Push your compiled JAR to Nexus for centralized artifact management.

### Why Nexus?

- 📦 **Centralized Repository** - Single source of truth for all artifacts
- 🔐 **Version Control** - Track every build version
- 🔄 **CI/CD Integration** - Automated deployment from pipelines
- 📊 **Artifact Tracking** - Know exactly what's deployed where
- 🛡️ **Release Management** - Separate RELEASE vs SNAPSHOT versions

### Setup (One-Time Configuration)

**1. Create Maven settings file** (if not already created)
```bash
cp settings.xml.example ~/.m2/settings.xml
```

**2. Edit with your Nexus credentials**
```bash
nano ~/.m2/settings.xml
```

Update the placeholders:
```xml
<username>YOUR_NEXUS_USERNAME</username>
<password>YOUR_NEXUS_PASSWORD</password>
```

For this demo: username=`admin`, password=`admin123`

**3. Verify Nexus is running**
```bash
# Check if Nexus container is running
docker ps | grep nexus

# Or access Nexus UI
open http://localhost:8081
# Login: admin / admin123
```

### Deploy Artifact to Nexus

**Simple One-Command Deployment:**
```bash
mvn clean package deploy
```

This does everything:
1. ✅ Cleans previous builds
2. ✅ Compiles source code
3. ✅ Runs all tests
4. ✅ Creates executable JAR
5. ✅ **Uploads JAR to Nexus repository**

**Console Output Example:**
```
[INFO] Building jar: target/java-demo-app-1.0.0.jar
[INFO] Uploading to nexus: http://localhost:8081/repository/maven-releases/
[INFO] Uploaded: com/demo/java-demo-app/1.0.0/java-demo-app-1.0.0.jar
[INFO] BUILD SUCCESS
```

### Verify Artifact in Nexus

**Option 1: Via Nexus Web UI**
1. Open http://localhost:8081
2. Login: `admin` / `admin123`
3. Click "Browse" → "maven-releases"
4. Navigate: `com` → `demo` → `java-demo-app` → `1.0.0`
5. See your JAR file! 🎉

**Option 2: Via Command Line**
```bash
# Check Nexus repository (requires curl)
curl -u admin:admin123 http://localhost:8081/service/rest/v1/search/assets
```

### Understanding Maven Repository URLs

In `pom.xml`, we configure two repositories:

```xml
<!-- Release versions (stable builds) -->
<repository>
    <id>nexus-releases</id>
    <url>http://localhost:8081/repository/maven-releases/</url>
</repository>

<!-- Snapshot versions (development builds) -->
<snapshotRepository>
    <id>nexus-snapshots</id>
    <url>http://localhost:8081/repository/maven-snapshots/</url>
</snapshotRepository>
```

**Key Difference:**
- **RELEASE** (1.0.0) - Final, production-ready versions
- **SNAPSHOT** (1.0.0-SNAPSHOT) - Development, frequently changing versions

### Complete DevOps Workflow

```bash
# 1. Edit code
nano src/main/java/com/demo/controller/DemoController.java

# 2. Run tests locally
mvn test

# 3. Build and run locally
java -jar target/java-demo-app-1.0.0.jar
# Test at http://localhost:9090

# 4. Deploy to Nexus (push artifact)
mvn clean package deploy

# 5. Verify in Nexus UI
open http://localhost:8081

# 6. Push changes to GitHub
git add .
git commit -m "Update API endpoint"
git push origin main

# 7. Now anyone on the team can use the artifact:
# mvn dependency:copy -Dartifact=com.demo:java-demo-app:1.0.0
```

### Troubleshooting Deployment

**Error: 401 Unauthorized**
```
Solution: Check credentials in ~/.m2/settings.xml
mvn clean package deploy -X  # Add -X for debug output
```

**Error: Cannot connect to Nexus**
```
Solution: Verify Nexus is running
docker ps | grep nexus
# If not running: docker start nexus (or docker-compose up)
```

**Artifact not showing in Nexus**
```
Solution: Check build log for [INFO] BUILD SUCCESS
mvn clean package deploy -e  # Add -e for error details
```

### Version Management: SNAPSHOT vs RELEASE

**This is the realistic DevOps pattern for your bootcamp demo!**

#### Technical Deep Dive: How SNAPSHOT vs RELEASE Work

##### 🟢 SNAPSHOT Versions (1.0.0-SNAPSHOT)

**How it works:**
- Each deploy **overwrites** the previous snapshot in Nexus
- Nexus stores metadata: timestamp, build number, classifier
- Multiple deployments are **always allowed**

**Example behavior:**
```bash
mvn clean package deploy  # ✅ SUCCESS - deploys 1.0.0-SNAPSHOT
# Make code changes...
mvn clean package deploy  # ✅ SUCCESS - overwrites previous snapshot
# Make more changes...
mvn clean package deploy  # ✅ SUCCESS - still works!
```

**Use Case:** Development/testing builds
- Perfect for iterating during development
- Developers always get the latest development build
- Nexus automatically manages multiple snapshots with timestamps

##### 🔴 RELEASE Versions (1.0.0)

**How it works:**
- Nexus treats RELEASE versions as **immutable** (cannot be changed)
- Second deployment attempt is **blocked by Nexus**
- This is a security feature to ensure production versions never change

**Example behavior:**
```bash
mvn clean package deploy  # ✅ SUCCESS - deployed to releases repo
# Try to deploy again...
mvn clean package deploy  # ❌ FAILURE - 400 Bad Request
```

**Error Message:**
```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-deploy-plugin:2.8.2:deploy
[ERROR] Failed to transfer file: http://localhost:8081/repository/maven-releases/
[ERROR] com/demo/java-demo-app/1.0.0/java-demo-app-1.0.0.jar
[ERROR] Return code is: 400, ReasonPhrase: Bad Request.
[ERROR] The artifact already exists in the repository.
```

**Use Case:** Production/final releases
- Immutable = cannot be accidentally overwritten
- Clear separation: what's in production stays in production
- Security: ensures released versions are trusted

#### Comparison Table

| Aspect | SNAPSHOT (1.0.0-SNAPSHOT) | RELEASE (1.0.0) |
|--------|---------------------------|-----------------|
| **Immutable** | ❌ No (can overwrite) | ✅ Yes (one-time only) |
| **Purpose** | Development/Testing | Production |
| **Re-deploy same version** | ✅ Multiple times allowed | ❌ Fails with 400 error |
| **Nexus Behavior** | Stores with timestamp | Blocks duplicates |
| **Security** | Lower priority | Higher priority |
| **Use in CI/CD** | Every build is a snapshot | Only for final releases |
| **Artifact Cleanup** | Auto-cleanup old snapshots | Kept forever |

#### Current Status
```xml
<version>1.0.0-SNAPSHOT</version>  ← Development version (can deploy multiple times)
```

#### Demo Workflow (Realistic Teaching Example)

**Phase 1: Development & Testing** (Days 1-5 of bootcamp)
```bash
# Using SNAPSHOT version - can deploy infinite times
# pom.xml: 1.0.0-SNAPSHOT

# Day 1: Initial demo
mvn clean package deploy  # ✅ Deployed to snapshots repo
# Show students the Nexus UI: http://localhost:8081

# Day 2: Add new endpoint
# Edit DemoController.java, add new feature
mvn clean package deploy  # ✅ Overwrites previous snapshot (no error!)
# Show students the updated version in Nexus

# Day 3: Bug fix
# Update code, add more features
mvn clean package deploy  # ✅ Still works! SNAPSHOT allows re-deployment
```

**Phase 2: Final Release** (Day 6 - Release day)
```bash
# Update pom.xml for final release
<version>1.0.0</version>  ← Production release (deploy only once!)

# Build final release version
mvn clean package deploy  # ✅ Deployed to releases repo (immutable)
# Show students: This is now in PRODUCTION!
```

**Phase 3: Next Version** (After release)
```bash
# Update pom.xml for next development cycle
<version>1.0.1-SNAPSHOT</version>  ← Ready for next iteration

# Continue iterating...
mvn clean package deploy  # ✅ Can deploy multiple times again
```

#### How to Increment Version During Demo

**Option 1: Manual Edit (Recommended)**
```bash
# Edit pom.xml
nano pom.xml
# Change: <version>1.0.0-SNAPSHOT</version>
# To:     <version>1.0.1-SNAPSHOT</version>
# Save and run:
mvn clean package deploy
```

**Option 2: Maven Versions Plugin (Automated)**
```bash
# Change version automatically
mvn versions:set -DnewVersion=1.0.1-SNAPSHOT

# Confirm changes
mvn versions:commit

# Deploy
mvn clean package deploy
```

**Option 3: Git Workflow (Professional)**
```bash
# Tag the release in git
git tag -a v1.0.0 -m "Release version 1.0.0"
git push origin v1.0.0

# Then increment for development
mvn versions:set -DnewVersion=1.0.1-SNAPSHOT
git add pom.xml
git commit -m "Start development on version 1.0.1"
git push origin main
```

#### Teaching Points for Your Bootcamp

**Why SNAPSHOT during development:**
- ✅ Can deploy multiple times (perfect for iterating)
- ✅ Shows version history with timestamps
- ✅ Developers always get latest development build
- ✅ No conflicts or errors on re-deployment

**Why RELEASE for production:**
- ✅ Immutable - cannot be changed accidentally
- ✅ Clear, final version number (1.0.0 not 1.0.0-SNAPSHOT-20240925)
- ✅ Easy to track what's deployed in production
- ✅ Security: Release versions are meant to stay stable

**Real-world example:**
```
Netflix uses this pattern:
- Development: 7.2.0-SNAPSHOT (deploy 50 times per day!)
- Release: 7.2.0 (deployed to production, never changes)
- Next: 7.3.0-SNAPSHOT (new development cycle)
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
