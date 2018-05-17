SUMMARY = "RTL8812AU kernel driver (AirCrack-NG version)"
DESCRIPTION = "RTL8812AU kernel driver, derived from Realtek's 5.1.5 version of the driver, with monitor mode and packet injection"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=34aaf4b07dc17a22fa2b1912ef8ce76a"

SRC_URI = "git://github.com/aircrack-ng/rtl8812au;protocol=https;branch=v5.1.5 \
	  "

SRCREV = "5a5da0ffe33d41fbce9dfd2adda47bda05ee9fdf"

S = "${WORKDIR}/git"

PV = "5.1.5-aircrack-ng-git+${SRCREV}"

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
    install -m 0755 ${B}/8812au.ko ${D}/lib/modules/${KERNEL_VERSION}/8812au.ko
}

