DESCRIPTION = "Progress Linux image."

LICENSE = "MIT"

inherit core-image

DISTRO_FEATURES += " pam splash package-management x11-base ssh-server-dropbear hwcodecs"

inherit distro_features_check
REQUIRED_DISTRO_FEATURES = "x11 pam"

IMAGE_INSTALL += " \
    kernel-modules \
    packagegroup-progress-core-apps \
    packagegroup-progress-basic-tools \
    packagegroup-progress-security-apps \
    packagegroup-progress-basic-tools \
    packagegroup-progress-internet-apps \
    packagegroup-progress-multimedia-apps"  


IMAGE_INSTALL_remove += " polkit-group-rule-datetime  matchbox-wm matchbox-terminal "

IMAGE_LINGUAS_append = "  es-es de-de fr-fr it-it"

TOOLCHAIN_HOST_TASK_append = " nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-glib-2.0"

inherit extrausers
EXTRA_USERS_PARAMS = "\
useradd -p ''  progress; \
groupadd users; \
userdel nobody; \
groupmod -g 1020 users; \
usermod -s /bin/sh progress; \
usermod -a -G users progress;\
usermod -a -G sudo progress;\
usermod -a -G audio progress;\
usermod -a -G pulse progress;\
usermod -a -G netdev progress;\
"
     
my_postprocess_function() {
  #echo "export QT_QPA_PLATFORMTHEME=lxqt"  > ${IMAGE_ROOTFS}/etc/profile.d/lxqt.sh
  #rm ${IMAGE_ROOTFS}/etc/xdg/autostart/lxqt-notifications.desktop 
  #rm ${IMAGE_ROOTFS}/etc/xdg/autostart/lxqt-panel.desktop 
  #rm ${IMAGE_ROOTFS}/etc/xdg/autostart/lxqt-policykit-agent.desktop   
  #echo "exec startlxqt"  > ${IMAGE_ROOTFS}/etc/profile.d/lxqt.sh
  rm ${IMAGE_ROOTFS}/etc/X11/Xsession.d/90*
  echo "exec  sddm"  >${IMAGE_ROOTFS}/etc/X11/Xsession.d/90xXWindowManager.sh 
  chmod u+x ${IMAGE_ROOTFS}/etc/X11/Xsession.d/90xXWindowManager.sh 
}


#grant_access_to_xorg(){
# chmod ug+s ${IMAGE_ROOTFS}/usr/bin/Xorg
#}

#ROOTFS_POSTPROCESS_COMMAND += "my_postprocess_function; grant_access_to_xorg; "
ROOTFS_POSTPROCESS_COMMAND += "my_postprocess_function; "
