DESCRIPTION = "Progress Linux image. Linux image including LXQT plus internet, multimedia and productivity applications"

LICENSE = "MIT"

inherit core-image-progress


IMAGE_INSTALL += " \
    packagegroup-progress-internet-apps \
    packagegroup-progress-multimedia-apps \
    "  
