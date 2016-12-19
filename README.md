## 基本介绍

该部分内容包括了使用PACT测试EventCompositeService和EventService、ReviewService之间的接口。

#### 测试EventCompositeService
```
cd event-composite-service
./gradlew test

```

运行如上命令，将生成类似target/*****.json的PACT文件


#### 测试EventService
```
cd event-service
./gradlew pactVerify

```

运行如上命令，将使用EventCompositeService生成的PACT文件进行验证

#### 测试ReviewService
```
cd review-service
./gradlew pactVerify

```
运行如上命令，将使用EventCompositeService生成的PACT文件进行验证

#### 启动pact-broker

```
cd pact-broker && docker-compose up -d
```

open `localhost:8888`

