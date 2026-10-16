# Docker Containerization Guide

Complete guide to running the Java Demo Application in Docker containers.

## Table of Contents

1. [Quick Start](#quick-start)
2. [Prerequisites](#prerequisites)
3. [Docker Setup](#docker-setup)
4. [docker-compose Setup](#docker-compose-setup)
5. [Dockerfile Options](#dockerfile-options)
6. [Jenkins Pipeline](#jenkins-pipeline)
7. [Access the Application](#access-the-application)
8. [Troubleshooting](#troubleshooting)

---

## Quick Start

**Option 1: Using docker-compose (Easiest)** ✅
```bash
cd /Users/demu/raviteja-devops-teaching-code/java_practice
docker-compose up -d
```

Then access: **http://localhost:9090**

**Option 2: Using docker build & run**
```bash
docker build -t java-demo-app:1.0.0 .
docker run -d -p 9090:9090 --name java-demo-app java-demo-app:1.0.0
```

Then access: **http://localhost:9090**

---

## Prerequisites

- **Docker** (version 20.10+)
  ```bash
  docker --version
  ```

- **docker-compose** (version 1.29+)
  ```bash
  docker-compose --version
  ```

- **JAR file built** (from Maven)
  ```bash
  mvn clean package -DskipTests
  ```

---

## Docker Setup

### Build the Docker Image

**Using the simple Dockerfile (recommended for bootcamp):**
```bash
docker build -t java-demo-app:1.0.0 -t java-demo-app:latest .
```

**Using the multi-stage Dockerfile (production):**
```bash
docker build -f Dockerfile.multistage -t java-demo-app:1.0.0-prod .
```

### Verify Image

```bash
docker images | grep java-demo-app
```

Expected output:
```
java-demo-app   1.0.0       7dc9e6ade7a3   8 seconds ago   327MB
java-demo-app   latest      7dc9e6ade7a3   8 seconds ago   327MB
```

### Run the Container

**Start container:**
```bash
docker run -d \
  --name java-demo-app \
  -p 9090:9090 \
  java-demo-app:latest
```

**Verify container is running:**
```bash
docker ps | grep java-demo-app
```

**View container logs:**
```bash
docker logs java-demo-app
docker logs -f java-demo-app  # Follow logs in real-time
```

**Stop container:**
```bash
docker stop java-demo-app
```

**Start container (if already exists):**
```bash
docker start java-demo-app
```

**Remove container:**
```bash
docker rm java-demo-app
```

---

## docker-compose Setup

### Overview

`docker-compose.yml` provides a simple way to manage containers without typing long commands.

### Run with docker-compose

**Start (build if needed):**
```bash
docker-compose up -d
```

**View services:**
```bash
docker-compose ps
```

**View logs:**
```bash
docker-compose logs -f java-app
```

**Stop services:**
```bash
docker-compose stop
```

**Restart services:**
```bash
docker-compose restart
```

**Remove containers and volumes:**
```bash
docker-compose down
```

**Rebuild image (after code changes):**
```bash
docker-compose up --build -d
```

---

## Dockerfile Options

### 1. Simple Dockerfile (Default)

**File:** `Dockerfile`

**Best for:**
- Bootcamp demos
- Learning Docker basics
- Quick deployments

**Features:**
- Single stage
- Minimal, straightforward
- ~327MB image size
- Good for teaching

**Build:**
```bash
docker build -t java-demo-app:1.0.0 .
```

### 2. Multi-Stage Dockerfile (Production)

**File:** `Dockerfile.multistage`

**Best for:**
- Production deployments
- Optimized image size
- Security-hardened

**Features:**
- Multi-stage build
- Non-root user (security)
- Optimized layers
- Production-ready

**Build:**
```bash
docker build -f Dockerfile.multistage -t java-demo-app:1.0.0-prod .
```

---

## Jenkins Pipeline

The Jenkins pipeline automates the entire process:

### Pipeline Stages

1. **Checkout** - Clone from GitHub
2. **Build** - Maven compile
3. **Test** - Run 7 integration tests
4. **Package** - Create JAR file
5. **Dockerize** - Build Docker image
6. **Run Container** - Start and test container

### Trigger Pipeline

**Via Jenkins UI:**
1. Go to http://localhost:8080
2. Click on `java_app_demo_pipeline`
3. Click `Build Now`

**Via Command Line:**
```bash
curl -X POST http://localhost:8080/job/java_app_demo_pipeline/build \
  --user admin:admin
```

### Pipeline Output

After successful completion, you'll see:
```
✅ Pipeline SUCCESS - Application containerized and deployed!
🐳 Docker Image: java-demo-app:1.0.0
📍 Access at: http://localhost:9090
📊 Health check: http://localhost:9090/actuator/health
```

---

## Access the Application

### Browser Access

**Dashboard UI:**
```
http://localhost:9090
```

**Direct API calls:**
```bash
# Welcome endpoint
curl http://localhost:9090/api/welcome

# System information
curl http://localhost:9090/api/info

# Personalized greeting
curl http://localhost:9090/api/greet?name=John

# Math operations
curl http://localhost:9090/api/calculate?a=10&b=5

# Health check
curl http://localhost:9090/actuator/health
```

### Remote Access (From Other Machines)

Find your Mac IP:
```bash
ifconfig | grep "inet " | grep -v 127.0.0.1
```

Example output: `192.168.1.100`

Then access from another machine:
```
http://192.168.1.100:9090
```

### Port Mapping Explanation

In docker-compose.yml or docker run:
```yaml
ports:
  - "9090:9090"
```

Means: `<host-port>:<container-port>`
- Host port 9090 → Container port 9090
- Traffic from outside reaches host:9090 → forwarded to container:9090

---

## Troubleshooting

### Container won't start

**Check logs:**
```bash
docker logs java-demo-app
```

**Common issues:**
- Port 9090 already in use: `lsof -i :9090`
- JAR file missing: Ensure `mvn package` was run
- Docker daemon not running: `open -a Docker` (Mac)

### Application not responding

**Test connectivity:**
```bash
curl -v http://localhost:9090/api/welcome
```

**Check container health:**
```bash
docker inspect java-demo-app | grep -A 5 "Health"
```

**View recent logs:**
```bash
docker logs --tail 50 java-demo-app
```

### Port already in use

**Find process using port 9090:**
```bash
lsof -i :9090
```

**Kill process:**
```bash
kill -9 <PID>
```

**Or use different port:**
```bash
docker run -d -p 9091:9090 --name java-demo-app java-demo-app:latest
```

### Out of disk space

**Clean up Docker:**
```bash
# Remove unused images
docker image prune

# Remove unused containers
docker container prune

# Remove unused volumes
docker volume prune

# Full cleanup
docker system prune -a
```

### Rebuild image from scratch

```bash
# Remove old image
docker rmi java-demo-app:1.0.0

# Remove old container
docker rm java-demo-app

# Rebuild JAR
mvn clean package -DskipTests

# Rebuild image
docker build -t java-demo-app:1.0.0 .

# Run new container
docker run -d -p 9090:9090 --name java-demo-app java-demo-app:1.0.0
```

---

## Docker Commands Cheat Sheet

```bash
# Images
docker images                          # List images
docker build -t name:tag .             # Build image
docker rmi image-id                    # Remove image
docker tag source:tag dest:tag         # Tag image

# Containers
docker ps                              # List running containers
docker ps -a                           # List all containers
docker run -d -p 9090:9090 image:tag   # Run container
docker stop container-name             # Stop container
docker start container-name            # Start container
docker rm container-name               # Remove container
docker logs container-name             # View logs
docker exec -it container-name bash    # Open shell in container

# docker-compose
docker-compose up -d                   # Start services
docker-compose down                    # Stop and remove services
docker-compose ps                      # List services
docker-compose logs -f                 # Follow logs

# Cleanup
docker system prune -a                 # Remove all unused
```

---

## Demo Workflow for Bootcamp

### 1. Show Code
```bash
cat src/main/java/com/demo/Application.java
cat Dockerfile
```

### 2. Build Application
```bash
mvn clean package -DskipTests
```

### 3. Build Docker Image
```bash
docker build -t java-demo-app:1.0.0 .
```

### 4. Run Container
```bash
docker-compose up -d
```

### 5. Test Application
```bash
curl http://localhost:9090/api/info
```

### 6. Show UI in Browser
```
http://localhost:9090
```

### 7. Show Container Details
```bash
docker ps
docker logs -f java-demo-app
```

### 8. Cleanup
```bash
docker-compose down
```

---

## Next Steps

- Learn about Docker networking
- Explore Kubernetes for orchestration
- Set up Docker registry for image storage
- Implement continuous deployment to Docker Hub

