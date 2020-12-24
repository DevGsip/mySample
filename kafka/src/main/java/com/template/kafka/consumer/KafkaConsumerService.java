package com.template.kafka.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.template.kafka.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class KafkaConsumerService {

    @Resource
    private UserService userService;

    /**
     * 注意topics为所需消费的配置
     * containerFactory为com.template.kafka.config.KafkaConsumerConfig#kafkaListenerContainerFactory()定义的bean
     */
    @KafkaListener(topics = "VAC-AP-STATUS", containerFactory = "kafkaListenerContainerFactory")
    public void receiveData(List<ConsumerRecord<?, ?>> records, Acknowledgment acknowledgment) {
        List data = new ArrayList();

        try {
            log.info("从kafka接收数据,size = {}", records.size());
            for (ConsumerRecord record : records) {
                String msg = record.value().toString();
                JSONObject jsonObject = JSON.parseObject(msg);

                // TODO: 对接收数据处理
            }
        } catch (Exception e) {
            log.error("消费异常", e);
        } finally {
            log.info("手动提交偏移量");
            acknowledgment.acknowledge();
        }
    }

    /**
     * 注意topics为所需消费的配置
     * containerFactory为com.template.kafka.config.KafkaConsumerConfig#kafkaListenerContainerFactory()定义的bean
     */
//    @KafkaListener(topics = "VAC-AP-TASK", containerFactory = "kafkaListenerContainerFactory")
//    public void receiveTaskStatus(List<ConsumerRecord<?, ?>> records, Acknowledgment acknowledgment) {
//        List data = new ArrayList();
//        try {
//            log.info("从kafka接收任务执行结果数据,size = {}", records.size());
//            for (ConsumerRecord<?, ?> record : records) {
//                String msg = record.value().toString();
//                log.info("数据,data = {}", msg);
//                JSONObject jsonObject = JSON.parseObject(msg);
//
//                // TODO: 对接收数据处理
//            }
//        } catch (Exception e) {
//            log.error("消费异常", e);
//        } finally {
//            log.info("手动提交偏移量");
//            acknowledgment.acknowledge();
//        }
//    }

}
