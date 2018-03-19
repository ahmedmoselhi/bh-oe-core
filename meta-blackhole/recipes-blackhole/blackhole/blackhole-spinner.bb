SUMMARY = "blackHole-spinner"
MAINTAINER = "BlackHole Team"
SECTION = "base"
LICENSE = "proprietary"
inherit allarch

require conf/license/license-gplv2.inc

PV = "1.0"
PR = "r11"

SRC_URI="file://wait1.png \
        file://wait2.png \
        file://wait3.png \
        file://wait4.png \
        file://wait5.png \
        file://wait6.png \
        file://wait7.png \
        file://wait8.png \
        "
        
S = "${WORKDIR}/"

do_install() {

    mkdir -p ${D}/usr/share/enigma2/skin_default/spinner

    install -d ${D}/usr/share/enigma2/skin_default/spinner
    install -m 0644 ${WORKDIR}/*.png ${D}/usr/share/enigma2/skin_default/spinner
}

FILES_${PN} = "/"
