package com.tomaszdziurko.spring_bean_issue.frontend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class SecondPage extends WebPage {

    public SecondPage() {
    }

    public SecondPage(String name) {
        add(new Label("submittedName", name));
    }

}
