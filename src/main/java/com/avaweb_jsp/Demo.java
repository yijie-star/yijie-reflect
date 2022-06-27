package com.avaweb_jsp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public void fun1(){
        /**
         * 1、创建图片缓冲区
         * 2、设置其宽高
         * 3、得到这个图片的绘制环境（画笔）
         * 4、保存起来
         */
        BufferedImage bufferedImage = new BufferedImage(70,35,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0,0,70,35-2);
        graphics.setColor(Color.red);
        graphics.drawString("Hello",5,5);

        try {
            ImageIO.write(bufferedImage,"JPEG",new FileOutputStream("F:"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
