
# SpringBoot3整合Sa-token+MyBatis


![Static Badge](https://img.shields.io/badge/Spring_Boot-v3.0.6-green?style=flat)  ![Static Badge](https://img.shields.io/badge/Mybatis_Spring-v3.0.2-red?style=flat)  ![Static Badge](https://img.shields.io/badge/Graalvm-v0.9.23-blue)

使用GraalVM将Spring Boot编译为原生可执行文件
<br>半秒完成Spring Boot启动

## 注意事项

使用本项目前请注意先配置以下环境:

* GraalVM 22.3
* [GraalVM JDK 17+](https://www.graalvm.org/downloads/#)
* Spring Boot 3.0.6
* MyBatis Spring Boot 3.0.2



## 项目设计需求

* 提供在本地Windows的SpringBoot项目供客户端前台调用
* 主要实现登录权限校验与数据库存储

## 构建实现

### 运行docker

Start docker container for building native image.

```
docker run -v $(pwd):/work -v $HOME/.m2:/root/.m2 -it -w /work \
  -e JAVA_HOME=/opt/graalvm-ce-java17-22.3.2 \
  -e GRAALVM_HOME=/opt/graalvm-ce-java17-22.3.2 \
  -e LANG=C.utf8　\
  ghcr.io/graalvm/graalvm-ce:22.3.2 bash
```

### 构建原生程序

不建议使用idea的终端直接运行此命令，最好是进入项目文件夹 /bridge-report-api/ 开启PS或者cmd执行此命令

因为系统环境变量的更新对idea的终端不起作用，需要重启才能生效，这对调试带来很大的麻烦

```
./mvnw -Pnative clean native:compile
```

## 如何运行

直接点击exe文件 (WIN) <br>或者使用命令

```
./target/bridge-report-native 
```

如果启动后提示XML没有权限

添加下面的参数启动

```
-Djavax.xml.accessExternalDTD=all
```

## 其他版本

本机构建的环境版本如下 <br>
Visual Studio 2022:17.6.4 <br>
MSVC-v143-2022-C++-x64/86: 14.36.32532 <br>
Windows Kits(Windows 10 SDK):10.0.20348.0  <br>
