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

```xml
spring.security.user.name=user
spring.security.user.password=123
```

#### other

Other more details about actuator can be found in files in ```Reference``` below.

## test for controller and actuator

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

## Spring Security

### Simple Demo

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //基于内存的用户存储
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("itguang").password("123456").roles("USER").and()
                .withUser("admin").password("123456").roles("ADMIN");
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/shop/hello").authenticated()
                .antMatchers(HttpMethod.POST,"/shop/order").authenticated()
                .anyRequest().permitAll();
    }
}
```

#### about demo

> * ```configure(AuthenticationManagerBuilder auth)```可简单理解为利用```AuthenticationManagerBuilder```创建多个用户，包含```roles```，```username```和```password```。  
在```application.properties```中写死也可以，不过那样貌似只有一个```roles```.
> * ```configure(HttpSecurity http)```就开始对每种```roles```设置不同的访问权限，常用的访问函数如下所述。

### Functions

> * ```antMatchers()```方法中设定的路径支持Ant风格的通配符。但是也可以不用，可以设置相对路由。
> * ```authenticated()```要求在执行该请求时，必须已经登录了应用。如果用户没有认证的话，Spring Security的Filter将会捕获该请求，并将用户重定向到应用的登录页面。 
> * ```permitAll()```方法允许请求没有任何的安全限制。
> * ```access(String)```如果给定的SpEL表达式计算结果为true，就允许访问
> * ```anonymous()```允许匿名用户访问
> * ```authenticated()```允许认证的用户进行访问
> * ```denyAll()```无条件拒绝所有访问
> * ```fullyAuthenticated()```如果用户是完整认证的话（不是通过Remember-me功能认证的），就允许访问
> * ```hasAuthority(String)```如果用户具备给定权限的话就允许访问
> * ```hasAnyAuthority(String…)```如果用户具备给定权限中的某一个的话，就允许访问
> * ```hasRole(String)```如果用户具备给定角色(用户组)的话,就允许访问/
> * ```hasAnyRole(String…)```如果用户具有给定角色(用户组)中的一个的话,允许访问.
> * ```hasIpAddress(String)```如果请求来自给定ip地址的话,就允许访问.
> * ```not()```对其他访问结果求反.
> * ```permitAll()```无条件允许访问
> * ```rememberMe()```如果用户是通过Remember-me功能认证的，就允许访问

#### All SPEL Expressions supported

> * ```authentication```用户的认证对象
> * ```denyAll```结果始终为false
> * ```hasAnyRole(list of roles)```如果用户被授予了列表中任意的指定角色，结果为true
> * ```hasRole(role)```如果用户被授予了指定的角色，结果为true
> * ```hasIpAddress(IPAddress)```如果请求来自指定IP的话，结果为true
> * ```isAnonymous()```如果当前用户为匿名用户，结果为true
> * ```isAuthenticated()```如果当前用户进行了认证的话，结果为true
> * ```isFullyAuthenticated()```如果当前用户进行了完整认证的话（不是通过Remember-me功能进行的认证），结果为true
> * ```isRememberMe()```如果当前用户是通过Remember-me自动认证的，结果为true
> * ```permitAll()```结果始终为true
> * ```principal()```用户的principal对象

## Problems encountered in this hw

### SpringBoot Test Procedure

开头加入这两个annotations

```java
@RunWith(SpringRunner.class)
@SpringBootTest
```

就能取到spring中的容器的实例，如果配置了@Autowired那么就自动将对象注入。

```@ContextConfiguration```可以指定测试的class. eg:

```java
@ContextConfiguration(classes = WordladderController.class)
```

## Useful Websites from Ren rui

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
> * [Spring Security初识](https://blog.csdn.net/itguangit/article/details/78932581)