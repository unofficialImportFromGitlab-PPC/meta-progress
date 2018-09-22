EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=${prefix}"

do_install_append_class-target(){
    mv ${D}/usr/lib/ ${D}${libdir}
}

FILES_${PN}-dev += "${libdir}/cmake \
  ${libdir}/cmake/CLuceneConfig.cmake \
  ${libdir}/pkgconfig/libclucene-core.pc"

FILES_${PN} += "${libdir}/libclucene-core.so.2.3.3.4 \
  ${libdir}/libclucene-contribs-lib.so.2.3.3.4  \
  ${libdir}/libclucene-contribs-lib.so.1 \
  ${libdir}/libclucene-shared.so.1 \
  ${libdir}/libclucene-contribs-lib.so \
  ${libdir}/libclucene-shared.so \
  ${libdir}/libclucene-core.so \
  ${libdir}/libclucene-core.so.1 \
  ${libdir}/libclucene-shared.so.2.3.3.4"
  
