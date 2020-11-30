package web;

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
 * 笔记
 * 验证码
 * @author: Peter
 * @date: 2020/11/30 1:34
 */
public class ValidateCode extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 0.创建空白图片
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        // 1.获取图片画笔
        Graphics g = image.getGraphics();
        Random r = new Random();
        // 2.设置画笔颜色
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        // 3.绘制矩形背景
        g.fillRect(0, 0, 100, 30);
        // 4.调用自定义方法，获取长度为5的字符串
        String number = getNumber(5);

        /*
         * 当页面请求一个验证码时，则将验证码的值放入该请求的 session 中。
         * 当前端发送下一个请求，如登录时，则在登录验证的方法中获取 session 中的该值，
         * 进行验证。
         */
        HttpSession session = req.getSession();
        session.setAttribute("code", number);

        g.setColor(new Color(0, 0, 0));// 设置画笔的颜色为黑色
        g.setFont(new Font(null, Font.BOLD, 24));// 设置画笔的字体
        // 5.设置颜色字体后，就可以继续在之前绘制好的矩形背景上绘制字符串了
        g.drawString(number, 5, 25); // 后2个参数为 x,y 坐标
        // 6.绘制8条干扰线
        for(int i = 0; i < 8; i ++){
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));// 随机线条的起始坐标和终点坐标
        }
        resp.setContentType("image/jpeg");
        OutputStream ops = resp.getOutputStream();
        ImageIO.write(image, "jpeg", ops);
        ops.close();
    }


    /**
     * 自定义获取指定长度的字符串方法
     * @param size
     * @return
     */
    private String getNumber(int size){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String number = "";
        Random r = new Random();
        for(int i = 0; i < size; i++){
            number += str.charAt(r.nextInt(str.length()));
        }
        return number;
    }
}
