# 如何在Linux上构建 Android 工程

- 在Linux上安装Android SDK

http://developer.android.com/sdk/index.html#Other

选择Linux版本并解压到指定目录

> tar zxvf android-sdk_r24.3.3-linux.tgz

由于SDK只有32位,如果装的是64位Linux系统,则要安装ia32-libs来运行32位程序

```
Ubuntu Linux :
apt-get install ia32-libs
apt-get install sun-java6-jdk

CentOS :
Fedora 17 64bit with 32bit Android SDK:
sudo yum install glibc.i686 zlib.i686 libstdc++.i686 ncurses-libs.i686
Fedora 20 64bit with 64bit Android SDK
sudo yum install glibc zlib libstdc++ ncurses-libs mesa-libGL-devel adb
```

参考:

http://blog.csdn.net/catoop/article/details/7618099

http://stackoverflow.com/questions/2710499/android-sdk-on-a-64-bit-linux-machine

- 更新SDK

进入SDK目录下的tools文件夹

>cd /home/AndroidSDK/android-sdk-linux/tools

更新现有的以及下载最新的sdk

>android update sdk --no-ui 

参考:

http://blog.csdn.net/hello0370/article/details/42675999

http://stackoverflow.com/questions/4681697/is-there-a-way-to-automate-the-android-sdk-installation/4682241#4682241

http://blog.csdn.net/csusunxgg/article/details/9703789

- 在Linux 上安装Gradle

下载最新的程序包：

http://www.gradle.org/downloads

解压，加入解压路径(可以自已设定)：/opt/gradle/gradle-1.4

在/etc/profile 文件的最后加入内容

```
gradle_HOME=/opt/gradle/gradle-1.4
exportgradle_HOME
PATH=$gradle_HOME/bin:$PATH
exportPATH
```

执行命令加入到当前命令环境中：(如果不想执行需要重启电脑)

>source/etc/profile

执行命令

>gradle -v

如果你可以看到如下版本信息，恭喜你，你安装成功了 






















