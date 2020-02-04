package springbook.user.dao;
import java.sql.*;

public class DConnectionMaker implements ConnectionMaker {

    public Connection makeNewConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/my_example?serverTimezone=UTC&useSSL=false", "root","123123!"
        );
    }

}
