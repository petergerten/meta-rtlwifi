SUMMARY = "RTL8822BU kernel driver (wifi)"
DESCRIPTION = "RTL8822BU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=e71d544fd90fb1393f4f62c4faea6384"

SRC_URI = "git://github.com/madscientist42/rtl8822bu.git;protocol=https"
SRCREV = "0a23e6067f36da250686ecd775a2e97d9854d31c"

S = "${WORKDIR}/git"

PV = "1.0-git"

# Force the kernel source workdir to BE there...
DEPENDS = "kernel-devsrc"
do_install[depends] += "virtual/kernel:do_shared_workdir"

inherit module

EXTRA_OEMAKE += " ARCH=${ARCH} KSRC=${STAGING_KERNEL_BUILDDIR}"

do_compile () {
    unset LDFLAGS
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/8822bu.ko ${D}/lib/modules/${KERNEL_VERSION}/8822bu.ko
}

