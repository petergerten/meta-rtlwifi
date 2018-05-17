SUMMARY = "RTL8822BU kernel driver (wifi)"
DESCRIPTION = "RTL8822BU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=12b95123fbe5dd02b8418463efdc6232"

SRC_URI = "git://github.com/tpircher/rtl8814AU.git;protocol=https"
SRCREV = "a0c44795f06d846b656ebac3310ba8f80f41333d"

PV = "1.0-git"

MODULE_NAME = "8814au.ko"

require realtek.inc

