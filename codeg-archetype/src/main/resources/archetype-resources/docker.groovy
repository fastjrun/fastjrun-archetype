/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
node {
    stage('git chekout') {
        git branch: "master", url: 'https://gitee.com/fastjrun/${rootArtifactId}-codeg.git'
    }
    stage('package') {
        sh 'sh build.sh package_mock_server'
    }
    stage('prepare docker') {
        sh 'rm -rf output && mkdir output'
        sh 'cp ${rootArtifactId}-mock-server/target/${rootArtifactId}-mock-server.jar output'
        sh 'cp Dockerfile output'
        dir( 'output' ) {
            stash 'output'
        }
    }
    stage('parallel docker build && push') {
        parallel (
                'docker build && push': {
                    sh 'cd output && docker build . -t pi4k8s/${rootArtifactId}-mock-server-arm64:1.4'
                    sh 'docker push pi4k8s/${rootArtifactId}-mock-server-arm64:1.4'
                },
                'docker build && push amd64': {
                    node('amd64') {
                        dir( 'output' ) {
                            unstash 'output'
                        }
                        sh 'cd output && docker build . -t pi4k8s/${rootArtifactId}-mock-server-amd64:1.4'
                        sh 'docker push pi4k8s/${rootArtifactId}-mock-server-amd64:1.4'
                    }
                }
        )
    }
    stage('manifest'){
        try {
            sh 'docker manifest rm pi4k8s/apiworld-mock-server:1.4'
        }catch(exc){
            echo "some thing wrong"
        }
        sh 'docker manifest create pi4k8s/apiworld-mock-server:1.4 pi4k8s/apiworld-mock-server-amd64:1.4 pi4k8s/apiworld-mock-server-arm64:1.4'
        sh 'docker manifest annotate pi4k8s/apiworld-mock-server:1.4 pi4k8s/apiworld-mock-server-amd64:1.4 --os linux --arch amd64'
        sh 'docker manifest annotate pi4k8s/apiworld-mock-server:1.4 pi4k8s/apiworld-mock-server-arm64:1.4 --os linux --arch arm64'
        sh 'docker manifest push pi4k8s/apiworld-mock-server:1.4'
    }
    stage('cleanWs'){
        parallel (
                'arm64': {
                    cleanWs()
                },
                'amd64': {
                    node('amd64') {
                        cleanWs()
                    }
                }
        )
    }
}