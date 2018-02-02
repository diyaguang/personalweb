package com.dygstudio.personalweb.config;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: diyaguang
 * @date: 2018/02/01 上午9:29
 * @description: com.dygstudio.personalweb.config
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)   //启用 JPA 的事务管理
@EnableJpaRepositories(basePackages = "com.dygstudio.personalweb.repository")  //启用JPA资源库并制定了上面定义的接口资源库的位置
@EntityScan(basePackages = "com.dygstudio.personalweb.entity")  //指定了定义实体的位置，它将导入我们定义的实体
public class RepositoryConfig {
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    Gson gson(){
        return new Gson();
    }
}
