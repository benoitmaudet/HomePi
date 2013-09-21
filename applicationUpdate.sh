#!/bin/bash
git config core.fileMode false
git pull
find . -name "*.java" | xargs /opt/jdk1.8.0/bin/javac -classpath .:classes:/var/www/HomePi/lib/'*' -d bin/
#To run : sudo java -classpath .:classes:/var/www/HomePi/lib/'*' Playground
