SUMMARY = "RTL8812AU kernel driver (AirCrack-NG version)"
DESCRIPTION = "RTL8812AU kernel driver, derived from Realtek's 5.1.5 version of the driver, with monitor mode and packet injection"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=f578868eaaf4f81f794a03a4f599980b"
EXTRA_OEMAKE += "CFLAGS='-Werror=incompatible-pointer-types'"

SRC_URI = " \
	git://github.com/aircrack-ng/rtl8812au;protocol=https;branch=v5.3.4 \
	"

SRCREV = "19132e290f8766c8a31296454f2abc70dfbe5215"

S = "${WORKDIR}/git"

MODVER = "5.3.4"

MODULE_NAME = "88XXau.ko"

require realtek.inc
