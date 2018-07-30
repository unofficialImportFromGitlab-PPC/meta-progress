DESCRIPTION = "Package groups for being distributed from an additional removable media or a remote server using a package manager"

inherit packagegroup

PACKAGES = "\
    packagegroup-progress-extra-utilities \
    packagegroup-progress-extra-internet-apps \
    packagegroup-progress-extra-network-apps"

RDEPENDS_packagegroup-progress-extra-utilities = "\
    simplescreenrecorder \
    "

RDEPENDS_packagegroup-progress-extra-internet-apps = "\
    otter-browser \
    epiphany \
    kvirc \
    "
    
    
RDEPENDS_packagegroup-progress-extra-network-tools = "\
    nut"
    

