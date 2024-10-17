package org.schola.schola.backbone.server.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.stereotype.Component;

@Component
public class CompromisedPasswordCheckerFactory {

    @Autowired
    private CompromisedPasswordCheckerConfiguration configuration;

    public CompromisedPasswordChecker get() {
        final String secure = configuration.getSecure().toLowerCase();
        return switch (secure) {
            case "weak" -> new WeakCompromisedPasswordChecker();
            case "strong" -> new StrongCompromisedPasswordChecker();
            default -> new MediumCompromisedPasswordChecker();
        };
    }
}