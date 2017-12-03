SUMMARY = "Otter Browser aims to recreate the best aspects of the classic Opera (12.x) UI using Qt5"
HOMEPAGE = "https://otter-browser.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fe869ee987a340198fb0d54c55c47f1"

inherit cmake_qt5
#inherit cmake_qt5 qt5-translation gtk-icon-cache

DEPENDS = "qtbase qtx11extras qtwebkit qtsvg openssl gstreamer hunspell"

PV="0.9.92"

SRC_URI = "https://github.com/OtterBrowser/${PN}/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "5c7087c6c17873846091a152b9df061d"
SRC_URI[sha256sum] = "ef57b3581385ce634b65b4a410898170cc88fa63bd1f43d194d1f85272d26e4d"

#S="${WORKDIR}/Yarock_${PV}_Sources"

EXTRA_QMAKEVARS_PRE += "PREFIX=${prefix}"

FILES_${PN} += " \
  /usr/share/icons/hicolor/64x64/apps/otter-browser.png \
  /usr/share/icons/hicolor/256x256/apps/otter-browser.png \
  /usr/share/icons/hicolor/128x128/apps/otter-browser.png \
  /usr/share/icons/hicolor/48x48/apps/otter-browser.png \
  /usr/share/icons/hicolor/16x16/apps/otter-browser.png \
  /usr/share/icons/hicolor/32x32/apps/otter-browser.png \
"
 
