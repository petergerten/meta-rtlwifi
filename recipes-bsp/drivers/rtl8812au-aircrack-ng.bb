SUMMARY = "RTL8812AU kernel driver (AirCrack-NG version)"
DESCRIPTION = "RTL8812AU kernel driver, derived from Realtek's 5.1.5 version of the driver, with monitor mode and packet injection"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=34aaf4b07dc17a22fa2b1912ef8ce76a"

SRC_URI = "git://github.com/aircrack-ng/rtl8812au;protocol=https;branch=v5.1.5 \
	  "

SRCREV = "5a5da0ffe33d41fbce9dfd2adda47bda05ee9fdf"

S = "${WORKDIR}/git"

PV = "5.1.5-aircrack-ng-git+${SRCREV}"

MODULE_NAME = "8812au.ko"

require realtek.inc
