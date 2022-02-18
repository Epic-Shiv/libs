def build() {
    sh 'docker image build -t ${REPOSITORY_TAG} .'
}
def push() {
    sh 'docker push ${REPOSITORY_TAG}'
}