
inherit core-image

DISTRO_FEATURES += " pam x11 keyboard usbgadget usbhost wifi opengl dircertfb"

IMAGE_FEATURES +=  "splash package-management x11-base ssh-server-dropbear hwcodecs"


IMAGE_INSTALL += " \
    kernel-modules \
    packagegroup-core-full-cmdline \
    packagegroup-progress-core-apps \
    packagegroup-progress-security-apps \
    packagegroup-progress-basic-tools \
    "
BAD_RECOMMENDATIONS = " polkit-group-rule-datetime "    

IMAGE_INSTALL_remove += " matchbox-wm matchbox-terminal "

IMAGE_LINGUAS_append = "  es-es de-de fr-fr it-it"

TOOLCHAIN_HOST_TASK_append = " nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-glib-2.0"

inherit extrausers
EXTRA_USERS_PARAMS = "\
usermod -P power root;\
useradd -P progress progress; \
groupadd users; \
userdel nobody; \
groupmod -g 1020 users; \
usermod -s /bin/sh progress; \
usermod -a -G users progress;\
usermod -a -G sudo progress;\
usermod -a -G audio progress;\
usermod -a -G pulse progress;\
usermod -a -G netdev progress;\
usermod -a -G plugdev progress;\
usermod -a -G video progress;\
"
     
config_session_launch() {
  rm ${IMAGE_ROOTFS}/etc/X11/Xsession.d/90* #Removes the xdg autostart scripts which started a root X session at tty2
  echo "exec  sddm"  >${IMAGE_ROOTFS}/etc/X11/Xsession.d/90xXWindowManager.sh 
  chmod u+x ${IMAGE_ROOTFS}/etc/X11/Xsession.d/90xXWindowManager.sh 
}


config_udisks2(){
    cat << "EOF" >> ${IMAGE_ROOTFS}${sysconfdir}/polkit-1/rules.d/50-org.freedesktop.udisks2.rules
// Allow udisks2 to mount devices without authentication
polkit.addRule(function(action, subject) {
    if (action.id == "org.freedesktop.udisks2.filesystem-mount-system" ||
         action.id == "org.freedesktop.udisks2.filesystem-mount")  {
        return polkit.Result.YES;
    }
});    
EOF
}

fix_directory_permissions(){    
  chmod 755 ${IMAGE_ROOTFS}/var/lib/sddm
  chmod 755 ${IMAGE_ROOTFS}/usr/share/polkit-1/rules.d/
  chmod 755 ${IMAGE_ROOTFS}${sysconfdir}/polkit-1/rules.d/
  chmod 755 ${IMAGE_ROOTFS}${sysconfdir}/polkit-1/rules.d/50-org.freedesktop.udisks2.rules
}

ROOTFS_POSTPROCESS_COMMAND += "config_session_launch; config_udisks2; fix_directory_permissions;"
