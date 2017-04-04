package com.tomaszdziurko.spring_bean_issue.frontend;

import com.tomaszdziurko.spring_bean_issue.domain.commands.CommandPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HomePageHandler {

    private final CommandPublisher commandPublisher;

    @Autowired
    public HomePageHandler(CommandPublisher commandPublisher) {
        this.commandPublisher = commandPublisher;
        log.info("Setting commandPublisher value to = " + this.commandPublisher);
    }

    public void executeAction(String name) {
        commandPublisher.publish(name);
    }
}
