SUMMARY = "RTL8723 kernel driver (wifi + bluetooth)"
DESCRIPTION = "RTL8723 kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=ce4c7adf40ddcf6cfca7ee2b333165f0"

PV = "1.0-git"
SRCREV = "8534c0f3e042c03d6dd270994c6742bea3262913"
SRC_URI = "git://github.com/lwfinger/rtl8723bu.git;protocol=https \
           file://0002-realtek-Disable-IPS-mode.patch "

S = "${WORKDIR}/git"

MODVER = "1.0"

MODULE_NAME = "8723bu.ko"

require realtek.inc





FILES_${PN} += "${sysconfdir}"
