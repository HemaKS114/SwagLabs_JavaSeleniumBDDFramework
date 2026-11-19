
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
				bat '''
            if not exist target\\BrowserReports\\Chrome mkdir target\\BrowserReports\\Chrome
            copy /Y target\\ExtentReports\\ExtentReport.html target\\BrowserReports\\Chrome\\ExtentReport.html
            if exist target\\ExtentReports\\Screenshots xcopy target\\ExtentReports\\Screenshots target\\BrowserReports\\Chrome\\Screenshots /E /I /Y
        '''
			}
		}
		
		stage('Edge tests'){
			steps{
				bat 'mvn -B clean test -Dbrowser=edge -Dheadless=true'
				bat '''
            if not exist target\\BrowserReports\\Edge mkdir target\\BrowserReports\\Edge
            copy /Y target\\ExtentReports\\ExtentReport.html target\\BrowserReports\\Edge\\ExtentReport.html
            if exist target\\ExtentReports\\Screenshots xcopy target\\ExtentReports\\Screenshots target\\BrowserReports\\Edge\\Screenshots /E /I /Y
        '''
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
