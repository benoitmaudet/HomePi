#!/bin/bash


#start without gui
update-rc.d lightdm disable

#Linux Optimisation:

#Désactiver les tty superflues
sed -i '/[2-6]:23:respawn:\/sbin\/getty 38400 tty[2-6]/s%^%#%g' /etc/inittab

#Mettre le swap a sa valeur optimale
echo "CONF_SWAPSIZE=512" > /etc/dphys-swapfile
dphys-swapfile setup
dphys-swapfile swapon

#Optimiser le montage du système
sed -i 's/defaults,noatime/defaults,noatime,nodiratime/g' /etc/fstab

#Désactiver IPv6
echo "net.ipv6.conf.all.disable_ipv6=1" > /etc/sysctl.d/disableipv6.conf
echo 'blacklist ipv6' >> /etc/modprobe.d/blacklist
sed -i '/::/s%^%#%g' /etc/hosts

#Changer l'ordonnanceur I/O pour noop (plus performant sur sdd/flash)
sed -i 's/deadline/noop/g' /boot/cmdline.txt
