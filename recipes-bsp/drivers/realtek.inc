# Handle all the common tasks in the Realtek driver recipes here...

S = "${WORKDIR}/git"

# Consistent package versioning rules...
PV = "${MODVER}-git+${SRCREV}"

inherit module

# Force the kernel source workdir to BE there...
do_compile[depends] += "virtual/kernel:do_shared_workdir" 

# Pass a few extra envvars in...
EXTRA_OEMAKE += " ARCH=${ARCH} KSRC=${STAGING_KERNEL_DIR} MODDESTDIR=${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}"

# Override the modules install target...
MODULES_INSTALL_TARGET = "install"

# Override the modules.bbclass install phase.  It does it wrong with everything on serveral fronts.
do_install() {
	install -d ${D}${nonarch_base_libdir}/
	install -d ${D}${nonarch_base_libdir}/modules
	install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}
	install -m 0755 ${B}/${MODULE_NAME} ${D}/lib/modules/${KERNEL_VERSION}/${MODULE_NAME}
}

