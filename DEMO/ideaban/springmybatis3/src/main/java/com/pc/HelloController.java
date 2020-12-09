package com.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: Peter
 * @date: 2020/12/7 1:55
 */
@Controller         // 当使用 @Controller 注解后，会自动实现 Controller 接口
@RequestMapping("/demo")
public class HelloController {

    @RequestMapping("/hello.do")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        System.out.println(this.getClass().getName() +": "+ "Hello, Controller");
        // 因为在 applicationContext.xml 中配置了 viewResolver bean 的前后缀参数，因此不能加.jsp
        return new ModelAndView("jsp/hello");
    }
}
