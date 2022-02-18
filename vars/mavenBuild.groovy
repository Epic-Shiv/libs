def call() {
    try {
        File file = new File("${WORKSPACE}/pom*");
        FileReader fr = new FileReader(file);
        sh 'mvn clean package'
    }
    catch(FileNotFoundException ex) {
        sh 'echo "pom.xml file not found, skipping to next step. ${WORKSPACE}"'
    }
}