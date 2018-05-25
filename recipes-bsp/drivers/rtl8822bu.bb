SUMMARY = "RTL8822BU kernel driver (wifi)"
DESCRIPTION = "RTL8822BU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=e71d544fd90fb1393f4f62c4faea6384"

SRC_URI = "git://github.com/madscientist42/rtl8822bu.git;protocol=https"
SRCREV = "0a23e6067f36da250686ecd775a2e97d9854d31c"

S = "${WORKDIR}/git"

MODVER = "5.2.4"

MODULE_NAME = "88x2bu.ko"

require realtek.inc

inherit module


