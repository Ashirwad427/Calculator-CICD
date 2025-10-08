pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
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
                echo "Building the Docker image..."
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                echo "Pushing the Docker image..."
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                echo "Deploying the application using the Ansible plugin..."
                ansiblePlaybook(
                    installation: 'Ansible', 
                    playbook: 'deploy.yml',
                    inventory: 'inventory.ini',
                    extraVars: [
                        docker_image: "${DOCKER_IMAGE}"
                    ]
                )
            }
        }
    }
}
