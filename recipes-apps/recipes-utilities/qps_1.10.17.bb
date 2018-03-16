SUMMARY = "The Qt process manager"
HOMEPAGE = "https://github.com/QtDesktop/qps"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"

inherit cmake_qt5 qt5-translation

DEPENDS += " \
        qtbase \
        qtx11extras \
        qttools \
        libxrender \
        "


SRC_URI = "https://github.com/QtDesktop/qps/archive/${PV}.tar.gz"

SRC_URI[md5sum] = "1ce452cace6c9371cf4cc70ce7b18f79"
SRC_URI[sha256sum] = "21b7a101f91e6fe5ba7e3b825f8724b0837869b1b5ebb058c3446e7ef9706ca8" 

#S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OECMAKE += "\
"



FILES_${PN} += " \
  /usr/share/icons/hicolor/48x48/apps/qps.png \
" 
