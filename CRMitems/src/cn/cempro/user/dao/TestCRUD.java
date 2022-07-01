package cn.cempro.user.dao;


import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestCRUD {
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = C3p0Utils.getConnection();
        try {
            ps = conn.prepareStatement("INSERT INTO user (username,password)VALUES('SUN99','123')");
            ps.executeUpdate();
            System.out.println("添加操作执行成功！");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("添加操作执行失败！");
        } finally {
            C3p0Utils.release(conn, ps, null);
        }
    }
}
