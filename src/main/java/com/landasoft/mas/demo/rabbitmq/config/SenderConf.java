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
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: SenderConf</p>  
 * <p>Description: </p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午2:15:47
 */
@Configuration
public class SenderConf {
    public final static String ROUTINGKEY="queue";
    public Queue queue() {
        return new Queue(ROUTINGKEY, true);
        
    }
}
