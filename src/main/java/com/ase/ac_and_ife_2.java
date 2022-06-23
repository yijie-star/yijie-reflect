/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: ac_and_ife_2.java
 * Date: 2022/6/20 下午7:50
 * Author: yijie
 */

package com.ase;

interface IGraphical{
    public void paint();
}
class Ponit{
    private double x;
    private double y;
    public Ponit(){}
    public Ponit(double x,double y){
        this.setX(x);
        this.setY(y);


    }    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
class Triangle implements IGraphical{
    private Ponit [] x;
    private Ponit [] y;
    private Ponit [] z;
    public Triangle(){}
    //????????
    public Triangle(Ponit [] x,Ponit [] y,Ponit [] z){
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    @Override
    public void paint() {
        System.out.println("??????????,???????[" + this.x[0].getX() + "," + this.x[0].getY() + "],????????[" + this.x[1].getX() + "," + this.x[1].getY() + "]");
        System.out.println("??????????,???????[" + this.y[0].getX() + "," + this.y[0].getY() + "],????????[" + this.y[1].getX() + "," + this.y[1].getY() + "]");
        System.out.println("???????????,???????[" + this.z[0].getX() + "," + this.z[0].getY() + "],????????[" + this.z[1].getX() + "," + this.z[1].getY() + "]");
    }

    public void setX(Ponit[] x) {
        this.x = x;
    }

    public void setY(Ponit[] y) {
        this.y = y;
    }

    public void setZ(Ponit[] z) {
        this.z = z;
    }
}
class Circular implements IGraphical{
    private double radius;
    public Circular(){}
    public Circular(double radius){
        this.setRadius(radius);
    }

    @Override
    public void paint() {
        System.out.println("??????" + this.radius + "???");
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
class Fatory{
    public static IGraphical getInstance(String ClassName,double ... args){
        if ("triangle".equalsIgnoreCase(ClassName)){
            return new Triangle(
                    new Ponit [] {
                            new Ponit(args[0],args[1]),new Ponit(args[2],args[3])},
                    new Ponit [] {
                            new Ponit(args[4],args[5]),new Ponit(args[6],args[7])},
                    new Ponit [] {
                            new Ponit(args[8],args[9]),new Ponit(args[10],args[11])}
            ) ;

        }else if ("circular".equalsIgnoreCase(ClassName)){
            return new Circular(args[0]);
        }else {
            return null;

        }
    }

}
public class ac_and_ife_2 {
    public static void main(String[] args) {
        /*
        ?????????????????????????????????????????л???
         */
        IGraphical iga = Fatory.getInstance("triangle", 1.1,2.2,2.2,3.4,11.1,11.2,11.3,11.4,22.1,22.2,22.3,22.4);
        iga.paint();
        IGraphical igb = Fatory.getInstance("circular", 5);
        igb.paint();
    }
}

