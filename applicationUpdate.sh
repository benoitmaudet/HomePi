#!/bin/bash
if [ -f install.sh ]
then
 rm install.sh
fi
git pull
chmod +x install.sh