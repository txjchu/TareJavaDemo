# 笔记


### 1.spring + mybatis 方式一

使用MapperScannerConfigurer扫描所有Mapper映射器接口，实现Spring整合MyBatis，完成对员工表的查询。

方案：在applicationContext.xml中配置MapperScannerConfigurer，用它来自动扫描指定包下的所有Mapper映射器。

    <!--注册数据源 DataSource-->
    <util:properties id="jdbc" location="classpath:properties/jdbc.properties"/>
    <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="#{jdbc.driver}"/>
        <property name="url" value="#{jdbc.url}"/>
        <property name="username" value="#{jdbc.username}"/>
        <property name="password" value="#{jdbc.password}"/>
    </bean>
    
    <!--SqlSession 工厂-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactory">
        <property name="dataSource" ref="ds"/>
        <property name="mapperLocations" value="classpath:com/pc/demo/dao/xml/*.xml"/>
    </bean>

    <!-- 扫描指定包下所有的接口 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.pc.demo.dao" />
    </bean>
    
### 2. spring + mybatis 方式二

使用MapperScannerConfigurer扫描带有注解的Mapper映射器接口，实现Spring整合MyBatis。

方案：创建一个自定义注解，然后在applicationContext.xml中配置MapperScannerConfigurer，用它来自动扫描指定包下的带有这个注解的Mapper映射器。

```
/**
 * spring+mybatis 整合方式二
 *
 * 自定义注解
 * 用来注解实体类的 mapper 接口，结合对应的 xml 来实现 mybatis 对数据库的操作
 *
 * 需要在 spring-confing.xml 中的 bean : org.mybatis.spring.mapper.MapperScannerConfigurer 中配置一个 property 声明注解类 annotationClass。
 * @author: Peter
 * @date: 2020/12/16 21:00
 */
public @interface Mapper {
}
```

修改 `dispatcher-servlet.xml`：

```
    <!-- 扫描指定包下带有注解@MyBatisRepository的接口 -->    
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.tarena.dao" />
        <property name="annotationClass" 
            value="com.tarena.annotation.MyBatisRepository"/>
    </bean>
```

### 3. spring+mybatis 方式三

使用SqlSessionTemplate的方式整合MyBatis，实现对xx表的增删改查。

方案：声明SqlSessionTemplate，并注入数据访问组件，利用它所提供的API，实现对xx表的增删改查。

第一步：`dispatcher-servlet.xml` 中添加
```    
    <!--spring+mybatis 方式三 使用 SqlSessionTemplate-->
    <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
       <constructor-arg ref="sqlSessionFactory" index="0"/>
    </bean>
```
第二步：

