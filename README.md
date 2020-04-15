> 使用该项目，只需要编写少量代码，即可完成日常WEB接口开发，并自动生成接口文档；让我们更专注于业务代码的书写，避免重复的Coding，提高生产效率。
>

## 项目说明

本项目采用SpringBoot + MybatisPlus框架，搭建了极低门槛的逆向工程脚手架，极大的方便了后端开发工作，只需编写少量代码，其余交给系统自动生成。 

## 项目结构

项目初始结构

```
sample
│
├─core         核心包
│    ├─entity  实体类包
│    │ 
│    ├─result  HTTP响应封装包
│    │ 
│    └─util	工具类包 
│        ├─CodeGenerator   代码自动生成器类
│        ├─YamlUtil        Yaml文件操作类       
│ 
├─dto     数据传输对象类包
├─entity  实体类包
├─resources
│    ├─templates	   代码生成器模板(velocity)
│    ├─application.yml 全局配置文件
│    └─generator.yml   代码生成器，配置文件
│
```

项目最终结构

```
sample
├─controller   控制器
│    ├─sys     业务模块名称（sys举例）
│ 
├─core         核心包
│    ├─entity  实体类包
│    │ 
│    ├─result  HTTP响应封装包
│    │ 
│    └─util	工具类包 
│        ├─CodeGenerator   代码自动生成器类
│        ├─YamlUtil        Yaml文件操作类
│       
│ 
├─dto          数据传输对象类包
│    ├─sys     业务模块
├─entity       实体类包
│    ├─sys     业务模块
├─mapper       mapper接口类包
│    ├─sys     业务模块
├─service      服务类包
│    ├─sys     业务模块
├─serviceImpl  服务实现类包
│    ├─sys     业务模块
├─resources
│    ├─mapper          SQL脚本
│       └─sys     		   业务模块
│    ├─templates	   代码生成器模板(velocity)
│    ├─application.yml 全局配置文件
│    └─generator.yml   代码生成器，配置文件
│
```

## 使用教程

### 自定义配置

修改generator.yml

```yaml
#作者名称
author: shenbinfeng
datasource:
  url: jdbc:mysql://localhost:3306/legal?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true&allowPublicKeyRetrieval=true
  #更改为自己的数据库名称及密码
  username: root
  password: 123456
  driverName: com.mysql.cj.jdbc.Driver
#包名
packageParent: com.shen.sample
#自定义文件输出路径
path: /src/main/java/com/shen/sample
#实体类父类位置
superEntityClass: com.shen.sample.entity.BaseId
templatePath:
  controller: templates/controller.java.vm
  service: templates/service.java.vm
  serviceImpl: templates/serviceImpl.java.vm
  entity: templates/entity.java.vm
  mapper: templates/mapper.java.vm
  mapperXml: templates/mapper.xml.vm
  inDto: templates/demoInDTO.java.vm
  outDto: templates/demoOutDTO.java.vm
  queryDto: templates/demoQueryDTO.java.vm
```

### 启动代码生成器

效果图

![image-20200415214152729](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20200415214152729.png)

### 演示效果


<video src="D:\setup\迅雷影音\Xmp\profiles\截图\20200415_21311120204152136532.mp4"></video>

### 接口文档效果

![image-20200415215256842](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20200415215256842.png)

![image-20200415215344225](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20200415215344225.png)