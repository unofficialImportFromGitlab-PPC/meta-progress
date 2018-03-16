FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 

SUMMARY = "Framework for defining and tracking users, login sessions, and seats"
HOMEPAGE = "https://github.com/ConsoleKit2/ConsoleKit2"
BUGTRACKER = "https://github.com/ConsoleKit2/ConsoleKit2/issues"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

DEPENDS = "glib-2.0 glib-2.0-native dbus dbus-glib virtual/libx11 virtual/gettext eudev gettext-native"
RDEPENDS_${PN} += "base-files"

inherit autotools pkgconfig distro_features_check gobject-introspection
# depends on virtual/libx11
REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "https://github.com/ConsoleKit2/ConsoleKit2/releases/download/1.2.1/ConsoleKit2-${PV}.tar.bz2 \
                        file://0001-Remove-AC_CHECK_FILE-for-cross-compilation.patch \
"
SRC_URI[md5sum] = "17d31475f9b08969e55ea60750f4f219"
SRC_URI[sha256sum] = "9af223096ece88b217bcd3fe85093390a8d1527b6492124b0e90ea7688ec934b"

S = "${WORKDIR}/ConsoleKit2-${PV}"

PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'pam', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)}"

PACKAGECONFIG[pam] = "--enable-pam-module --with-pam-module-dir=${base_libdir}/security,--disable-pam-module,libpam"
PACKAGECONFIG[policykit] = "--with-polkit,--without-polkit,polkit"
PACKAGECONFIG[systemd] = "--with-systemdsystemunitdir=${systemd_unitdir}/system/,--with-systemdsystemunitdir="

FILES_${PN} += "${exec_prefix}/lib/ConsoleKit \
                ${libdir}/ConsoleKit  ${systemd_unitdir} ${base_libdir} \
                ${datadir}/dbus-1 ${datadir}/PolicyKit ${datadir}/polkit*"

PACKAGES =+ "pam-plugin-ck-connector"
FILES_pam-plugin-ck-connector += "${base_libdir}/security/*.so"
RDEPENDS_pam-plugin-ck-connector += "${PN}"

REPLACES_${PN} = "consolekit"
RREPLACES_${PN} = "consolekit"
RPROVIDES_${PN} = "consolekit"
RCONFLICTS_${PN} = "consolekit"

do_install_append() {
	if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
		install -d ${D}${sysconfdir}/tmpfiles.d
		echo "d ${localstatedir}/log/ConsoleKit - - - -" \
			> ${D}${sysconfdir}/tmpfiles.d/consolekit.conf
	fi

	# Remove /var/ directories as the daemon creates them as required
	rm -rf ${D}${localstatedir}
}
