package com.template.springboot.redis.config.cluster;//package com.template.springboot.redis.config.cluster;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.util.StringUtils;
//
///**
// * @author francis
// * @Title: LettureRedisAutoConfiguration
// * @Description:
// * @Copyright: 中国电信爱WiFi运营中心
// * @Company: 中国电信爱WiFi运营中心
// * @Date 2020-09-03 15:28
// */
//@Configuration
//@EnableConfigurationProperties(RedisProperties.class)
//public class LettureRedisAutoConfiguration {
//
//    @Autowired
//    private RedisProperties redisProperties;
//
//    @Bean
//    @ConditionalOnProperty(value = "spring.redis.cluster.nodes") // 条件加载配置属性，如果满足条件，加载当前bean
//    public RedisClusterConfiguration redisClusterConfiguration() {
//        RedisProperties.Cluster clusterProperties = redisProperties.getCluster();
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(clusterProperties.getNodes());
//        if (!StringUtils.isEmpty(clusterProperties.getMaxRedirects())) {
//            redisClusterConfiguration.setMaxRedirects(clusterProperties.getMaxRedirects());
//        }
//
//        return redisClusterConfiguration;
//    }
//
//    @Bean
//    @ConditionalOnProperty(value = "spring.redis.cluster.nodes") // 条件加载配置属性，如果满足条件，加载当前bean
//    public LettuceConnectionFactory lettuceConnectionFactory(
//            RedisClusterConfiguration redisClusterConfiguration) {
//        /** 集群模式：spring boot 1.5.x LettuceConnectionFactory构造方法不够完善，不支持连接池配置，不能同时传递连接池和集群配置，
//         *  spring boot 2.x中支持
//         */
//        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisClusterConfiguration);
////        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisClusterConfiguration, getPoolConfig()); // spring boot 2.x
//        factory.setPassword(redisProperties.getPassword());
//        factory.setTimeout(redisProperties.getTimeout());
////        // 配置连接池，1.5.x默认没有属性支持
////        factory.setPoolConfig(getPoolConfig());
//        return factory;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "redisTemplate")
//    public RedisTemplate<Object, Object> redisTemplate(
//            LettuceConnectionFactory lettuceConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(lettuceConnectionFactory);
//
//        ObjectMapper om = new ObjectMapper();
//        // 设置任何字段可见
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        // 设置不是final的属性可以转换
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        RedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        // key：采用String的序列化方式
//        template.setKeySerializer(stringRedisSerializer);
//        // value：采用String的序列化方式
//        template.setValueSerializer(stringRedisSerializer);
//        // hash key：采用String的序列化方式
//        template.setHashKeySerializer(stringRedisSerializer);
//        // hash value：采用jackson的序列化方式
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//
//        template.afterPropertiesSet();
//        template.setEnableTransactionSupport(false);
//
//        return template;
//    }
//}
