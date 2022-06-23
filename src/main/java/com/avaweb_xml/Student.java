package com.avaweb_xml;

public class Student {
    private String sid;
    private String sname;
    private String sage;
    public Student (){}
    public Student (String sname,String sage){
        super();
        this.setSname(sname);
        this.setSage(sage);
    }
    public Student (String sid,String sname,String sage){
        super();
        this.setSid(sid);
        this.setSname(sname);
        this.setSage(sage);
    }
    public String getInfo(){
        return "学号：" + this.sid + " 姓名：" + this.sname + " 年龄：" + this.sage;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }
}
