package web;

import dao.*;
import entity.Account;
import entity.AdminInfo;
import entity.Cost;
import utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 1. 此 Servlet 处理项目所有的请求，充当控制器 Controller
 * 2. 处理需要响应的数据，并转发给对应的 JSP 处理。
 * @author: Peter
 * @date: 2020/10/3 23:07
 */
public class ActionServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 统一设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        // 判断请求路径
        // 因为分模块处理( /cost/list.do )，因此需要判断 uri 中模块部分的路径，所以此处采用字符串匹配除去`项目部署名`路径后的全路径。
        String uri = req.getRequestURI();
        System.out.println(this.getClass().getName() +"完整 URI："+ uri);
        // req.getContextPath() 获取到的是项目部署名路径
        uri = uri.replace(req.getContextPath(),"");
        System.out.println(this.getClass().getName() +"截取后的 URI："+ uri);
//        System.out.println("项目部署名："+ req.getContextPath());

        if("/index.do".equals(uri)){
            // 进入首页
            toIndex(req, resp);
        } else if ("/toLogin.do".equals(uri)){
            // 进入登录页
            toLogin(req, resp);
        } else if ("/login.do".equals(uri)){
            // 登录
            login(req, resp);
        } else if ("/logout.do".equals(uri)){
            // 退出登录状态
            logout(req, resp);
        } else if("/cost/list.do".equals(uri)){
            // 资费查询
            findCost(req, resp);
        } else if ("/cost/toAdd.do".equals(uri)){
            // 打开新增资费页
            toAddCost(req, resp);
        } else if ("/cost/add.do".equals(uri)){
            // 新增资费
            addCost(req, resp);
        } else if ("/cost/toUpdate.do".equals(uri)){
            // 打开修改资费页面
            toUpdateCost(req, resp);
        } else if("/cost/update.do".equals(uri)){
            // 修改资费
            updateCost(req, resp);
        } else if("/cost/delete.do".equals(uri)){
            // 删除资费
            deleteCost(req, resp);
        } else if("/cost/startCost.do".equals(uri)){
            // 启动资费
            startCost(req, resp);
        } else if("/cost/toDetail.do".equals(uri)){
            // 打开资费详情页面
            toDetailCost(req, resp);
//        } else if("/cost/detail.do".equals(uri)){
//          // 资费详情页
//            detailCost(req, resp);
        } else if("/account/list.do".equals(uri)){
            // 账务账户列表页
            findAccount(req, resp);
        } else if ("/account/toAdd.do".equals(uri)) {
            // 打开添加新增账务账号页面
            toAddAccount(req, resp);
        } else if ("/account/add.do".equals(uri)) {
            // 新增账务账号
            addAccount(req, resp);
        } else if ("/account/delete.do".equals(uri)){
            // 删除账务账号记录
            deleteAccount(req, resp);
        } else if ("/account/update.do".equals(uri)){
            // 修改账务账号记录
            updateAccount(req, resp);
        } else if ("/account/toUpdate.do".equals(uri)){
            // 进入修改账务账号页面
            toUpdateAccount(req, resp);
        } else if ("/account/updateStatus.do".equals(uri)){
            // 修改账号账号开通暂停状态
//            startAccount(req, resp);
        } else if("/account/detail.do".equals(uri)){
            // 进入 账务账号 详情页面
            toDetailAccount(req, resp);
        }else if("".equals(uri)){

        }else if("".equals(uri)){

        }else if("".equals(uri)){

        }else if("".equals(uri)){

        }else if("".equals(uri)){

        }else if("".equals(uri)){

        }else if("".equals(uri)){

        }



    }


    /**
     * 进入登录页
     * @param req
     * @param resp
     */
    protected void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("../WEB-INF/login.jsp").forward(req, resp);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    /**
     * 登录
     * @param req
     * @param resp
     */
      // 无验证码验证
//    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
//        String adminCode = req.getParameter("adminCode");
//        String password = req.getParameter("password");
//        String vcode = req.getParameter("vcode");
//        IAdminInfoDAO dao = new AdminInfoDAOImpl();
//        AdminInfo adminInfo = null;
//        if(!StringUtil.IsEmpty(password) && !StringUtil.IsEmpty(adminCode)){
//            adminInfo = dao.findByCode(adminCode);
//        }
//        try {
//            if(adminInfo != null && adminInfo.getPassword().equals(password)){
//                resp.sendRedirect("index.do");
//            } else {
//                req.setAttribute("login_err", "用户名或密码错误！");
//                req.getRequestDispatcher("login.jsp").forward(req, resp);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new ServletException(e);
//        }
//    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminCode = req.getParameter("adminCode");
        String password = req.getParameter("password");
        String vcode = req.getParameter("vcode");

        String saveCookie = req.getParameter("saveCookie");
        Cookie adminCodeCookie = new Cookie("adminCode", adminCode);
        Cookie passwordCookie = new Cookie("password", password);
        if(saveCookie != null && "yes".equalsIgnoreCase(saveCookie)){ // 忽略大小写
            adminCodeCookie.setMaxAge(60 * 60 * 24 * 30); // 有效期1个月
            passwordCookie.setMaxAge(60 * 60 * 24 * 30);
        } else {
            adminCodeCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
        }
        resp.addCookie(adminCodeCookie);
        resp.addCookie(passwordCookie);

        // 验证验证码
        HttpSession session = req.getSession();
        String code = session.getAttribute("code").toString();
        if(vcode == null || !code.equalsIgnoreCase(vcode)){
            req.setAttribute("vcode_err", "验证码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            IAdminInfoDAO dao = new AdminInfoDAOImpl();
            AdminInfo adminInfo = null;
            if(!StringUtil.IsEmpty(password) && !StringUtil.IsEmpty(adminCode)){
                adminInfo = dao.findByCode(adminCode);
            }
            try {
                if(adminInfo != null && adminInfo.getPassword().equals(password)){
                    resp.sendRedirect("index.do");
                } else {
                    req.setAttribute("login_err", "用户名或密码错误！");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServletException(e);
            }

        }

    }

    /**
     * 进入首页
     * @param req
     * @param resp
     */
    protected void toIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
    }

    /**
     * 退出登录状态
     * 将 name 为 adminCode、password 2个 cookie 设置为失效
     * @param req
     * @param resp
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies){
            if("adminCode".equals(c.getName()) || "password".equals(c.getName())){
                c.setMaxAge(0);
                // 笔记 cookie 的用法，在设置完cookie 后需要再次将其 add 到resp对象中返回给客户端才能生效
                resp.addCookie(c);
            }
        }
        resp.sendRedirect("toLogin.do");
    }

    /**
     * 查询资费
     * @param req
     * @param resp
     */
    protected void findCost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CostDAOImpl dao = new CostDAOImpl();
            List<Cost> costs = dao.findAll();
            req.setAttribute("costs", costs);
            // 将请求转发给 jsp
            // 当前路径：/netctoss/cost/list.do
            // 目标：/netctoss/WEB-INF/cost/cost_list.jsp
            req.getRequestDispatcher("../WEB-INF/cost/cost_list.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("err_msg", "数据查询异常！");
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    /**
     * 打开新增资费页面
     * @param req
     * @param resp
     */
    protected void toAddCost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 当前方法(Servlet)的访问路径
        // /netctoss/cost/toAdd.do
        // jsp文件的存放路径，通过该路径可以找到
        // jsp，但是无法访问，因为受到WEB-INF的保护。
        // 通过转发就可以访问它了。
        // /netctoss/WEB-INF/cost/add_cost.jsp
        req.getRequestDispatcher("../WEB-INF/cost/add_cost.jsp").forward(req, resp);

    }

    /**
     * 新增资费
     * @param req
     * @param resp
     */
    protected void addCost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取相应对象中的数据
        String name = req.getParameter("name");
        String costType = req.getParameter("costType");
        String descr = req.getParameter("descr");
        String baseDuration = req.getParameter("baseDuration");
        String baseCost = req.getParameter("baseCost");
        String unitCost = req.getParameter("unitCost");
        // 构造 Cost 对象
        Cost cost = new Cost();
        cost.setName(name);
        cost.setDescr(descr);
        cost.setCostType(costType);
        /*
         * 因为资费的类型为包月、套餐、计时，
         * 当包月时，baseDuration unitCost 为空，
         * 当计时时，baseDuration baseCost 为空。
         * 因此需要在此处先判空再为对象赋值。与数据库交互时，数据库不做非空限制。
         */
        if(baseDuration != null && !baseDuration.equals("") ){
            cost.setBaseDuration(new Integer(baseDuration));
        }
        if(baseCost != null && !baseCost.equals("")){
            cost.setBaseCost(new Double(baseCost));
        }
        if(unitCost != null && !unitCost.equals("")){
            cost.setUnitCost(new Double(unitCost));
        }
        CostDAOImpl dao = new CostDAOImpl();
        dao.save(cost);

        //保存成功后重定向到查询资费页面
        // /netctoss/cost/add.do
        // /netctoss/cost/list.do
        resp.sendRedirect("list.do");
    }

    /**
     * 进入修改资费页面
     *
     * 根据 cost_id 获取到该条资费的数据填充到页面中.
     * @param req
     * @param resp
     */
    protected void toUpdateCost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String costId = req.getParameter("id");
        Cost cost = null;
        CostDAOImpl dao = new CostDAOImpl();
        if(!"".equals(costId) && costId != null){
            cost = dao.findById(Integer.parseInt(costId));
        }
        if(cost != null){
            req.setAttribute("cost", cost);
        }

        // /netctoss/cost/toAdd.do
        // /netctoss/WEB-INF/cost/update_cost.jsp
        req.getRequestDispatcher("../WEB-INF/cost/update_cost.jsp").forward(req, resp);
    }


    /**
     * 修改资费
     * 根据 id 获取到
     * @param req
     * @param resp
     */
    protected void updateCost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String costId = req.getParameter("costId");
        String name = req.getParameter("name");
        String costType = req.getParameter("costType");
        String baseDuration = req.getParameter("baseDuration");
        String baseCost = req.getParameter("baseCost");
        String unitCost = req.getParameter("unitCost");
        String descr = req.getParameter("descr");

        Cost cost = new Cost();
        cost.setCostId(new Integer(costId));
        cost.setName(name);
        cost.setCostType(costType);
        if(baseDuration != null && !baseDuration.equals("") ){
            cost.setBaseDuration(new Integer(baseDuration));
        }
        if(baseCost != null && !baseCost.equals("")){
            cost.setBaseCost(new Double(baseCost));
        }
        if(unitCost != null && !unitCost.equals("")){
            cost.setUnitCost(new Double(unitCost));
        }
        cost.setDescr(descr);

        CostDAOImpl dao = new CostDAOImpl();
        dao.update(cost);

        //重定向回查询
        // /netctoss/cost/update.do
        // /netctoss/cost/list.do
        resp.sendRedirect("list.do");
    }

    /**
     * 删除某条资费
     * @param req
     * @param resp
     */
    protected void deleteCost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String costId = req.getParameter("id");
        CostDAOImpl dao = new CostDAOImpl();
        dao.delete(new Integer(costId));
        // 删除成功后返回列表页
        resp.sendRedirect("list.do");
    }

    /**
     * 启动某条资费（变更资费状态）
     *
     * 新增资费的 status 为 null, 关闭为1,开通为0.
     * 当资费状态为 非0 时，该方法会将其改为0，
     * 若为 0 时，则会将其改为1.
     * @param req
     * @param resp
     */
    protected void startCost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String costId = req.getParameter("id");
        String status = req.getParameter("status");
        if("".equals(costId) || costId == null){
            return;
        }
        CostDAOImpl dao = new CostDAOImpl();
        Cost cost = new Cost();
        cost.setCostId(new Integer(costId));
        if("0".equals(status)){
            cost.setStatus("1");// 若启动，则改为关闭 1
        } else {
            cost.setStatus("0");// 若关闭，则改为启动 0
        }
        dao.updateStatus(cost);
        // 修改成功后返回列表页
        resp.sendRedirect("list.do");
    }

    /**
     * 进入资费详情页面
     * @param req
     * @param resp
     */
    protected void toDetailCost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String costId = req.getParameter("id");

        // 因为需要 req 中附带参数，因此不能使用重定向，重定向的第二次请求会更换 req 对象，绑定的数据会失效
        // resp.sendRedirect("detail.do");
        // 因为只有一个查询业务，因此不需要其他业务方法
        // req.getRequestDispatcher("detail.do").forward(req, resp);

        if(costId == null || "".equals(costId)){
            return;
        }
        ICostDAO dao = new CostDAOImpl();
        Cost cost = dao.findById(new Integer(costId));
        req.setAttribute("cost", cost);

        req.getRequestDispatcher("../WEB-INF/cost/cost_detail.jsp").forward(req, resp);

    }

    /**
     * 资费详情页 -- 作废
     * @param req
     * @param resp
     */
    protected void detailCost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String costId = (String) req.getAttribute("costId");

        ICostDAO dao = new CostDAOImpl();
        Cost cost = dao.findById(new Integer(costId));
        req.setAttribute("cost", cost);

        req.getRequestDispatcher("../WEB-INF/cost/cost_detail.jsp").forward(req, resp);
    }

    /**
     * 打开账务账户列表页
     * @param req
     * @param resp
     */
    protected void findAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAccountDAO dao = new AccountDAOImpl();
        List<Account> accounts = dao.findAll();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("../WEB-INF/account/account_list.jsp").forward(req, resp);
    }

    /**
     * 打开新增资费页面
     * @param req
     * @param resp
     */
    protected void toAddAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 当前方法(Servlet)的访问路径
        // /netctoss/account/toAdd.do
        // jsp文件的存放路径，通过该路径可以找到
        // jsp，但是无法访问，因为受到WEB-INF的保护。
        // 通过转发就可以访问它了。
        // /netctoss/WEB-INF/account/account_add.jsp
        req.getRequestDispatcher("../WEB-INF/account/account_add.jsp").forward(req, resp);

    }

    /**
     * 新增资费页面
     *
     * 对于身份证号、手机号、邮箱这类数据格式的验证，应该做到前后端都要验证。
     * 暂时不做验证
     * @param req
     * @param resp
     */
    protected void addAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String realName = req.getParameter("realName");
        String idcardNo = req.getParameter("idcardNo");
        String loginName = req.getParameter("loginName");
        String loginPasswd = req.getParameter("loginPasswd");
        String telephone = req.getParameter("telephone");

        String recommenderId = req.getParameter("recommenderId");

        // 此处应先对 idcardNo 进行格式验证
        // 截取身份证号中第 7-14 位为出生年月
        String birthdate = idcardNo.substring(6, 14);
        String email = req.getParameter("email");
        String occupation = req.getParameter("occupation");
        String gender = req.getParameter("gender");

        String mailaddress = req.getParameter("mailaddress");
        String zipcode = req.getParameter("zipcode");
        String qq = req.getParameter("qq");

        Account account = new Account();
        account.setRealName(realName);
        account.setIdcardNo(idcardNo);
        account.setLoginName(loginName);
        account.setLoginPasswd(loginPasswd);
        account.setTelephone(telephone);
        account.setRecommenderId(recommenderId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            account.setBirthdate(sdf.parse(birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        account.setEmail(email);
        account.setOccupation(occupation);
        account.setGender(gender);
        account.setMailaddress(mailaddress);
        account.setZipcode(zipcode);
        account.setQq(qq);

        account.setStatus("0");// 默认创建则开通，记载创建时间

        IAccountDAO dao = new AccountDAOImpl();
        dao.save(account);

        //保存成功后重定向到查询资费页面
        // /netctoss/account/add.do
        // /netctoss/account/list.do
        resp.sendRedirect("list.do");
    }

    /**
     * 删除账务账号记录
     * @param req
     * @param resp
     */
    protected void deleteAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String accountId = req.getParameter("id");
        IAccountDAO dao = new AccountDAOImpl();
        dao.delete(new Integer(accountId));
        resp.sendRedirect("list.do");
    }

    /**
     * 进入账务账号详情页面
     * @param req
     * @param resp
     */
    protected void toDetailAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountId = req.getParameter("id");
        IAccountDAO dao = new AccountDAOImpl();
        Account account = dao.findById(new Integer(accountId));
        String recommenderId = account.getRecommenderId();
        if(recommenderId != null && !"".equals(recommenderId)){
            Account recommender = dao.findById(new Integer(recommenderId));
            req.setAttribute("recommenderIdcardNo", recommender.getIdcardNo());
        } else {
            req.setAttribute("recommenderIdcardNo", "");
        }
        req.setAttribute("account", account);
        req.getRequestDispatcher("../WEB-INF/account/account_detail.jsp").forward(req, resp);
    }

    /**
     * 进入账务账号修改页面
     * 直接转发，将根据 id 查找到的对象携带到目标页面中
     * @param req
     * @param resp
     */
    protected void toUpdateAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountId = req.getParameter("id");
        IAccountDAO dao = new AccountDAOImpl();
        Account account = dao.findById(new Integer(accountId));
        String recommenderId = account.getRecommenderId();
        if(recommenderId != null && !"".equals(recommenderId)){
            Account recommender = dao.findById(new Integer(recommenderId));
            req.setAttribute("recommenderIdcardNo", recommender.getIdcardNo());
        }
        req.setAttribute("account", account);
        req.getRequestDispatcher("../WEB-INF/account/account_update.jsp").forward(req, resp);
    }

    /**
     * 修改账务账号记录
     * @param req
     * @param resp
     */
    protected void updateAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String accountId = req.getParameter("accountId");
        String realName = req.getParameter("realName");
        String idcardNo = req.getParameter("idcardNo");
        String loginName = req.getParameter("loginName");
        String loginPasswd = req.getParameter("loginPasswd");
        String telephone = req.getParameter("telephone");

        // 前端只能输入推荐人身份证号，因此需要通过推荐人身份证号查找其 ID 后再进行赋值
        String recommenderIdcardNo = req.getParameter("recommenderIdcardNo");

        // 此处应先对 idcardNo 进行格式验证
        // 截取身份证号中第 7-14 位为出生年月
        String birthdate = idcardNo.substring(6, 14);


        String email = req.getParameter("email");
        String occupation = req.getParameter("occupation");
        String gender = req.getParameter("gender");

        String mailaddress = req.getParameter("mailaddress");
        String zipcode = req.getParameter("zipcode");
        String qq = req.getParameter("qq");

        IAccountDAO dao = new AccountDAOImpl();

        Account account = new Account();
        account.setAccountId(new Integer(accountId));
        account.setRealName(realName);
        account.setIdcardNo(idcardNo);
        account.setLoginName(loginName);
        account.setLoginPasswd(loginPasswd);
        account.setTelephone(telephone);

        if(!"".equals(recommenderIdcardNo) && recommenderIdcardNo != null){
            Account recommender = dao.findByIdcordNo(recommenderIdcardNo);
            req.setAttribute("recommenderIdcardNo", recommender.getIdcardNo());
            account.setRecommenderId(recommender.getAccountId().toString());
        } else {
            account.setRecommenderId("");
            req.setAttribute("recommenderIdcardNo", "");
        }
        /**
         * 笔记
         * 12345612 -> 1238-08-12
         * 可得 SimpleDateFormat 的 parse(String str) 方法中如果某个时间分域中的值超出分域的最大值，
         * 则会自动计算进位。
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            account.setBirthdate(sdf.parse(birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        account.setEmail(email);
        account.setOccupation(occupation);
        account.setGender(gender);
        account.setMailaddress(mailaddress);
        account.setZipcode(zipcode);
        account.setQq(qq);

        dao.update(account);
        resp.sendRedirect("list.do");
    }


}
