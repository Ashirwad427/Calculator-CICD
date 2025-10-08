pipeline {
    agent any

    tools {
        maven 'Maven3' // Or the name you configured
    }

    environment {
        // Define a variable for your Docker image name
        DOCKER_IMAGE = "ashirwad4/scientific-calculator"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ashirwad427/Calculator-CICD.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean install'
            }
        }

        // --- NEW STAGE: Build Docker Image ---
        stage('Build Docker Image') {
            steps {
                echo "Building the Docker image..."
                // The 'sh' step runs shell commands
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        // --- NEW STAGE: Push to Docker Hub ---
        stage('Push to Docker Hub') {
            steps {
                echo "Pushing the Docker image..."
                // Use the 'withCredentials' block to securely access the stored credentials
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }
    }
}
