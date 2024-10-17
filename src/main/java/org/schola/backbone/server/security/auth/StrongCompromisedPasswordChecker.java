package org.schola.backbone.server.security.auth;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("strong")
public class StrongCompromisedPasswordChecker extends CompromisedPasswordCheckerWithRegex {

    public StrongCompromisedPasswordChecker() {
        super("^(?=[a-z]*)(?=[A-Z]*)(?=[0-9]*)(?=[*.!@$%^&()]*)[a-zA-Z0-9*.!@$%^&]{12,63}$");
    }
}
