zPage Java 版本库
=====

为了方便在 Java 程序中使用 zPage 的约定，我们也提供了 Java 的调用库。
设计这版库的时候我们主要有以下考虑:

* 普通的Java程序只要在硬盘上建立 zPage 需要的目录和文件，就可以正确的渲染出网页
* 有些 Java 程序可能并不是使用普通的文件系统，因此我们对文件系统要进行封装
* 要考虑支持 Markdown 和 zdoc 等 wiki 格式

#### 依赖的库

zPage 运行的时候仅仅依赖 nutz.jar，其log输出方式，采用 Nutz 的 Log 接口来适配。
因此如果你想采用 log4j 输出日志，直接选用一版 log4j 的 jar 包即可。
