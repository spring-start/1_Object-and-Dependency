package springbook.user.dao;

import springbook.user.domain.User;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;
public class NUserDao extends UserDao {
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/my_example?serverTimezone=UTC&useSSL=false", "root","123123!"
        );
        return c;
    }
}
