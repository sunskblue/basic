# basic
### 基础种子项目

一、快速开始

1.1：项目启动激活环境：

application.xml 中spring.profiles.active: dev

1.2：初始化数据库，执行/resources/demo-user.sql 文件到数据库127.0.0.1:3306/testsql

1.3：接口返回统一封装：

使用ResultGenrator中的静态方法即可

1.4：Swagger 使用：

官方文档：https://github.com/swagger-api/

Swagger 常用 API：
* @Api用于Controller
* @ApiOperation用于Controller内的方法。
* @ApiResponses用于标识接口返回数据的类型。
* @ApiModel用于标识类的名称
* @ApModelProperty用于标识属性的名称

1.5：异常校验查看:javax.validation.constraints

1.6：概念

VO（View Object）： 视图对象，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来。

DTO（Data Transfer Object）： 数据传输对象，这个概念来源于J2EE的设计模式，原来的目的是为了EJB的分布式应用提供粗粒度的数据实体，以减少分布式调用的次数，从而提高分布式调用的性能和降低网络负载，但在这里，我泛指用于展示层与服务层之间的数据传输对象。

DO（Domain Object）： 领域对象，就是从现实世界中抽象出来的有形或无形的业务实体。

PO（Persistent Object）： 持久化对象，它跟持久层（通常是关系型数据库）的数据结构形成一一对应的映射关系，如果持久层是关系型数据库，那么，数据表中的每个字段（或若干个）就对应PO的一个（或若干个）属性。

1.7：项目已经集成 testNg 测试时使用 testng
