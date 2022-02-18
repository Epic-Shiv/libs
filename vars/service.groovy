def call() {
    pipeline {
        agent any
        environment {
            SERVICE_NAME = repoName()
            REPOSITORY_TAG = "${REPO_USERNAME}/${SERVICE_NAME}:${BUILD_ID}"
        }
        stages {
            stage('Building Artifacts') {
                steps {
                    script {
                        mavenBuild()
                    }
                }
            }
            stage('Building Image') {
                steps {
                    script {
                        dockerImageBuild(imageName:"${REPOSITORY_TAG}")
                    }
                }
            }
            stage('Pushing Image') {
                steps {
                    script {
                        dockerImage.push(imageName:"${REPOSITORY_TAG}")
                    }
                }
            }
            stage('Deploying') {
                steps {
                    script {
                        deployToCluster()
                    }
                }
            }
        }
    }
}