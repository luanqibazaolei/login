//package com.shen.login.config;
//
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DataSourceConfig {
//    /**
//     * Mapper接口所在包名，Spring会自动查找其下的Mapper
//     *
//     * @return mapperScannerConfigurer
//     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("mapper.*");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//
//        return mapperScannerConfigurer;
//    }
//
//}
