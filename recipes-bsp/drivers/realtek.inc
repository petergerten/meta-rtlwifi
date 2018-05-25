# Handle all the common tasks in the Realtek driver recipes here...

S = "${WORKDIR}/git"

# Consistent package versioning rules...
PV = "${MODVER}-git+${SRCREV}"

inherit module

# Force the kernel source workdir to BE there...
do_compile[depends] += "virtual/kernel:do_shared_workdir" 

EXTRA_OEMAKE += " ARCH=${ARCH} KSRC=${STAGING_KERNEL_DIR}"

do_compile () {
    # Force the additional LDFLAGS as they break things on some targets and
    # weren't overly helpful...
    unset LDFLAGS
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/${MODULE_NAME} ${D}/lib/modules/${KERNEL_VERSION}/${MODULE_NAME}
}

