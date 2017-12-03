FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 

SUMMARY = "Network UTility - nut manages your network devices (dhcp, static, zeroconf)"
HOMEPAGE = "https://github.com/dosnut/nut"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=03951036b49813694604a644693609be"

inherit cmake_qt5 qt5-translation 

DEPENDS = "resolvconf libnl wireless-tools"

SRC_URI = "https://github.com/dosnut/${PN}/archive/${PN}-v${PV}.tar.gz"
SRC_URI[md5sum] = "bf1ba0d2cd251b4df8f20b02ca3d8ac2"
SRC_URI[sha256sum] = "0e73f93d8c9d03a024c8a5cdd73ffef4e43f41649219d8b56d4659eb170cbc91"
SRC_URI += "file://COPYING"
SRC_URI += "file://nuts.config"

S="${WORKDIR}/${PN}-${PN}-v${PV}"

#EXTRA_QMAKEVARS_PRE += "PREFIX=${prefix}"

FILES_${PN} += " \
    ${datadir}/qnut \
    ${datadir}/qnut/icons \
    ${datadir}/dbus-1/system.d/nuts-dbus.conf \
"

do_install_append() {
    install -d ${D}${sysconfdir}/dbus-1/system.d/
    install -m 0644 ${S}/resources/nuts-dbus.conf  ${D}${sysconfdir}/dbus-1/system.d/
    
    install -d ${D}${sysconfdir}/nuts/events/all
    #install -m 0644 ${S}/nuts/nuts.config ${D}${sysconfdir}/nuts/
    install -m 0644 ${WORKDIR}/nuts.config ${D}${sysconfdir}/nuts/
    install -m 0755 ${S}/nuts/dispatch ${D}${sysconfdir}/nuts/
    install -m 0644 ${S}/nuts/events/all/* ${D}${sysconfdir}/nuts/events/all
    
    install -d ${D}${datadir}/man/man1/
    install -m 0644 ${S}/resources/nuts.1 ${D}${datadir}/man/man1/
}
