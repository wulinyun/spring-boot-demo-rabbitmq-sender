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
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: SenderConf</p>  
 * <p>Description:
 * Fanout Exchange形式又叫广播形式,因此我们发送到路由器的消息会使得绑定到该路由器的每一个Queue接收到消息,
 * 这个时候就算指定了Key,或者规则(即上文中convertAndSend方法的参数2),也会被忽略! 
 * </p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午2:15:47
 */
@Configuration
public class SenderFanoutConf {
    @Bean(name="Amessage")
    public Queue AMessage() {
    	return new Queue("fanout.A",true);
    }
    @Bean(name="Bmessage")
    public Queue BMessage() {
    	return new Queue("fanout.B",true);
    }
    @Bean(name="Cmessage")
    public Queue CMessage() {
    	return new Queue("fanout.C",true);
    }
    @Bean
    public FanoutExchange  fanoutExchange () {
    	return new FanoutExchange("fanoutExchange", true, false);
    }
    @Bean
    Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage, 
    		FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(@Qualifier("Bmessage") Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
