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

        stage('Parallel Validation') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        sh 'mvn test'
                    }
                }

                stage('Integration Tests') {
                    steps {
                        sh 'mvn verify'
                    }
                }

                stage('Code Coverage') {
                    steps {
                        sh 'mvn test jacoco:report'
                    }
                }

                stage('Code Analysis') {
                    steps {
                        sh 'mvn checkstyle:checkstyle'
                    }
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: true
        }

        success {
            archiveArtifacts(
                artifacts: 'target/*.jar',
                fingerprint: true
            )

            archiveArtifacts(
                artifacts: 'target/site/jacoco/**',
                fingerprint: false,
                allowEmptyArchive: true
            )

            echo 'Parallel CI pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}