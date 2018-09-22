FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://libreoffice-5.0.6.3-icu-61-compatibility.patch\
    "

inherit pythonnative

do_configure_prepend(){
    if [ "${TARGET_ARCH}" = "powerpc64" ]; then
                PYTHON_CFLAGS="-I${STAGING_INCDIR}/${PYTHON_DIR} -I${STAGING_INCDIR}  -D__powerpc64__"
    else
        PYTHON_CFLAGS="-I${STAGING_INCDIR}/${PYTHON_DIR} -I${STAGING_INCDIR}"
    fi

}

INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN} += "ldflags"
