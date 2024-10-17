package org.schola.backbone.server.security.auth;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

@Primary
@Qualifier("medium")
public class MediumCompromisedPasswordChecker extends CompromisedPasswordCheckerWithRegex {

    public MediumCompromisedPasswordChecker() {
        super("^(?=[a-z]*)(?=[A-Z]*)(?=[0-9]*)[a-zA-Z0-9]{12,63}$");
    }
}
