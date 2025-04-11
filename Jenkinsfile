pipeline {
    agent any

    environment {
        SAUCE_USERNAME = credentials('sauce-username')     // Use Jenkins credentials ID
        SAUCE_ACCESS_KEY = credentials('sauce-access-key') // Use Jenkins credentials ID
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/your-selenium-project.git'
            }
        }

        stage('Build and Test in Docker') {
            agent {
                docker {
                    image 'prats069/selenium-sauce3:latest' // Or your custom Docker image
                    args '-v /root/.m2:/root/.m2'          // Cache Maven dependencies
                }
            }
            steps {
                sh 'mvn clean test -Dsauce.username=$SAUCE_USERNAME -Dsauce.accessKey=$SAUCE_ACCESS_KEY'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml' // Adjust path based on your project setup
        }
        failure {
            echo 'Tests failed. Check reports for details.'
        }
        success {
            echo 'Tests passed successfully!'
        }
    }
}
