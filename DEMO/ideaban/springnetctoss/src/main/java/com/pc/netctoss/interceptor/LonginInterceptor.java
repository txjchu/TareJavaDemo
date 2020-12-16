package com.pc.netctoss.interceptor;

import com.pc.netctoss.entity.AdminInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录验证拦截器
 * 登录成功后会为 session 中添加 adminInfo 对象，如果新的请求中，检测到 session 中没有 adminInfo 对象，则返回登录页。
 * @author: Peter
 * @date: 2020/12/12 2:45
 */
public class LonginInterceptor implements HandlerInterceptor {

    /**
     * 处理请求前执行该方法进行判断。
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AdminInfo adminInfo = (AdminInfo) request.getSession().getAttribute("adminInfo");   // 必须与控制器中登录成功后为 session 添加的对象名一致。
        if (adminInfo == null){
            response.sendRedirect(request.getContextPath() +"/login/toLogin.do");
            return false;
        }
        return true;    // 如果验证成功，则继续请求的后续处理。
    }

    /**
     * 处理器执行后、视图处理前调用。
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 整个请求处理完成后执行。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
