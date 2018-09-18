SUMMARY = "Gede is a graphical frontend (GUI) to GDB written in C++ and using the Qt4 (or Qt5) toolkit."

HOMEPAGE = "http://acidron.com/gede/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ba8c0bee6efa138bb9d7909d39d5c371"

inherit qmake5

DEPENDS = "qtbase qttools qtx11extras qttools-native ctags python"
RDEPENDS_${PN} = "ctags"


SRC_URI = "http://gede.acidron.com/uploads/source/gede-${PV}.tar.xz"
SRC_URI[md5sum] = "17b0a4895ad0d6761512dfde1f5858a1"
SRC_URI[sha256sum] = "e6ade1f5608f9dd76ca9e094f3c2fd88e1bc6de7c87e48aa9456996ef2d8692b"

do_configure(){
 cd ${WORKDIR}/${PN}-${PV}/src
 ${OE_QMAKE_QMAKE}
}

do_compile(){
 cd ${WORKDIR}/${PN}-${PV}/src
 oe_runmake 
}

do_install(){
 cd ${WORKDIR}/${PN}-${PV}/src
 install -d ${D}${bindir}/
 install -m 0644 ${WORKDIR}/${PN}-${PV}/src/gede ${D}${bindir}/
 chmod 755 ${D}${bindir}/gede
}


