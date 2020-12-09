package com.pc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author: Peter
 * @date: 2020/12/6 23:45
 */
public class HelloController implements Controller {
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        System.out.println(this.getClass().getName() +": "+ "Hello, Controller");
        return new ModelAndView("jsp/hello");
    }
}
