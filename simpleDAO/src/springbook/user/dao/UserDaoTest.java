package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(DataFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);
//        DaoFactory daoFactory = new DaoFactory();

//        UserDao userDao = daoFactory.userDao();
//        MessageDao messageDao = daoFactory.messageDao();
//        AccountDao accountDao = daoFactory.accountDao();
        User user = new User();
        user.setId("mark");
        user.setName("son");
        user.setPassword("markson");


        dao.add(user);
        System.out.println(user.getName()+" 등록 성공");

        dao.get(user.getID());
        System.out.println(user.getName()+" 조회 성공");

    }
}
//
//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//UserDao dao = context.getBean("userDao", UserDao.class);
//User user = new User();
//user.setId("mark");
//user.setName("son");
//user.setPassword("mark.son");
//dao.add(user);
