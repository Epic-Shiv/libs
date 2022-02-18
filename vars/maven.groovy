def checkFile() {
    try {
        File file = new File("${WORKSPACE}/pom.xml");
        FileReader fr = new FileReader(file);
        Boolean flag = true
    }
    catch(FileNotFoundException ex) {
        Boolean flag=false
    }
}
def buildArtifact() {
    checkFile()
    if ( flag=true) {
        sh 'mvn clean build'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def packageArtifact() {
    checkFile()
    if (flag=true) {
        sh 'mvn clean package'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}
def installArtifact() {
    checkFile()
    if (flag=true) {
        sh 'mvn clean install'
    } else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}