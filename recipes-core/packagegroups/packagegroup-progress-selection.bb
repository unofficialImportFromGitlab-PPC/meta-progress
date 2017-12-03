DESCRIPTION = "Package groups for an  image includding prouctivity apps, internet tools, etc"

inherit packagegroup

PACKAGES = "\
    packagegroup-progress-internet-apps \
    packagegroup-progress-multimedia-apps"

RDEPENDS_packagegroup-progress-internet-apps = "\
    otter-browser "

RDEPENDS_packagegroup-progress-multimedia-apps = "\
    gstreamer1.0-plugins-base \
    gst-plugins-good \
    gst-plugins-bad \
    gst-plugins-ugly \
    qmmp "

