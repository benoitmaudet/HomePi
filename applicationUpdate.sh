#!/bin/bash
git config core.fileMode false
git pull
find . -name "*.java" | xargs /opt/jdk1.8.0/bin/javac -classpath .:classes:/home/pi/HomePi/lib/'*' -d bin/
#To run : sudo java -classpath .:classes:/opt/pi4j/lib/'*' Playground
