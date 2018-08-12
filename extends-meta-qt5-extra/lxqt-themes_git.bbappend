FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 

SRC_URI += "file://mars/551041main_pia14156-full_full.jpg\
    file://mars/arrow-right.svg     \
    file://mars/lxqt-notificationd.qss\
    file://mars/lxqt-runner/clear.svg  \
    file://mars/lxqt-runner/navigation-menu.svg  \
    file://mars/mainmenu.svg   \
    file://mars/README\
    file://mars/wallpaper.cfg\
    file://mars/arrow-left.svg \
    file://mars/lxqt-notificationd/cancel.svg \
    file://mars/lxqt-panel.qss\
    file://mars/lxqt-runner.qss  \
    file://mars/preview.png   \
"

PR="r2"

do_install_append() { 

    install -d ${D}/${datadir}/lxqt/themes/mars
    install -d ${D}/${datadir}/lxqt/themes/mars//lxqt-notificationd
    install -d ${D}/${datadir}/lxqt/themes/mars/lxqt-runner
    install -d ${D}/${datadir}/lxqt/themes/mars/spacer-plugin
    install -m 0644 ${WORKDIR}/mars/README ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/arrow-right.svg   ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/arrow-left.svg ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/mainmenu.svg ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/wallpaper.cfg ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/551041main_pia14156-full_full.jpg ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/lxqt-notificationd.qss ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/lxqt-panel.qss ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/lxqt-runner.qss ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/preview.png ${D}/${datadir}/lxqt/themes/mars
    install -m 0644 ${WORKDIR}/mars/lxqt-runner/clear.svg ${D}/${datadir}/lxqt/themes/mars/lxqt-runner
    install -m 0644 ${WORKDIR}/mars/lxqt-runner/navigation-menu.svg ${D}/${datadir}/lxqt/themes/mars/lxqt-runner
    install -m 0644 ${WORKDIR}/mars/lxqt-notificationd/cancel.svg ${D}/${datadir}/lxqt/themes/mars/lxqt-runner
    
    ln -s ../../graphics/spacer-dark-dots.svg ${D}${datadir}/lxqt/themes/mars/spacer-plugin/spacer-dots.svg
    ln -s ../../graphics/spacer-dark-line.svg ${D}${datadir}/lxqt/themes/mars/spacer-plugin/spacer-line.svg
}
