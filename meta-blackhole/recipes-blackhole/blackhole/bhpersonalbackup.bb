DESCRIPTION = "Black Hole Bh Personal Backup"
MAINTAINER = "Meo <lupomeo@gmail.com>"
require conf/license/openpli-gplv2.inc

RDEPENDS_${PN} += "enigma2"

SRC_URI ="file://__init__.py \ 
         file://plugin.py \
         file://backup_1.png \
         file://backup_2.png \
         file://backup_3.png \
         file://backup_4.png \
         file://backup_5.png \
         file://backup_6.png \
         "

PV = "3.0"
PR = "r9"

S = "${WORKDIR}/"

FILES_${PN} = "/"



do_install() {
	mkdir -p ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhPersonalBackup
        mkdir -p ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhPersonalBackup/icons

	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhPersonalBackup
	install -m 0644 ${WORKDIR}/__init__.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhPersonalBackup/__init__.py
	install -m 0644 ${WORKDIR}/plugin.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhPersonalBackup/plugin.py
        install -m 0644 ${WORKDIR}/*.png ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhPersonalBackup/icons

	
}
