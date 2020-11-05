##### 一、项目技术栈
Spring Boot + Mybatis + Mysql + Druid + Swagger + logback

--优点：
* 文档丰富
* 上手简单

--基础功能：
* Swagger 在线接口文档
* 接口统一返回
* 常用工具类：Gson
* 全局异常拦击
* 自定义异常拦截
* maven 多环境配置
* TesgNg 单元测试
* Quartz ：TODO
* 代码生成器：TODO
* 通用分页对象：TODO
* Docker 部署项目 ：TODO
* 封装 HTTP Client工具类

##### 二、快速开始

###### 2.1 前提

* 了解 Spring、Spring Boot、mysql、TestNg、Java 等基础知识
* 物理机环境：
    * git
    * Java 8.x
    * maven 3.x
    * mysql 5.x
    * idea: 安装lombok插件
  
###### 2.2 项目结构

```
.
├── README.md
├── basic-client
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── sunskblue
│                       └── basicclient
│                           └── bean
│                               └── TUser.java
├── basic-server
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── sunskblue
│       │   │           └── basicserver
│       │   │               ├── BasicServerApplication.java
│       │   │               ├── config
│       │   │               │   ├── DataSourceConfig.java
│       │   │               │   └── swagger
│       │   │               │       ├── SwaggerConfig.java
│       │   │               │       └── SwaggerInfo.java
│       │   │               ├── controller
│       │   │               │   └── UserController.java
│       │   │               ├── core
│       │   │               │   ├── ResultCode.java
│       │   │               │   ├── ResultGenerator.java
│       │   │               │   └── ResultWrapper.java
│       │   │               ├── exception
│       │   │               │   ├── APIException.java
│       │   │               │   └── ExceptionControllerAdvice.java
│       │   │               ├── mapper
│       │   │               │   └── UserMapper.java
│       │   │               ├── service
│       │   │               │   ├── UserService.java
│       │   │               │   └── impl
│       │   │               │       └── UserServiceImpl.java
│       │   │               └── util
│       │   │                   └── GsonUtil.java
│       │   └── resources
│       │       ├── application-dev.yml
│       │       ├── application.yml
│       │       ├── banner.txt
│       │       ├── demo-user.sql
│       │       ├── logback-spring.xml
│       │       └── mapper
│       │           └── UserMapping.xml
│       └── test
│           ├── java
│           │   └── com
│           │       └── sunskblue
│           │           └── basicserver
│           │               ├── BasicServerApplicationTests.java
│           │               └── UserTest.java
│           └── resources
│               └── testng.xml
└── pom.xml
```

###### 2.3 服务启动
2.3.1 配置数据库信息：
```
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/testsql?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root
    password: admin
    driver-class-name: com.mysql.jdbc.Driver
```
2.3.2 在 testsql 库中执行demo-user.sql文件
2.3.3 配置项目启动类，服务启动

###### 2.4 基础介绍

Lombok 插件注解：

* `@Data`：注解在类上，其中包含了@Getter、@Setter、@ToString、@EqualsAndHashCode、@RequiredArgsConstructor等；如果属性为final修饰的属性，则不会为该属性生成setter方法。

* `@Getter`：注解可以写在类上或具体的属性上，为类中所有属性或具体的属性提供 getter 方法；

* `@Setter`：注解可以写在类上或具体的属性上，为类中所有非final修饰的属性或具体的非final修饰的属性提供 setter 方法；

* `@ToString`：注解写在类上，Lombok会生成一个toString()方法，默认情况下，会输出类名、所有属性(会按照属性定义顺序)，用逗号来分割；

spring&&spring boot注解介绍：

* `@RestController`:用于标注控制层组件, @Controller 和 @ResponseBody 的合集,表示这是个控制器bean,并且是将函数的返回值直 接填入HTTP响应体中,是REST风格的控制器。
* `@RequestMapping`:提供路由信息
* `@SpringBootApplication`:可以理解为该注解作用于服务启动类上，包含了@ComponentScan、@Configuration和@EnableAutoConfiguration注解
* `@Configuration`:作用于配置类，相当于 xml 配置文件
* `@PathVariable`：获取参数。
* `@Autowired`：自动导入。
* `@Resource`:自动导入。
* `@Service`:修饰 service 层组件
* `@Repository`:修饰 Dao 层组件（不是 spring 的注解）
* `@Mapper`:修饰 Dao 层组件

`@Repository`和`@Mapper`区别：

* 使用@mapper后，不需要在spring配置中设置扫描地址，通过mapper.xml里面的namespace属性对应相关的mapper类，spring将动态的生成Bean后注入到ServiceImpl中。
* @repository则需要在Spring中配置扫描包地址，然后生成dao层的bean，之后被注入到ServiceImpl中。
