### 快嘉框架archetype系列

#### 基于h2生成mybatis代码原型

- [基于h2数据库使用mybatis-generator-maven-plugin生成代码实践-注解版](https://my.oschina.net/fastjrun/blog/5425920)

```bash
mvn archetype:generate -U -B -DgroupId=com.fastjrun.share -DartifactId=mbgdemo -Dpackage="com.fastjrun.share.mbgdemo" -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=com.fastjrun.archetype -DarchetypeArtifactId=mbg-archetype -DarchetypeVersion=1.2 -U
```

#### 接口代码生成模块原型

```shell
mvn archetype:generate -U -B -DgroupId=com.fastjrun.codeg.hellapi.simple -DartifactId=hellapi -Dpackage="com.fastjrun.hellapi" -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=com.fastjrun.archetype -DarchetypeArtifactId=codeg-archetype -DarchetypeVersion=1.3 -U
```

- 已知问题
  - 默认生成的脚手架是基于apiworld接口代码生成模块的多模块工程，可以通过调整fastjrun-apiworld-schema.xsd和__rootArtifactId__-api.xml来达到效果
  - 默认生成的脚手架项目名称为__rootArtifactId__，需要手工调整为__rootArtifactId__-codeg
  - 



#### 自定义接口代码生成器模块原型

```shell
mvn archetype:generate -U -B -DgroupId=com.fastjrun.codeg.hellapi -DartifactId=hellapi -Dpackage="com.fastjrun.hellapi" -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=com.fastjrun.archetype -DarchetypeArtifactId=sdkg-archetype -DarchetypeVersion=1.4 -U
```

- 已知问题
  - 默认生成的脚手架是基于apiworld接口代码生成器模块的多模块工程，内含接口代码生成模块
  - 默认生成的脚手架项目名称为__rootArtifactId__，需要手工调整为__rootArtifactId__-sdkg
  - 需要手动调整*-sdkg-generator/src/main/resources/ext-generator.properties


