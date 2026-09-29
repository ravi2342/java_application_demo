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
                        JAR_PATH="/var/jenkins_home/workspace/java_app_demo_pipeline/target/java-demo-app-1.0.0-SNAPSHOT.jar"
                        
                        echo "Stopping existing container..."
                        docker stop java-app 2>/dev/null || true
                        docker rm java-app 2>/dev/null || true
                        
                        echo "Starting Java application..."
                        echo "Using: java -jar ${JAR_PATH}"
                        
                        nohup java -jar "${JAR_PATH}" > /tmp/app.log 2>&1 &
                        APP_PID=$!
                        echo "Application started with PID: $APP_PID"
                        
                        echo "Waiting for application to start..."
                        sleep 5
                        
                        if curl -s http://localhost:9090/api/welcome > /dev/null; then
                            echo "✅ Application is running!"
                            echo "Access at: http://localhost:9090"
                        else
                            echo "⚠️  Application may still be starting..."
                            tail -10 /tmp/app.log
                        fi
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
