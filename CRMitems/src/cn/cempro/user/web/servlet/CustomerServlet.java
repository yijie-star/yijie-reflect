package cn.cempro.user.web.servlet;

import cn.cempro.user.domain.Customer;
import cn.cempro.user.service.CustomerService;
import cn.itike.iutils.commons.CommonUtils;
import cn.itike.iutils.servlet.BaseServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * web层
 */
public class CustomerServlet extends BaseServletUtils {
    private CustomerService customerService = new CustomerService();

    /**
     * 添加客户
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public String add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /**
         * 1、封装表单数据
         * 2、补全：cid，使用uuid
         * 3、使用service方法完成添加工作
         * 4、向request域中保存信息
         * 5、转发到msg.jsp
         */
        Customer c = CommonUtils.toBean(req.getParameterMap(),Customer.class);
        c.setCid(CommonUtils.uuId());
        try {
            customerService.add(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("msg","恭喜添加客户成功！");
        return "f:/msg.jsp";
    }

}
