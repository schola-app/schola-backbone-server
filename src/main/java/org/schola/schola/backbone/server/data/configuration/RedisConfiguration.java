package org.schola.schola.backbone.server.data.configuration;

import org.schola.schola.backbone.server.data.model.Account;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
@EnableRedisRepositories(basePackages = "org.schola.schola.backbone.server.data.repository.redis")
public class RedisConfiguration {

    @Bean
    public RedisConnectionFactory factory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Account> template() {
        final RedisConnectionFactory factory = this.factory();

        final RedisTemplate<String, Account> template = new RedisTemplate<>();
        final StringRedisSerializer serializer = new StringRedisSerializer();

        template.setKeySerializer(serializer);
        template.setValueSerializer(serializer);

        return template;
    }
}