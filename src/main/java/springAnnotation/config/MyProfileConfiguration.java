package springAnnotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import springAnnotation.entity.DatabaseConfig;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by shengchao wu on 7/6/2018.
 */

@Configuration
@PropertySource({"classpath:/db.properties"})
public class MyProfileConfiguration {


    private DatabaseConfig databaseConfig;

    @Bean
    public DatabaseConfig databaseConfig() {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        this.databaseConfig = databaseConfig;
        return databaseConfig;
    }

    @Profile("test")
    @Bean("testDatasource")
    public DataSource testDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(databaseConfig.getDriverName());
        dataSource.setJdbcUrl(databaseConfig.getJdbcUrl());
        dataSource.setUser(databaseConfig.getUsername());
        dataSource.setPassword(databaseConfig.getPassword());
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDatasource")
    public DataSource devDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(databaseConfig.getDriverName());
        dataSource.setJdbcUrl(databaseConfig.getJdbcUrl());
        dataSource.setUser(databaseConfig.getUsername());
        dataSource.setPassword(databaseConfig.getPassword());
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDatasource")
    public DataSource prodDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(databaseConfig.getDriverName());
        dataSource.setJdbcUrl(databaseConfig.getJdbcUrl());
        dataSource.setUser(databaseConfig.getUsername());
        dataSource.setPassword(databaseConfig.getPassword());
        return dataSource;
    }
}
