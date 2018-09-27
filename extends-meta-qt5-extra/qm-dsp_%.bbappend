do_install_append(){    
    mv ${D}/usr/lib/libqm-dsp.a ${D}/${libdir}
    rm -rf ${D}/usr/lib/
}


FILES_${PN} += "/usr/lib64"
