SUMMARY = "The ownCloud Desktop Client is a tool to synchronize files from ownCloud Server with your computer."
HOMEPAGE = "https://owncloud.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c262c13b60ebefe3060aed37d334ab6"

SRC_URI = "https://github.com/frankosterfeld/qtkeychain/archive/v${PV}.tar.gz "
SRC_URI[md5sum] = "e6921de6f256259784f2a9edd1eeb8f5"
SRC_URI[sha256sum] = "9c2762d9d0759a65cdb80106d547db83c6e9fdea66f1973c6e9014f867c6f28e"


inherit cmake_qt5 qt5-translation 

EXTRA_OECMAKE += "\
    -DBUILD_TRANSLATIONS=OFF \
"

do_install_append(){
    install -d  ${D}${datadir}/qt5/translations
    
}

FILES_${PN}-dev += " \
    ${libdir}/cmake/Qt5Keychain/Qt5KeychainLibraryDepends-noconfig.cmake\
    ${libdir}/cmake/Qt5Keychain/Qt5KeychainConfigVersion.cmake \
    ${libdir}/cmake/Qt5Keychain/Qt5KeychainConfig.cmake \
    ${libdir}/cmake/Qt5Keychain/Qt5KeychainLibraryDepends.cmake  \
    ${libdir}/cmake/Qt5Keychain/Qt5KeychainLibraryDepends.cmake \
    /usr/mkspecs/modules   \
    /usr/mkspecs/modules/qt_Qt5Keychain.pri  \
  "

