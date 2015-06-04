#!/bin/bash
PREFIX=$1

if [ PREFIX == "" ]
then
        PREFIX = "wevan"
fi

CONTAINER_NAME=$PREFIX-cspforms-mysql
MYSQL_DATA_FOLDER=/docker-volumes/$CONTAINER_NAME/data
MYSQL_CONF_FOLDER=/docker-volumes/$CONTAINER_NAME/conf

docker rm -f $CONTAINER_NAME

CMD="docker run -d --name $CONTAINER_NAME -p 3306:3306 -v $MYSQL_DATA_FOLDER:/var/lib/mysql -v $MYSQL_CONF_FOLDER:/etc/mysql dockerfile/mysql"

echo "Launching docker instance for mysql."
echo "  $CMD"

$CMD