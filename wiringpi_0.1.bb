SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "A library to control Raspberry Pi GPIO channels wiringPi"
SECTION = "examples"
LICENSE = "CLOSED"
SRC_URI += "file://./*"

# SRC_URI = "git://github.com/Willem65/wiringpi-yocto.git;branch=master;protocol=https"
# SRCREV  = "1c20520eb500319fff2a650488eb2a13c87e46df"


S = "${WORKDIR}/"

INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

CFLAGS_prepend = "-I${S}/wiringPi -I${S}/devLib"

EXTRA_OEMAKE += "'INCLUDE_DIR=${D}${includedir}' 'LIB_DIR=${D}${libdir}'"
EXTRA_OEMAKE += "'DESTDIR=${D}/usr' 'PREFIX=""'"

do_compile() {
    oe_runmake -C devLib
    oe_runmake -C wiringPi
    oe_runmake -C gpio 'LDFLAGS=${LDFLAGS} -L${S}/wiringPi -L${S}/devLib'
}

do_install() {
	install -d ${D}${libdir}
	install -m 0755 wiringPi/libwiringPi.so ${D}${libdir}
	install -m 0755 devLib/libwiringPiDev.so ${D}${libdir}
	install -d ${D}${bindir}
	install -m 0755 gpio/gpio ${D}${bindir}
}
