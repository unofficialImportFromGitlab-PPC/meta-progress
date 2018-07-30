DESCRIPTION = "Package groups for a base image"

inherit packagegroup

PACKAGES = "\
    packagegroup-progress-core-apps \
    packagegroup-progress-security-apps \
    packagegroup-progress-basic-tools "

RDEPENDS_packagegroup-progress-core-apps = "\
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
    
RDEPENDS_packagegroup-progress-basic-tools = "\
    featherpad \
    network-manager-applet \
    qps \
    "

RDEPENDS_packagegroup-progress-security-apps  = "\
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
