# springboot集成mongodb

## 环境准备
* 下载地址：https://www.mongodb.com/try/download/community
* 安装地址：https://www.cnblogs.com/chy18883701161/p/11100560.html

## 使用说明
* 实体类上使用注解@Document(collection = "user_collection")关联数据库集合，参考com.example.mongo.model.User
* 接口实现上使用注解@Component加载，参考com.example.mongo.dao.impl.UserDaoImpl
* 数据库操作使用mongoTemplate，参考com.example.mongo.dao.impl.UserDaoImpl.MongoTemplate

## 使用场景
