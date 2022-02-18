def call() {
pipeline {
    agent any

    environment {
        // You must set the following environment variables
        SERVICE_NAME = "fleetman-webapp"
        // ORGANIZATION_NAME
        // DOCKERHUB_USERNAME (it doesn't matter if you don't have one)

        REPOSITORY_TAG="${DOCKERHUB_USERNAME}/${SERVICE_NAME}:${BUILD_ID}"
    }

    stages {
        stage('Building Artifact') {
            steps {
                cleanWs()
                sh 'echo no build required'
            }
        }

        stage('Building Docker Image') {
            steps {
                sh 'docker image build -t ${REPOSITORY_TAG} .'
            }
        }

        stage('Pushing Image to Repo') {
            steps {
                script {
                    docker.pushImage()
                }
            }
        }

        stage('Deploy to Cluster') {
            steps {
                script {
                    deploy.eksCluster()
                }
            }
        }
    }
}
}
