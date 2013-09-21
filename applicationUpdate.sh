#!/bin/bash
git config core.fileMode false
git pull
/opt/jdk1.8.0/bin/javac -sourcepath src -d ./bin -cp src-backend/ -cp lib/junit-4.11.jar src/**/*.java