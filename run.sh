#!/bin/bash

declare dc_infra=docker-compose.yml
declare dc_app=docker-compose-app.yml

function build_api() {
    cd /home/victor/projeto-spring-kubernetes/springboot-kubernetes/
    mvn clean package -DskipTests
    cd /home/victor/projeto-spring-kubernetes/springboot-kubernetes/
}


function start_infra() {
    echo "Starting infra dcoker containers . . ."
    docker-compose -f ${dc_infra} up -d
    docker-compose -f ${dc_infra} logs -f
}

function stop_infra() {
    echo "Stopping infra dcoker containers . . ."
    docker-compose -f ${dc_infra} stop
    docker-compose -f ${dc_infra} rm -f
}

function start() {
    build_api
    echo "Starting all app dcoker containers . . ."
    docker-compose -f ${dc_infra} -f ${dc_app}  up  --build -d 
    docker-compose -f ${dc_infra} -f ${dc_app} logs -f
}


function stop() {
    build_api
    echo "Stopping all app dcoker containers . . ."
    docker-compose -f ${dc_infra} -f ${dc_app}  stop
    docker-compose -f ${dc_infra} -f ${dc_app} rm -f
}

function restart() {
    stop
    sleep 3
    start
}

action="start"

if [[ "$#" != "0" ]]
then
    action=$@
fi

eval ${action}