#!/bin/bash

echo "build ..."
if [ "local_${rootArtifactId}_sdkg" = $1 ] ; then
  mvn clean install -pl ${rootArtifactId}-sdkg-client,${rootArtifactId}-sdkg-provider,${rootArtifactId}-sdkg-generator -am
elif [ "publish_${rootArtifactId}_sdkg" = $1 ] ; then
  mvn clean deploy -Prelease -pl ${rootArtifactId}-sdkg-client,${rootArtifactId}-sdkg-provider,${rootArtifactId}-sdkg-generator -am
elif [ "package_${rootArtifactId}" = $1 ] ; then
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-api -am -Dapigc.skip=false
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-bundle -am -Dbdgc.skip=false
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-bundle-mock -am -Dbdmgc.skip=false
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-client -am -Dclientgc.skip=false
  mvn package -pl ${rootArtifactId}-codeg/${rootArtifactId}-api,${rootArtifactId}-codeg/${rootArtifactId}-bundle,${rootArtifactId}-codeg/${rootArtifactId}-bundle-mock,${rootArtifactId}-codeg/${rootArtifactId}-client -am
elif [ "local_${rootArtifactId}" = $1 ] ; then
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-api -am -Dapigc.skip=false
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-bundle -am -Dbdgc.skip=false
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-client -am -Dclientgc.skip=false
  mvn install -pl ${rootArtifactId}-codeg/${rootArtifactId}-api,${rootArtifactId}-codeg/${rootArtifactId}-bundle,${rootArtifactId}-codeg/${rootArtifactId}-client -am
elif [ "deploy_${rootArtifactId}" = $1 ] ; then
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-api -am -Dapigc.skip=false
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-bundle -am -Dbdgc.skip=false
  mvn compile -pl ${rootArtifactId}-codeg/${rootArtifactId}-client -am -Dclientgc.skip=false
  mvn deploy  -Prelease -pl ${rootArtifactId}-codeg/${rootArtifactId}-api,${rootArtifactId}-codeg/${rootArtifactId}-bundle,${rootArtifactId}-codeg/${rootArtifactId}-client -am
elif [ "package_${rootArtifactId}_mock_server" = $1 ] ; then
  mvn package -pl ${rootArtifactId}-codeg/${rootArtifactId}-mock-server -am -Dbdmgc.skip=false
elif [ "clean" = $1 ] ; then
  mvn clean
  rm -rf ${rootArtifactId}-codeg/${rootArtifactId}-api/src
  rm -rf ${rootArtifactId}-codeg/${rootArtifactId}-bundle/src
  rm -rf ${rootArtifactId}-codeg/${rootArtifactId}-bundle-mock/src
  rm -rf ${rootArtifactId}-codeg/${rootArtifactId}-client/src
elif [ "set_version" = $1 ] ; then
  mvn versions:set -DnewVersion=$2
  cd ${rootArtifactId}-codeg
  mvn versions:set -DnewVersion=$2
  cd ..
fi
echo "build done."
