package cn.itike.iutils.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * BaseServlet[抽象类] 不需要在web.xml中添加路径
 */
public class BaseServletUtils extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");//处理响应编码
        /*
         * 设置POST和GET请求编码
         */
        /*
         * 1. 获取参数，用来识别用户想请求的方法
         *      method是用户在浏览器地址栏中输入的想要调用的方法，是个参数
         */
        String methodName = request.getParameter("method");
        /*
         * 2. 判断用户有没有传参数
         */
        if(methodName == null || methodName.trim().isEmpty()){
            throw new RuntimeException("您没有传递method参数! 无法确定您要调用的方法！");
        }
        /**
         * 3. 判断是哪一个方法，是哪一个就调用哪一个
         *    所用的技术是： 反射
         *        需要得到本类Class,然后调用它的getMethod，通过传递过来的方法名字进行得到Method对象
         *    这样做的目的是： 以后像其他Servlet中的方法要修改或者添加新方法时，就不用在去修改这一块代码了
         */
        /*
         * 3.1.  得到当前类的对象
         */
        Class<? extends BaseServletUtils> clazz = this.getClass();
        /*
         * 3.2.  通过传递过来的方法名（addUse等）得到Method对象
         *    导包 ：java.lang.reflect.Method;
         */
        Method method = null ;
        try {
            method = clazz.getMethod(methodName,
                    HttpServletRequest.class,HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("您要调用的方法"+methodName+",它不存在");
        }
        try {
            /*
             * 3.3. 调用method表示的方法,即： 调用继承该类的类中的方法
             *     反射调用： 用this来调用method表示的方法，并且传递参数req和resp
             */
            String result =(String)method.invoke(this, request,response);
            /**
             * 4. 处理从继承这个类的类中返回的字符串（重定向和转发）
             *     return "r:/a.jsp"; 和 return "f:/a.jsp";
             *      返回的是字符串，需要解读字符串
             */
            /*
             * 4.1. 如果用户返回的字符串为null，或者"",那么什么都不做
             */
            if(result == null || result.trim().isEmpty()){
                return  ;
            }
            /*
             * 4.2. 解读字符串1:判断字符串中有没有冒号
             *        没有冒号默认表示转发，反之再进行判断
             */
            if(result.contains(":")){
                /*
                 * 4.3. 解读字符串2 ： 先获取冒号位置，然后截取前缀（操作，是重定向还是转发）和后缀（路径）
                 */
                int index = result.indexOf(":");
                String operate = result.substring(0,index);
                String path = result.substring(index+1);
                /*
                 * 4.4. 进行处理，如果是r重定向，如果是f则转发
                 */
                if(operate.equalsIgnoreCase("r")){
                    response.sendRedirect(request.getContextPath()+path);
                }else if(operate.equalsIgnoreCase("f")){
                    request.getRequestDispatcher(path).forward(request, response);
                }else{
                    throw new RuntimeException("您指定的操作"+operate+
                            "不支持，请正确填写：r和f");
                }
            }else{
                /*
                 * 没有冒号默认转发处理
                 */
                request.getRequestDispatcher(result).forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("您要调用的方法"+methodName+",它内部抛出了异常");
            throw new RuntimeException(e);
        }
    }
}

