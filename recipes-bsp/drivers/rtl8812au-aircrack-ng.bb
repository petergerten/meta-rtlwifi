SUMMARY = "RTL8812AU kernel driver (AirCrack-NG version)"
DESCRIPTION = "RTL8812AU kernel driver, derived from Realtek's 5.1.5 version of the driver, with monitor mode and packet injection"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=34aaf4b07dc17a22fa2b1912ef8ce76a"
EXTRA_OEMAKE += "CFLAGS='-Werror=incompatible-pointer-types'"

SRC_URI = " \
	git://github.com/aircrack-ng/rtl8812au;protocol=https;branch=v5.3.4 \
	file://00001-makefile.patch \
	"

SRCREV = "19132e290f8766c8a31296454f2abc70dfbe5215"

S = "${WORKDIR}/git"

MODVER = "5.1.5"

MODULE_NAME = "8812au.ko"

require realtek.inc
