package com.example.demo.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {
    @Bean(name = "datasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource ehubDataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("select 1");
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    @Autowired
    public JdbcTemplate masterJdbcTemplate(@Qualifier("datasource") DataSource dsMaster) {
        return new JdbcTemplate(dsMaster);
    }
}
