SUMMARY = "Cross-platform (Qt), open-source (GPLv3) video editor https://www.shotcut.org"
HOMEPAGE = "https://owncloud.org/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"


SRC_URI = "https://github.com/mltframework/shotcut/archive/v${PV}.tar.gz "
SRC_URI[md5sum] = "a5853be51dc93dceb24e2da393390f46"
SRC_URI[sha256sum] = "0883cbab0d5ae239a40720961cea66e5fe2a181e33b46b7ed1654229c30f8166"

inherit qmake5  qt5-translation pkgconfig

DEPENDS += "qttools qttools-native qtbase mlt qtdeclarative qtwebkit qtmultimedia qtx11extras  glib-2.0 glib-2.0-native "
RDEPENDS_${PN} +="libsdl2 libjack"

EXTRA_QMAKEVARS_PRE += "PREFIX=${prefix} "

EXTRA_OECONF += "--disable-rpath"

# Dirty hack to Workaround wrong paths. QtWebKit recipe shoudl be fixed to include mkspecs in the dev package and to fix the inlucde path. 
do_configure_prepend(){

    if [ ! -f ${RECIPE_SYSROOT}/usr/bin/lrelease ]
    then
        ln -s ${RECIPE_SYSROOT_NATIVE}/usr/bin/qt5/lrelease ${RECIPE_SYSROOT}/usr/bin/lrelease
    fi 
    
    
    #if [ ! -d ${RECIPE_SYSROOT}/usr/include/qt5/QtWebKitWidgets ]
    #then
    #    ln -s ${RECIPE_SYSROOT}/usr/include/QtWebKitWidgets  ${RECIPE_SYSROOT}/usr/include/qt5/QtWebKitWidgets 
    #fi
}

# Workaround taken from https://lists.yoctoproject.org/pipermail/yocto/2016-November/032926.html
do_install_append(){
    chrpath -d ${D}${bindir}/shotcut
}

FILES_${PN} += " \
    ${datadir}/shotcut/qml/* \
    ${datadir}/icons/hicolor/64x64/apps/org.shotcut.Shotcut.png \
    ${datadir}/metainfo/org.shotcut.Shotcut.appdata.xml \
    ${datadir}/mime/packages/org.shotcut.Shotcut.xml  \
    "
    
