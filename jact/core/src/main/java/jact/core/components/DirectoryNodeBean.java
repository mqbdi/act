package jact.core.components;

import jact.core.config.JactBasicConfig;
import jact.core.controller.AliveController;
import jact.core.model.PingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.Session;

@Component
@EnableAsync
@Slf4j
public class DirectoryNodeBean {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private AliveController aliveController;


    @Async
    @Scheduled(initialDelay = 100, fixedRate = 2500)
    public void sendPing() {
        log.debug("JMS Template: " + jmsTemplate);
        jmsTemplate.convertAndSend(JactBasicConfig.DirectoryMessageBox, aliveController.get());
    }

    @JmsListener(destination = JactBasicConfig.DirectoryMessageBox, containerFactory = JactBasicConfig.ContainerFactory)
    /*
    @Payload Order order,
                               @Headers MessageHeaders headers,
                               Message message, Session session
     */
    public void receiveMessage(@Payload PingMessage ping, @Headers MessageHeaders headers, Message message, Session session) {
        log.info("Receive <" + ping + ">");
        if (log.isDebugEnabled()) {
            log.debug("- - - - - - - - - - - - - - - - - - - - - - - -");
            log.debug("######          Message Details           #####");
            log.debug("- - - - - - - - - - - - - - - - - - - - - - - -");
            log.debug("headers: " + headers);
            log.debug("message: " + message);
            log.debug("session: " + session);
            log.debug("- - - - - - - - - - - - - - - - - - - - - - - -");
        }

    }
}
