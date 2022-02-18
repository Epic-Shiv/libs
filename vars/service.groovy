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
                    if(fileExists pom.xml) {
                        script {
                            mavenBuild()
                        }
                    } else {
                        sh 'echo "pom.xml file not found, skipping to next step."'
                    }

                }
            }
            stage('Building Image') {
                steps {
                    script {
                        dockerImage.build(imageName:"${REPOSITORY_TAG}")
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