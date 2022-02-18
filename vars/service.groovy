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
                    script {
                        docker.build();
                    }
                }
            }
            stage('Pushing Image') {
                steps {
                    script {
                        docker.push();
                    }
                }
            }
            stage('Deploying') {
                steps {
                    script {
                        deploy.cluster();
                    }
                }
            }
        }
    }
}