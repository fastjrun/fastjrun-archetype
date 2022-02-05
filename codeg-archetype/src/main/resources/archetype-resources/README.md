为了前后端开发同事之间能够更好的配合，我们团队特意开发了apiworld-codeg这个项目，通过该项目既可以帮助我们快速构建支持http协议的接口模拟系统，也可以为正式的Java项目提供接口相关代码（如Controller、Service接口和接口请求参数与相应参数DTO等），这些代码不经改动即可用于spring4、springboot1.x和springboot2.x项目。
### 项目支持的接口响应格式
#### 默认支持接口响应格式
目前项目默认支持的接口响应格式如下
1. 基础响应格式
```json
{
  "code": 2000,
  "msg": "OK"
}
```
2. 对象格式
```json
{
  "code": 2000,
  "msg": "OK",
  "data": {
    "nickName": "fastjrun",
    "sex": "1",
    "mobileNo": "18900000000",
    "email": "18900000000@alibaba.com",
    "uu_id": "H8gpczAh6SfTuZMUpMSPSKNCTc2Jlf3Rr6ABJBIn9p"
  }
}
```
3. 数组格式
```json
{
  "code": 2000,
  "msg": "OK",
  "data": [
    {
      "id": 53,
      "detailUrl": "http://www.example.com/book/53",
      "title": "接口规范"
    }
  ]
}
```
4. 分页格式
```json
{
  "code": 2000,
  "message": "OK",
  "data": {
    "currentPage": 0,
    "pageSize": 0,
    "rows": [
      {
        "id": 53,
        "detailUrl": "http://www.example.com/book/53",
        "title": "接口规范"
      }
    ],
    "total": 0,
    "totalPage": 0
  }
}
```

### 使用前提
使用前确保你的办公机已经可以正常安装和配置jdk1.8+、maven3.5+和idea，eclipse和其他ide工具或许也能正常使用，但确实很推荐idea，太好用了，没有之一。
### 快速搭建接口模拟系统
```bash
cd ${rootArtifactId}-codeg
sh build.sh package_mock_server
java -jar ${rootArtifactId}-mock-server/target/${rootArtifactId}-mock-server.jar
```
用浏览器访问http://localhost:8080/doc.html 显示如下  
![](https://oscimg.oschina.net/oscnet/up-c2f8dfe2dc0f6232bdea7b0bc284e48bbd3.png)  
显然这是一个满足swagger风格的接口系统。
展开“第三方接口 Article Custom Api Controller”  ，这里一共提供了6个接口示例如下  
![](https://oscimg.oschina.net/oscnet/up-d6559eb8b1e97f47662d37d0b24b8d41aca.png)  
进入本类接口下的/customapi/user/login接口界面，查看具体的接口参数和响应报文  
![](https://oscimg.oschina.net/oscnet/up-213489550d034b4b4dd4b3fc15fd8d41aa0.png)  
点击上图中的Try it out按钮，可以切换到本接口的mock服务调用界面如下  
![](https://oscimg.oschina.net/oscnet/up-e5dd7dfec3630de72a17803c3ad5d33a22a.png)  
点击Execute按钮，可以看到返回值类似如下  
![](https://oscimg.oschina.net/oscnet/up-7b6eef245248186eeaaeb4f03e397d51743.png)
本项目也集成了knife4j，knife4j是为Java MVC框架集成Swagger生成Api文档的增强解决方案,它的前身是swagger-bootstrap-ui。
用浏览器访问http://localhost:8080/doc.html  显示如下
![](https://oscimg.oschina.net/oscnet/up-e319533d1005339975502eba7392b10a634.png)


### 接口定义规范约定
#### 术语
**Controller**：控制器，统称接口，包括http接口和rpc接口，本项目中只涉及http接口。
**Service**：参考分层架构中的服务层
**DTO**：DTO（Data Transfer Object）数据传输对象；本规范中分为两种，一种是serviceDTO，即service层使用的请求参数和返回值对象；一种是ControllerDTO，即接口层使用的请求参数和返回值对象，根据实践来看，一般ControllerDTO会在普通的serviceDTO之外包一层
#### serviceDTO规范约定
- DTO首先是一个普通的JavaBean，原则上，JavaBean所有规范都都适用于DTO规范
- DTO必须是一个公共类，使用public修饰，如： public class Book{ …}
- DTO必须有一个不带参数公共构造函数：例如：public Book() {…}
- DTO所有类成员变量都为private  ，如： private Integer id;
- DTO所有类成员变量都不能是基础类型， 必须使用包装数据类型
- DTO类成员变量 使用的包装数据类型只限于Integer、Long、Double和Boolean四种，Byte、Character、Short和Float弃用
- DTO类成员变量类型只能是包装数据类型、其他DTO数据类型和java.util.List；且List中的类型只能是包装数据类型或其他DTO数据类型
- DTO所有类成员变量都必须提供getter/setter方法的成员变量，且getter/setter方法不能含有任何业务逻辑
- DTO所有类成员变量命名规范建议
  - 一般以连续的两个小写字母开头
  - 如果类成员名的第二个字母大写，那么该属性名直接用作 getter/setter 方法中 get/set 的后部分，就是说大小写不变。例如类成员名为uName，方法是getuName/setuName
  - 如果前两个字母是大写（一般的专有名词和缩略词都会大写），也是类成员名直接用作 getter/setter 方法中 get/set 的后部分。例如类成员名为URL，方法是getURL/setURL
  - 如果类成员属性是Boolean，那么类成员名不可以用is、IS、iS和Is开头
- 满足以上定义的DTO均可以在快嘉接口定义文件中被使用，无论已有还是新建
- 对于未在规范中显性支持的字段类型和自定义类型，暂不支持
#### Service规范约定
- Service是一个普通的Interface
- Service由若干方法组成
- Service中每个方法的请求参数只能是0到多个包装类型和至多一个DTO类，且DTO类只能是请求参数中的最后一个
- Service中每个方法的返回值只能是VOID、包装数据类型、DTO数据类型和java.util.List；且List中的类型只能是包装数据类型或其他DTO数据类型
- Service中每个方法均有version字段，在实际的Service定义中，该version字段会和方法的name字段一起影响生成的Interface
- Service中每个方法均有version、path、resType、reqType和method字段，这些字段将会在http接口中发挥作用
- Service中每个方法的headVariables域由0到多个包装类型组成，这些字段将会作为参数作用在http接口中的请求Header
- Service中每个方法的cookieVariables域由0到多个包装类型组成，这些字段将会作为参数作用在http接口中的请求Cookie
- Service中每个方法的pathVariables域由0到多个包装类型组成，这些字段将会作为参数作用在http接口中的请求路径
- Service中每个方法的parameters域由0到多个包装类型组成，这些字段将会作为参数作用在http接口中的QueryString 部分或者Form表单
- Service中每个方法的request或者不存在，或者是一个DTO，这个字段对应的对象实例将会反序列化成一个字符串作为参数作用在http接口中的reqeustBody
- Service中每个方法的response或者为空，或者是一个包装数据类型、一个DTO数据类型和一个java.util.List；且List中的类型只能是包装数据类型或DTO数据类型
#### ControllerDTO规范约定
- serviceDTO可以直接作为ControllerDTO使用
- 无论更改接口的请求ControllerDTO和响应ControllerDTO，都会同时影响到到服务端和请求端的具体实现，且只会影响到到服务端和请求端的具体实现，且只会影响到到服务端和请求端对serviceDTO中系统参数的解析和处理部分。
### 接口定义指南
本项目接口定义文件采用xml格式，其规范请参见：https://fastjrun.github.io/apiworld-sdkg/fastjrun-schema.xsd
快嘉接口规范分为3节，分别是packets、services和contorllers。其中packets节定义请求和响应报文对应的DTO；services节定义service接口的；contorllers节定义我们需要的contorller，这些contorller返回的响应格式是我们项目提前定义好的。每个contorller会对应一个service接口，service接口中的每个方法也都会在相应的contorller中生成。
${rootArtifactId}-api.xml，将本项目导入idea后，${rootArtifactId}-api.xml进行编辑，调试。
#### 定义DTO
```xml
<packet class="packet.customapi.LoginRestRequestBody">
  <field name="loginName" dataType="String" length="12"
         canBeNull="false" remark="登录名"/>
  <field name="loginpwd" dataType="String" length="64" canBeNull="false"
         remark="密码"/>
</packet>
```
如上所示，该DTO对应的Java类名为LoginRestRequestBody，生成在名为${packagePrefix}.package.customapi的package下，一共6个属性，分别是loginName和loginpwd，其对应的属性均为String。
生成Java代码如下
```java
package com.fastjrun.apiworld.packet.customapi;

import java.io.Serializable;


/**
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的
 *
 * @Copyright 2021 快嘉. All rights reserved.
 * @author cuiyingfeng
 */
public class LoginRestRequestBody
        implements Serializable
{
  /**
   * 密码
   */
  private String loginpwd;
  /**
   * 登录名
   */
  private String loginName;
  private static final long serialVersionUID = 575886617L;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(("LoginRestRequestBody"+" ["));
    sb.append("field [");
    sb.append("loginpwd");
    sb.append("=");
    sb.append(this.loginpwd);
    sb.append(",");
    sb.append("loginName");
    sb.append("=");
    sb.append(this.loginName);
    sb.append("]");
    sb.append("]");
    return sb.toString();
  }

  public String getLoginpwd() {
    return this.loginpwd;
  }

  public void setLoginpwd(String loginpwd) {
    this.loginpwd = loginpwd;
  }

  public String getLoginName() {
    return this.loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }
}
```
#### 定义Service
```xml
<service name="userServiceRestCustomApi" class="controller.UserServiceRestCustomApi">
  <method name="register" version="" path="/register" remark="注册">
    <request class="packet.customapi.RegistserRestRequestBody"/>
  </method>
  <method name="login" version="" path="/login" remark="登录">
    <request class="packet.customapi.LoginRestRequestBody"/>
    <response class="packet.customapi.LoginRestResponseBody"/>
  </method>
  <method name="login" version="v1_1" path="/login" remark="登录v1.1">
    <request class="packet.customapi.LoginRestRequestBody"/>
    <response class="packet.customapi.LoginRestResponseBody"/>
  </method>
  <method name="autoLogin" version="" path="/autoLogin" remark="自动登录">
    <request class="packet.customapi.AutoLoginRestRequestBody"/>
    <response class="packet.customapi.LoginRestResponseBody"/>
  </method>
</service>
```
如上所示，该Service对应的Java类名为UserServiceRestCustomApi，生成在名为${packagePrefix}.service.controller的package下
生成Java代码如下
```java
package com.fastjrun.apiworld.service.controller;

import com.fastjrun.apiworld.packet.customapi.AutoLoginRestRequestBody;
import com.fastjrun.apiworld.packet.customapi.LoginRestRequestBody;
import com.fastjrun.apiworld.packet.customapi.LoginRestResponseBody;
import com.fastjrun.apiworld.packet.customapi.RegistserRestRequestBody;


/**
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的
 *
 * @Copyright 2021 快嘉. All rights reserved.
 * @author cuiyingfeng
 */
public interface UserServiceRestCustomApi {

  /**
   * 注册
   */
  void register(RegistserRestRequestBody requestBody);

  /**
   * 登录
   */
  LoginRestResponseBody login(LoginRestRequestBody requestBody);

  /**
   * 登录v1.1
   */
  LoginRestResponseBody loginv1_1(LoginRestRequestBody requestBody);

  /**
   * 自动登录
   */
  LoginRestResponseBody autoLogin(AutoLoginRestRequestBody requestBody);
}
```

#### 定义Controller
```xml
<controller type="CustomApi" name="UserCustomApiController" path="/customapi/user"
            clientName="UserCustomApiClient" remark="用户管理接口" tags="第三方接口">
  <service name="userService" ref="userServiceRestCustomApi"/>
</controller>
```
如上所示，该Controller对应的Java类名为UserCustomApiController，生成在名为${packagePrefix}. web.apiworld.controller的package下
生成Java代码如下
```java
package com.fastjrun.apiworld.web.apiworld.controller;

import com.fastjrun.apiworld.dto.ResultModel;
import com.fastjrun.apiworld.helper.ResultHelper;
import com.fastjrun.apiworld.packet.customapi.AutoLoginRestRequestBody;
import com.fastjrun.apiworld.packet.customapi.LoginRestRequestBody;
import com.fastjrun.apiworld.packet.customapi.LoginRestResponseBody;
import com.fastjrun.apiworld.packet.customapi.RegistserRestRequestBody;
import com.fastjrun.apiworld.service.controller.UserServiceRestCustomApi;
import com.fastjrun.web.controller.BaseController;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的
 *
 * @Copyright 2021 快嘉. All rights reserved.
 * @author cuiyingfeng
 */
@RestController
@RequestMapping("/customapi/user")
public class UserCustomApiController
        extends BaseController
{
  @Autowired
  @Qualifier("userServiceRestCustomApi")
  private UserServiceRestCustomApi userService;

  /**
   * 注册
   */
  @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResultModel register(@RequestBody @Valid RegistserRestRequestBody requestBody) {
    ResultModel result = ResultHelper.ok();
    this.userService.register(requestBody);
    log.debug("result={}", result);
    return result;
  }

  /**
   * 登录
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResultModel<LoginRestResponseBody> login(@RequestBody @Valid LoginRestRequestBody requestBody) {
    ResultModel<LoginRestResponseBody> result = ResultHelper.ok();
    LoginRestResponseBody resultData = this.userService.login(requestBody);
    result.setData(resultData);
    log.debug("result={}", result);
    return result;
  }

  /**
   * 登录v1.1
   */
  @RequestMapping(value = "/login/v1_1", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResultModel<LoginRestResponseBody> loginv1_1(@RequestBody @Valid LoginRestRequestBody requestBody) {
    ResultModel<LoginRestResponseBody> result = ResultHelper.ok();
    LoginRestResponseBody resultData = this.userService.loginv1_1(requestBody);
    result.setData(resultData);
    log.debug("result={}", result);
    return result;
  }

  /**
   * 自动登录
   */
  @RequestMapping(value = "/autoLogin", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ResultModel<LoginRestResponseBody> autoLogin(@RequestBody @Valid AutoLoginRestRequestBody requestBody) {
    ResultModel<LoginRestResponseBody> result = ResultHelper.ok();
    LoginRestResponseBody resultData = this.userService.autoLogin(requestBody);
    result.setData(resultData);
    log.debug("result={}", result);
    return result;
  }
}
```
#### 
修改完apiworld-api.xml后，需要重新执行代码生成命令如下
```bash
sh build.sh package_mock_server
```
再启动接口模拟系统
```bash
java -jar apiworld-mock-server/target/apiworld-mock-server.jar
```
然后打开http://localhost:8080/swagger-ui.html ，就可以看到修改后的效果了。
