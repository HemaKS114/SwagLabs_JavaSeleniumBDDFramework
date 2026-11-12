
pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven310'
    }

    options {
        timestamps()
    }

    stages {

        stage('Verify Java and Maven') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Checkout') {
            steps {
                echo 'Source code checked out from GitHub'
            }
        }

        stage('Build and Run Cucumber Tests') {
            steps {
                bat 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: '**/target/surefire-reports/*.xml'
        }
    }
}
