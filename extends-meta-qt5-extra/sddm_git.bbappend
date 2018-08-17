FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 

RDEPENDS_${PN} += "qtquickcontrols"

EXTRA_OECMAKE += "-DQT_IMPORTS_DIR=${OE_QMAKE_PATH_QML}"

SRC_URI += "file://sddm.conf \
             file://faces/progress.face.icon \
             file://themes/progress/Main.qml \
             file://themes/progress/metadata.desktop \
             file://themes/progress/theme.conf \
             file://themes/progress/README \
             file://themes/progress/LICENSE \
             file://themes/progress/angle-down.png \
             file://themes/progress/angle-left.png \
             file://themes/progress/angle-right.png \
             file://themes/progress/reboot.png \
             file://themes/progress/shutdown.png \
             file://themes/progress/images/background.jpg \
             file://themes/mars/Main.qml \
             file://themes/mars/metadata.desktop \
             file://themes/mars/theme.conf \
             file://themes/mars/README \
             file://themes/mars/LICENSE \
             file://themes/mars/angle-down.png \
             file://themes/mars/angle-left.png \
             file://themes/mars/angle-right.png \
             file://themes/mars/reboot.png \
             file://themes/mars/shutdown.png \
             file://themes/mars/images/background.jpg \
             file://init.d/sddm \
             file://0004-xsession_ck_launch_session.patch \
             file://0005-set_software_renderer.patch \
" 

PR="r3"

do_install_append() { 
    install -m 644 ${WORKDIR}/sddm.conf ${D}${sysconfdir} 
        
    install -d ${D}/${datadir}/sddm/faces
    install -m 0644 ${WORKDIR}/faces/progress.face.icon ${D}/${datadir}/sddm/faces
    
    install -d ${D}/${datadir}/sddm/themes/progress
    install -d ${D}/${datadir}/sddm/themes/progress/images
    install -m 0644 ${WORKDIR}/themes/progress/Main.qml ${D}/${datadir}/sddm/themes/progress 
    install -m 0644 ${WORKDIR}/themes/progress/metadata.desktop ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/theme.conf ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/README ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/LICENSE ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/angle-down.png ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/angle-left.png ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/angle-right.png ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/reboot.png ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/shutdown.png ${D}/${datadir}/sddm/themes/progress
    install -m 0644 ${WORKDIR}/themes/progress/images/background.jpg ${D}/${datadir}/sddm/themes/progress/images
    
    install -d ${D}/${datadir}/sddm/themes/mars
    install -d ${D}/${datadir}/sddm/themes/mars/images
    install -m 0644 ${WORKDIR}/themes/mars/Main.qml ${D}/${datadir}/sddm/themes/mars 
    install -m 0644 ${WORKDIR}/themes/mars/metadata.desktop ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/theme.conf ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/README ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/LICENSE ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/angle-down.png ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/angle-left.png ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/angle-right.png ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/reboot.png ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/shutdown.png ${D}/${datadir}/sddm/themes/mars
    install -m 0644 ${WORKDIR}/themes/mars/images/background.jpg ${D}/${datadir}/sddm/themes/mars/images
    
    install -d ${D}${sysconfdir}/init.d/
    #install -d ${D}${sysconfdir}/rc5.d/
    install -m 0755 ${WORKDIR}/init.d/sddm ${D}${sysconfdir}/init.d
    #cd ${D}${sysconfdir}/rc5.d/
    #ln -s ../init.d/sddm ${D}${sysconfdir}/rc5.d/S90sddm
    
}
