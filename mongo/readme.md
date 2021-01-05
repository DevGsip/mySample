# springboot集成mongodb

## 环境准备
* 下载地址：https://www.mongodb.com/try/download/community
* 安装地址：https://www.cnblogs.com/chy18883701161/p/11100560.html

## 使用说明
* 实体类上使用注解@Document(collection = "user_collection")关联数据库集合，参考com.example.mongo.model.User
* 接口实现上使用注解@Component加载，参考com.example.mongo.dao.impl.UserDaoImpl
* 数据库操作使用mongoTemplate，参考com.example.mongo.dao.impl.UserDaoImpl.MongoTemplate

## 适用场景
* 更高的写入负载

  ```
  默认情况下，MongoDB更侧重高数据写入性能，而非事务安全，MongoDB很适合业务系统中有大量“低价值”数据的场景。但是应当避免在高事务安全性的系统中使用MongoDB，除非能从架构设计上保证事务安全。‘
  
  日志、简历、帖子等。
  ```

* 高可用性

  ```
  MongoDB的复副集(ReplSet)配置非常简洁方便，此外，MongoDB可以快速响应的处理单节点故障，自动、安全的完成故障转移。这些特性使得MongoDB能在一个相对不稳定（如云主机）的环境中，保持高可用性。
  ```

* 数据量很大或者未来会变得很大

  ```
  依赖数据库(MySQL)自身的特性，完成数据的扩展是较困难的事，在MySQL中，当一个单表达到5- 10GB时会出现明显的性能降级，此时需要通过数据的水平和垂直拆分、库的拆分完成扩展，使用MySQL通常需要借助驱动层或代理层完成这类需求。而MongoDB内建了多种数据分片的特性，可以很好的适应大数据量的需求。
  ```

* 基于位置的数据查询

  ```
  MongoDB支持二维空间索引，因此可以快速及精确的从指定位置获取数据。
  ```

* 表结构不明确，且数据在不断变大

  ```
  在一些传统RDBMS中，增加一个字段会锁住整个数据库/表，或者在执行一个重负载的请求时会明显造成其它请求的性能降级。通常发生在数据表大于1G的时候（当大于1TB时更甚）。 因MongoDB是文档型数据库，为非结构货的文档增加一个新字段是很快速的操作，并且不会影响到已有数据。另外一个好处当业务数据发生变化时，是将不在需要由DBA修改表结构。
  ```

* 没有DBA支持

  ```
  如果没有专职的DBA，并且准备不使用标准的关系型思想（结构化、连接等）来处理数据，那么MongoDB将会是你的首选。MongoDB对于对像数据的存储非常方便，类可以直接序列化成JSON存储到MongoDB中。 但是需要先了解一些最佳实践，避免当数据变大后，由于文档设计问题而造成的性能缺陷。
  ```



## 不适用场景

在某些场景下，MongoDB作为一个非关系型数据库有其局限性。MongoDB不支持事务操作，所以需要用到事务的应用建议不用MongoDB，另外MongoDB目前不支持join操作，需要复杂查询的应用也不建议使用MongoDB。

