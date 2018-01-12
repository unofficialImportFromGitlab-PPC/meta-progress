SUMMARY = "An efficient feature complete C++ bittorrent implementation"
HOMEPAGE = "https://github.com/arvidn/libtorrent"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=c2eb6b769958a05942513deaec0aa005"

inherit autotools

DEPENDS += " boost"

SRC_URI = " \
    https://github.com/arvidn/libtorrent/releases/download/libtorrent-1_1_5/${PN}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "f0e26796a79c51ae8e49ab652ce00166"
SRC_URI[sha256sum] = "103134068389155a0f2bccaca72a57765460eb8188495089dcad280dcf426930"  

#S = "${WORKDIR}/git"

EXTRA_OECONF += "--with-boost-libdir=${STAGING_LIBDIR}"
 
