package com.pc.controller;

import com.pc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 笔记
 * SpringMVC 中控制器与前端页面数据交互
 * @author: Peter
 * @date: 2020/12/8 1:07
 */
@Controller
@RequestMapping("/demo")
public class UserController {

    /**
     * 使用 Request 对象接收参数
     * Spring 自动参数注入进 request 对象中，
     * 优点是比较直接，缺点是需要自己处理数据类型的转换。
     * @param request
     * @return
     */
    @RequestMapping("/test1.do")
    public ModelAndView test1(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(this.getClass().getName() +": "+ "username : "+ userName +", password : " +password);
        return new ModelAndView("jsp/hello");
    }

    /**
     * Spring 会自动将表单中的数据注入到方法的参数中，要求参数名一致。
     * 可以使用@RequestParam("")注解映射不一致的名称。
     * 优点是自动转换类型，缺点是可能类型转换异常。
     * @param userName
     * @param pwd
     * @return
     */
    @RequestMapping("/test2.do")
    public ModelAndView test2(String userName, @RequestParam("password") String pwd){
        System.out.println(this.getClass().getName() +": "+ "username : "+ userName +", pwd : " +pwd);
        return new ModelAndView("jsp/hello");
    }

    /**
     * Spring 使用自动机制封装成 bean 实体类，要求实体类的属性名与表单组件的name相同
     * @param user
     * @return
     */
    @RequestMapping("/test3.do")
    public ModelAndView test3(User user){
        System.out.println(this.getClass().getName() +": "+ "userName : "+ user.getUserName() +", password : "+ user.getPassword());
        return new ModelAndView("jsp/hello");
    }


    /**
     * 使用 ModelAndView 向页面传输数据
     * 将数据封装为一个 Map 后，放入 ModelAndView 中即可传到 jsp 页面中。
     * ModelAndView 会利用 HttpServletRequest 对象的 Attribute 传递数据。
     * @return
     */
    @RequestMapping("/test4.do")
    public ModelAndView test4(){
        Map<String, Object> date = new HashMap<String, Object>();
        date.put("success", true);
        date.put("message", "操作成功！");
        return new ModelAndView("jsp/hello", date);
    }


    /**
     * 使用 ModelMap 传出数据
     * 在方法的参数列表中添加 ModelMap 参数即可。
     * ModelMap 会利用 HttpServletRequest 对象的 Attribute 传递到 jsp 页面。
     * ModelMap 继承与 LinkedHashMap（LinkedHashMap 实现了 Map 接口）
     * @param model
     * @return
     */
    @RequestMapping("/test5.do")
    public ModelAndView test5(ModelMap model){
        model.addAttribute("success", false);
        model.addAttribute("message", "操作失败！");
        return new ModelAndView("jsp/hello");
    }

    /**
     * 使用 @ModelAttribute("")传出数据
     * @ModelAttribute 会使用 HttpServletRequest 对象的 Attribute 传输数据。
     * @ModelAttribute 可以使用在控制器 Controller 的方法参数前，
     * 或者使用在 Bean 属性的方法上。
     *
     *
     * @return
     */
    @ModelAttribute("age")
    public int getAge(){
        return 24;
    }
    // 将 index.jsp 中 form 提交请求改为 test6.do
    // @ModelAttribute("xxx") 注解中参数名必须与接收时一致，且方法的参数名也要与接收时一致。
    @RequestMapping("/test6.do")
    public ModelAndView test6(@ModelAttribute("userName") String userName, String password){
        System.out.println(this.getClass().getName() +": "+ userName +", "+ password);
        return new ModelAndView("jsp/hello");
    }

    /**
     * 获取 Request 的 session 传输数据
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/test7.do")
    public ModelAndView test7(HttpServletRequest request, User user){
        HttpSession session = request.getSession();
        session.setAttribute("salary", 6000);
        session.setAttribute("user", user);
        return new ModelAndView("jsp/hello");
    }

    /**
     * 返回 String ，表示返回的页面，其中使用 User 接收数据，使用 ModelMap 传输数据。
     * 注意 index.jsp 表单提交的路径
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping("/test8.do")
    public String test8(User user, ModelMap modelMap){
        modelMap.addAttribute("user", user);
        return "jsp/hello";
    }

    /**
     * 进入错误页面
     * @return
     */
    @RequestMapping("/test9.do")
    public String test9(){
        return "jsp/error";
    }

    /**
     * 重定向方式一
     * 使用 RedirectView 视图，指定重定向的路径，从最后一个 / 分隔符开始改变url路径。
     * @param user
     * @return
     */
    @RequestMapping("/test10.do")   // 注意修改 index.jsp 表单提交路径
    public ModelAndView test10(User user){
        if("admin".equals(user.getUserName())){
            return new ModelAndView("jsp/hello");
        } else {
            return new ModelAndView(new RedirectView("test9.do")); //
        }
    }

    /**
     * 重定向方式二
     * 如果方法的返回值是 String 类型，则可以
     * 使用 redirect:url  方式重定向到某个请求。
     * @param user
     * @return
     */
    @RequestMapping("/test11.do")
    public String test11(User user){
        if("admin".equals(user.getUserName())){
            return "jsp/hello";
        } else {
            return "redirect:test9.do";
        }
    }


}
