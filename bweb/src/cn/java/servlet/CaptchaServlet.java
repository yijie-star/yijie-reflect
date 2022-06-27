package cn.java.servlet;

import cn.iutils.DmicCaptUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CaptchaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1、生成图片
         * 2、图片上的文本到session域中
         * 3、把图片响应给客户端
         */
        DmicCaptUtils dmicCaptUtils = new DmicCaptUtils();
        BufferedImage bufferedImage = dmicCaptUtils.getImage();
        req.getSession().setAttribute("captcha",dmicCaptUtils.getText());
        DmicCaptUtils.output(bufferedImage,resp.getOutputStream());
    }
}
