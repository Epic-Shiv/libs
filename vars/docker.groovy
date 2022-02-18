def buildImage() {
    sh 'docker image build -t ${REPOSITORY_TAG} .'
}
def pushImage() {
    sh 'docker push ${REPOSITORY_TAG}'
}