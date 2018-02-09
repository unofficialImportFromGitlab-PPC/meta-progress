SUMMARY = "Audacious is an open source audio player. A descendant of XMMS, Audacious plays your music how you want it, without stealing away your computer’s resources from other tasks."
HOMEPAGE = "https://audacious-media-player.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=e4232be386c99ea029d1af8123ace1f2"

inherit autotools-brokensep  pkgconfig gettext

DEPENDS += " \
mpg123 \
wavpack \
neon \
ffmpeg \
phonon \
"

RDEPENDS_${PN} += " libnotify audacious gtk+ libsamplerate0"

SRC_URI = "https://github.com/audacious-media-player/audacious-plugins/archive/audacious-plugins-${PV}.tar.gz"

SRC_URI[md5sum] = "f8515c2d1e114dfb748267980e91e59a"
SRC_URI[sha256sum] = "1d6ec9da502d79735afa5d5377c74c69863348fc8173edc5b4d6c2158b94418c" 

S = "${WORKDIR}/${PN}-${PN}-${PV}"


EXTRA_OECONF += "\
    --enable-qt \
    --disable-gtk \
"

FILES_${PN} += " \
  /usr/lib/audacious/Input/ \
  /usr/lib/audacious/Container/ \
  /usr/lib/audacious/Effect/ \
  /usr/lib/audacious/Transport/ \
  /usr/lib/audacious/Output/ \
  /usr/lib/audacious/Visualization/ \
  /usr/lib/audacious/General/ \
  /usr/share/audacious \
  /usr/share/audacious/Skins \
  /usr/share/audacious/Skins/Classic1.3 \
  /usr/share/audacious/Skins/Default \
  /usr/share/audacious/Skins/Osmosis \
  /usr/share/audacious/Skins/Refugee \
  /usr/share/audacious/Skins/Ivory \
  /usr/share/audacious/Skins/TinyPlayer \
  /usr/share/audacious/Skins/Classic \
"

