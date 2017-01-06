#!groovy
node {
    stage('Checkout') {
        checkout scm
    }

    stage('Build') {
        sh 'mvn build'
    }

    stage('Test') {
        echo 'Testing...'
    }

    stage('Deploy') {
        echo 'Deploying...'
    }
}
