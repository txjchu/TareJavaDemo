# 笔记


实现NETCTOSS登录功能。

### 方案

开发准备：

1. 创建项目、导入jar包
2. 配置web.xml
3. 配置Spring配置文件
4. 建表

打开登录页开发步骤：

1. 在Controller中增加打开登录页的方法
2. 创建登录页面

提交登录验证开发步骤：

1. 在DAO中增加根据账号查询用户的方法
2. 在Service中增加验证账号和密码的方法
3. 在Controller中增加登录验证的方法
4. 修改登录页面，设置表单



### **知识点**

#### 1. Spring 中的注解

#### 2. Spring 的 web 配置

#### 3. Spring 中 `dispatcher-servlet.xml` 与 `applicationContext.xml` 的区别

#### 4. SQLException 的处理

#### 5. Spring+maven+Junit 测试的使用

#### 6. Spring 中路径的 （classpath:）

#### 7. Spring 的配置注入

#### 8. Spring 中前后端数据交互的方式

#### 9. 启动时注意`cache`、`<mvc:annotation-driven/>`
        NoSuchBeanDefinitionException: No bean named 'cacheManager' available
#### 10. SpringMVC 四种方法解决表单到后台的日期类型转换
   [SpringMVC 四种方法解决表单到后台的日期类型转换](https://blog.csdn.net/wn084/article/details/80171687)

### day05 知识点

#### 1. 使用spring提供的过滤器解决表单中文参数问题

   注意：
    a.表单提交方式必须为post
    b.表单所在的页面的编码与
    过滤器的编码必须一致，比如
    都为"utf-8"
     
     <!--使用Spring自带的编码解析器处理前后端中文乱码的问题-->
         <!--需要注意的是表单数据以POST方式提交，页面编码方式要与过滤器编码方式一致。-->
         <filter>
             <filter-name>encodingFilter</filter-name>
             <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
             <init-param>
                 <param-name>encoding</param-name>
                 <param-value>UTF-8</param-value>
             </init-param>
         </filter>
         <filter-mapping>
             <filter-name>encodingFilter</filter-name>
             <url-pattern>/*</url-pattern>
         </filter-mapping>
				
#### 2.spring的异常处理

  有三种方式：

1) 使用SpringMVC 提供的简单异常处理器：`SimpleMappingExceptionResolver` .
    
        <!--处理系统异常-->
        <!--使用 SpringMVC 提供的简单异常控制器处理系统异常-->
        <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
            <property name="exceptionMappings">
                <props>
                    <prop key="java.lang.Exception">main/error</prop> <!--系统异常处理方式为返回指定的异常页面-->
                </props>
            </property>
        </bean>

2) 实现 `HandlerExceptionResolver` 接口，自定义异常处理器。
3) 使用 `@ExceptionHandler` 注解实现异常处理。 

      在`LoginController.java` 中进行程序异常处理

        /**
         * 使用 @ExceptionHandler 注解处理应用内异常
         * 捕捉不同异常后，进行不同的处理
         *
         * 该方式处理异常后，将替代原 checkLogin() 方法中处理异常的过程
         * @param request
         * @param response
         * @param e
         * @return
         */
        @ExceptionHandler
        public String execute(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
            if(e instanceof AdminCodeException || e instanceof PasswordException){
                // 业务异常自己处理
                request.setAttribute("message", e.getMessage());    // 在抛出异常时，这里自定义的异常都已经设置了不同的 message
                request.setAttribute("adminCode", request.getParameter("adminCode"));
                request.setAttribute("password", request.getParameter("password"));
                return "main/login";    // 返回登录页面
            } else {
                // 如果是其他异常，则抛出给 Spring 容器处理
                throw e;
            }
        }

4) 注意：
   (1)对于系统异常，在配置文件当中配置异常解析器。
   (2)对于应用异常，使用 @ExceptionHandler 来处理。
   
   
   
#### 3. SpringMVC 中的拦截器

##### 3.1 拦截器必须实现 `HandlerInterceptor` 接口。该接口有3个方法。
   1. `preHandler(...)` 处理器执行前被调用。返回 true 则继续执行其他拦截器和处理器。
   2. `postHandler(...)` 处理器执行后、视图处理前调用。此时可通过 `ModlerAndView` 对象对模型数据进行处理，或对视图进行处理。
   3. `afterCompletion(...)` 整个请求处理完后调用。如性能监控中我们可以在此记录结束时间，并输出消耗时间，还可以进行一些资源的清理。
        只有 `preHandler()` 方法返回 `true` 时才会执行该方法。
        
##### 3.2 xml 中配置：
   
        
        <!--拦截器 -->
        <mvc:interceptors>
            <mvc:interceptor>
                <mvc:mapping path="/**"/>
                <bean class="com.pc.netctoss.interceptor.FirstInterceptor"/>
            </mvc:interceptor>
        </mvc:interceptors>
        
##### 3.3 自定义拦截器时，需要实现`HandlerInterceptor`接口的所有方法，如果只需要用到某一个方法，可以继承`HandlerInterceptorAdapter`.(adapter:适配器)  