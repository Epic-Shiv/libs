
def call() {
    if(fileExists 'pom.xml') {
        sh 'mvn clean package'
    }else {
        sh 'echo "pom.xml file not found, skipping to next step."'
    }
}