package com.pc.netctoss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * 进入首页控制器组件
 *
 * 先经过拦截器判断 session 中是否有用户信息，如果有则进入首页。
 * 注意 Controller 上的 @RequestMapping 映射的请求路径为空。
 * @author: Peter
 * @date: 2020/12/12 20:41
 */
@Controller
@RequestMapping
public class IndexController implements Serializable {

    @RequestMapping("index.do")
    public String toIndex(){
        return "main/index";
    }
}
