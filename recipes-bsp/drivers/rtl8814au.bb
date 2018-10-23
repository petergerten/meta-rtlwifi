SUMMARY = "RTL8814AU kernel driver (wifi)"
DESCRIPTION = "RTL8814AU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=12b95123fbe5dd02b8418463efdc6232"

SRC_URI = "git://github.com/tpircher/rtl8814AU.git;protocol=https"
SRCREV = "a0c44795f06d846b656ebac3310ba8f80f41333d"

MODVER = "4.3.21"

MODULE_NAME = "8814au.ko"

require realtek.inc

