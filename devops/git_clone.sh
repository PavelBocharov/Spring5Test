#!/bin/bash
echo $MAROLOK | base64 --decod > /cert/mar.txt
java -jar /app/Spring5Test.jar