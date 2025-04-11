pipeline {
    agent any
    environment {
            SAUCE_USERNAME = credentials('sauce-username')
            SAUCE_ACCESS_KEY = credentials('sauce-access-key')
            SAUCE_DATA_CENTER = 'EU Central 1' // Replace with your Sauce Labs region
        }

    

    stages {
        stage('Checkout') {
            steps {
                 git url: 'https://github.com/Prats111/EclipseDemo.git', branch: 'master'
            }
        }

         stage('Run Selenium Tests in Docker') {
            steps {
               docker.image('prats069/selenium-sauce3').inside ("-e SAUCE_USERNAME=$SAUCE_USERNAME -e SAUCE_ACCESS_KEY=$SAUCE_ACCESS_KEY"){
                     sh "echo SAUCE_USERNAME=$SAUCE_USERNAME"
    				 sh "echo SAUCE_ACCESS_KEY=$SAUCE_ACCESS_KEY"
    				 sh "mvn test"
                //sh 'mvn clean test -Dsauce.username=$SAUCE_USERNAME -Dsauce.accessKey=$SAUCE_ACCESS_KEY'
            }
        }
    }
}