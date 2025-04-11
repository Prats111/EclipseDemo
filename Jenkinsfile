pipeline {
    agent any

    tools {
        jdk 'JDK 17'
        maven 'maven 3.9.8'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

         stage('Build and Test') {
            steps {
                // Print env variables for debugging
                sh 'echo $SAUCE_USERNAME'
                sh 'echo $SAUCE_ACCESS_KEY'
                
                // Run your Maven tests
                sh 'mvn clean test -Dsauce.username=$SAUCE_USERNAME -Dsauce.accessKey=$SAUCE_ACCESS_KEY'
            }
        }
    }
}