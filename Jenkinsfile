pipeline {
    agent any
    environment {
            SAUCE_USERNAME = credentials('sauce-username')
            SAUCE_ACCESS_KEY = credentials('sauce-access-key')
            SAUCE_DATA_CENTER = 'EU Central 1' // Replace with your Sauce Labs region
        }

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