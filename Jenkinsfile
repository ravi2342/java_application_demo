// Jenkins Pipeline for Java Demo Application
// CI/CD Pipeline: GitHub → Build → Test → Package → Deploy to Nexus

pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
    }

    environment {
        NEXUS_CREDENTIALS = 'nexus-credentials'
        GITHUB_CREDENTIALS = 'github-pat'
        NEXUS_HOST = 'host.docker.internal:8081'
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
                sh 'mvn clean compile -DskipTests -q'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -q'
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests -q'
            }
        }

        stage('Deploy to Nexus') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "${NEXUS_CREDENTIALS}",
                    usernameVariable: 'NEXUS_USER',
                    passwordVariable: 'NEXUS_PASS'
                )]) {
                    sh 'mvn deploy -DskipTests -q -Dnexus.host=${NEXUS_HOST}'
                }
            }
        }

        stage('Verify Deployment') {
            steps {
                sh 'curl -s -u admin:admin123 http://${NEXUS_HOST}/service/rest/v1/search/assets | grep -q "java-demo-app" && echo "✅ Deployed" || echo "❌ Failed"'
            }
        }
    }

    post {
        always {
            cleanWs()
        }

        success {
            echo '✅ SUCCESS'
        }

        failure {
            echo '❌ FAILED'
        }
    }
}

// SETUP: Add credentials (github-pat, nexus-credentials) → Create Pipeline job → Build Now
