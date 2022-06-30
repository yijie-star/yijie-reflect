package cn.itike.iutils.securitycode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class DmicCaptUtils {
    private int width = 70;
    private int height = 35;
    private Random random = new Random();
    private String [] fontNames = {"宋体","华文楷体","黑体","微软雅黑","楷体_GB2312","华文隶书"};
    private String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Color bgColor = new Color(255,255,255);
    private String text;
    private Color randomColor(){
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red,green,blue);
    }
    private Font randomFont(){
        int index = random.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(fontName,style,size);
    }
    private void drawLine (BufferedImage image){
        int num = 3;
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics2D.setStroke(new BasicStroke(1.5F));
            graphics2D.setColor(Color.orange);
            graphics2D.drawLine(x1,y1,x2,y2);
        }
    }
    private char randomChar(){
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }
    private BufferedImage createImage(){
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        graphics2D.setColor(this.bgColor);
        graphics2D.fillRect(0,0,width,height);
        return image;
    }
    //外界调用此方法得到验证码
    public BufferedImage getImage(){
        BufferedImage image = createImage();
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        StringBuilder stringBuilder = new StringBuilder();
        //向图中画四个字符
        for (int i = 0; i < 4; i++) {
            String str = randomChar() + "";
            stringBuilder.append(str);
            float x = i * 1.0F * width / 4;
            graphics2D.setFont(randomFont());
            graphics2D.setColor(randomColor());
            graphics2D.drawString(str,x,height - 5);
        }
        this.text = stringBuilder.toString();
        drawLine(image);
        return image;
    }
    public String getText(){
        return this.text;
    }
    public static void output (BufferedImage image, OutputStream outputStream){
        try {
            ImageIO.write(image,"JPEG",outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        DynamicCaptchaUtils dynamicCaptchaUtils = new DynamicCaptchaUtils();
//        BufferedImage image = dynamicCaptchaUtils.getImage();
//        DynamicCaptchaUtils.output(image,new FileOutputStream("E:/xxx.jpg"));
//        System.out.println(dynamicCaptchaUtils.getText());
//    }
}
