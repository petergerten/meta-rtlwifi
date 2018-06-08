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

# Stage in some directory pathing at the initial phase of the install task so that the module.bbclass
# can do things "right" with the above declarations...
do_install_prepend() {
	install -d ${D}${nonarch_base_libdir}/
	install -d ${D}${nonarch_base_libdir}/modules
	install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}
}

