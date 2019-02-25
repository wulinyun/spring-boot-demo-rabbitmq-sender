package com.landasoft.mas.demo.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.landasoft.mas.demo.rabbitmq.sender.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoRabbitmqSenderApplicationTests {

	@Autowired
    private HelloSender helloSender;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testRabbit() {
        helloSender.send("hello,rabbit~");
    }

}
