SUMMARY = "SpeedCrunch is a high-precision scientific calculator. It features a syntax-highlighted scrollable display and is designed to be fully used via keyboard. Some distinctive features are auto-completion of functions and variables, a formula book, and quick insertion of constants from various fields of knowledge."
HOMEPAGE = "http://speedcrunch.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=39bba7d2cf0ba1036f2a6e2be52fe3f0"

inherit  qmake5 qt5-translation

DEPENDS += " \
qtbase \
qtbase-native \
qttools \
qttranslations \
qtx11extras \
"

SRC_URI = "https://bitbucket.org/heldercorreia/speedcrunch/get/50a69b6954ea97aa37f62c68df3ff4ce7df4ab05.zip"

SRC_URI[md5sum] = "1a243bc4f0477f51e4986ac388d82384"
SRC_URI[sha256sum] = "7c0b05e88742a52d63dc08a2793118ad2483351a6a97bb35cb1b05fab1eb270f" 

S = "${WORKDIR}/heldercorreia-speedcrunch-50a69b6954ea/src"

EXTRA_OECMAKE += "\
"

FILES_${PN} += " \
    /usr/share/appdata/speedcrunch.appdata.xml \
"

do_install_append() {    
    install -d ${D}/${datadir}/pixmaps
    install -m 0644 ${WORKDIR}/image/share/pixmaps/speedcrunch.png ${D}/${datadir}/pixmaps
    
    install -d ${D}/${datadir}/applications
    install -m 0644 ${WORKDIR}/image/share/applications/speedcrunch.desktop ${D}/${datadir}/applications
    
    install -d ${D}/${datadir}/appdata
    install -m 0644 ${WORKDIR}/image/share/appdata/speedcrunch.appdata.xml ${D}/${datadir}/appdata
    
    rm ${WORKDIR}/image/share/pixmaps/speedcrunch.png
    rm -rf ${WORKDIR}/image/share/pixmaps/    
    
    rm ${WORKDIR}/image/share/applications/speedcrunch.desktop
    rm -rf ${WORKDIR}/image/share/applications/    
    
    rm ${WORKDIR}/image/share/appdata/speedcrunch.appdata.xml
    rm -rf ${WORKDIR}/image/share/appdata/

    rm -rf ${WORKDIR}/image/share/
}

