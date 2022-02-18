def build(Map config) {
    try {
        File file = new File("${WORKSPACE}/Dockerfile");
        FileReader fr = new FileReader(file);
        sh "docker image build -t ${config.imageName} ."
    }
    catch(FileNotFoundException ex) {
        sh 'echo "Dockerfile not found, skipping to next step."'
    }
}
def push(Map config) {
    try {
        File file = new File("${WORKSPACE}/Dockerfile");
        FileReader fr = new FileReader(file);
        sh "docker push ${config.imageName}"
    }
    catch(FileNotFoundException ex) {
        sh 'echo "Dockerfile not found, skipping to next step."'
    }
}