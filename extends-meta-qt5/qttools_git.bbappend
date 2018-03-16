FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_remove += "\
    file://0002-linguist-tools-cmake-allow-overriding-the-location-f.patch \
"

SRC_URI += "\
    file://0002-progress-linguist-tools-cmake-allow-overriding-the-location-f.patch \
"
 
