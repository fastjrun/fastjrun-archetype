FROM pi4k8s/openjdk8:centos7

ADD ${rootArtifactId}-mock-server.jar /opt

ENV JAVA_OPTS "-Xms128m -Xmx128m"

WORKDIR /opt

ENTRYPOINT java ${JAVA_OPTS} -jar ${rootArtifactId}-mock-server.jar
