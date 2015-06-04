#!/bin/bash
PREFIX=$1

if [ PREFIX == "" ]
then
	PREFIX = "wevan"
fi

CONTAINER_NAME=$PREFIX-cspforms
WORKSPACE="/docker-workspace/csp-forms"
KUBIK_DATA_DIR="/docker-volumes/$CONTAINER_NAME"

docker rm -f $CONTAINER_NAME

echo "Launching maven build for CSP Forms."

mvn -f $WORKSPACE/pom.xml clean install

echo "Building Dockerfile for CSP Forms."

sh $WORKSPACE/docker-resources/scripts/csp-forms/docker-build.sh

CMD="docker run -d -p 8090:8080 -v $KUBIK_DATA_DIR:/data --name $CONTAINER_NAME cspinformatique/csp-forms"

echo "Launching docker instance for CSP Forms."
echo "	Cmd : $CMD"

$CMD
