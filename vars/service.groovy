def call() {
    pipeline {
        agent any
        environment {
            SERVICE_NAME = "fleetman-webapp"
            REPOSITORY_TAG = "${REPO_USERNAME}/${SERVICE_NAME}:${BUILD_ID}"
        }
        stages {
            stage('Building Artifacts') {
                steps {
                    cleanWs()
                }
            }
            stage('Building Image') {
                steps {
                    docker.build();
                }
            }
            stage('Pushing Image') {
                steps {
                    docker.push();
                }
            }
            stage('Deploying') {
                steps {
                    deploy.cluster();
                }
            }
        }
    }
}