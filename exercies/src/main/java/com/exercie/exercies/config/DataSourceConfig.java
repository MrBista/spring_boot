package com.exercie.exercies.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariConfig hikariConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(2);
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        // bisa pakai ini
        return new JdbcTemplate(dataSource);
    }

}
