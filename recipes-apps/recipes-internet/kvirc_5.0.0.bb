SUMMARY = "KVIrc is a free portable IRC client based on the excellent Qt GUI toolkit."
HOMEPAGE = "http://www.kvirc.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://doc/COPYING;md5=310f085f1f830cca24a65c1e5512b9f4"

inherit cmake_qt5 

DEPENDS += " \
    qtbase \
    zlib \
    python \
    phonon \
    enchant \
    libxscrnsaver \
    qtmultimedia \
    qtx11extras \
    qttools \
    qtscript \
    qtsvg \
    "
    

SRC_URI = " \
    https://github.com/${PN}/KVIrc/archive/${PV}-alpha1.tar.gz \
"

SRC_URI[md5sum] = "3c5ee74d128a246a724837b9383fd4b3"
SRC_URI[sha256sum] = "d4718207bce831adf32be8602becb82904f104f37984c543bfea6d50f50c2c26" 

S = "${WORKDIR}/KVIrc-${PV}-alpha1"

EXTRA_OECMAKE += "-DWANT_ENV_FLAGS=ON \
                -DWANT_QTWEBKIT=OFF \
                -DWANT_KDE=OFF \
                -DWANT_DOXYGEN=OFF \
                -DTEST_DID_RUN=0 \
                -DTEST_DID_RUN__TRYRUN_OUTPUT=0 \
                -DTEST_DID_RUN_DYNLABELS=0 \
                "
                
do_install_append(){
    install -d ${D}${libdir}
    
    install -d ${D}/${libdir}/kvirc/4.9/modules/
    install -m 0644 ${WORKDIR}/image/usr/lib/kvirc/4.9/modules/* ${D}/${libdir}/kvirc/4.9/modules/
    
    install -m 0644 ${WORKDIR}/image/usr/lib/libkvilib.so.4.9.1 ${D}/${libdir}/
    install -m 0644 ${WORKDIR}/image/usr/lib/libkvilib.so ${D}/${libdir}/
    install -m 0644 ${WORKDIR}/image/usr/lib/libkvilib.so.4 ${D}/${libdir}/
    rm -rf ${WORKDIR}/image/usr/lib
}

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libkvilib.so"

FILES_${PN} += " \
  /usr/share/icons/hicolor/64x64/mimetypes/text-x-kvs.png \
  /usr/share/icons/hicolor/64x64/mimetypes/application-x-kvt.png \
  /usr/share/icons/hicolor/64x64/mimetypes/text-x-kvc.png \
  /usr/share/icons/hicolor/64x64/mimetypes/application-x-kva.png \
  /usr/share/icons/hicolor/64x64/apps/kvirc.png \
  /usr/share/icons/hicolor/scalable/mimetypes/text-x-kvs.svgz \
  /usr/share/icons/hicolor/scalable/mimetypes/application-x-kva.svgz \
  /usr/share/icons/hicolor/scalable/mimetypes/application-x-kvt.svgz \
  /usr/share/icons/hicolor/scalable/mimetypes/text-x-kvc.svgz \
  /usr/share/icons/hicolor/scalable/apps/kvirc.svgz \
  /usr/share/icons/hicolor/128x128/mimetypes/text-x-kvs.png \
  /usr/share/icons/hicolor/128x128/mimetypes/application-x-kvt.png \
  /usr/share/icons/hicolor/128x128/mimetypes/text-x-kvc.png \
  /usr/share/icons/hicolor/128x128/mimetypes/application-x-kva.png \
  /usr/share/icons/hicolor/128x128/apps/kvirc.png \
  /usr/share/icons/hicolor/48x48/mimetypes/text-x-kvs.png \
  /usr/share/icons/hicolor/48x48/mimetypes/application-x-kvt.png \
  /usr/share/icons/hicolor/48x48/mimetypes/text-x-kvc.png \
  /usr/share/icons/hicolor/48x48/mimetypes/application-x-kva.png \
  /usr/share/icons/hicolor/48x48/apps/kvirc.png \
  /usr/share/icons/hicolor/16x16/mimetypes/text-x-kvs.png \
  /usr/share/icons/hicolor/16x16/mimetypes/application-x-kvt.png \
  /usr/share/icons/hicolor/16x16/mimetypes/text-x-kvc.png \
  /usr/share/icons/hicolor/16x16/mimetypes/application-x-kva.png \
  /usr/share/icons/hicolor/16x16/apps/kvirc.png \
  /usr/share/icons/hicolor/32x32/mimetypes/text-x-kvs.png \
  /usr/share/icons/hicolor/32x32/mimetypes/application-x-kvt.png \
  /usr/share/icons/hicolor/32x32/mimetypes/text-x-kvc.png \
  /usr/share/icons/hicolor/32x32/mimetypes/application-x-kva.png \
  /usr/share/icons/hicolor/32x32/apps/kvirc.png \
"
