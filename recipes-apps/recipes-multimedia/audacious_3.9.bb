SUMMARY = "Audacious is an open source audio player. A descendant of XMMS, Audacious plays your music how you want it, without stealing away your computer’s resources from other tasks."
HOMEPAGE = "https://audacious-media-player.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=3e1b6de75db8b4a3c68f791b50500cf5"

inherit autotools-brokensep  pkgconfig gettext

DEPENDS += " \
glib-2.0 \
qtbase \
qtx11extras \
phonon \
"

SRC_URI = "https://github.com/audacious-media-player/audacious/archive/audacious-${PV}.tar.gz"

SRC_URI[md5sum] = "3cafb795997cedb304381c5f4808aded"
SRC_URI[sha256sum] = "22226ca3f161711790cd550757742aebe386f9c2567d7912ac9fd35fae488664" 

S = "${WORKDIR}/${PN}-${PN}-${PV}"

EXTRA_OECONF += "\
    --enable-qt \
    --disable-gtk \
"

FILES_${PN} += " \
  /usr/share/icons/hicolor/scalable/apps/audacious.svg \
  /usr/share/icons/hicolor/48x48/apps/audacious.png \
" 

 
