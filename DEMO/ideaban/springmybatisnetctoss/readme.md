# 笔记

### 1. 修改 spring xml 配置文件的路径后报错

`java.io.FileNotFoundException: Could not open ServletContext resource [/WEB-INF/dispatcher-servlet.xml]`

参考：[关于SpringMVC项目报错](https://www.cnblogs.com/yxdz/p/7528351.html)

注意：`web.xml` 中为 spring servlet 添加 `<init-param>`

??? 将 dispatch-servlet.xml 放在 WEB-INF 下，并将所有配置放在其中。

[applicationContext.xml和dispatcher-servlet.xml的区别](https://www.cnblogs.com/parryyang/p/5783399.html)

