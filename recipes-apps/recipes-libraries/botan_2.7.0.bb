SUMMARY = "Botan (Japanese for peony) is a cryptography library written in C++11 and released under the permissive Simplified BSD license."
HOMEPAGE = "https://botan.randombit.net/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://license.txt;md5=bf361fc63df3fa25652ee82c43b7601a"

inherit autotools

SRC_URI = " \
    https://github.com/randombit/botan/archive/2.7.0.tar.gz \
"
SRC_URI[md5sum] = "5db8c4c61475ef0e15267d74af7a15f7"
SRC_URI[sha256sum] = "6d950a5a588b47b19805573683b7b8d51947fc5b3bc2fb31ecaa1ef6b631eb0c"

do_configure(){
    python ${S}/configure.py --with-endian big --cpu ppc64 --prefix="/usr" --libdir=${libdir}
}

do_compile() {
    make
}

do_install(){
    oe_runmake 'DESTDIR=${D}'  install
    #rm ${D}${libdir}/libbotan-2.a
}

FILES_${PN}-dev += " \
  ${includedir}/botan-2/botan/* \
  ${docdir}/* \
  ${libdir}/libbotan-2* \
  ${libdir}/python2.7/site-packages/botan2.py\
  ${libdir}/pkgconfig/botan-2.pc\
  ${bindir}/botan\
  "
