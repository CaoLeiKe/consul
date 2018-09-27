# consul
因项目配置文件过多且变更比较频繁，故通过脚本把key对应的value放入console中。
##配置文件的定义
resources目录下develop.ini，通过写好的脚本执行加上参数可以直接放入console中
## 实现原理
* 定义接口、定义方法`com.zd.configuration`
* 使用注解在接口的方法上进行定义`@ConsulNameSpace、@ConsulKey`的url值
* 通过动态代理的方式获取接口方法上的注解的url值，请求console的结果进行返回
* 研究Spring源码，把动态代理注入到容器中，应用直接@Autowired即可

## 项目结构
* `com.zd.configuration`定义地址
* `com.zd.consul`进行实现
* `com.zd.consul.methodProxy`动态代理实现方法
* `com.zd.consul.core`注入Spring容器方法的实现

___

### 使用方法
* 配置
    * SpringBoot  
    @EnableConsulConfiguration 在启动类加上即可
    * Spring xml
        ```xml
            <bean class="com.zd.consul.core.ConsulScannerConfigurer">
                <!-- consul接口所在包名，Spring会自动查找其下的接口，可以配置多个包 -->
                <property name="basePackage" value="com.zd.configuration"/>
                <!-- 指定注解，被注解的接口可以被扫描，如果没有配置，则扫描包下的所有的接口 -->
                <property name="annotationClass" value="com.zd.consul.annotation.ConsulNameSpace"/>
                <!-- 获取consulValueBase64转化String的编码 -->
                <property name="charsetName" value="utf-8"/>
                <!-- console主机 -->
                <property name="host" value="${consul.host}"/>
                <!-- console端口 -->
                <property name="port" value="8500"/>
            </bean>
        ```
* 使用  
    * 如果已经配置，那代理实现得方法已经注入到容器中，从容器获取该对象即可
    * 如果没有配置，则通过方法获取实现`ConsulProxy.getProxyObj(接口.class)`
