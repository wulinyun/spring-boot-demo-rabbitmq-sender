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

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: SenderConf</p>  
 * <p>Description: </p>  
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
    @Bean(name="message")
    public Queue queueMessage() {
    	return new Queue("topic.message",true);
    }
    @Bean(name="messages")
    public Queue queueMessages() {
    	return new Queue("topic.messages",true);
    }
    @Bean
    public TopicExchange exchange() {
    	return new TopicExchange("exchange", true, false);
    }
    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, 
    		TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
