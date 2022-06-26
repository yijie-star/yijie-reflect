package cn.book.dao;

import cn.book.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class BookDao {
    private QueryRunner queryRunner = new QueryRunner();
    public List<Book> findAll(){
        String sql = "select * from t_book";

        try {
            return queryRunner.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Book> findByCategory(int category){
        String sql = "select * from t_book where category=?";
        try {
            return queryRunner.query(sql, new BeanListHandler<Book>(Book.class),category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
