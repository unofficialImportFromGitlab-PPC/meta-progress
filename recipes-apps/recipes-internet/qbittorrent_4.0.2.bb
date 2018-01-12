FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 

SUMMARY = "The qBittorrent project aims to provide an open-source software alternative to µTorrent."
HOMEPAGE = "http://www.qbittorrent.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=2870806e3fb82aeb8ebbcdfc75f509ac"

inherit cmake_qt5 

DEPENDS += " qtbase libtorrent-rasterbar zlib"

SRC_URI = " \
    https://github.com/qbittorrent/qBittorrent/archive/release-${PV}.tar.gz \
    file://determine_gcc_system_include_dirs.patch \
"

SRC_URI[md5sum] = "a591721929769a1e03138bdba7946336"
SRC_URI[sha256sum] = "7627b2b83b674d3e95878bfcfb1b4305f04b7938308519c2240a591e7e43c13c" 

S = "${WORKDIR}/qBittorrent-release-${PV}"

EXTRA_OECMAKE += "-DWANT_ENV_FLAGS=ON \
                -DPOST26_GLIBC_DETECTED=0 \
                -DPOST26_GLIBC_DETECTED__TRYRUN_OUTPUT=224 \
                "
                
FILES_${PN} += " \
  /usr/share/appdata/qbittorrent.appdata.xml \
  /usr/share/icons/hicolor/64x64/apps/qbittorrent.png \
  /usr/share/icons/hicolor/64x64/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/scalable/status/qbittorrent-tray-dark.svg \
  /usr/share/icons/hicolor/scalable/status/qbittorrent-tray-light.svg \
  /usr/share/icons/hicolor/scalable/status/qbittorrent-tray.svg \
  /usr/share/icons/hicolor/22x22/apps/qbittorrent.png \
  /usr/share/icons/hicolor/22x22/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/192x192/apps/qbittorrent.png \
  /usr/share/icons/hicolor/192x192/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/72x72/apps/qbittorrent.png \
  /usr/share/icons/hicolor/72x72/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/96x96/apps/qbittorrent.png \
  /usr/share/icons/hicolor/96x96/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/36x36/apps/qbittorrent.png \
  /usr/share/icons/hicolor/36x36/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/128x128/apps/qbittorrent.png \
  /usr/share/icons/hicolor/128x128/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/48x48/apps/qbittorrent.png \
  /usr/share/icons/hicolor/48x48/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/16x16/apps/qbittorrent.png \
  /usr/share/icons/hicolor/16x16/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/24x24/apps/qbittorrent.png \
  /usr/share/icons/hicolor/24x24/status/qbittorrent-tray.png \
  /usr/share/icons/hicolor/32x32/apps/qbittorrent.png \
  /usr/share/icons/hicolor/32x32/status/qbittorrent-tray.png \
  "
