SUMMARY = "RTL8822BU kernel driver (wifi)"
DESCRIPTION = "RTL8822BU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=12b95123fbe5dd02b8418463efdc6232"

DEPENDS = "virtual/kernel"

SRC_URI = "git://github.com/tpircher/rtl8814AU.git;protocol=https"
SRCREV = "a0c44795f06d846b656ebac3310ba8f80f41333d"

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

