def call(Map config) {
        sh "docker image build -t ${config.imageName} ."
}