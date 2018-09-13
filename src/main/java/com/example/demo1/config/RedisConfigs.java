package com.example.demo1.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class RedisConfigs {

    private final static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

   /* @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        logger.info("JedisConnectionFactory bean init success.");
        return factory;
    }

    @Bean
    @Primary
    public RedisTemplate redisTemplate() {
        JedisConnectionFactory jedisConnectionFactory = getConnectionFactory();
        StringRedisTemplate template = new StringRedisTemplate(jedisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
*/
}
