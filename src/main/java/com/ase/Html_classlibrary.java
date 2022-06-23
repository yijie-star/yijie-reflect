/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Html_classlibrary.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Html_classlibrary {
    public static void main(String[] args) {
        /*
        给定下面HTML代码：
            <font face = "Arial,Serif" size="+2" color ="red">
            要求对内容进行拆分，拆分之后的结果是：
                face Arial,Serif
                size +2
                color red
         */
        String str = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";
        String regex = "\\w+=\"[a-zA-Z0-9,\\+]+\"";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()){
            String tempstr = matcher.group(0);
            String result [] = tempstr.split("=");
            System.out.println(result[0] + "  " + result[1].replaceAll("\"",""));
        }
    }
}
