package com.landasoft.mas.demo.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.landasoft.mas.demo.rabbitmq.bean.User;
import com.landasoft.mas.demo.rabbitmq.sender.HelloSender;
import com.landasoft.mas.demo.rabbitmq.sender.HelloTopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoRabbitmqSenderApplicationTests {

	@Autowired
    private HelloSender helloSender;
	@Autowired
    private HelloTopicSender helloTopicSender;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testRabbit() {
        helloSender.send("hello,rabbit~");
        User user = new User();
        user.setUserName("wulinyun");
        user.setUserPassword("88888888");
        helloSender.send(user);
    }
    @Test
    public void testTopicRabbit() {
    	helloTopicSender.send("exchange", "topic.message", "hello,rabbit~");;
        User user = new User();
        user.setUserName("wulinyun");
        user.setUserPassword("88888888");
       // helloTopicSender.send("exchange", "topic.messages", user);
    }
    @Test
    public void testFanoutRabbit() {
    	helloTopicSender.send("fanoutExchange", "", "hello,fanout rabbit~");;
        User user = new User();
        user.setUserName("wulinyun");
        user.setUserPassword("88888888");
        //helloTopicSender.send("fanoutExchange", "", user);
    }

}
