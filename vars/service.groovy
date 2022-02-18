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
        stage('Preparation') {
            steps {
                cleanWs()
                git credentialsId: 'GitHub', url: "https://github.com/${ORGANIZATION_NAME}/${SERVICE_NAME}"
            }
        }
        stage('Building Artifact') {
            steps {
               // script {
               //     maven.packageArtifact()
               // }
            }
        }

        stage('Building Docker Image') {
            steps {
                script {
                    docker.buildImage(imageName:${REPOSITORY_TAG})
                }
            }
        }

        stage('Pushing Image to Repo') {
            steps {
                script {
                    docker.pushImage(imageName:${REPOSITORY_TAG})
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
