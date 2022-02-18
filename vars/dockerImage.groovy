def build(Map config) {
    sh "docker image build -t ${config.imageName} ."
}
def push(Map config) {
    sh "docker push ${config.imageName}"
}