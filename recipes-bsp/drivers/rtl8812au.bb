SUMMARY = "RTL8812AU kernel driver (wifi)"
DESCRIPTION = "RTL8812AU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=e6402a1e8edc484c8a4cd7d18753fb5f"

SRC_URI = "git://github.com/gnab/rtl8812au.git;protocol=https"
SRCREV = "3e450d16d9c3e730c67b2a541520e85f664fd101"

S = "${WORKDIR}/git"

PV = "1.0-git"

DEPENDS = "virtual/kernel"

inherit module

EXTRA_OEMAKE  = "ARCH=${ARCH}"
EXTRA_OEMAKE += "KSRC=${STAGING_KERNEL_BUILDDIR}"

do_compile () {
    unset LDFLAGS
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/rtl8812au.ko ${D}/lib/modules/${KERNEL_VERSION}/rtl8812au.ko
}

