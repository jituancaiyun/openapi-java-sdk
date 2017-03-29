# openapi-java-sdk 使用说明

### 1. maven pom.xml 增加如下依赖 

```xml
<dependency>
    <groupId>com.shinemo.openapi</groupId>
    <artifactId>openapi-client</artifactId>
    <version>1.0.1</version>
</dependency>
```

### 2.spring 配置 ```open-api-spring.xml```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--open api configuration-->
    <bean id="openApiConfiguration" class="com.shinemo.openapi.client.OpenApiConfiguration">
        <property name="appId" value="94181123"/><!--应用ID-->
        <property name="appSecret" value="6fe73d451cd37f8a"/><!--应用密钥-->
        <property name="baseUrl" value="http://10.0.10.49:8081/openapi/"/><!--open api 接口地址 必须以"/"结尾-->
        <property name="connectTimeoutMillis" value="3000"/><!--建立http连接超时时间, 默认10s-->
        <property name="writeTimeoutMillis" value="2000"/><!--发送数据超时时间, 默认10s-->
        <property name="readTimeoutMillis" value="2000"/><!--读取数据超时时间, 默认10s-->
        <property name="maxRetry" value="1"/><!--最大失败重试次数, 默认不重试-->
    </bean>

    <!--open api client-->
    <bean id="openApiClient" class="com.shinemo.openapi.client.spring.OpenApiClientFactoryBean">
        <property name="configuration" ref="openApiConfiguration"/>
    </bean>

    <!--通讯录接口服务-->
    <bean id="contactApiService" class="com.shinemo.openapi.client.spring.OpenApiServiceFactoryBean">
        <property name="apiServiceFactory" ref="openApiClient"/>
        <property name="interfaceName" value="com.shinemo.openapi.client.service.ContactApiService"/>
    </bean>
</beans>
```
