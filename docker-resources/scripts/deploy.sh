#!/bin/bash
PREFIX=$1
SCRIPTS_FOLDER="/docker-workspace/Kubik/docker-resources/scripts"

if [ PREFIX == "" ]
then
	PREFIX = "wevan"
fi

$SCRIPTS_FOLDER/mysql/deploy.sh $PREFIX
$SCRIPTS_FOLDER/csp-forms/deploy.sh $PREFIX
