# openapi-java-sdk 使用说明

### 1. maven pom.xml 增加如下依赖 

```
<dependency>
    <groupId>com.jituancaiyun.openapi</groupId>
    <artifactId>openapi-client</artifactId>
    <version>x.y.z</version>
</dependency>
```

```
sdk 通讯录接口有更新，如果没有使用到通讯录接口，可使用原1.5.1依赖
https://github.com/jituancaiyun/openapi-java-sdk/releases/tag/1.5.5-SNAPSHOT
```

### 2.手动创建,以免登接口为例
```java
public class AuthApiServiceTest {

    private OpenApiClient openApiClient;
    private AuthApiService authApiService;

    @Before
    public void setUp() throws Exception {
        OpenApiConfiguration configuration = new OpenApiConfiguration();
        //开放平台接口基础地址,以"/"结尾
        configuration.setBaseUrl("http://10.0.10.49:8081/openapi/");
        //应用ID
        configuration.setAppId(94181123);
        //应用密钥                 
        configuration.setAppSecret("6fe73d451cd37f8a");
        //建立http连接超时时间, 默认10s      
        configuration.setConnectTimeoutMillis(3000);
        //最大失败重试次数, 默认不重试         
        configuration.setMaxRetry(1);                                
        
        openApiClient = configuration.create();
        authApiService = openApiClient.createApiService(AuthApiService.class);
    }

    @Test
    public void login() throws Exception {
        //token从客户端获取
        String token = "ODQwNjk3fDgwZTg3YzM5YmNiYTc0Mjc1ZTcwNDg1ZjM2NzU1OWVifDE0ODk5Nzk0NzYwMDA=";
        OpenApiResult<UserInfoDTO> result = authApiService.login(token);
        System.out.println(result);
    }
}
```
### 一.spring 配置 ```open-api-spring.xml```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--==============================================OpenApiClient配置=================================================-->
    <!--open api configuration-->
    <bean id="openApiConfiguration" class="com.shinemo.openapi.client.OpenApiConfiguration">
        <property name="appId" value="94181123"/><!--应用ID-->
        <property name="appSecret" value="6fe73d451cd37f8a"/><!--应用密钥-->
        <property name="appToken" value="12345678"/><!--应用token, 用于回调签名-->
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

    <!--==============================================AES密钥服务配置=================================================-->
    <!--密钥服务数据源, 生产环境可以换成数据源实现, DriverManagerDataSource不推荐使用到生产环境-->
    <bean name="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://10.0.10.41:3306/shinemo_openapi"/>
        <property name="username" value="root"/>
        <property name="password" value="shinemo123"/>
    </bean>

    <!--密钥服务数据查询对象-->
    <bean id="aesKeyDao" class="com.shinemo.openapi.client.aes.db.MysqlAesKeyDao" init-method="init">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--密钥服务-->
    <bean id="aesKeyService" class="com.shinemo.openapi.client.aes.DefaultAesKeyService" init-method="init">
        <property name="authApiService" ref="authApiService"/>
        <property name="aesKeyDao" ref="aesKeyDao"/>
        <property name="limit" value="10"/>
    </bean>

    <!--==============================================OpenApi接口服务配置=================================================-->
    <!--免等接口服务-->
    <bean id="authApiService" class="com.shinemo.openapi.client.spring.OpenApiServiceFactoryBean">
        <property name="apiServiceFactory" ref="openApiClient"/>
        <property name="interfaceName" value="com.shinemo.openapi.client.service.AuthApiService"/>
    </bean>

    <!--通讯录接口服务-->
    <bean id="contactApiService" class="com.shinemo.openapi.client.spring.OpenApiServiceFactoryBean">
        <property name="apiServiceFactory" ref="openApiClient"/>
        <property name="interfaceName" value="com.shinemo.openapi.client.service.ContactApiService"/>
    </bean>

    <!--会议邀请接口服务-->
    <bean id="meetingApiService" class="com.shinemo.openapi.client.spring.OpenApiServiceFactoryBean">
        <property name="apiServiceFactory" ref="openApiClient"/>
        <property name="interfaceName" value="com.shinemo.openapi.client.service.MeetingApiService"/>
    </bean>

    <!--消息推送接口服务-->
    <bean id="messageApiService" class="com.shinemo.openapi.client.spring.OpenApiServiceFactoryBean">
        <property name="apiServiceFactory" ref="openApiClient"/>
        <property name="interfaceName" value="com.shinemo.openapi.client.service.MessageApiService"/>
    </bean>

    <!--加密消息推送接口服务-->
    <bean id="securityMessageApiService" class="com.shinemo.openapi.client.service.SecurityMessageApiService" init-method="init">
        <property name="messageApiService" ref="messageApiService"/>
        <property name="aesKeyService" ref="aesKeyService"/>
    </bean>

    <!--==============================================OpenApiServlet配置=================================================-->
    <!--查询密钥servlet, 该servlet会被自动部署到tomcat, 不需要手动添加到web.xml, 默认path为/queryKey-->
    <bean id="openApiAesKeyServlet" class="com.shinemo.openapi.client.web.OpenApiAesKeyServlet">
        <property name="openApiClient" ref="openApiClient"/>
        <property name="aesKeyService" ref="aesKeyService"/>
    </bean>

    <!--接收开放平台回调通知servlet, 该servlet会被自动部署到tomcat, 不需要手动添加到web.xml, 默认path为/callback-->
    <bean id="openApiCallbackServlet" class="com.shinemo.openapi.client.web.OpenApiCallbackServlet">
        <property name="callbackEventReceiver" ref="com.xxx.MyCallbackEventReceiver"/>
    </bean>
</beans>
```

### 二.springboot 初始化bean
```java
@Configuration
public class BeanConfiguration {

    @Bean(name = "openApiClient")
    @ConditionalOnMissingBean(OpenApiClient.class)
    public OpenApiClient openApiClient() {
        OpenApiConfiguration configuration = new OpenApiConfiguration();
        //开放平台接口基础地址,以"/"结尾
        configuration.setBaseUrl("https://openapi.e.uban360.com/platform/");
        //应用ID
        configuration.setAppId(xxxxx);
        //应用密钥
        configuration.setAppSecret("xxxxxxxxxx");
        //建立http连接超时时间, 默认10s
        configuration.setConnectTimeoutMillis(10 * 1000);
        //http写超时时间
        configuration.setWriteTimeoutMillis(10 * 1000);
        //http读超时时间
        configuration.setReadTimeoutMillis(10 * 1000);
        //最大失败重试次数, 默认不重试
        configuration.setMaxRetry(1);
        return configuration.create();
    }

    @Bean(name = "messageApiService")
    @ConditionalOnBean(OpenApiClient.class)
    @ConditionalOnMissingBean(MessageApiService.class)
    public MessageApiService messageApiService(final OpenApiClient openApiClient) {
        return openApiClient.createApiService(MessageApiService.class);
    }
}
```
