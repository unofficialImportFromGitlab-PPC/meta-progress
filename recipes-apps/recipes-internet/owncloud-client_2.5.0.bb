SUMMARY = "The ownCloud Desktop Client is a tool to synchronize files from ownCloud Server with your computer."
HOMEPAGE = "https://owncloud.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


SRC_URI = "https://github.com/owncloud/client/archive/v${PV}.tar.gz "
SRC_URI[md5sum] = "df7e6a8b87fbcd4faa088abdc6a9d35f"
SRC_URI[sha256sum] = "789179c6a77bea5a0f06727f197d6d5608af551688427e0bbe223d1a261b9047"

S="${WORKDIR}/client-${PV}"

inherit cmake_qt5 qt5-translation 

DEPENDS+= " qtkeychain qtwebkit"

FILES_${PN} += " \
    ${datadir}/icons/hicolor/*/apps/*png \
    ${datadir}/mime/packages/owncloud.xml \
    ${datadir}/nemo-python/extensions/syncstate-ownCloud.py \
    ${datadir}/owncloud/i18n/*.qm \
    ${datadir}/caja-python/extensions/syncstate-ownCloud.py \
    ${datadir}/nautilus-python/extensions/syncstate-ownCloud.py \
    "
