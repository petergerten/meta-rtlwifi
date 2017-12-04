SUMMARY = "RTL8812AU kernel driver (wifi)"
DESCRIPTION = "RTL8812AU kernel driver, derived from Realtek's 5.2.9 version of the driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=4b85004ff83dd932ff28f7f348fb2a28"

SRC_URI = "git://github.com/zebulon2/rtl8812au-driver-5.2.9;protocol=https \
	   file://0001-date-time-macro-removal.patch \
	  "

SRCREV = "601ccd117168c37ff93daecab75ed9581d412371"

S = "${WORKDIR}/git"

PV = "5.2.9-git+${SRCREV}"

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
    install -m 0755 ${B}/8812au.ko ${D}/lib/modules/${KERNEL_VERSION}/8812au.ko
}

