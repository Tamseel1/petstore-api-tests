pipeline {
    agent any

    tools {
        jdk 'JDK8'
        maven 'Maven'
    }

    stages {
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}

