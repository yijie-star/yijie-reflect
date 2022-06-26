package cn.book.web.servlet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
/*
 * 创建这个BaseServlet的目的：
 * 1.以前是一个功能就写一个servlet，这样的写法过于繁琐，现在想是否能有一种方法，可以只写一个servlet实现多个功能呢
 * 2.一般servlet处理完都会有一个转发的功能，所以，我把转发的功能也放在这里，以简化代码
 * 步骤：
 * 0.首先这段代码要写在service方法中，其他servlet继承这个方法以后，只写方法就可以了，不用再写doget和dopost了
 * 1.首先前端必须把要调用的方法作为参数发过来
 * 2.然后判断这个参数是否为空
 * 3.接下来，用反射的知识获取类，然后就可以根据发过来的方法名字来调用响应的方法
 * 4.最后执行方法invoke后还会返回一个参数，这个参数作为转发的目的地，然后我就可以在其他的servlet中，返回一个参数就可以实现转发
 * 5.如果我想要重定向的话，只需要写一个重定向的语句，然后返回一个null给这个baseservlet即可
 */

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String parName = req.getParameter("method");//获取客户端传递的参数
        /**
         * 得到方法名称，通过反射来调用需求
         * 需要得到class，然后调用它的方法来进行查询，得到传递过来的参数
         * 要查询的是当前类的方法，所以需要得到当前类额class
         */
        if (parName == null || parName.trim().isEmpty()){
            //trim--去掉空格
            throw new RuntimeException("没有获取到您传递的请求参数，无法确定您的需求！");
        }
        Class current_class = this.getClass();//获得当前类对象
        Method method = null;
        try {
            method = current_class.getMethod(parName,HttpServletRequest.class,HttpServletResponse.class);//通过传递过来的参数查询对应的处理方法
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("您调用的需求无法满足！" + parName + "不存在！");
        }
        /**
         * 调用parName方法
         * 反射调用:method.invoke(this,req,resp);
         */
        try {
            String result = (String) method.invoke(this,req,resp);
            /**
             * 获取请求处理方法执行后返回的字符串表示转发或者重定向的路径
             * 帮他完成转发后者重定向
             * 如果用户返回的字符串为null或为 ""，那么什么也不做
             * 查看返回的字符串是否包含冒号，没有表示转发，如果有使用冒号分割字符串，得到前缀和后缀
             * 其中前缀是f,表示转发，如果是r表示重定向，后缀则表示转发或重定向的路径
             */
            if (result == null || result.trim().isEmpty()){
                return;
            }
            if (result.contains(":")){
                int index = result.indexOf(":");
                String prefix = result.substring(0,index);//表示操作
                String suffix = result.substring(index + 1);//表示路径
                if (prefix.equalsIgnoreCase("f")){
                    resp.sendRedirect(req.getContextPath() + suffix);
                }else if (prefix.equalsIgnoreCase("f")){
                    req.getRequestDispatcher(suffix).forward(req,resp);
                }else {
                    throw new RemoteException("您指定的操作：" + prefix + "，当前版本还不支持！");
                }
            }else {
                req.getRequestDispatcher(result).forward(req,resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
