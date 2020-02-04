package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {
    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker(ConnectionMaker realConnectionMaker){
        this.realConnectionMaker = realConnectionMaker;
    }

    public int getCounter(){
        return this.counter;
    }
    @Override
    public Connection makeNewConnection() throws SQLException, ClassNotFoundException {
        this.counter++;
        return realConnectionMaker.makeNewConnection();

//        Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection(
//                "jdbc:mysql://localhost/my_example?serverTimezone=UTC&useSSL=false", "root","akzmWkd1!"
//        );
    }
}
