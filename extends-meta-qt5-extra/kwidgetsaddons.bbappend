FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

#support building against a qt without a11y enabled
SRC_URI += "file://001-Set-access-title-in-kcollapsiblegroupbox.patch"
