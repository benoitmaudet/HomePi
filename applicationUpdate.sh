#!/bin/bash
git config core.fileMode false
git pull
/opt/jdk1.8.0/bin/javac src/*.java -d ./bin -cp src-backend/ src