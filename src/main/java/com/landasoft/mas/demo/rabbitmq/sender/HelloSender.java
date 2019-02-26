/**
 * <p>Title: HelloSender.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: www.landasoft.com</p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午2:17:02 
 * @version 1.0  
 */
package com.landasoft.mas.demo.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.landasoft.mas.demo.rabbitmq.bean.User;
import com.landasoft.mas.demo.rabbitmq.config.SenderConf;

/**
 * <p>Title: HelloSender</p>  
 * <p>Description: 
 * Direct模式相当于一对一模式,一个消息被发送者发送后,会被转发到一个绑定的消息队列中,然后被一个接收者接收!
 * 实际上RabbitMQ还可以支持发送对象:当然由于涉及到序列化和反序列化,该对象要实现Serilizable接口</p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午2:17:02
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send(String str) {
        amqpTemplate.convertAndSend(SenderConf.ROUTINGKEY, str);
    }
    public void send(User user) {
    	amqpTemplate.convertAndSend(SenderConf.ROUTINGKEY, user);
    }
}
