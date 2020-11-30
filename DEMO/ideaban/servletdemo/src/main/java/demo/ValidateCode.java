package demo;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 练习验证码的生成
 * 使用 Java 的画图为请求返回一张随机生成的带有验证码的图片。
 * @author: Peter
 * @date: 2020/11/15 23:34
 */
public class ValidateCode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");


        // 1.创建空白图片
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        // 2.获取图片画笔
        Graphics g = image.getGraphics();
        Random r = new Random();
        // 3.设置画笔颜色
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        // 4.绘制矩形的背景
        g.fillRect(0,0,100, 30);
        // 5.调用自定义的方法，获取长度为5的字母数字组合的字符串
        String number = getNumber(5);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font(null, Font.BOLD, 24));// 设置字体颜色字体字号
        // 6.设置颜色字体后，绘制字符串
        g.drawString(number, 5,25);
        // 7.绘制8条干扰线
        for(int i=0; i<8; i++){
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }
        // 8.相应回浏览器
        resp.setContentType("image/jpeg");
        OutputStream ops = resp.getOutputStream();// 获取输出流
        ImageIO.write(image, "jpeg", ops);
        ops.close();

        // 练习6，为 login.jsp 添加验证码验证
        HttpSession session = req.getSession();
        session.setAttribute("code", number);


    }

    // 随机生成指定字符串的方法，生成的字符串包括大写字母和数字
    private String getNumber(int size){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String number = "";
        Random r = new Random();
        for(int i = 0; i < size; i ++){
            number += str.charAt(r.nextInt(str.length()));
        }
        return number;
    }
}
