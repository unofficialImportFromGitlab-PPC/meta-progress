#Core apps
IMAGE_INSTALL += "\
    liberation-fonts \
    oxygen-fonts \
    oxygen-icons \
    packagegroup-lxqt-base \
    qtbase \
    qtbase-plugins \
    mingetty \
    networkmanager \
    sddm \
    mozjs \
    mesa-demos \
    lsb \
    xserver-xorg-extension-glx  \
    setxkbmap \
    "
#Basic Tools    
IMAGE_INSTALL += "\
    featherpad \
    network-manager-applet \
    qps \
    x11vnc \
    "
#Security apps
IMAGE_INSTALL += "\
    libpam-runtime \
    pam-plugin-env \
    pam-plugin-loginuid \
    pam-plugin-cracklib \
    pam-plugin-unix \
    pam-plugin-limits \
    pam-plugin-umask \
    pam-plugin-nologin \
    pam-plugin-deny \
    pam-plugin-shells \
"         
