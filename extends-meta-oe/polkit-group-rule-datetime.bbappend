# Fix up permissions on polkit rules.d to work with rpm4 constraints
do_install_append() {
	chmod 700 ${D}${sysconfdir}/polkit-1/rules.d
	chown polkitd:root ${D}${sysconfdir}/polkit-1/rules.d
}

