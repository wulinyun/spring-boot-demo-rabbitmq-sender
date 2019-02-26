/**
 * <p>Title: SenderConf.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: www.landasoft.com</p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午2:15:47 
 * @version 1.0  
 */
package com.landasoft.mas.demo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: SenderConf</p>  
 * <p>Description: D
 * irect模式相当于一对一模式,一个消息被发送者发送后,会被转发到一个绑定的消息队列中,然后被一个接收者接收!
 * 实际上RabbitMQ还可以支持发送对象:当然由于涉及到序列化和反序列化,该对象要实现Serilizable接口</p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午2:15:47
 */
@Configuration
public class SenderConf {
    public final static String ROUTINGKEY="DIRECT_QUEUE";
    @Bean
    public Queue queue() {
        return new Queue(ROUTINGKEY, true);
        
    }
}
