# Handle all the common tasks in the Realtek driver recipes here...

S = "${WORKDIR}/git"

# Consistent package versioning rules...
PV = "${MODVER}-git+${SRCREV}"

inherit module

# Force the kernel source workdir to BE there...
do_compile[depends] += "virtual/kernel:do_shared_workdir" 

# Pass a few extra envvars in...
EXTRA_OEMAKE += " ARCH=${ARCH} KSRC=${STAGING_KERNEL_DIR}"



