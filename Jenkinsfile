// Jenkins Pipeline for Java Demo Application
// CI/CD Pipeline: GitHub → Build → Test → Package → Dockerize → Deploy Container

pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
    }

    environment {
        GITHUB_CREDENTIALS = 'github-pat'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                sh 'git log --oneline -1'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
                echo "✅ JAR built successfully at target/java-demo-app-1.0.0-SNAPSHOT.jar"
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh '''
                        JAR_PATH="/var/jenkins_home/workspace/java_app_demo_pipeline/target/java-demo-app-1.0.0-SNAPSHOT.jar"
                        HOST_JAR="/tmp/java-demo-app-1.0.0-SNAPSHOT.jar"
                        
                        echo "📦 Copying JAR to host machine..."
                        docker cp jenkins:${JAR_PATH} ${HOST_JAR}
                        
                        if [ -f "${HOST_JAR}" ]; then
                            echo "✅ JAR copied successfully!"
                            ls -lh ${HOST_JAR}
                        else
                            echo "❌ Failed to copy JAR"
                            exit 1
                        fi
                    '''
                }
            }
        }

        stage('Dockerize') {
            steps {
                script {
                    sh '''
                        echo "🐳 Building Docker image..."
                        echo ""
                        echo "Using: Dockerfile (simple single-stage)"
                        echo "Alternative: docker build -f Dockerfile.multistage (production-ready with security)"
                        echo ""
                        
                        # Build using simple Dockerfile (default)
                        docker build -t java-demo-app:1.0.0 -t java-demo-app:latest .
                        
                        echo "✅ Docker image built successfully!"
                        echo ""
                        docker images | grep java-demo-app
                    '''
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    sh '''
                        echo "🚀 Stopping existing container..."
                        docker stop java-demo-app 2>/dev/null || true
                        docker rm java-demo-app 2>/dev/null || true
                        
                        echo "🚀 Starting Docker container..."
                        docker run -d \\
                            --name java-demo-app \\
                            -p 9090:9090 \\
                            java-demo-app:latest
                        
                        echo "⏳ Waiting for application to start..."
                        sleep 5
                        
                        echo ""
                        echo "✅ Container running!"
                        docker ps | grep java-demo-app
                        echo ""
                        echo "📍 Access application at: http://localhost:9090"
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline SUCCESS - Application containerized and deployed!'
            echo "🐳 Docker Image: java-demo-app:1.0.0"
            echo "📍 Access at: http://localhost:9090"
            echo "📊 Health check: http://localhost:9090/actuator/health"
        }

        failure {
            echo '❌ Pipeline FAILED'
        }
    }
}
