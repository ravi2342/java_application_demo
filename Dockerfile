# Simple Single-Stage Dockerfile
# Straightforward approach: Copy JAR and run it
# Best for: Learning, quick deployments, bootcamp demos

FROM eclipse-temurin:21-jre-alpine

LABEL maintainer="DevOps Bootcamp"
LABEL description="Java Demo Application - Spring Boot REST API"
LABEL version="1.0.0"

WORKDIR /app

# Copy built JAR from host
COPY target/java-demo-app-1.0.0-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 9090

# Health check
HEALTHCHECK --interval=10s --timeout=5s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:9090/actuator/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
