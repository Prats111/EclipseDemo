pipeline {
    agent any

    environment {
        SAUCE_USERNAME = credentials('sauce-username')     // Use Jenkins credentials ID
        SAUCE_ACCESS_KEY = credentials('sauce-access-key') // Use Jenkins credentials ID
    }
    tools {
    git 'git'  // use the name you gave in the Global Tool Configuration
   }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Prats111/EclipseDemo.git'
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
