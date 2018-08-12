
do_install_append() { 

    sed -i 's/theme=frost/theme=mars/'  ${D}${sysconfdir}/xdg/lxqt/lxqt.conf
    
}
