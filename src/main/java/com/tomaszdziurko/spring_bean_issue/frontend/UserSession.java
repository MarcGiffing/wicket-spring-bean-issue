package com.tomaszdziurko.spring_bean_issue.frontend;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class UserSession extends AbstractAuthenticatedWebSession {

    public UserSession(Request request) {
        super(request);
    }

    @Override
    public Roles getRoles() {
        return new Roles();
    }

    @Override
    public boolean isSignedIn() {
        return true;
    }

}
