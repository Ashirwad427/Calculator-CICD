pipeline {
    // 1. Define the build agent (any available machine)
    agent any

    // 2. Define the tools needed for the build
    tools {
        // This name MUST match the name you configured in Global Tool Configuration
        maven 'maven-3.9.1'
    }

    // 3. Define the stages of the pipeline
    stages {
        // STAGE 1: Checkout code from GitHub
        stage('Checkout') {
            steps {
                // This command clones your repository's main branch
                git branch: 'main', url: 'https://github.com/Ashirwad427/Calculator-CICD.git'
            }
        }

        // STAGE 2: Build and test the application using Maven
        stage('Build & Test') {
            steps {
                // This command runs the Maven build, which compiles and tests the code
                sh 'mvn clean install'
            }
        }
    }
}
