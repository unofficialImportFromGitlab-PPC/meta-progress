FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

#Big endinan fix
SRC_URI += "file://bigendian-fix-for-assimp.patch" 
