pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven' // Ensure Maven is installed in Jenkins
        TEST_RESULTS_DIR = 'target/cucumber-reports/' // Define test result directory
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mudhol1982/DSAlgo_TeamAchievers.git' // Replace with your repo
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Cucumber Report') {
            steps {
                publishCucumberReports(
                    fileIncludePattern: '**/target/cucumber-reports/*.json'
                )
            }
        }

        stage('Allure Report') {
            steps {
                allure([
                    results: [[path: "target/allure-results"]]
                ])
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            deleteDir()
        }
        success {
            echo 'Build completed successfully!'
            archiveArtifacts artifacts: '**/target/cucumber-reports/*.json', fingerprint: true
        }
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}
