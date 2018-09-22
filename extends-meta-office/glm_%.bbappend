EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=${prefix}"

do_install_append_class-target(){
    mv ${D}/usr/lib/ ${D}${libdir}
}

FILES_${PN}-dev += "\
  ${libdir}/pkgconfig \
  ${libdir}/pkgconfig/glm.pc \
  ${libdir}/cmake/glm/glmTargets.cmake \
  ${libdir}/cmake/glm/glmConfig.cmake \
  ${libdir}/cmake/glm/glmConfigVersion.cmake"
  
  
