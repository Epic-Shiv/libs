def buildImage(Map config = [:]) {
    sh 'docker image build -t ${config.imageName} .'
}
def pushImage(Map config = [:]) {
    sh 'docker push ${config.imageName}'
}