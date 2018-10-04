DEPENDS += " libxscrnsaver   xext  xinerama  xrandr  "

PACKAGECONFIG += " vdpau" 

EXTRA_OECONF += "--enable-libmpv-shared"

do_install_append(){
    install -d ${D}${libdir}
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${D}/usr/lib/libmpv* ${D}${libdir}
    install -m 0644 ${D}/usr/lib/pkgconfig/* ${D}${libdir}/pkgconfig
    rm -rf ${D}/usr/lib/

}

FILES_${PN} += "\
    ${libdir}/libmpv.so\
"
FILES_${PN}-dev += "\
    ${libdir}/libmpv.so.1\
    ${libdir}/libmpv.so.1.25.0\
   ${libdir}/pkgconfig/mpv.pc \
"
