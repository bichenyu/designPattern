package com.bcy.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Component
@Configuration
//@MapperScan(basePackages = {"com.vivachek.service.dao","com.vivachek.service.dao2"})
public class DynamicDataSourceConfig {

    @Bean("firstDataSource")
    @Primary
    @Qualifier("firstDataSource")
    @ConfigurationProperties("spring.datasource.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean("secondDataSource")
    @Qualifier("secondDataSource")
    @ConfigurationProperties("spring.datasource.second")
    public DataSource  secondDataSource(){

        return DruidDataSourceBuilder.create().build();
    }


//    @Bean
//    public DynamicDataSource dataSource(@Qualifier("firstDataSource") DataSource first,
//                                        @Qualifier("secondDataSource") DataSource second) {
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put("first",first);
//        targetDataSources.put("second", second);
//        return new DynamicDataSource(first, targetDataSources);
//    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("firstDataSource") DataSource mainDataSource,
//                                               @Qualifier("secondDataSource") DataSource yuntuDataSource) throws Exception{
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(this.dataSource(mainDataSource, yuntuDataSource));
//        //fb.setTypeAliasesPackage("fm.xiaoai.exmanager");//可以不设置
//        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        return fb.getObject();
//    }

    /**
     * 配置事务管理器
     */
//    @Bean
//    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
//        return new DataSourceTransactionManager(dataSource);
//    }

}
