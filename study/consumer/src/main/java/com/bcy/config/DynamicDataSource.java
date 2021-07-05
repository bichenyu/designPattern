//package com.bcy.config;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Component
//public class DynamicDataSource extends AbstractRoutingDataSource {
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return null;
//    }
////    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
////
////    public DynamicDataSource(@Qualifier("firstDataSource")DataSource defaultTargetDataSource,
////                             Map<Object, Object> targetDataSources) {
////        super.setDefaultTargetDataSource(defaultTargetDataSource);
////        super.setTargetDataSources(targetDataSources);
////        super.afterPropertiesSet();
////    }
////
////    @Override
////    protected Object determineCurrentLookupKey() {
////        return getDataSource();
////    }
////
////    public static void setDataSource(String dataSource) {
////        contextHolder.set(dataSource);
////    }
////
////    public static String getDataSource() {
////        return contextHolder.get();
////    }
////
////    public static void clearDataSource() {
////        contextHolder.remove();
////    }
//}
