package com.bcy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Objects;

@RestController
@RequestMapping("/ds")
public class DSTestController {

    @Autowired
    @Qualifier("secondTemplate")
    private JdbcTemplate jdbcTemplate;

    @PostMapping("add")
    public String insert() throws SQLException {
//        Account account1=new Account();
//        account1.setMoney(200);
//        account1.setName("mika");
//        accountService.add(account1);
        return Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection().getMetaData().getUserName();

    }

}
