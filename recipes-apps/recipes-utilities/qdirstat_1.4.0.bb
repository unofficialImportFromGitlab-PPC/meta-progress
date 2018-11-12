SUMMARY = "QDirStat is a graphical application to show where your disk space has gone and to help you to clean it up."
HOMEPAGE = "https://github.com/shundhammer/qdirstat"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

inherit qmake5 qt5-translation gtk-icon-cache

DEPENDS = "qttools-native qtbase qtx11extras qtsvg hicolor-icon-theme"

SRC_URI = "https://github.com/shundhammer/qdirstat/archive/1.4.tar.gz"
SRC_URI[md5sum] = "fcd3bcbdb5a78a1ea64bf3f8c12f392e"
SRC_URI[sha256sum] = "7f9a0a7304c55ebfad1e50c7747ba762b07068f48304b3d3919bdb65ee037999"

S="${WORKDIR}/${PN}-1.4"

RDEPENDS_${PN} += "perl"

do_install_append(){
    install -m 755 ${B}/src/qdirstat ${D}/${bindir}
}

#FILES_${PN} += " \
#    ${datadir}/featherpad \
#    ${datadir}/featherpad/help \
#"
