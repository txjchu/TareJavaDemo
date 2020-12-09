#笔记：
### 1 实战案例

#### 1.1 问题

a. 练习接收页面参数值

b. 练习向页面传出数据

c. 练习使用session

d. 练习重定向




#### 1.2 方案

1) 接收页面参数值有3种方式

    a. 使用request

    b. 使用@RequestParam注解

    c. 使用实体对象

2) 向页面传出数据有3种方式

    a. 使用ModelAndView对象

    b. 使用ModelMap对象

    c. 使用@ModelAttribute注解

3) 在Controller方法参数上直接声明HttpSession即可使用

4) 重定向有2种方式

    a. 使用RedirectView

    b. 使用redirect: