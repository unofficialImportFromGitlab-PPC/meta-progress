
PACKAGECONFIG_FONTS = "fontconfig" 

PACKAGECONFIG_append= "sql-sqlite"

#https://github.com/meta-qt5/meta-qt5/commit/3cf0bbb8e1113376d5b5b26ecff362e180a180fd
#qtbase_git: install qt.conf for the target
#The build-in qmake settings point to the sysroots on the host machine.
#Running qmake on the target hence errors with:
#  Could not find qmake configuration file linux-oe-g++.
#  Error processing project file
#So add qt.conf to the target image with the correct locations.
generate_target_qt_config_file() {
    qtconf="$1"
    cat > "${qtconf}" <<EOF
[Paths]
Prefix = ${OE_QMAKE_PATH_PREFIX}
Headers = ${OE_QMAKE_PATH_HEADERS}
Libraries = ${OE_QMAKE_PATH_LIBS}
ArchData = ${OE_QMAKE_PATH_ARCHDATA}
Data = ${OE_QMAKE_PATH_DATA}
Binaries = ${OE_QMAKE_PATH_BINS}
LibraryExecutables = ${OE_QMAKE_PATH_LIBEXECS}
Plugins = ${OE_QMAKE_PATH_PLUGINS}
Imports = ${OE_QMAKE_PATH_IMPORTS}
Qml2Imports = ${OE_QMAKE_PATH_QML}
Translations = ${OE_QMAKE_PATH_TRANSLATIONS}
Documentation = ${OE_QMAKE_PATH_DOCS}
Settings = ${OE_QMAKE_PATH_SETTINGS}
Examples = ${OE_QMAKE_PATH_EXAMPLES}
Tests = ${OE_QMAKE_PATH_TESTS}
HostBinaries = ${OE_QMAKE_PATH_BINS}
HostData = ${OE_QMAKE_PATH_ARCHDATA}
HostLibraries = ${OE_QMAKE_PATH_LIBS}
HostSpec = ${OE_QMAKE_PLATFORM}
TargetSpec = ${OE_QMAKE_PLATFORM}
ExternalHostBinaries = ${OE_QMAKE_PATH_BINS}
Sysroot =
EOF
}

do_install_append() {
    generate_target_qt_config_file ${D}${OE_QMAKE_PATH_BINS}/qt.conf
}
