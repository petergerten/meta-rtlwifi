SUMMARY = "RTL8822BU kernel driver (wifi)"
DESCRIPTION = "RTL8822BU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=e71d544fd90fb1393f4f62c4faea6384"

SRC_URI = "git://github.com/madscientist42/rtl8822bu.git;protocol=https"
SRCREV = "f0f86d18774c60f8ba02d54753c158c42431f622"

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
    install -m 0755 ${B}/8822bu.ko ${D}/lib/modules/${KERNEL_VERSION}/8822bu.ko
}

