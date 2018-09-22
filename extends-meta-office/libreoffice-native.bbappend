FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://libreoffice-5.0.6.3-icu-61-compatibility.patch\
    "

inherit python3native
