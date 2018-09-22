SUMMARY = "htmlcxx is a simple non-validating css1 and html parser for C++."
HOMEPAGE = "http://sf.net/projects/htmlcxx"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=21fe7ac191e4ebd44f0cd1a5a58357c2"

inherit autotools

DEPDENS += " flex"

SRC_URI = " \
    git://github.com/raspopov/htmlcxx.git \
"
SRCREV = "38bbfc9953b1b7cdab95842a14b11e9934194f9a"
#PV = "3.0.0pre2"
S = "${WORKDIR}/git"
