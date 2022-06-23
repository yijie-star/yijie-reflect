/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_case_4.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class java_IO_case_4 {
    public static void main(String[] args) {
        /*
        从键盘输入以下数据“TOM:89|JERRY:90|TONY:95”，数据格式为“姓名：成绩|姓名：成绩”
        对输入的内容按成绩进行排序，并将排序结果按照成绩由高到低排序。
         */
        /*
        扩展：将全部输入的信息保存到文件中，还可以添加信息，并可以显示全部的数据
         */
        new MenuStudent();
    }
}
//1、建立Student的程序类，并且进行排序规则的配置
class StudentVo implements Comparable<StudentVo>{
    private String name;
    private double score;
    public StudentVo(){

    }
    public StudentVo(String name,double score){
        this.setName(name);
        this.setScore(score);
    }
    public String toString(){
      return  "姓名：" + this.name + " 年龄：" + this.score;
    }
    @Override
    public int compareTo(StudentVo obj) {
        if (this.score > obj.score){
            return -1;
        }else if (this.score < obj.score){
            return 1;
        }else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
//2、建立一个数据输入处理操作，牵扯到拆分问题
interface IStudentService{
    void append(String str);//实现数据增加，并且保存到文件里
    StudentVo [] getData();//获取排序数据
}
//3、建立StudentService子类
class StudentImpl implements IStudentService{
    private static final File SAVE_FILE = new File("E:" + File.separator + "java_IO" + File.separator + "4.txt");
    private String content;
    private StudentVo [] studentVos;
//    public StudentImpl(){}
//    public StudentImpl(String content){
//        this.setContent(content);
//        this.handle();//直接调用进行数据处理
//    }

    public StudentImpl(){
        this.setContent(FileUtilStudent.load(SAVE_FILE));//读取已有的数据文件内容
        this.handle();//直接调用进行数据处理
    }
    private void handle(){//进行字符串处理操作

        if (this.content == null || "".equals(this.content)){
            return;//没有数据可以处理
        }
        String result [] = this.content.split("\\|");//拆分数据
        this.studentVos = new StudentVo[result.length];
        for (int i = 0; i < this.studentVos.length; i++) {
            String temp [] = result[i].split(":");
            this.studentVos[i] = new StudentVo(temp[0],Double.parseDouble(temp[1]));
        }
    }

    @Override
    public void append(String str) {
        if (str.startsWith("|")){//最前面有竖线
            str = str.substring(1);
        }
        if (!str.endsWith("|")){//数据合理，直接追加
            str = str + "|";//如果没有竖线，则需要加上与后面的数据进行分割
        }
        FileUtilStudent.append(SAVE_FILE, str);
    }

    @Override
    public StudentVo[] getData() {
        Arrays.sort(this.studentVos);
        return this.studentVos;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
//4、定义Factory工厂类
class StudentFactory{
    public StudentFactory(){}
    public static IStudentService getInstance(){
//        return new StudentImpl(InputUtil.getString("请输入数据信息："));
        return new StudentImpl();
    }
}
//5、测试

//6、扩展增加FileUtilStudent,该类之中只是提供有数据的增加以及读取
class FileUtilStudent{
    public static String load(File file){
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);//进行文件加载
            if (scanner.hasNext()){//有数据
                String str = scanner.next();//获取数据
                return str;
            }
            return null;
        }catch (Exception e){
            return null;
        }finally {
            if (scanner != null){
                scanner.close();
            }
        }

    }
    public static boolean append(File file,String content){
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(file,true));
            out.print(content);//内容增加
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }finally {
            if (out != null){
                out.close();
            }
        }
    }
}
//定义一个菜单处理
class MenuStudent{
//    private IStudentService studentService;
    public MenuStudent(){
//        this.studentService = StudentFactory.getInstance();
        this.choose();
    }
    public void showMenu() {
        System.out.println("【1】、追加数据：\n");
        System.out.println("【2】、显示所有的学生数据：\n");
        System.out.println("【0】、结束程序！");
        System.out.println("\n");
    }
    public void choose(){
        this.showMenu();
        String choose = InputUtil.getString("请进行选择：");
        switch (choose){
            case "1":{
                IStudentService studentService = StudentFactory.getInstance();
                String str = InputUtil.getString("请输入要追加的数据：");
                studentService.append(str);//追加数据
                choose();
            }
            case "2":{
                IStudentService studentService = StudentFactory.getInstance();
                System.out.println(Arrays.toString(studentService.getData()));
                choose();
            }
            case "0":{
                System.out.println("下次再见!");
                System.exit(1);
            } default:{
                System.out.println("您输入了非法的选项，请核对后再输入！");
                choose();
            }
        }
    }
}