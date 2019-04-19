package org.tare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.tare.dao.SaleDao;
import org.tare.entity.City;
import org.tare.entity.Sale;
import org.tare.entity.Street;
import org.tare.util.GenStreet;
/**
 * ActionServlet服务端组件，处理请求
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		//获取请求路径资源
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		if(path.equals("/get_text")){
			out.print("来自星星的你。");
		} else if(path.equals("/post_text")){
			String str = req.getParameter("uname");
			out.print("这一次是"+ str +"!!>");
		} else if(path.equals("/check_name")){
			String name = req.getParameter("name");
			if(1 == 1){
				try {
					Thread.sleep(4000);//模拟网络延迟
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("ajax04中，获取到的name:"+ name);
			if("abcd".equals(name)){
				out.print(name +"该用户名不可用！");
			} else {
				out.print(name +"可以使用！");
			}
		} else if("/check_name2".equals(path)){
//			String name = req.getParameter("name");		//若是IE浏览器，则会发生缓存问题，相同的请求路径只能发出一次，因此使用追加随机数拼接uri，使请求发生变化。
			String name = req.getParameter("name").substring(0, req.getParameter("name").lastIndexOf(".") - 2);//因为获取到的字符串是:enme.0.5424213形式，最后一个点的下标要减2才能截取到想要的name字符串
			if(1 == 1){
				try {
					Thread.sleep(4000);//模拟网络延迟
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("ajax05中获取到的name:"+ name);
			if("abc张三".equals(name)){
				out.print(name +"用户名已存在！");
			} else {
				out.print(name +"可以使用！");
			}
		} else if("/getCity".equals(path)){
			String name = req.getParameter("name");//获取请求中的参数name的值，即城市的值
			if("bj".equals(name)){
				out.print("朝阳,cy;东城,dc");
			} else if("sh".equals(name)){
				out.print("静安,ja;黄埔,hp;浦东新,pdx");
			} else if("gz".equals(name)){
				out.print("白云,by;番禺,py");
			}
		} else if("/getCity2".equals(path)){//使用JSON传输数据的方式
			String name = req.getParameter("name");
			if("bj".equals(name)){
				City c1 = new City("朝阳", "cy");
				City c2 = new City("海淀", "hd");
				City c3 = new City("东城", "dc");
				List<City> cs = new ArrayList<City>();
				cs.add(c1);
				cs.add(c2);
				cs.add(c3);
				JSONArray jsonArr = JSONArray.fromObject(cs);
				String jsonStr = jsonArr.toString();
				out.print(jsonStr);
			} else if("sh".equals(name)){
				City c1 = new City("徐汇", "xh");
				City c2 = new City("黄埔", "hp");
				City c3 = new City("浦东新", "pdx");
				List<City> cs = new ArrayList<City>();
				cs.add(c1);
				cs.add(c2);
				cs.add(c3);
				JSONArray jsonArr = JSONArray.fromObject(cs);
				String jsonStr = jsonArr.toString();
				out.print(jsonStr);
			} else if("gz".equals(name)){
				City c1 = new City("白云", "by");
				City c2 = new City("番禺", "py");
				List<City> cs = new ArrayList<City>();
				cs.add(c1);
				cs.add(c2);
				JSONArray jsonArr = JSONArray.fromObject(cs);
				String jsonStr = jsonArr.toString();
				out.print(jsonStr);
			} 
		}else if("/getStreet".equals(path)){
			String name = req.getParameter("name");
			System.out.println(name);
			if("hd".equals(name)){
				Street s1 = new Street("海淀一路","hd1");
				Street s2 = new Street("海淀二路","hd2");
				Street s3 = new Street("海淀三路","hd3");
				List<Street> list = new ArrayList<Street>();
				list.add(s1);
				list.add(s2);
				list.add(s3);
				JSONArray jsonArr = JSONArray.fromObject(list);
				String jsonStr = jsonArr.toString();
				out.print(jsonStr);
			} else if("dc".equals(name)){//东城
				out.print(GenStreet.GenStreetStr("东城", name));
			} else if("cy".equals(name)){//朝阳
				out.print(GenStreet.GenStreetStr("朝阳", name));
			} else if("by".equals(name)){//白云
				out.print(GenStreet.GenStreetStr("白云", name));
			} else if("py".equals(name)){//番禺
				out.print(GenStreet.GenStreetStr("番禹", name));
			} else if("xh".equals(name)){//徐汇
				out.print(GenStreet.GenStreetStr("徐汇", name));
			} else if("hp".equals(name)){//黄埔
				out.print(GenStreet.GenStreetStr("黄埔", name));
			} else if("pdx".equals(name)){ //浦东新
				out.print(GenStreet.GenStreetStr("浦东新", name));
			}
			
		}else if("/sale".equals(path)){
			System.out.println("进没进来？");
			SaleDao dao = new SaleDao();
			List<Sale> list = dao.findSell();
			JSONArray jsonArr = JSONArray.fromObject(list);//将集合对象抓变为JSON数组对象
			String jsonStr = jsonArr.toString();//将JSON对象转变为字符串
			System.out.println(jsonStr);
			out.print(jsonStr);//写出jsonStr字符串
			
		}
		
		out.close();
	}
	
}
