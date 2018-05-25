SUMMARY = "RTL8723 kernel driver (wifi + bluetooth)"
DESCRIPTION = "RTL8723 kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=ce4c7adf40ddcf6cfca7ee2b333165f0"

SRC_URI = " \
    git://github.com/lwfinger/rtl8723bu.git;protocol=https \
    file://0001-ARM-Support.patch \
    file://0002-realtek-Disable-IPS-mode.patch \
    file://0003-Add-compatibility-for-kernels-v4.11.9.patch \
    "
SRCREV = "692edf2a9284a14671c0d03927d75856967d5c84"

S = "${WORKDIR}/git"

MODVER = "1.0"

MODULE_NAME = "8723bu.ko"

require realtek.inc





