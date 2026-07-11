pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Static Code Analysis') {
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
        }
    }

    post {
        success {
            archiveArtifacts(
                artifacts: 'target/*.jar',
                fingerprint: true
            )

            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: false

            echo 'Pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }

        always {
            echo "Final pipeline status: ${currentBuild.currentResult}"
        }
    }
}
