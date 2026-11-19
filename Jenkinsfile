
pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven310'
    }
    
    triggers {
        githubPush()
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

        /*stage('Build and Run Cucumber Tests') {
            steps {
                bat 'mvn -B clean test'
            }
        }*/
        
        stage('Chrome tests'){
			steps{
				bat 'mvn -B clean test -Dbrowser=chrome -Dheadless=true'
			}
		}
		
		stage('Edge tests'){
			steps{
				bat 'mvn -B clean test -Dbrowser=edge -Dheadless=true'
			}
		}
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/ExtentReports/**/*',
                             allowEmptyArchive: true
        }
    }
}
