#!/bin/bash

KOTLIN_BIN="/d/Apps/Kotlin/kotlinc/bin"

execkotlin(){
    $KOTLIN_BIN/kotlin -version
    if [ -z "$1" ];then
        echo "Missing file parameter"
    else
        $KOTLIN_BIN/kotlinc $1
        if [[ $1 =~ ([A-Z][A-Za-z0-9_]+)\.kt$ ]] && [[ -e "${BASH_REMATCH[1]}Kt.class" ]]; then
            $KOTLIN_BIN/kotlin "${BASH_REMATCH[1]}Kt"
        else
            echo $1 doesn\'t match format or file "${BASH_REMATCH[1]}Kt.class" does not exist
        fi
    fi
    rm -f *.class *.jar
}