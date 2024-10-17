package org.schola.backbone.server.security.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CompromisedPasswordCheckerFactory {

    @Value("${spring.security.password.checker.secure}")
    private String secure;

    public CompromisedPasswordCheckerWithRegex get() {
        return switch (secure) {
            case "weak" -> new WeakCompromisedPasswordChecker();
            case "strong" -> new StrongCompromisedPasswordChecker();
            default -> new MediumCompromisedPasswordChecker();
        };
    }
}