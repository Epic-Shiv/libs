def checkFile() {
    try {
        File file = new File("${WORKSPACE}/pom.xml");
        FileReader fr = new FileReader(file);
        def x = true
    }
    catch(FileNotFoundException ex) {
        def x = false;
    }
}
def buildArtifact() {
    checkFile();
    if(x) {
        sh 'mvn clean build'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def packageArtifact() {
    checkFile();
    if(x) {
        sh 'mvn clean package'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def installArtifact() {
    checkFile();
    if(x) {
        sh 'mvn clean install'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}