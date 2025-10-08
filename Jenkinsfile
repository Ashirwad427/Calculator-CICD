pipeline {
    agent any

    tools {
        maven 'Maven3' // Or the name you configured
    }

    environment {
        // Use your Docker Hub username here
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

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }

        // --- NEW FINAL STAGE: Deploy with Ansible ---
        stage('Deploy with Ansible') {
            steps {
                echo "Deploying the application..."
                // This command runs the playbook and passes the image name as a variable
                sh "ansible-playbook -i inventory.ini deploy.yml --extra-vars 'docker_image=${DOCKER_IMAGE}'"
            }
        }
    }
}
