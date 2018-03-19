SUMMARY = "VLAN provides vconfig utility"
SECTION = "misc"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://vconfig.c;beginline=1;endline=19;md5=094ca47de36c20c598b15b32c270ce0a"

SRC_URI = "http://${BPN}.sourcearchive.com/downloads/${PV}-3ubuntu9/${BPN}_${PV}.orig.tar.gz \
           file://no-HOME-includes.patch \
           file://0001-Add-printf-format-and-silence-format-security-warnin.patch \
"

SRC_URI[md5sum] = "5f0c6060b33956fb16e11a15467dd394"
SRC_URI[sha256sum] = "3b8f0a1bf0d3642764e5f646e1f3bbc8b1eeec474a77392d9aeb4868842b4cca"

S = "${WORKDIR}/${BPN}"

EXTRA_OEMAKE = "-e MAKEFLAGS="

# comment out MakeInclude in Makefile which sets build environment
do_configure_append () {
    sed -i 's/^ include/#^include/' ${S}/Makefile
}

# ignore strip to avoid yocto errors in stripping
do_compile () {
    oe_runmake PLATFORM=ARM 'STRIP=echo' all
}

do_install () {
    install -d ${D}/${base_sbindir}
    install -m 0755 ${S}/vconfig ${D}/${base_sbindir}/
}
