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

import com.landasoft.mas.demo.rabbitmq.config.SenderConf;

/**
 * <p>Title: HelloSender</p>  
 * <p>Description: </p>  
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
}
