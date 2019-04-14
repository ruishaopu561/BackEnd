# HW4 Record
## actuator
### dependency
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>
</dependencies>
```
### properties in application.properties
```properties
info.app.name=spring-boot-actuator
info.app.version= 1.0.0
info.app.test=test

management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
#management.endpoints.web.base-path=/monitor

management.endpoint.shutdown.enabled=true
```
#### open all endpoints
Spring Boot 2.x only provides two common endpoints, add ```management.endpoints.web.exposure.include=*```
to open all the endpoints.
#### security when curling actuator
Under normal circumstances, It's OK to request to all endpoints. However, sometimes  you may set some security settings and you need to log in to continue.  
User used to be ```user```, password will be a string of characters generated in terminal.  
Also you can set by youself in ```application.properties```, like this:  
```
spring.security.user.name=user
spring.security.user.password=123
```
#### other
Other more details about actuator can be found in files in ```Reference``` below.

## security

## test for controller
### Basic framwork
```java
package rsp.hw.controller;

@RunWith(SpringJUnit4ClassRunner.class)   
@WebAppConfiguration  
public class MocPostTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()
    public void setup()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void getAllCategoryTest() throws Exception
    {

    }
}
```
#### annotation used here
> * ```@RunWith(SpringJUnit4ClassRunner.class)```: 表示使用Spring Test组件进行单元测试; 
> * ```@WebAppConfiguration```: 使用这个Annotate会在跑单元测试的时候真实的启一个web服务，然后开始调用Controller的Rest API，待单元测试跑完之后再将web服务停掉;
> * ```@Before()```  //这个方法在每个方法执行之前都会执行一遍

#### Process
> * ```mockMvc.perform```执行一个请求。
> * ```MockMvcRequestBuilders.post("http://127.0.0.1:8888/login")```构造一个请求。
> * ```ResultActions.andExpect```添加执行完成后的断言。
> * ```ResultActions.andDo()```添加一个结果处理器，表示要对结果做点什么事情，比如此处使用```MockMvcResultHandlers.print()```输出整个响应结果信息。
> * ```ResultActions.andReturn()```表示执行完成后返回相应的结果。

## Useful Wesites from Ren rui
### Spring Boot
https://spring.io/guides/gs/rest-service  
https://github.com/spring-guides/gs-rest-service
### Spring Security
https://spring.io/guides/topicals/spring-security-architecture  
https://spring.io/guides/gs/securing-web/
### Spring Actuator
https://spring.io/guides/gs/actuator-service/  
https://github.com/spring-guides/gs-actuator-service.git

## Reference
> * [security用户密码设置](https://blog.csdn.net/russle/article/details/82454921)
> * [Actuator](http://www.ityouknow.com/springboot/2018/02/06/spring-boot-actuator.html)
> * [使用MockMvc测试 Controller](https://blog.csdn.net/Adam_allen/article/details/79919921)
> * [Spring Security初步理解并实现](https://www.jianshu.com/p/e6655328b211)