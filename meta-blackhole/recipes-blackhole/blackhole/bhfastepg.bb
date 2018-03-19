DESCRIPTION = "Black Hole BhFast Epg Backup"
MAINTAINER = "Meo <lupomeo@gmail.com>"
require conf/license/openpli-gplv2.inc

RDEPENDS_${PN} += "enigma2"

SRC_URI = " \
	file://__init__.py file://plugin.py \
"
PV = "3.0"
PR = "r9"

S = "${WORKDIR}/"

FILES_${PN} = "/"



do_install() {
	mkdir -p ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhFastEpg

	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhFastEpg
	install -m 0644 ${WORKDIR}/__init__.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhFastEpg/__init__.py
	install -m 0644 ${WORKDIR}/plugin.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/BhFastEpg/plugin.py

	
}
