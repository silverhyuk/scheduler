package com.cafe24.scheduler.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.nio.charset.Charset;

@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFatory(DataSource datasource) throws Exception {
        ResourcePatternResolver applicationContext = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(datasource);
        sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/config/mybatis/mybatisConfig.xml"));
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));

        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
