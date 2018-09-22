EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=${prefix}"

do_install_append_class-target(){
    mv ${D}/usr/lib/ ${D}${libdir}
}

FILES_${PN}-dev += " \
  ${libdir}/vigra \
  ${libdir}/vigra/VigraConfigVersion.cmake \
  ${libdir}/vigra/vigra-targets.cmake \
  ${libdir}/vigra/vigra-targets-release.cmake \
  ${libdir}/vigra/VigraConfig.cmake"

FILES_${PN} += "${libdir}/libvigraimpex.so.5.1.10.0 \
  ${libdir}/libvigraimpex.so.5 \
  ${libdir}/libvigraimpex.so"
  
