SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(suniv)"

inherit kernel

#require linux.inc
require recipes-kernel/linux/linux-yocto.inc

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "f1c100s-480272lcd-test"

# Pull in the devicetree files into the rootfs
# RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KCONFIG_MODE ?= "alldefconfig"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"

SRCREV_pn-${PN} = "9b2fb662b0c8a8d0b93a8ad39fa8bef0bcb95509"
PATCHTOOL = "quilt"

#SRC_URI += "git://github.com/Icenowy/linux.git;branch=f1c100s-480272lcd-test;protocol=git \
#        file://defconfig \
#        "
SRC_URI += "git:///home/fefr/Builds/suniv/linux;branch=f1c100s-480272lcd-test;protocol=file \
         file://defconfig \
         file://linux_spinor_licheepi_nano.patch \
         "
#do_patch_prepend() {
#    patch ${WORKDIR}/defconfig ${WORKDIR}/linux_spiflash_licheepi_nano.patch
#}
