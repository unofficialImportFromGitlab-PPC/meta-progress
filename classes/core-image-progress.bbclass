
inherit core-image

IMAGE_FEATURES +=  "splash package-management x11-base ssh-server-dropbear hwcodecs"


IMAGE_INSTALL += " \
    kernel-modules \
    packagegroup-core-full-cmdline \
    "

# This recipe is added by meta-qt5-extras and causes an error (a conflict with polkit). The same rule is added using the function config_settime (see below)
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
  rm ${IMAGE_ROOTFS}/etc/X11/Xsession.d/89* #Removes the xdg autostart scripts which started a root X session at tty2
  rm ${IMAGE_ROOTFS}/etc/X11/Xsession.d/90* #Removes 90xXWindowManager.sh  script to be replaced by a custom one launching SDDM
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

# polkit-group-rule-datetime has been removed (see the previous comment). It was added by meta-qt5-extras and causes an error (a conflict with polkit). The same rule is added using this function 
config_settime(){
    cat << "EOF" >> ${IMAGE_ROOTFS}${sysconfdir}/polkit-1/rules.d/50-org.freedesktop.timedate1.rules
// Give group 'datetime' rights to change settings based upon http://lists.freedesktop.org/archives/systemd-devel/2013-March/009576.html 
polkit.addRule(function(action, subject) {
  if (action.id.indexOf("org.freedesktop.timedate1.") == 0 && subject.isInGroup("datetime")) {
    return polkit.Result.YES;
  }
});    
EOF
}


fix_directory_permissions(){    
  chmod 755 ${IMAGE_ROOTFS}/var/lib/sddm
  chmod 755 ${IMAGE_ROOTFS}/usr/share/polkit-1/rules.d/
  chmod 755 ${IMAGE_ROOTFS}${sysconfdir}/polkit-1/rules.d/
  chmod 755 ${IMAGE_ROOTFS}${sysconfdir}/polkit-1/rules.d/*
}


add_repository(){
  mkdir ${IMAGE_ROOTFS}${sysconfdir}/yum.repos.d 
  cat << "EOF" >> ${IMAGE_ROOTFS}${sysconfdir}/yum.repos.d/progress-repo.repo
[progress-repo]                                                                                                                                             
name=Power Progress Community Linux repo                                                                                                                        
baseurl=http://repo.powerprogress.org/yocto/${DISTRO_VERSION}/rpm/                  
enabled=1                                               
metadata_expire=0                            
gpgcheck=0      
EOF
}

ROOTFS_POSTPROCESS_COMMAND += "config_session_launch; config_udisks2; config_settime; fix_directory_permissions; add_repository; "
