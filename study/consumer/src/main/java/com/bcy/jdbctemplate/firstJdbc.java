package com.bcy.jdbctemplate;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class firstJdbc {
     @Bean(name="firstTemplate")
    public JdbcTemplate firstTemplate(@Qualifier("firstDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
