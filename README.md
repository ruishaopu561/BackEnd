# BackEnd

- [Junit安装教程](https://www.jianshu.com/p/b7280027755c)
- [Junit语法教程](https://www.w3cschool.cn/junit/2wjx1hvc.html)

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
