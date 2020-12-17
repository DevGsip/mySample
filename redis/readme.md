# springboot 集成redis
## redis单机
* application.yaml配置参考redis单机配置
* pom.xml文件参考redis单机
* 需要实现com.template.springboot.redis.config.RedisConfig进行初始化RedisTemplate<String, Object>
* 数据操作参考com.template.springboot.redis.service.impl.RedisServiceImpl

## redis集群
* application.yaml配置参考redis集群配置
* pom.xml文件参考redis集群
* 集群模式参考com.template.springboot.redis.config.cluster下文件
* 数据操作参考com.template.springboot.redis.config.cluster.RedisTemplateUtil

## 其他
| 问题 | 处理 |
|-------|---------|
|数据库连接异常You must configure either the server or JDBC driver (via the 'serverTimezone | 数据库连接url拼接?serverTimezone=UTC|



