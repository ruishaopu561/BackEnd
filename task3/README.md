# Docker

[My docker repo](https://hub.docker.com/r/ruishaopu561/wordladder)

## 教程
### Download
```
$ docker pull ruishaopu561/wordladder
```
### 查看
```
docker images
```
### 修改下载的Image的REPOSITORY和TAG属性：
```
docker tag <IMAGE ID> <REPOSITORY NAME>
```
### 运行
```
docker run -d --name docker -p 8080:8080 ruishaopu561/wordladder
```
### 删除容器id
```
docker rm 容器id
```
### 删除镜像  镜像id
```
docker rmi image-id
```
### 查看容器日志
```
docker logs    container-name /container-id
```
### 停止容器
```
$ docker ps // 查看所有正在运行容器
$ docker stop containerId // containerId 是容器的ID
```
```
$ docker ps -a // 查看所有容器
$ docker ps -a -q // 查看所有容器ID
```
```
$ docker stop $(docker ps -a -q) //  stop停止所有容器
$ docker rm $(docker ps -a -q) //   remove删除所有容器
```
