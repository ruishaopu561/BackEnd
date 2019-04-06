# BackEnd

- [Junit安装教程](https://www.jianshu.com/p/b7280027755c)
- [Junit语法教程](https://www.w3cschool.cn/junit/2wjx1hvc.html)
- [IntelliJ IDEA教程](https://blog.csdn.net/antony9118/article/details/51736135)
- [IDEA Test coverage](https://www.jianshu.com/p/ca3b91e85fea)

## 修改JAVA_HOME
在```/etc/profile```中修改（或添加）JAVA_HOME和PATH如下：
```
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/
export PATH=${JAVA_HOME}/bin:$PATH
```
```/usr/lib/jvm/java-11-openjdk-amd64/```　是jdk的路径名（可用```update-alernatives --config java```查看）  
（可用```source /etc/profile```刷新一下）  
```mvn -v```查看正确时的结果，如下：
```
Maven home: /usr/share/maven
Java version: 10.0.2, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: zh_CN, platform encoding: UTF-8
OS name: "linux", version: "4.15.0-45-generic", arch: "amd64", family: "unix"

```
## 安装配置maven
maven安装包下载后一般解压放在```/usr/local```中。  
在java的配置路径```/etc/profile```中，加入maven文件的路径，如下：
```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
export M2_HOME=/usr/local/maven/apache-maven-3.6.0
export PATH=${M2_HOME}/bin:$PATH
```
重点在后两句，前四句均是jdk路径。  
```source /etc/profile```激活后方能用```mvn -v```和```java -version```验证是否安装正确。
## 安装配置tomcat
官网地址(http://tomcat.apache.org/download-80.cgi)
ubuntu下载zip或tar.gz格式，下载下来后解压到```/opt```文件夹内, 进入到```apache-tomcat-8.5.39```(这是我的版本名)中
```sudo vim ./bin/startup.sh```以及```sudo vim ./bin/shutdown.sh```在两文件中  
配置路径如下(写在开头)
```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
export TOMCAT_HOME=/opt/apache-tomcat-8.5.39
```
打开tomcat
```sudo ./bin/startup.sh```
关闭tomcat
```sudo ./bin/shutdown.sh```
