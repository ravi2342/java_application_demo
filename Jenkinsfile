// Jenkins Pipeline for Java Demo Application
// CI/CD Pipeline: GitHub → Build → Test → Package

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
    }

    post {
        always {
            cleanWs()
        }

        success {
            echo '✅ Pipeline SUCCESS - Application packaged'
        }

        failure {
            echo '❌ Pipeline FAILED'
        }
    }
}
