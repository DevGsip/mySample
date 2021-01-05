package com.example.mongo.dao.impl;

import com.example.mongo.dao.UserDao;
import com.example.mongo.model.User;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class UserDaoImpl implements UserDao {

    @Resource
    private MongoTemplate mongoTemplate;



    @Override
    public int deleteByPrimaryKey(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
        return 0;
    }

    @Override
    public int insert(User record) {
        mongoTemplate.save(record);
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        Query query = new Query(Criteria.where("id").is(record.getId()));

        Update update = new Update();
        update.set("account", record.getAccount());
        update.set("age", record.getAge());
        update.set("name", record.getName());

        mongoTemplate.updateFirst(query, update, User.class);
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    @Override
    public long updateByPrimaryKeySelective(User record) {
        Query query = new Query(Criteria.where("id").is(record.getId()));

        Update update = new Update();
        update.set("account", record.getAccount());
        update.set("age", record.getAge());
        update.set("name", record.getName());
        UpdateResult res = mongoTemplate.updateFirst(query, update, User.class);
        log.info("com.example.mongo.dao.impl.UserDaoImpl.updateByPrimaryKeySelective UpdateResult:{}",res);
        return res.getModifiedCount();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public List<User> listUser() {
        List<User> users = mongoTemplate.findAll(User.class);
        return users;
    }
}
