SUMMARY = "RTL8812AU kernel driver (wifi)"
DESCRIPTION = "RTL8812AU kernel driver, derived from Realtek's 5.2.9 version of the driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=4b85004ff83dd932ff28f7f348fb2a28"

SRC_URI = "git://github.com/zebulon2/rtl8812au-driver-5.2.9;protocol=https \
	   file://0001-date-time-macro-removal.patch \
	  "

SRCREV = "601ccd117168c37ff93daecab75ed9581d412371"

S = "${WORKDIR}/git"

MODVER = "5.2.9"

MODULE_NAME = "8812au.ko"

require realtek.inc
