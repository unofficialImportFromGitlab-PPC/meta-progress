EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=${prefix}"

do_install_append_class-target(){
    mv ${D}/usr/lib/ ${D}${libdir}
}

FILES_${PN}-dev += " \
  ${libdir}/pkgconfig \
  ${libdir}/pkgconfig/graphite2.pc"

FILES_${PN} += "${libdir}/libgraphite2.so \
    ${libdir}/libgraphite2.so.3 \
    ${libdir}/libgraphite2.so.3.0.1"

    

BBCLASSEXTEND = "native"
  
