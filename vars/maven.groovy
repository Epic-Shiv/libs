def checkFile() {
    try {
        File file = new File("${WORKSPACE}/pom.xml");
        FileReader fr = new FileReader(file);
        Boolean fileExist == TRUE
    }
    catch(FileNotFoundException ex) {
        Boolean fileExist == FALSE
    }
}
def buildArtifact() {
    checkFile()
    if (fileExist == TRUE) {
        sh 'mvn clean build'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def packageArtifact() {
    checkFile()
    if (fileExist == TRUE) {
        sh 'mvn clean package'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def installArtifact() {
    checkFile()
    if (fileExist == TRUE) {
        sh 'mvn clean install'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}