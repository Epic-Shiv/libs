def buildArtifact() {
    sh 'mvn clean build'
}
def packageArtifact() {
    sh 'mvn clean package'
}
def installArtifact() {
    sh 'mvn clean install'
}