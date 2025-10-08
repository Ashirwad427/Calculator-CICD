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

        // STAGE 5: Deploy the application using the Ansible Plugin
        stage('Deploy with Ansible') {
            steps {
                echo "Deploying the application using the Ansible plugin..."
                // This step uses the Ansible plugin to run the playbook
                ansiblePlaybook(
                    ansible: 'Ansible', // The name of the Ansible tool you configured in Jenkins
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
