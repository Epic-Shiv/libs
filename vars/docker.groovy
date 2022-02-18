def build() {
    sh 'docker image build -t ${REPOSITORY_TAG} .'
}
def image() {
    sh 'docker push ${REPOSITORY_TAG}'
}