package org.schola.schola.backbone.server.security.auth;

import org.springframework.stereotype.Component;

@Component
public class MediumCompromisedPasswordChecker extends CompromisedPasswordCheckerWithRegex {

    public MediumCompromisedPasswordChecker() {
        super("^(?=[a-z]*)(?=[A-Z]*)(?=[0-9]*)[a-zA-Z0-9]{12,63}$");
    }
}