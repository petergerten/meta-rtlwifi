SUMMARY = "RTL8812AU kernel driver (AirCrack-NG version)"
DESCRIPTION = "RTL8812AU kernel driver, derived from Realtek's 5.1.5 version of the driver, with monitor mode and packet injection"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=5a443c39c748f0a31bdead8f162da6f6"
EXTRA_OEMAKE += "CFLAGS='-Werror=incompatible-pointer-types'"

SRC_URI = " \
	git://github.com/aircrack-ng/rtl8812au;protocol=https;branch=v5.6.4.2 \
	"

SRCREV = "b65dcf4105641716d16f3a6c96507fdd9c1862b4"

S = "${WORKDIR}/git"

MODVER = "5.6.4.2"

MODULE_NAME = "88XXau.ko"

require realtek.inc
