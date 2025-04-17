package org.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DatabaseConfig {

    @Value("db.username")
    private String username;

    @Value("db.password")
    private String password;

    @Value("db.url")
    private String jdbcUrl;

    @Value("db.max-pool-size")
    private String maxPoolSize;

    @Value("db.idleTimeOUt")
    private String idleTimeOut;

    @Bean
    @Profile("dev")
    public DataSource dataSourceDev(){
        HikariConfig dataSource = new HikariConfig();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
        dataSource.setMinimumIdle(5);
        dataSource.setIdleTimeout(Long.parseLong(idleTimeOut));
        dataSource.setMaxLifetime(10 * 60_000);
        return new HikariDataSource(dataSource);
    }
    @Bean
    @Profile("prod")
    public DataSource dataSourceProd(){
        HikariConfig dataSource = new HikariConfig();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
        dataSource.setMinimumIdle(5);
        dataSource.setIdleTimeout(Long.parseLong(idleTimeOut));
        dataSource.setMaxLifetime(10 * 60_000);
        return new HikariDataSource(dataSource);
    }
}
