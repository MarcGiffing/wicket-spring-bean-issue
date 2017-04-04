package com.tomaszdziurko.spring_bean_issue.frontend;

import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.devutils.stateless.StatelessComponent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@Slf4j
@StatelessComponent
@MountPath("home-page")
public class HomePage extends WebPage {

    @SpringBean
    private HomePageHandler handler;

    private String name;

    public HomePage() {
        Form<HomePage> form = addRegistrationForm();
        form.add(new TextField<>("name", new PropertyModel<>(this, "name")));
    }

    private Form<HomePage> addRegistrationForm() {
        Form<HomePage> form = new StatelessForm<HomePage>("form") {
            @Override
            protected void onSubmit() {
                log.info("Submitting name: {}", name);
                handler.executeAction(name);
                setResponsePage(new SecondPage(name));
            }
        };
        add(form);
        return form;
    }

}
