# Handle all the common tasks in the Realtek driver recipes here...

S = "${WORKDIR}/git"


# Force the kernel source workdir to BE there...
DEPENDS = "virtual/kernel kernel-devsrc"
do_install[depends] += "virtual/kernel:do_shared_workdir"

inherit module

EXTRA_OEMAKE += " ARCH=${ARCH} KSRC=${STAGING_KERNEL_BUILDDIR}"

do_compile () {
    unset LDFLAGS
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/${MODULE_NAME} ${D}/lib/modules/${KERNEL_VERSION}/${MODULE_NAME}
}

