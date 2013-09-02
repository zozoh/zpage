zpage
=====

> 一个简单的网站生成器

# zpage 是干什么的?

在静态网站制作领域，有很多有力的工具，其中最华丽的一个就是 Dreamweaver。我以前还是一个网页制作师的时候，就是它的重度使用者。很多年以后，当我已经很少写静态网站的时候，回想起来，Dreamweaver 似乎对我来说最重要的功能不是它的所见即所得编辑器（是的，我经常在代码视图里工作），而是下面两个功能:

1. 网页模板
2. 代码片段

这两个功能极大的提升了我的生产力，以及心情。是的很多事情可以批量修改难道不是一件愉快的事情吗。以至于某一天，我产生了一个心愿:"如果有一个工具仅有这两个功能，那么我就再也不用 Dreamweaver 了。"

幸运的是，我是一个程序员，我可以自己做一个，于是就有了这个项目 -- **zpage**

# zpage 为谁而设计

我假想的 zpage 的用户具备如下技能:

1. 具备网站制作的基本技巧，即了解 HTML/CSS
2. 阅读完本篇文档

那么你就能使用 zpage 制作你的网站了。但是 zpage 并不是一个动态网站制作工具，它只帮你最大限度的利用你已有的知识，方便的制作静态网站而已。


# zpage 怎么安装

zpage 是由 golang 语言编写的，在任何平台上（Mac, Windows, Linux …） 只要能跑 go ，你就能这样安装:

	go get github.com/zozoh/zpage
	

# zpage 怎么使用

zpage 就是将你工作目录里面所有的网页以及静态资源统统输出到目标目录

	zpage 工作目录 目标目录
	# 比如
	zpage ~/mysite/zozohblog  ~/output/zozohblog
	
为了能保证 zpage 工作正常，你需要花几分钟时间读读下面的约定


# zpage 的约定

## 顶级目录结构
	
zpage 假想你的工作目录由如下结构组成

	[imgs]       # 存放你所有的图片文件，zpage 会全部 copy 到目标目录
	[js]         # 存放你所有的脚本文件，zpage 会全部 copy 到目标目录
	[css]        # 存放你所有的样式表单，zpage 会全部 copy 到目标目录
	[_tmpl]      # 这里存放模板，一个网站可以有多个模板
	[_libs]      # 这里存放代码片段
	zpage.conf   # 你的网站项目的总体配置文件      
	index.html   # 所有的 HTML 都会一视同仁进行转换
	
## _tmpl 目录
	
	[_tmpl]                 # 目录内任何一个 html 文件就是一个模板
		normal.html         # 这个模板的名字为 "normal"
		[black]             
			myblank.html    # 这个模板的名字为 "black.myblank"
			

## _libs 目录
	
	[_libs]                 # 目录内任何一个 html 文件就是一个代码片段
		menu.html           # 这个片段的名字为 "menu"
		[black]             
			menu.html       # 这个片段的名字为 "black.menu"
			
## zpage.conf

放置这个文件的的目录将作为 zpage 的工作目录，这个文件也不是必须的，如果没有，一切将采用
默认值

	# 模板目录，默认 _tmpl
	zpage-tmpl=_tmpl
	
	# 代码片段目录，默认 _libs
	zpage-libs=_libs
	
	# 下面的路径，都是要全部执行 copy 的
	zpage-rs=imgs,js,css
	
	# 网页的模板设置
	#
	#  > 每行两个字段 :  [网页路径匹配模式(正则表达式)]  : 模板名
	#  > 排在第一行的匹配规则有更高的优先级
	#
	# 如果没有这个设置，默认相当于
	#
	#   .*           : normal
	#
	# 关键字 "none" 表示不使用任何模板，比如:
	#
	#   /abc.html     : none
	#
	zpage-tmpl-setup:
	/index.html  : normal
	/page/.*     : black.myblank
	.*           : normal
	# ~ 结束模板设置
	
## 所谓转换

所谓 zpage 的转换，就是寻找工作目录中任何 .html 文件或者 .htm 文件，并对其进行转换。
一次转换将执行下列动作

1. 寻找一个匹配的网页模板
	* 如果一个网页，第一行是 `<!--#zpage-tmpl:abc-->` 表示它要使用特殊模板，否则就根据匹配规则匹配
	* 根据网页的当前路径，修改模板中的 src, href
2. 将当前网页内容嵌入模板
3. 将网页和模板中应用的代码片段链入
	* 根据网页的当前路径，修改代码片段中的 src, href
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
















