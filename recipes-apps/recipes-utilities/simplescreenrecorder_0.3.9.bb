SUMMARY = "SimpleScreenRecorder is a Linux program that I've created to record programs and games."
HOMEPAGE = "http://www.maartenbaert.be/simplescreenrecorder/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit cmake_qt5 

DEPENDS += " \
qtbase \
qtx11extras \
alsa-lib \
ffmpeg \
"


SRC_URI = "https://github.com/MaartenBaert/ssr/archive/${PV}.tar.gz"

SRC_URI[md5sum] = "5caa2a10128189d93a7a0699014d3925"
SRC_URI[sha256sum] = "f3820eadaf9ecfe9aaf0940bf868cedd828c6e75b6a860195ecc091c174fcebe" 

S = "${WORKDIR}/ssr-${PV}"

EXTRA_OECMAKE += "-DWITH_JACK=FALSE \
-DWITH_QT5=TRUE \
-DENABLE_X86_ASM=FALSE \
-DWITH_GLINJECT=FALSE \
"

RDEPENDS_simplescreenrecorder +="bash"

#The following line removes QA Issue: -dev package contains non-symlink .so: simplescreenrecorder-dev path '/work/core2-64-poky-linux/simplescreenrecorder/0.3.9-r0/packages-split/simplescreenrecorder-dev/usr/lib/libssr-glinject.so' [dev-elf]
INSANE_SKIP_${PN}-dev += "dev-elf"

FILES_${PN} += " \
/usr/share/appdata/simplescreenrecorder.appdata.xml \
/usr/share/icons/hicolor/64x64/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/64x64/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/64x64/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/64x64/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/64x64/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/scalable/apps/simplescreenrecorder-paused.svg \
/usr/share/icons/hicolor/scalable/apps/simplescreenrecorder-recording.svg \
/usr/share/icons/hicolor/scalable/apps/simplescreenrecorder-idle.svg \
/usr/share/icons/hicolor/scalable/apps/simplescreenrecorder.svg \
/usr/share/icons/hicolor/scalable/apps/simplescreenrecorder-error.svg \
/usr/share/icons/hicolor/22x22/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/22x22/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/22x22/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/22x22/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/22x22/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/192x192/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/192x192/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/192x192/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/192x192/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/192x192/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/256x256/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/256x256/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/256x256/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/256x256/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/256x256/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/96x96/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/96x96/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/96x96/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/96x96/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/96x96/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/128x128/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/128x128/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/128x128/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/128x128/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/128x128/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/48x48/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/48x48/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/48x48/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/48x48/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/48x48/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/16x16/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/16x16/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/16x16/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/16x16/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/16x16/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/24x24/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/24x24/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/24x24/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/24x24/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/24x24/apps/simplescreenrecorder-idle.png \
/usr/share/icons/hicolor/32x32/apps/simplescreenrecorder.png \
/usr/share/icons/hicolor/32x32/apps/simplescreenrecorder-recording.png \
/usr/share/icons/hicolor/32x32/apps/simplescreenrecorder-error.png \
/usr/share/icons/hicolor/32x32/apps/simplescreenrecorder-paused.png \
/usr/share/icons/hicolor/32x32/apps/simplescreenrecorder-idle.png \
"
