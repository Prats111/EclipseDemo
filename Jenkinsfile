pipeline {
    agent {
        docker {
            image 'prats069/selenium-sauce3:latest'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'saucelabs-credentials', usernameVariable: 'SAUCE_USERNAME', passwordVariable: 'SAUCE_ACCESS_KEY')]) {
                    sh "mvn test -Dsauce.username=${SAUCE_USERNAME} -Dsauce.accessKey=${SAUCE_ACCESS_KEY} -Dsauce.testName='My Test' -Dsauce.build='Jenkins Build ${BUILD_NUMBER}'"
                }
            }
        }
    }
    post {
        success {
            junit '**/TEST-*.xml'
        }
    }
}