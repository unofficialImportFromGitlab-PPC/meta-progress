
EXTRA_OECONF_class-native_remove = "${@bb.utils.contains("BUILD_ARCH", "powerpc", "--enable-targets=all --enable-install-libbfd --disable-nls --enable-64-bit-bfd  --disable-werror", "", d)}"
CFLAGS_class-native+="${@bb.utils.contains("BUILD_ARCH", "powerpc","-fpic -m32", "", d)}"
CXXFLAGS_class-native+="${@bb.utils.contains("BUILD_ARCH", "powerpc","-fpic -m32", "", d)}"
LDFLAGS_class-native+="${@bb.utils.contains("BUILD_ARCH", "powerpc","-m32", "", d)}"
