def checkFile() {
    try {
        File file = new File("${WORKSPACE}/pom.xml");
        FileReader fr = new FileReader(file);
        def v = true;
    }
    catch(FileNotFoundException ex) {
        def v = false;
    }
}
def buildArtifact() {
    checkFile();
    if( v == true) {
        sh 'mvn clean build'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def packageArtifact() {
    checkFile();
    if(v == true) {
        sh 'mvn clean package'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def installArtifact() {
    checkFile();
    if(v == true) {
        sh 'mvn clean install'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}