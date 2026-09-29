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
    }

    stages {
        stage('Checkout') {
            steps {
                echo '🔄 Checking out source code from GitHub...'
                checkout scm
                sh 'git log --oneline -5'
            }
        }

        stage('Build') {
            steps {
                echo '🔨 Building application with Maven...'
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running integration tests...'
                sh 'mvn test'
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Package') {
            steps {
                echo '📦 Creating executable JAR...'
                sh 'mvn package -DskipTests'
                sh 'ls -lh target/*.jar'
            }
        }

        stage('Deploy to Nexus') {
            steps {
                echo '🚀 Deploying artifact to Nexus...'
                withCredentials([usernamePassword(
                    credentialsId: "${NEXUS_CREDENTIALS}",
                    usernameVariable: 'NEXUS_USER',
                    passwordVariable: 'NEXUS_PASS'
                )]) {
                    sh 'mvn deploy -DskipTests'
                }
            }
        }

        stage('Verify Deployment') {
            steps {
                echo '✅ Verifying artifact in Nexus...'
                sh 'curl -s -u admin:admin123 http://localhost:8081/service/rest/v1/search/assets | grep -q "java-demo-app" && echo "✅ Artifact deployed successfully" || echo "❌ Artifact not found"'
            }
        }
    }

    post {
        always {
            cleanWs()
        }

        success {
            echo '✅ Build and deployment SUCCESSFUL!'
        }

        failure {
            echo '❌ Build FAILED!'
        }
    }
}


// ============================================================================
// JENKINS SETUP INSTRUCTIONS
// ============================================================================
//
// 1. VERIFY JAVA AND MAVEN IN JENKINS CONTAINER
//    docker exec jenkins java -version
//    docker exec jenkins mvn -version
//
// 2. CREATE JENKINS CREDENTIALS
//    - Jenkins Dashboard → Manage Jenkins → Credentials
//    - Add: Secret text (GitHub PAT)
//      ID: github-pat
//    - Add: Username/Password (Nexus)
//      ID: nexus-credentials
//      Username: admin
//      Password: admin123
//
// 3. CREATE PIPELINE JOB
//    - New Item → Pipeline
//    - Pipeline script from SCM
//    - Git: https://github.com/ravi2342/java_application_demo.git
//    - Branch: */main
//    - Script Path: Jenkinsfile
//
// 4. BUILD
//    - Click "Build Now"
//    - Monitor Console Output
//
// 5. VERIFY ARTIFACT
//    - Nexus: http://localhost:8081
//    - Browse → maven-snapshots → com → demo → java-demo-app → 1.0.0-SNAPSHOT
// ============================================================================
