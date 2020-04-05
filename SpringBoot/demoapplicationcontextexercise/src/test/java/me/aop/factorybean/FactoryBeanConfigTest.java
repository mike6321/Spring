package me.aop.factorybean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/29
 * Time : 11:45 오전
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FactoryBeanConfig.class})
class FactoryBeanConfigTest {

    @Autowired
    private Message message;

    @Autowired
    ApplicationContext context;

    @Resource(name = "&message")
    private MessageFactoryBean messageFactoryBean;

    @Test
    public void testConstructWorkerByJava() {
        Object message = context.getBean("message");
        assertEquals(message, is(Message.class));

        assertEquals(this.message.getText(), "text");
    }

}