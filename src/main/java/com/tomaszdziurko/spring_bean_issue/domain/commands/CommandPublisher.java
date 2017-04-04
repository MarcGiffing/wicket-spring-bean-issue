package com.tomaszdziurko.spring_bean_issue.domain.commands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public CommandPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publish(String text) {
        log.info("Received command: {}", text);
        eventPublisher.publishEvent(text);
    }

}
