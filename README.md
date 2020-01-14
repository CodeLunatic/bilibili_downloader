# BiliBili下载器

分享一下1年前写的一个`JavaFX`项目，停了很长时间了，还没有完成，界面设计到了一半，下载的逻辑已经全部实现。

> 感谢你无意间发现了这个仓库，该仓库仅供学习交流使用，方便程序员下载`BiliBili`上面的优质学习资源,当前代码为正在开发中的半成品，佛系开发，完全不知道什么时间完成， 甚至`BiliBili`接口已经全部改变也不一定会完成。

![界面预览](http://p.qlogo.cn/qqmail_head/Q3auHgzwzM4g2cLj1J8wBePWc7IpPAic1gQEvuMBfJVP4y7MCwJnC2s8LI88l8pj53L5oWAyBGDviaWXp5FS2oVciaCicwwN0cZ3WibQ1Adyaibiac/0)

`BiliBili`下载器，提供更全面的资源支持，现已支持`AV`、`EP`、`SS`、`AM`、`AU`、`LIVE`、`VC`等类型的下载，默认下载到程序文件所在路径

暂时不支持`JDK8`以上版本的`JavaFX`

现在程序功能已经全部可用，还没有完全开发完成，如果你喜欢，欢迎加入

# 使用方法

克隆仓库

```shell
git clone https://github.com/CodeLunatic/bilibili_downloader.git
```

进入文件夹

```shell
cd bilibili_downloader
```

打包源码

```shell
mvn clean package
```

进入打包目录

```shell
cd target
```

使用方式

```shell
java -jar BiliBili-jar-with-dependencies.jar https://www.bilibili.com/video/av39718511
```

# 还没有开发功能

> 自定义整列表下载
>
> 登陆状态保持
>
> 下载弹幕、字幕和歌词
>
> ...
