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
                    sh 'echo building artifacts'
                }
            }
            stage('Building Image') {
                steps {
                    script {
                        dockerImage.build()
                    }
                }
            }
            stage('Pushing Image') {
                steps {
                    script {
                        dockerImage.push()
                    }
                }
            }
            stage('Deploying') {
                steps {
                    script {
                        deploy.cluster()
                    }
                }
            }
        }
    }
}