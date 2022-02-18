def call() {
    sh 'envsubst < ${WORKSPACE}/application.yaml | kubectl apply -f -'
}