package com.tomaszdziurko.spring_bean_issue;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.tomaszdziurko.spring_bean_issue.frontend.UserSession;
import com.tomaszdziurko.spring_bean_issue.frontend.HomePage;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.devutils.stateless.StatelessChecker;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

import static java.util.Arrays.asList;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@Slf4j
public class ExampleApplication extends WicketBootSecuredWebApplication {

    public static void main(String... args) {
        run(ExampleApplication.class, args);
        log.info("Application started with args: {}", asList(args));
    }

    public static WebApplication get() {
        return WicketBootSecuredWebApplication.get();
    }

    @Override
    protected void init() {
        super.init();
        getComponentPostOnBeforeRenderListeners().add(new StatelessChecker());
        new AnnotatedMountScanner().scanPackage("com.tomaszdziurko.spring_bean_issue").mount(this);
        getMarkupSettings().setStripWicketTags(true);
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return HomePage.class;
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return UserSession.class;
    }

}
