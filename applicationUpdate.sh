#!/bin/bash
if [ -f install.sh ]
then
 rm install.sh
fi
git pull
chmod +x install.sh
/opt/jdk1.8.0/bin/javac src/*.java -d ./bin -cp src-backend/