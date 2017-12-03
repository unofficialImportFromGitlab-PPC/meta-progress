SUMMARY = "FeatherPad (by Pedram Pourang, a.k.a. Tsu Jan <tsujan2000@gmail.com>) is a lightweight Qt5 plain-text editor for Linux."
HOMEPAGE = "https://github.com/tsujan/FeatherPad"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

inherit qmake5 qt5-translation gtk-icon-cache

DEPENDS = "qttools-native qtbase qtx11extras qtsvg hicolor-icon-theme"

SRC_URI = "https://github.com/tsujan/FeatherPad/archive/V${PV}.tar.gz"
SRC_URI[md5sum] = "f9d8510ea29866644793c084983ff0e6"
SRC_URI[sha256sum] = "4deb8d8d00aaf8fb3d859e9a283132a1aa301cdbb87666f2c71cbdf6a6d10f8c"

S="${WORKDIR}/FeatherPad-${PV}"

#EXTRA_QMAKEVARS_PRE += "PREFIX=${prefix}"

FILES_${PN} += " \
    ${datadir}/featherpad \
    ${datadir}/featherpad/help \
"
