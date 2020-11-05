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
