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
 * ActionServlet������������������
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
		//��ȡ����·����Դ
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		if(path.equals("/get_text")){
			out.print("�������ǵ��㡣");
		} else if(path.equals("/post_text")){
			String str = req.getParameter("uname");
			out.print("��һ����"+ str +"!!>");
		} else if(path.equals("/check_name")){
			String name = req.getParameter("name");
			if(1 == 1){
				try {
					Thread.sleep(4000);//ģ�������ӳ�
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("ajax04�У���ȡ����name:"+ name);
			if("abcd".equals(name)){
				out.print(name +"���û��������ã�");
			} else {
				out.print(name +"����ʹ�ã�");
			}
		} else if("/check_name2".equals(path)){
//			String name = req.getParameter("name");		//����IE���������ᷢ���������⣬��ͬ������·��ֻ�ܷ���һ�Σ����ʹ��׷�������ƴ��uri��ʹ�������仯��
			String name = req.getParameter("name").substring(0, req.getParameter("name").lastIndexOf(".") - 2);//��Ϊ��ȡ�����ַ�����:enme.0.5424213��ʽ�����һ������±�Ҫ��2���ܽ�ȡ����Ҫ��name�ַ���
			if(1 == 1){
				try {
					Thread.sleep(4000);//ģ�������ӳ�
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("ajax05�л�ȡ����name:"+ name);
			if("abc����".equals(name)){
				out.print(name +"�û����Ѵ��ڣ�");
			} else {
				out.print(name +"����ʹ�ã�");
			}
		} else if("/getCity".equals(path)){
			String name = req.getParameter("name");//��ȡ�����еĲ���name��ֵ�������е�ֵ
			if("bj".equals(name)){
				out.print("����,cy;����,dc");
			} else if("sh".equals(name)){
				out.print("����,ja;����,hp;�ֶ���,pdx");
			} else if("gz".equals(name)){
				out.print("����,by;��خ,py");
			}
		} else if("/getCity2".equals(path)){//ʹ��JSON�������ݵķ�ʽ
			String name = req.getParameter("name");
			if("bj".equals(name)){
				City c1 = new City("����", "cy");
				City c2 = new City("����", "hd");
				City c3 = new City("����", "dc");
				List<City> cs = new ArrayList<City>();
				cs.add(c1);
				cs.add(c2);
				cs.add(c3);
				JSONArray jsonArr = JSONArray.fromObject(cs);
				String jsonStr = jsonArr.toString();
				out.print(jsonStr);
			} else if("sh".equals(name)){
				City c1 = new City("���", "xh");
				City c2 = new City("����", "hp");
				City c3 = new City("�ֶ���", "pdx");
				List<City> cs = new ArrayList<City>();
				cs.add(c1);
				cs.add(c2);
				cs.add(c3);
				JSONArray jsonArr = JSONArray.fromObject(cs);
				String jsonStr = jsonArr.toString();
				out.print(jsonStr);
			} else if("gz".equals(name)){
				City c1 = new City("����", "by");
				City c2 = new City("��خ", "py");
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
				Street s1 = new Street("����һ·","hd1");
				Street s2 = new Street("�����·","hd2");
				Street s3 = new Street("������·","hd3");
				List<Street> list = new ArrayList<Street>();
				list.add(s1);
				list.add(s2);
				list.add(s3);
				JSONArray jsonArr = JSONArray.fromObject(list);
				String jsonStr = jsonArr.toString();
				out.print(jsonStr);
			} else if("dc".equals(name)){//����
				out.print(GenStreet.GenStreetStr("����", name));
			} else if("cy".equals(name)){//����
				out.print(GenStreet.GenStreetStr("����", name));
			} else if("by".equals(name)){//����
				out.print(GenStreet.GenStreetStr("����", name));
			} else if("py".equals(name)){//��خ
				out.print(GenStreet.GenStreetStr("����", name));
			} else if("xh".equals(name)){//���
				out.print(GenStreet.GenStreetStr("���", name));
			} else if("hp".equals(name)){//����
				out.print(GenStreet.GenStreetStr("����", name));
			} else if("pdx".equals(name)){ //�ֶ���
				out.print(GenStreet.GenStreetStr("�ֶ���", name));
			}
			
		}else if("/sale".equals(path)){
			System.out.println("��û������");
			SaleDao dao = new SaleDao();
			List<Sale> list = dao.findSell();
			JSONArray jsonArr = JSONArray.fromObject(list);//�����϶���ץ��ΪJSON�������
			String jsonStr = jsonArr.toString();//��JSON����ת��Ϊ�ַ���
			System.out.println(jsonStr);
			out.print(jsonStr);//д��jsonStr�ַ���
			
		}
		
		out.close();
	}
	
}
