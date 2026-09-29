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
                        HOST_JAR="/tmp/java-demo-app-1.0.0-SNAPSHOT.jar"
                        
                        echo "📦 Copying JAR to host machine..."
                        docker cp jenkins:${JAR_PATH} ${HOST_JAR}
                        
                        if [ -f "${HOST_JAR}" ]; then
                            echo "✅ JAR copied successfully!"
                            ls -lh ${HOST_JAR}
                            echo ""
                            echo "To run the application:"
                            echo "  java -jar ${HOST_JAR}"
                            echo ""
                            echo "Then access at: http://localhost:9090"
                        else
                            echo "❌ Failed to copy JAR"
                            exit 1
                        fi
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline SUCCESS - JAR built and ready!'
            echo "📦 JAR Location: /var/jenkins_home/workspace/java_app_demo_pipeline/target/java-demo-app-1.0.0-SNAPSHOT.jar"
        }

        failure {
            echo '❌ Pipeline FAILED'
        }
    }
}
