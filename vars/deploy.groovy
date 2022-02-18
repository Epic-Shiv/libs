def eksCluster() {
    sh 'envsubst < ${WORKSPACE}/application.yaml | kubectl apply -f -'
}