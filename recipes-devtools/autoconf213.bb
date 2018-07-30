require autoconf.inc

PV="2.13"
PR = "r11"

S = "${WORKDIR}/autoconf-${PV}/"
EXTRA_OECONF += " --prefix=${D}${prefix} --program-suffix=-${PV}"
EXTRA_OEMAKE = "DESTDIR=${D}"

CXXFLAGS += " --sysroot=${PKG_CONFIG_SYSROOT_DIR}"
CFLAGS += " --sysroot=${PKG_CONFIG_SYSROOT_DIR}"

LICENSE = "GPLv2 & GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=361b6b837cad26c6900a926b62aada5f "
SRC_URI +=  " \
        file://autoconf-2.12-race.patch \
        file://autoconf-2.13-mawk.patch \
        file://autoconf-2.13-notmp.patch \
        file://autoconf-2.13-c++exit.patch \
        file://autoconf-2.13-headers.patch \
        file://autoconf-2.13-autoscan.patch \
        file://autoconf-2.13-exit.patch \
        file://autoconf-2.13-wait3test.patch \
        file://autoconf-2.13-make-defs-62361.patch \
        file://autoconf-2.13-versioning.patch \
        file://autoconf213-destdir.patch \
        file://autoconf213-info.patch"

SRC_URI[md5sum] = "9de56d4a161a723228220b0f425dc711"
SRC_URI[sha256sum] = "f0611136bee505811e9ca11ca7ac188ef5323a8e2ef19cffd3edb3cf08fd791e"


EXTRA_OECONF += "--exec-prefix=${prefix} \
            --bindir=${prefix}/bin \
            --program-suffix=-${PV}"

BBCLASSEXTEND = "native nativesdk"

do_configure_append(){
    mv ${S}autoconf.texi ${S}/autoconf213.texi
    rm -f ${S}/autoconf.info
}


FILES_${PN} = " ${datadir}/autoconf-2.13/* \
            ${bindir}/*\
            "
