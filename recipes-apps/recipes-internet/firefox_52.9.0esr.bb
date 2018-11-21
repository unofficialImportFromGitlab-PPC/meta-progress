DESCRIPTION ?= "Browser made by mozilla"
DEPENDS += "alsa-lib curl startup-notification libevent libnotify libvpx \
            virtual/libgl nss nspr nspr-native pulseaudio yasm-native icu icu-native unzip-native"

RDEPENDS_${PN}  += "icu"

LICENSE = "MPLv1 | GPLv2+ | LGPLv2.1+"
LIC_FILES_CHKSUM = "file://toolkit/content/license.html;endline=39;md5=f7e14664a6dca6a06efe93d70f711c0e"

PR="r3"

# Patch version
MOZ_HTTP_URI="https://archive.mozilla.org/pub/${PN}/releases"

SRC_URI = "${MOZ_HTTP_URI}/${PV}/source/firefox-${PV}.source.tar.xz \
	file://firefox.desktop\
	file://firefox.png\
 	file://google-api-key\
	file://firefox-symbolic.svg\
	file://mozilla-api-key\
	file://progress-linux-default-prefs.js\
	file://firefox-x11.desktop\
	file://firefox.1 \
	file://firefox.sh.in\
	file://firefox-x11.sh.in\
	file://icucross.mk \
	file://icucross.inc \
    file://2000_Use-C99-math-isfinite.patch \
    file://2001_system_harfbuzz.patch \
    file://2002_system_graphite2.patch \
    file://2003_fix_sandbox_prlimit64.patch \
    file://2004_nICEr-implicit-decls.patch \
    file://2006_fix_lto_builds.patch \
    file://6000_only_attempt_to_use_getcontext_on_glibc.patch \
    file://6001_add_missing_header_for_basename.patch \
    file://6002_add_alternate_name_for_private_siginfo_struct_member.patch \
    file://6003_fix_syscall_wrappers_on_musl.patch \
    file://6004_drop_hunspell_alloc_hooks_musl.patch \
    file://6005_fix_seccomp-bpf-1.patch \
    file://7000-too_long_shebang_path.patch \
    file://7001-firefox_52_segfaults_when_you_right-click_on_ppc64.patch\
    file://7002-graphics_crashes_on_big_endian_machines.patch \
    file://7003-build-icu-big-endian.patch \
    file://7004-generate_icu_data_file_for_cross_build.patch \
    file://7005-avoid_use_strtod_l.patch \
"


SRC_URI[md5sum] = "b8c2f3619c684818be9a513f8aa1dbfd"
SRC_URI[sha256sum] = "c01d09658c53c1b3a496e353a24dad03b26b81d3b1d099abc26a06f81c199dd6"

S = "${WORKDIR}/firefox-52.9.0esr"
# MOZ_APP_BASE_VERSION should be incremented after a release
MOZ_APP_BASE_VERSION = "52.9"

SECTION = "x11/utils"
DEPENDS += "gnu-config-native virtual/libintl libxt libxi zip-native gtk+ icu-native git-native autoconf213 autoconf213-native"


SRC_URI += "file://mozconfig"

inherit gettext pkgconfig 


export SHELL="/bin/sh"
export MOZCONFIG = "${WORKDIR}/mozconfig"
export MOZ_OBJDIR = "${S}/firefox-build-dir"
export ICU_NATIVEDIR= "${STAGING_DATADIR_NATIVE}/icu/61.1"

#EXTRA_OEMAKE += "SHELL=/bin/bash"
EXTRA_OECONF = "--target=${TARGET_SYS} --host=${BUILD_SYS} \
                --prefix=${prefix} --disable-elf-hack"
#SELECTED_OPTIMIZATION = "-Os -fsigned-char -fno-strict-aliasing"
MOZ_OPTIMIZE_FLAGS=""

#export CROSS_COMPILE = "1"

#export OBJDIR = "${S}/firefox-build-dir"
#export MOZ_OBJDIR = "${S}/firefox-build-dir"
#export FOUND_MOZCONFIG = "${WORKDIR}/mozconfig"

export TARGET_SYS
export BUILD_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

export CONFIGURE_ARGS = "${EXTRA_OECONF}"
export HOST_CC = "${BUILD_CC}"
export HOST_CXX = "${BUILD_CXX}"
export HOST_CFLAGS = "${BUILD_CFLAGS}"
export HOST_CXXFLAGS = "${BUILD_CXXFLAGS}"
export HOST_LDFLAGS = "${BUILD_LDFLAGS}"
export HOST_RANLIB = "${BUILD_RANLIB}"
export HOST_AR = "${BUILD_AR}"


#EXTRA_OECONF_append = " --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR}"
EXTRA_OECONF_append_libc-musl = " --disable-jemalloc"

EXTRA_OEMAKE += "installdir=${libdir}/${PN}"

LD="${TARGET_PREFIX}ld"
AR="${TARGET_PREFIX}ar"
RANLIB="${TARGET_PREFIX}ranlib"

CXXFLAGS += "-fno-delete-null-pointer-checks -fno-lifetime-dse ${TARGET_CC_ARCH} --sysroot=${PKG_CONFIG_SYSROOT_DIR}"
CXXFLAGS_remove_toolchain-clang = "-fno-lifetime-dse"
CFLAGS += "-fno-delete-null-pointer-checks -fno-lifetime-dse ${TARGET_CC_ARCH} --sysroot=${PKG_CONFIG_SYSROOT_DIR}"
CFLAGS_remove_toolchain-clang = "-fno-lifetime-dse"


#TARGET_CC_ARCH += "${LDFLAGS}"

export CC="${TARGET_PREFIX}gcc ${CFLAGS}"
export CXX="${TARGET_PREFIX}g++ ${CXXFLAGS}"

EXTRA_OECONF_remove = "--disable-static --enable-nls"

do_configure(){
  export SHELL="/bin/sh"
  #echo "ac_add_options --target=${TARGET_SYS}"  >> ${MOZCONFIG}
  #echo "ac_add_options --host=${BUILD_SYS}"  >> ${MOZCONFIG}
  

  # Put PARALLEL_MAKE into mozconfig
  if [ ! -z "${PARALLEL_MAKE}" ] ; then
    FLAG=`echo ${PARALLEL_MAKE} | sed -e 's/ //g'`
    echo mk_add_options MOZ_MAKE_FLAGS=\"${FLAG}\" \ 
    >> ${MOZCONFIG}
  fi
  
 
  
  cp ${WORKDIR}/icucross.mk ${ICU_NATIVEDIR}/config
  cp ${WORKDIR}/icucross.inc ${ICU_NATIVEDIR}/config
  #./configure --host=${TARGET_SYS}  --with-cross-build=${S}
  
  ./mach python intl/icu_sources_data.py . 
  ls -l config/external/icu/data
  rm -f config/external/icu/data/icudt*l.dat
  
  # workaround for funky/broken upstream configure...
  # SHELL="$(SHELL)"
   oe_runmake -f client.mk -s configure  
}

do_compile() {
    #export CROSS_COMPILE=1
    export CC="${TARGET_PREFIX}gcc ${CFLAGS} "
    export CXX="${CXX} ${CXXFLAGS}"
    #export LDFLAGS="${TARGET_LDFLAGS}"
	SHELL=/bin/bash ./mach build
}


do_compile(){
    export SHELL=/bin/bash 
    oe_runmake -f client.mk realbuild
}


do_install(){
    export SHELL=/bin/bash 
    
    # Augment this with hwaccel prefs
	if use hwaccel ; then
		cat "${WORKDIR}"/gentoo-hwaccel-prefs.js-1 >> \
		"${BUILD_OBJ_DIR}/dist/bin/browser/defaults/preferences/all-gentoo.js" \
		|| die
	fi

    oe_runmake -f client.mk install INSTALL_SDK= DESTDIR="${D}"
    
    
    install -d ${D}${datadir}/applications
    install -d ${D}${datadir}/pixmaps
    install -d ${D}${libdir}/${PN}/defaults/pref

    install -m 0644 ${WORKDIR}/firefox.desktop ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/firefox.png ${D}${datadir}/pixmaps/
    install -m 0644 ${WORKDIR}/progress-linux-default-prefs.js ${D}${libdir}/${PN}/defaults/pref/

    # Fix ownership of files
    chown root:root -R ${D}${datadir}
    chown root:root -R ${D}${libdir}

}

#PACKAGES = "${PN}"

#TODO: Check this:  LDFLAGS=-Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed
INSANE_SKIP_${PN} = "ldflags" 

FILES_${PN} = "${bindir}/${PN} \
               ${datadir}/applications/ \
               ${datadir}/pixmaps/ \
               ${libdir}/${PN}/ \
               ${bindir}/defaults"
FILES_${PN}-dev += "${datadir}/idl ${bindir}/${PN}-config ${libdir}/${PN}-devel-*"
FILES_${PN}-staticdev += "${libdir}/${PN}-devel-*/sdk/lib/*.a"
FILES_${PN}-dbg += "${libdir}/${PN}/*/*/.debug/* ${libdir}/${PN}/*/.debug/* ${libdir}/${PN}-devel-*/sdk/lib/.debug/*"
# We don't build XUL as system shared lib, so we can mark all libs as private
PRIVATE_LIBS = "libmozjs.so \
                libxpcom.so \
                libnspr4.so \
                libxul.so \
                libmozalloc.so \
                libplc4.so \
                libplds4.so \
                liblgpllibs.so \
                libmozsqlite3.so \
                libbrowsercomps.so \
                libclearkey.so\
                libnssdbm3.so \
                libfreeblpriv3.so \
                libsmime3.so \
                libsoftokn3.so \
                libnss3.so \
                libssl3.so \
                libnssckbi.so \
                "
