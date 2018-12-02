PR="r3"

CXXFLAGS += "-DADDON_DIR=${libdir} "
CFLAGS += "-DADDON_DIR=${libdir} "

do_install_append(){
    install -d ${D}${libdir}
    install -d ${D}${libdir}/pkgconfig
    install -d ${D}${libdir}/${PN}
 
    mv ${D}/usr/lib/* ${D}${libdir}
    rm -rf ${D}/usr/lib/*
    if [ "${TARGET_ARCH}" = "powerpc64" ]; then
	ln -s ${libdir}/${PN} ${D}/usr/lib/${PN}
    fi
}

FILES_jack-server += " /usr/lib/jack"
