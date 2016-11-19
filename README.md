## 基本介绍

该部分内容包括了使用PACT测试EventCompositeService和EventService、ReviewService之间的接口。

#### 测试EventCompositeService
```
cd event-composite-service
./gradlew test

```

#### 测试EventService
```
cd event-service
./gradlew pactVerify

```

#### 测试ReviewService
```
cd review-service
./gradlew pactVerify

```