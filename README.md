说明
========
暂时只支持从spi flash启动licheepi nano。

使用
========
假设目录架构为
```
~
|-- poky
|    |-- meta
|    |-- meta-poky
|    |-- meta-yocto-bsp
|    |-- meta-openembedded
|    |           |-- meta-oe
|    |-- meta-suniv
|-- build
```
> cp -r ~/poky/meta-suniv/example/conf ~/build

然后编辑`~/build/conf/bblayers.conf`，将`BBLAYERS`变量里的相应路径改为自己实际的路径，然后可选择编辑`~/build/conf/local.conf`文件里的`DL_DIR`及`SSTATE_DIR`两个变量到想要的路径。

其中，`DL_DIR`里存储的是编译时使用到的工具及包，编译系统在编译时会检查`DL_DIR`是否存在对应的包，有则直接使用，无则从网上下载并存储到`DL_DIR`所在目录，不同项目可共用`DL_DIR`。

`SSTATE_DIR`存储的是编译时产生的可复用可共享的缓存信息，可提升重新编译的速度，且好像可以在不同间共享（？待研究）。

执行命令`source ~/poky/oe-init-build-env ~/build`初始化编译环境，

随后运行`bitbake u-boot`编译u-boot。

`bitbake linux-suniv`编译kernel。

`bitbake core-image-minimal`编译rootfs。
