#Fixes the following error:
# Problem: conflicting requests                                                                                                                                                                  
#  - nothing provides qtwebkit-qmlplugins needed by packagegroup-qt5-toolchain-target-1.0-r0.noarch
# Solution found here:
# https://github.com/meta-qt5/meta-qt5/commit/5bbfbca70586922b9b3f62878f46bc7260f42135#diff-0c0a10bc8fcb3190dfd257b37aaa9848

# Requires Ruby to work
USE_RUBY = " \
    qtquick1-dev \
    qtquick1-mkspecs \
    qtquick1-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtquick1-qmlplugins', '', d)} \
    qttranslations-qtquick1 \
    qtwebkit-dev \
"
