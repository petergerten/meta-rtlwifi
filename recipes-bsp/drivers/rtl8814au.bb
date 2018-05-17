SUMMARY = "RTL8822BU kernel driver (wifi)"
DESCRIPTION = "RTL8822BU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=e71d544fd90fb1393f4f62c4faea6384"

DEPENDS = "virtual/kernel"

SRC_URI = "git://github.com/tpircher/rtl8814AU.git;protocol=https"
SRCREV = "a0c44795f06d846b656ebac3310ba8f80f41333d"

S = "${WORKDIR}/git"

PV = "1.0-git"

DEPENDS = "virtual/kernel"

inherit module

EXTRA_OEMAKE  = "ARCH=${ARCH} KSRC=${}"

do_compile () {
    unset LDFLAGS
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/8822bu.ko ${D}/lib/modules/${KERNEL_VERSION}/8822bu.ko
}

