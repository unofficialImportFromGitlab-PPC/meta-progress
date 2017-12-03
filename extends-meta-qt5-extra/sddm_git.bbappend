FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 

SRC_URI += "file://sddm.conf" 

do_install_append() { 
    install -m 644 ${WORKDIR}/sddm.conf ${D}${sysconfdir} 
}
