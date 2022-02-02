node {
    stage('git chekout') {
        git branch: "master", url: 'https://gitee.com/fastjrun/fastjrun-archetype.git'
    }
    stage('mvn deploy') {
        sh 'mvn clean deploy -Prelease'
    }
}
