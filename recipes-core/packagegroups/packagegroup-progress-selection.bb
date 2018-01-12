DESCRIPTION = "Package groups for an  image includding prouctivity apps, internet tools, etc"

inherit packagegroup

PACKAGES = "\
    packagegroup-progress-internet-apps \
    packagegroup-progress-multimedia-apps \
    packagegroup-progress-productivity-apps \
    packagegroup-progress-graphics-apps \
    "

RDEPENDS_packagegroup-progress-internet-apps = "\
    otter-browser \
    qbittorrent \
    "

RDEPENDS_packagegroup-progress-multimedia-apps = "\
    gstreamer1.0-plugins-base \
    gst-plugins-good \
    gst-plugins-bad \
    gst-plugins-ugly \
    qmmp \
    "
#vlc 

RDEPENDS_packagegroup-progress-productivity-apps = "\
    abiword "
    
RDEPENDS_packagegroup-progress-graphics-apps = "\
    gimp "
