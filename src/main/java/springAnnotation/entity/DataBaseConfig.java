package springAnnotation.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by shengchao wu on 7/6/2018.
 */
public class DatabaseConfig {

    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;

    @Value("${jdbc.driverClass}")
    private String driverName;

    @Value("${jdbc.user}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    public DatabaseConfig() {}


    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataBaseConfig{" +
                "jdbcUrl='" + jdbcUrl + '\'' +
                ", driverName='" + driverName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
