package com.springboot.cache.config;

import com.springboot.cache.bean.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author frank
 * @create 2019-09-09 21:29
 */
@Configuration
public class MyRedisConfig {
    @Bean
    @ConditionalOnMissingBean(
            name = {"redisTemplate"}
    )
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer ser = new Jackson2JsonRedisSerializer(Employee.class);
        template.setDefaultSerializer(ser);
        return template;
    }
}
