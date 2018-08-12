
do_install_append() { 
    sed -i 's/frost\/lxqt-origami-light.png/mars\/551041main_pia14156-full_full.jpg/'  ${D}${sysconfdir}/xdg/pcmanfm-qt/lxqt/settings.conf    
}
