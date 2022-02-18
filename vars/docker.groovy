def build() {
    sh 'docker image build -t ${REPOSITORY_TAG} .'
}