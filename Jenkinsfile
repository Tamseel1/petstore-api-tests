pipeline {
    agent any

    tools {
        jdk 'JDK8'
        maven 'Maven'
    }

    stages {
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}

