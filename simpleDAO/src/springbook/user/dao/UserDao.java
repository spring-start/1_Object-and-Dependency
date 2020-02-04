package springbook.user.dao;
import springbook.user.domain.User;
import springbook.user.dao.*;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private ConnectionMaker ConnectionMaker;
    private DataSource DataSource;
    public UserDao(){
//        ConnectionMaker = new DConnectionMaker();
    }

    public UserDao(DataSource DataSource){
//        this.ConnectionMaker = ConnectionMaker;
        this.DataSource = DataSource;
    }

    public void setDataSource(DataSource DataSource){
        this.DataSource = DataSource;
    }
    public void setConnectionMaker(springbook.user.dao.ConnectionMaker connectionMaker) {
        ConnectionMaker = connectionMaker;
    }

    //if Singleton Pattern..
//    private static UserDao INSTANCE;
//    public static UserDao getUserDao(){
//        if(INSTANCE == null)
//            INSTANCE = new UserDao(new DConnectionMaker());
//        return INSTANCE;
//    }
    public void add(User user) throws ClassNotFoundException, SQLException{
//        Connection c = ConnectionMaker.makeNewConnection();
        Connection c = DataSource.getConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)"
        );
        ps.setString(1, user.getID());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public User get(String id) throws ClassNotFoundException, SQLException{

//        Connection c = ConnectionMaker.makeNewConnection();
        Connection c = DataSource.getConnection();
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?"
        );
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

//    public static void main(String[] args) throws ClassNotFoundException, SQLException{
//        UserDao dao = new UserDao();
//
//        User user = new User();
//        user.setId("mark");
//        user.setName("son");
//        user.setPassword("mark.son");
//
//        dao.add(user);
//        System.out.println(user.getID()+" 등록 성공");
//        User user2 = dao.get(user.getID());
//        System.out.println(user2.getName());
//
//        System.out.println(user2.getPassword());
//        System.out.println(user2.getID()+" 조회 성공");
//
//    }
}
