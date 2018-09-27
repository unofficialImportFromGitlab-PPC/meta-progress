do_install_append(){
    install -d ${D}${libdir}
    install -d ${D}${libdir}/pkgconfig
    install -d ${D}${libdir}/${PN}
 
    mv ${D}/usr/lib/* ${D}${libdir}
    rm -rf ${D}/usr/lib/
} 

FILES_${PN} += "/usr/lib64/vamp-plugin-sdk"

