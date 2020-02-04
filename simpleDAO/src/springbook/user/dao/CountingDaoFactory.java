package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Configuration
public class CountingDaoFactory {
    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }
//    <bean id="userDao" class="springbook.user.dao.UserDao">
//        <property name="connectionMaker" ref="connectionMaker" />
//    </bean>
    @Bean
    public ConnectionMaker connectionMaker(){
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker(){
        return new DConnectionMaker();
    }
//    <bean id="realConnectionMaker" class="springbook.user.dao.DConnectionMaker" />
}
