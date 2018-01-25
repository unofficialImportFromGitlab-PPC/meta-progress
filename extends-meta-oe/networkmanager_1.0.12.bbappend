FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 


SRC_URI += "file://NetworkManager.conf \
            file://init.d/networkmanager \
"            

do_install_append() { 
    install -d ${D}${sysconfdir}/NetworkManager/
    install -m 644 ${WORKDIR}/NetworkManager.conf ${D}${sysconfdir}/NetworkManager

    install -d ${D}${sysconfdir}/init.d/
    install -d ${D}${sysconfdir}/rc5.d/
    install -m 0755 ${WORKDIR}/init.d/networkmanager ${D}${sysconfdir}/init.d
    cd ${D}${sysconfdir}/rc5.d/
    ln -s ../init.d/networkmanager ${D}${sysconfdir}/rc5.d/S95networkmanager
}     
