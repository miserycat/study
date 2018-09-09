package springAnnotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import springAnnotation.dao.PersonDao;
import springAnnotation.entity.DatabaseConfig;

/**
 * Created by shengchao wu on 7/6/2018.
 */
@Configuration
@ComponentScan("springAnnotation")
@PropertySource({"classpath:/db.properties"})
public class MyConfiguration2 {


    @Bean
    public DatabaseConfig databaseConfig () {
        return new DatabaseConfig();
    }

    @Primary
    @Bean
    public PersonDao personDao() {
        PersonDao personDao = new PersonDao();
        personDao.setLabel("2");

        return personDao;
    }
}

