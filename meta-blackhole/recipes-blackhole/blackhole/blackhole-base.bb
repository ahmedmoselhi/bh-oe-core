DESCRIPTION = "BlackHole extra files"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Black Hole team"

require conf/license/openpli-gplv2.inc

SRC_URI = "file://Ncam_Ci.sh file://StartBhCam file://Delete_all_Crashlogs.sh file://Ifconfig.sh file://Bhepgproviders.cfg \
	file://client.confOff file://clientp2p.confOff file://server.confOff file://skyitepglock file://image-version \
	file://serverp2p.conf file://openvpn.log file://ca.crt file://client1.crt file://client1.key \
	file://client2.crt file://client2.key file://client3.crt file://client3.key file://dh1024.pem \
	file://delite.key file://server.crt file://server.key file://bhversion file://bhrev \
	file://Netstat.sh file://Uptime.sh file://bhextramod file://Blackholecmd"

PR = "r7"

FILES_${PN} = "/"

do_compile() {
	echo "${MACHINE}" > ${WORKDIR}/bhmachine
}


do_install() {

	mkdir -p ${D}/usr/camscript
	mkdir -p ${D}/usr/script
	mkdir -p ${D}/usr/uninstall
        mkdir -p ${D}/usr/scam
        mkdir -p ${D}/etc/bhcron
        mkdir -p ${D}/media/downloads
        mkdir -p ${D}/media/hdd
        mkdir -p ${D}/media/usb
        mkdir -p ${D}/media/music
        mkdir -p ${D}/media/net
        mkdir -p ${D}/media/video
        mkdir -p ${D}/media/photo
        mkdir -p ${D}/media/personal



	install -d ${D}/etc
	install -m 0644 ${WORKDIR}/bhmachine ${D}/etc/bhmachine
	install -m 0644 ${WORKDIR}/bhversion ${D}/etc/bhversion
        install -m 0644 ${WORKDIR}/Bhepgproviders.cfg ${D}/etc/Bhepgproviders.cfg
        install -m 0644 ${WORKDIR}/skyitepglock ${D}/etc/skyitepglock
        install -m 0644 ${WORKDIR}/image-version ${D}/etc/image-version
        install -m 0644 ${WORKDIR}/bhrev ${D}/etc/bhrev
	

	install -d ${D}/usr/bin
	for x in /StartBhCam Blackholecmd bhextramod; do
		install -m 0755 ${WORKDIR}/$x ${D}/usr/bin/$x
	done
	

	install -d ${D}/usr/camscript
	install -m 0755 ${WORKDIR}/Ncam_Ci.sh ${D}/usr/camscript/Ncam_Ci.sh
	
	install -d ${D}/usr/script
	for x in /Delete_all_Crashlogs.sh Ifconfig.sh Netstat.sh Uptime.sh; do
		install -m 0755 ${WORKDIR}/$x ${D}/usr/script/$x
	done
	
	install -d ${D}/etc/openvpn
	for x in /client.confOff clientp2p.confOff openvpn.log server.confOff serverp2p.conf; do
		install -m 0644 ${WORKDIR}/$x ${D}/etc/openvpn/$x
	done

	install -d ${D}/etc/openvpn/keys
	for x in /ca.crt client1.crt client1.key client2.crt client2.key client3.crt \
	client3.key dh1024.pem delite.key server.crt server.key; do
		install -m 0644 ${WORKDIR}/$x ${D}/etc/openvpn/keys/$x
	done
	
	install -d ${D}/etc/rc3.d
	ln -sf /etc/init.d/openvpn ${D}/etc/rc3.d/S40openvpn

	install -d ${D}/etc/rc4.d
	ln -s /etc/init.d/openvpn ${D}/etc/rc4.d/K40openvpn

}
