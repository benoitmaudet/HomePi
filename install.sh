#!/bin/bash
echo "Lauch raspi-config to expend sdcard partition"

# git config core.fileMode false
url="http://www.java.net/download/jdk8/archive/b108/binaries/jdk-8-ea-b108-linux-arm-vfp-hflt-18_sep_2013.tar.gz"
file="jdk-8-ea-b108-linux-arm-vfp-hflt-18_sep_2013.tar.gz"

wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com" $url
tar zxvf $file -C /opt
update-alternatives --install "/usr/bin/java" "java" "/opt/jdk1.8.0/bin/java" 1
update-alternatives --config javac

rm $file