PYQT_MODULES += "QtWebKitWidgets"

do_install_append_class-target(){
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/QtWidgets.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/pyrcc.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/Qt.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/QtNetwork.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/QtWebKit.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/QtWebKitWidgets.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/pylupdate.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/QtSvg.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/QtGui.so 
    chrpath -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt5/QtCore.so 
}
