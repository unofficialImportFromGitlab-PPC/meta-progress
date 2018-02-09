DESCRIPTION = "Progress Linux image. Linux image including LXQT plus internet, multimedia and productivity applications"

LICENSE = "MIT"

inherit core-image-progress


IMAGE_INSTALL += " \
    packagegroup-progress-internet-apps \
    packagegroup-progress-multimedia-apps \
    packagegroup-progress-productivity-apps \
    packagegroup-progress-graphics-apps \
    packagegroup-progress-selected-tools \
    "  
