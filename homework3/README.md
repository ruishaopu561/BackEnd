# Pratice of Microservice
## split hw2 REST Service into two microservices
part a: login

part b: wordladder

通过wordladder服务向login服务发送http请求，验证用户是否存在，而不直接允许处理业务

login的端口为8900，wordladder的端口为8700

源码：分开的两个项目分别在login和homework3目录下

## pull images from docker hub
```
docker pull ruishaopu561/homework3
docker pull ruishaopu561/login
```
## run images
run wordladder
```
docker run -d -p 8700:8700 --name=ladder ruishaopu561/homework3
```
run login
```
docker run -d -p 8900:8900 --name=login ruishaopu561/login
```
运行后通过```http://localhost:8700/ladder?u=admin&p=123&b=cat&e=dog```来访问服务，wordladder会接收4个参数，分别是用户名，密码，两个word，用户名和密码会被发送到login服务接收验证，正确后才会尝试生成wordladder。

## Reference
[wordladder](https://hub.docker.com/r/ruishaopu561/homework3)  
[login](https://hub.docker.com/r/ruishaopu561/login)
