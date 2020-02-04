package springbook.user.dao;

import java.sql.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
//    @Bean
//    public UserDao userDao() {
//        return new UserDao(countConnectionMaker());
//    }

    @Bean
    public AccountDao accountDao(){
        return new AccountDao(countConnectionMaker());
    }
    @Bean
    public MessageDao messageDao(){
        return new MessageDao(countConnectionMaker());
    }
    @Bean
    public ConnectionMaker realConnectionMaker(){
        return new DConnectionMaker();
    }
    @Bean
    public ConnectionMaker countConnectionMaker(){
        return new CountingConnectionMaker(realConnectionMaker());
    }

}
