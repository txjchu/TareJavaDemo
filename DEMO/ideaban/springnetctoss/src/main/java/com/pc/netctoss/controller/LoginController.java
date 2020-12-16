package com.pc.netctoss.controller;

import com.pc.netctoss.entity.AdminInfo;
import com.pc.netctoss.exception.AdminCodeException;
import com.pc.netctoss.exception.PasswordException;
import com.pc.netctoss.service.AdminInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * 登录控制器
 * @author: Peter
 * @date: 2020/12/10 19:32
 */
@Controller
@RequestMapping("/login")
public class LoginController implements Serializable {

    @Resource
    private AdminInfoService adminInfoService;


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


    /**
     * 进入登录页
     * @return
     */
    @RequestMapping("/toLogin.do")
    public String toLogin(){
        return "main/login";
    }

    /**
     * 进入首页
     * @return
     */
    @RequestMapping("/toIndex.do")
    public String toIndex(){
        return "main/index";
    }

    /**
     * 验证账号密码
     * @param adminCode
     * @param password
     * @param modelMap
     * @param session // 为何可以直接使用，而不需要从 request 对象中获取
     * @return
     */
    @RequestMapping("/checkLogin.do")
    public String checkLogin(String adminCode, String password, ModelMap modelMap, HttpSession session) throws SQLException {

        // 使用 @ExceptionHandler 注解处理异常后，此处就不需要如此
//        try {
//            AdminInfo adminInfo = adminInfoService.checkAdminCodeAndPwd(adminCode, password);
//            session.setAttribute("adminInfo", adminInfo);
//        } catch (AdminCodeException e) {
//            modelMap.addAttribute("message", e.getMessage());
//            modelMap.addAttribute("adminCode", adminCode);
//            modelMap.addAttribute("password", password);
//            return "main/login";
//        } catch (PasswordException e){
//            modelMap.addAttribute("message", e.getMessage());
//            modelMap.addAttribute("adminCode", adminCode);
//            modelMap.addAttribute("password", password);
//            return "main/login";
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Integer.valueOf("abc");   // 模拟系统异常，使用 SpringMVC 提供的简单异常机制处理

        AdminInfo adminInfo = adminInfoService.checkAdminCodeAndPwd(adminCode, password);
        session.setAttribute("adminInfo", adminInfo);
        return "redirect:toIndex.do";
    }


}
