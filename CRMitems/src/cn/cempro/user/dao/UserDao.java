package cn.cempro.user.dao;

import cn.cempro.user.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 数据类
 */
public class UserDao {
    private String path = "E:/users.xml";

    /**
     * 按照用户名查询
     * @param username
     * @return
     */
    public User findBtUsername(String username){
        /**
         * 1、得到Document
         * 2、xpath查询
         *      3、校验查询的结构是否为null，为null则返回null
         *      4、不为null，需要把Element封装到User对象中
         */

        try {
            Document document = Dom4jUtils.getDocument(path);
            Element element = (Element) document.selectSingleNode("//user[@username='" + username + "']");
            if (element == null) return null;
            User user = new User();
            String attUsername = element.attributeValue("username");//获取元素名为username的属性值
            String attPassword = element.attributeValue("password");
            user.setUsername(attUsername);
            user.setPassword(attPassword);
            return user;
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 添加用户
     */
    public void addUser(User user){
        /**
         * 1、得到Document
         * 2、通过Document得到root根元素，使用参数user，转换成Element元素中
         * 3、保存Document
         */
        try {
            Document document = Dom4jUtils.getDocument(path);
            Element root = document.getRootElement();
            Element userElement = root.addElement("user");
            userElement.addAttribute("username",user.getUsername());
            userElement.addAttribute("password",user.getPassword());

            OutputFormat outputFormat = new OutputFormat("\t",true);//缩进使用\t，是否换行，是
            outputFormat.setTrimText(true);
            XMLWriter xmlWriter = Dom4jUtils.getXmlWriter(path);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
