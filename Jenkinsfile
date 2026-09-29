// Jenkins Pipeline for Java Demo Application
// CI/CD Pipeline: GitHub → Build → Test → Package → Deploy (Docker)

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
                        echo "Stopping existing container..."
                        docker stop java-app 2>/dev/null || true
                        docker rm java-app 2>/dev/null || true
                        
                        echo "Starting Java application in Docker..."
                        docker run -d \\
                            --name java-app \\
                            -p 9090:9090 \\
                            --network bug-report-portal-devops_ci-cd \\
                            -v /var/jenkins_home/workspace/java_app_demo_pipeline/target:/app \\
                            openjdk:21 \\
                            java -jar /app/java-demo-app-1.0.0-SNAPSHOT.jar
                        
                        echo "Waiting for application to start..."
                        sleep 3
                        
                        echo "✅ Application deployed!"
                        echo "Access at: http://localhost:9090"
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline SUCCESS - Application deployed!'
            echo "Access application at: http://localhost:9090"
        }

        failure {
            echo '❌ Pipeline FAILED'
        }
    }
}
